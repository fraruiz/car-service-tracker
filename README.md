# Car Service Tracker

Este proyecto es una aplicación web desarrollada en Java utilizando Spring Boot. El proyecto está gestionado por Gradle y se desarrolla en el entorno de IntelliJ IDEA.

## Requisitos previos

Antes de comenzar, asegúrate de tener instaladas las siguientes herramientas:

- **Java 21** o superior
- **Gradle 7** o superior
- **IntelliJ IDEA** (versión Community o Ultimate)
- **Git** (opcional, para control de versiones)

## Configuración del entorno de desarrollo

1. **Clona el repositorio**:

   ```bash
   git clone https://github.com/fraruiz/car-service-tracker.git
   cd car-service-tracker
   ```
2. **Importa el proyecto en IntelliJ IDEA:**
- Abre IntelliJ IDEA.
- Selecciona File > Open y navega hasta la carpeta del proyecto.
- IntelliJ IDEA detectará automáticamente el archivo build.gradle y configurará el proyecto.

3. **Configura el JDK:**
- Ve a File > Project Structure > Project.
- Asegúrate de que la versión del JDK sea la correcta (Java 17 o superior).

## Compilación y ejecución

Para compilar y ejecutar el proyecto, utiliza los siguientes comandos de Gradle:

### Compilar el proyecto:
- Copiar código: 
```bash
./gradlew build
```
Ejecutar la aplicación:
```bash
./gradlew bootRun
```
La aplicación estará disponible en http://localhost:8080 de forma predeterminada.

### Pruebas
Para ejecutar las pruebas, utiliza el siguiente comando:
```bash
./gradlew test
```

### Despliegue
Este proyecto está configurado para ser empaquetado como un archivo JAR. Puedes crear el JAR utilizando el siguiente comando:


```bash
./gradlew bootJar
```
El archivo JAR generado se ubicará en el directorio build/libs.
