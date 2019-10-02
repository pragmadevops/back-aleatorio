# Devops Pragma Practica
Aplicativo encargado de realizar CRUD de particpantes expuesto en un API Rest.

# Tecnologias usadas
* SpringBoot 2.1.4.RELEASE
* Swagger 2.7.0
* Jacoco 0.8.3
* Maven 4.0.0
* Java 1.8
* SonarQube 2.4
* MariaDB 10.1.29 - Apache 2.4.29 - PHP 7.2.0
* Docker


## Prerequisitos
* Ambiente desarrollo:
```
Instalacion de Docker 
```
```
Crear DB importando el archivo de base de datos, se recomienda usar Xammp 3.2.2
```
```
Importar el proyecto como un maven project, se recomienda usar eclipse
```
```
Ir al paquete src/main/resources y poner la ruta de data source segun se requiera
```
* Ambiente pruebas:
```
Instalacion de Docker 
```
```
Crear DB importando el archivo de base de datos, se recomienda usar Xammp 3.2.2
```
```
Importar el proyecto como un maven project, se recomienda usar eclipse
```
```
Ir al paquete src/main/resources y poner la ruta de data source segun se requiera
```

## Instalación

crear variable de entorno de nombre HOST
```
HOST = 'valor sera el host que aloja la base de datos'
```
Ubicarse en la carpeta raiz del proyecto y ejecutar el siguiente comando por consola

```
mvn install
```
```
agregar el .jar generado a la carpeta raiz donde se va  ejecutar el DockerFile
```
## Ejecución
```
Ubicarse en la carpeta donde esta ubicado el DockerFile
```
```
Para crear la imagen correr por consola el comando docker build -t kudoimage .
```
```
Para crear el contenedor e iniciarlo corree por consola el comando docker run -it -p 8090:8090 --name kudoapp kudoimage
```
Para correr el aplicativo se debe ejecutar el comando en consola con el respectivo "profile" (dev, test, ...)
el "profile" por defecto es prod
```
$java -jar -Dspring.profiles.active=[profile] kudoDevOps-0.0.1-SNAPSHOT.jar
```
## Guia pruebas unitarias usando Mocks

[Guia Mocks](https://drive.google.com/open?id=12XvWdjHzYEiFR9Ezb6YFfu2ztcxZGYoi)
