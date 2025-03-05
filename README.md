# IngenieriaSoftareTarea3
Grupo: 6CV4
Allumno: Cruz Merlin Wilfrido

Este proyecto es una aplicación desarrollada con **Spring Boot**, utilizando **Java 21 (Amazon Corretto)** y **Maven 3.9.9**. Además, la aplicación está **dockerizada**, lo que facilita su despliegue y ejecución en cualquier entorno.

## Tecnologías utilizadas

- **Java 21 (Amazon Corretto)**
- **Spring Boot**
- **Maven 3.9.9**
- **Docker**
- **VS Code**

## Requisitos previos

Para ejecutar este proyecto en tu máquina local, asegúrate de tener instalados los siguientes componentes:

- [Java 21 (Amazon Corretto)](https://docs.aws.amazon.com/corretto/latest/corretto-21-ug/downloads-list.html)
- [Maven 3.9.9](https://maven.apache.org/download.cgi)
- [Docker](https://www.docker.com/get-started)

## Clonar el repositorio

```sh
 git clone https://github.com/tu-usuario/tu-repositorio.git
 cd tu-repositorio
```

## Compilar y ejecutar la aplicación

Si deseas ejecutar la aplicación sin Docker, usa los siguientes comandos:

```sh
 mvn spring-boot:run
```
Nota: Como base de datos se utilizó XAMPP junto a phpMyAdmin.

## Ejecutar con Docker

Para ejecutar la aplicación utilizando Docker:

1. Construir la imagen Docker:

```sh
 docker-compose up --build 
```

La aplicación estará disponible en `http://localhost:8080`.

## Capturas de Pantalla
Aplicaicion ejecutandose con Docker
![Captura desde 2025-03-05 07-46-14](https://github.com/user-attachments/assets/b13c9c85-b5d5-400a-a348-9c7f10c31398)


Pestaña de login funcionando
![Captura desde 2025-03-05 07-47-18](https://github.com/user-attachments/assets/3ff8916e-8b15-4daa-a172-cedb8b3bb80d)


Inicio de sesion de usuario
![Captura desde 2025-03-05 07-47-48](https://github.com/user-attachments/assets/fff4688d-c1df-406b-9aba-e275914c65c4)

## Investigación

El Dockerfile es el archivo que define cómo se construirá la imagen Docker para la aplicación. Para optimizar el tamaño de la imagen final, el proceso se divide en dos etapas. En la primera, se utiliza la imagen base de Maven para compilar el proyecto. Se copian el archivo pom.xml y las dependencias necesarias, luego se incorpora el código fuente y se ejecuta el comando de compilación con Maven para generar el archivo .jar.

En la segunda etapa, se usa una imagen más ligera de Java (eclipse-temurin:21-jre), sin herramientas de desarrollo innecesarias, para ejecutar la aplicación. En esta fase, se copia el .jar generado en la etapa anterior y se configura el contenedor para que exponga el puerto 8080 y ejecute la aplicación con el comando java -jar app.jar. Este enfoque permite reducir el tamaño de la imagen final y hacer más eficiente su ejecución.

Por otro lado, el archivo docker-compose.yml se encarga de orquestar la ejecución de los contenedores de la aplicación y la base de datos. Define dos servicios principales: el primero es el servicio de la aplicación (app), que se construye a partir del Dockerfile y expone el puerto 8080. Además, se asegura de que la base de datos (db) esté disponible antes de iniciar. También establece las variables de entorno necesarias para la conexión con MySQL y configura una red (app-network) para la comunicación entre los servicios.

El segundo servicio es el de la base de datos, que utiliza la imagen oficial de MySQL en su versión 8.0. Para su funcionamiento, se configuran credenciales mediante variables de entorno y se asigna un volumen (mysql-data) que garantiza la persistencia de los datos incluso si el contenedor se reinicia. Además, se carga un archivo SQL (bd.sql) al inicio para definir la estructura de la base de datos.

Finalmente, docker-compose.yml define una red personalizada que permite la interacción entre los contenedores y un volumen persistente para MySQL, asegurando que los datos no se pierdan tras un reinicio. Gracias a esta configuración, es posible desplegar la aplicación y su base de datos de manera automatizada, manteniendo un entorno limpio, replicable y portátil.

