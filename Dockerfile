FROM openjdk:8
EXPOSE 8090
#RUN wget "http://35.236.220.189:8081/repository/maven-releases/co/com/kudodevoops/kudoDevOps/1.0.1/kudoDevOps-1.0.1.jar"
ADD jar/kudoDevOps-0.0.1-SNAPSHOT.jar app.jar
ARG profile=dev
CMD ["/bin/sh"]
ENTRYPOINT ["java",  "-Dspring.profiles.active=${profile}", "-jar", "/app.jar"]