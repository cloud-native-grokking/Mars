# Please name the image "mercury-service" by using:
# docker build -t mercury-service .

FROM openjdk:8
MAINTAINER vietdv272
ENV SPRING_APPLICATION_JSON="SB"
COPY ./target/mars*.jar app/mars-service.jar
EXPOSE 8080 8070
ENTRYPOINT ["java", "-jar", "app/mars-service.jar", "--spring.profiles.active=docker"]