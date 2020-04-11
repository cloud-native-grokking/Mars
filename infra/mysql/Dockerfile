# Please name the image "mysql-mercury" by using:
# docker build -t mysql-mercury .


FROM mysql:8.0
MAINTAINER vietdv272
ENV SPRING_APPLICATION_JSON="SB"
COPY ./scripts/ /docker-entrypoint-initdb.d/