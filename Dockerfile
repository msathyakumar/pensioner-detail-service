FROM openjdk:8
EXPOSE 9081
ADD "target/pensioner-detail-service.jar" "pensioner-detail-service.jar"
ENTRYPOINT [ "java", "-jar", "/pensioner-detail-service.jar" ]