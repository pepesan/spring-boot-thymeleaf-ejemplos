# ===== Etapa 1: Build (compila el JAR con Maven y Java 21) =====
FROM maven:3.9-eclipse-temurin-21 AS build

# Define el directorio de trabajo
WORKDIR /app

# Copiamos el pom primero para aprovechar la caché de dependencias
COPY pom.xml .
# Descarga dependencias sin compilar (mejor cacheo)
RUN --mount=type=cache,target=/root/.m2 mvn -q -e -DskipTests dependency:go-offline

# Copiamos el código fuente
COPY src ./src

# Compilamos el JAR (ajusta el perfil si usas alguno)
RUN --mount=type=cache,target=/root/.m2 mvn -q -e -DskipTests clean package

# ===== Etapa 2: Runtime (imagen ligera para ejecutar el JAR) =====
FROM eclipse-temurin:21-jre

# Puerto en el que arrancará la app (debe coincidir con application.properties)
ENV SERVER_PORT=8081
EXPOSE 8081

# Usuario no root por seguridad (opcional)
RUN useradd -ms /bin/sh spring
USER spring

WORKDIR /app

# Copiamos el JAR generado desde la etapa de build
# Si tu jar final cambia de nombre, ajusta el patrón o usa ARG
COPY --from=build /app/target/*.jar /app/app.jar

# Opcional: Java flags razonables (memoria, entropy, timezone, etc.)
ENV JAVA_OPTS="\
-XX:+UseContainerSupport \
-XX:MaxRAMPercentage=75 \
-Djava.security.egd=file:/dev/./urandom \
-Duser.timezone=UTC \
"

# Arranque de la app. Puedes añadir --spring.profiles.active=prod si procede.
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app/app.jar --server.port=${SERVER_PORT}"]
