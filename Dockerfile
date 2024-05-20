FROM openjdk:11
ARG JAR_FILE=/*.jar
COPY ${JAR_FILE} fxdeal-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/fxdeal-0.0.1-SNAPSHOT.jar"]
EXPOSE 8761
