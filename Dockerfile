FROM maven:3.9.9-eclipse-temurin-21 as builder
WORKDIR /building

ADD . .
RUN mvn package -T 4 -B -DskipTests
RUN mv target/$(ls ./target | grep \.jar | grep -v original | grep -v javadoc | grep -v source)  ./visit-tracker.jar

FROM openjdk:19-jdk-slim

WORKDIR /app

COPY --from=builder /building/visit-tracker.jar .

ENTRYPOINT java -jar visit-tracker.jar