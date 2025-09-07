# 🚀 Mi Aplicación Spring Boot (Desarrollo)

Este proyecto es una aplicación desarrollada con **Spring Boot**.  
La aplicación está configurada para arrancar en el **puerto 8081** y permite acceder a la interfaz desde un navegador web.

---

## 📂 Requisitos previos

Antes de ejecutar la aplicación, asegúrate de tener instalado:

- [Java 21+](https://adoptium.net/) (o la versión que uses en tu proyecto)
- [Maven 3.9+](https://maven.apache.org/) o el **wrapper** incluido (`mvnw`)
- **Git** (opcional, para clonar el repositorio)

---

## ⚙️ Configuración del puerto

La aplicación está configurada para iniciar en el **puerto 8081**.  
Esto se define en el fichero:

src/main/resources/application.properties


Con el siguiente contenido:

```properties
server.port=8081
```

## 🚀 Lanzamiento de la aplicación
Para iniciar la aplicación, navega hasta el directorio raíz del proyecto y ejecuta el siguiente comando:

```bash
mvn spring-boot:run
```
O, si usas el **wrapper** de Maven:

```bash
./mvnw spring-boot:run
```
Una vez que la aplicación esté en funcionamiento, podrás acceder a ella desde tu navegador web en:

```
http://localhost:8081
```

