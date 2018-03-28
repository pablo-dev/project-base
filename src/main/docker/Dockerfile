FROM java:8
VOLUME /tmp
ADD proyect-base-1.0.0-SNAPSHOT.war app.war
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.war"]