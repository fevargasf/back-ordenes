#
# Build del proyecto (Multi-Stage)
# --------------------------------
#
# Usamos una imagen de Maven para hacer build de proyecto con Java 17
# Llamaremos a este sub-entorno "build"
# Copiamos todo el contenido del repositorio
# Ejecutamos el comando mvn clean package (Generara un archivo JAR para el despliegue)
FROM maven:3.8.1-openjdk-17 AS build
COPY . .
# se establecen los argumentos para tomar desde el proceso debuilding.

ARG DATABASE_URL
ARG USER
ARG PASSWORD
ARG HOST
ARG PGPORT
ARG DATABASE
#    se utilzia el comando sed para reemplazar las variables "tales" por los valores tomados desde el proceso de building

RUN sed -i 's/DATABASE_URL/$DATABASE_URL/' src/main/resources/application.yml
RUN sed -i 's/USER/$USER/' src/main/resources/application.yml
RUN sed -i 's/PASSWORD/$PASSWORD/' src/main/resources/application.yml
RUN sed -i 's/HOST/$HOST/' src/main/resources/application.yml
RUN sed -i 's/PGPORT/$PGPORT/' src/main/resources/application.yml
RUN sed -i 's/DATABASE/$DATABASE/' src/main/resources/application.yml

RUN mvn clean package


# Usamos una imagen de Openjdk v17
# Exponemos el puerto que nuestro componente va a usar para escuchar peticiones
# Copiamos desde "build" el JAR generado (la ruta de generacion es la misma que veriamos en local) y lo movemos y renombramos en destino como
# Marcamos el punto de arranque de la imagen con el comando "java -jar app.jar" que ejecutará nuestro componente.
FROM openjdk:17


EXPOSE 8082
COPY --from=build /target/ordenes-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]