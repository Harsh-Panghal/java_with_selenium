FROM maven:3.9.9-eclipse-temurin-21
 
WORKDIR /app
 
COPY . .
 
RUN mvn clean install -DskipTests
 
CMD ["mvn","-Dtest=runners.TestRunner","test"]