# Alpine Linux Image with JDK8
FROM openjdk:8-alpine

LABEL MAINTAINER="saikris12@gmail.com"

ADD leagueservice/target/leagueservice-0.0.1-SNAPSHOT.jar /app.jar

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS  -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]