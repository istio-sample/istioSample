FROM openjdk:8-jdk-alpine
VOLUME /tmp

ADD ./target/core1-0.0.1-SNAPSHOT.jar /app.jar

ARG BGENV
ENV env=$BGENV

ENTRYPOINT java -Dbgenv=${env} -jar app.jar