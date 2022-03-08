FROM openjdk:latest

ADD target/customer-phone-validation-1.jar app.jar

ENTRYPOINT [ "java" ,"-jar", "app.jar" ]

EXPOSE 8081