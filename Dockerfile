FROM openjdk:8
EXPOSE 9081
ADD "target/pensioner-detail-service-sk.jar" "pensioner-detail-service-sk.jar"
ENTRYPOINT [ "java", "-jar", "/pensioner-detail-service-sk.jar" ]