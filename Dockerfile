FROM alpine/git as clone
ARG url
WORKDIR /app
RUN git clone https://github.com/EvgeniyViktorov/agro-analysis-service.git

FROM maven:3.5-jdk-8-alpine as build
ARG project 
WORKDIR /app/agro-analysis-service
COPY --from=clone /app /app
RUN ls /app
RUN mvn clean package -Dmaven.test.skip=true

FROM openjdk:8-jre-alpine
ARG artifactid
ARG version
ENV artifact agro-help-core-0.1.jar 
WORKDIR /app/agro-analysis-service/target
EXPOSE 8080
CMD ["java -jar agro-help-core-0.1.jar "] 