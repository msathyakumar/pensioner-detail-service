#FROM openjdk:8
#EXPOSE 9081
#ADD "target/pensioner-detail-service.jar" "pensioner-detail-service.jar"
#ENTRYPOINT [ "java", "-jar", "/pensioner-detail-service.jarr" ]

FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 9081
ADD target/*.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]