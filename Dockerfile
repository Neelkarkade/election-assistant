FROM openjdk:17-jdk

WORKDIR /app

COPY . .

RUN chmod +x mvnw && ./mvnw clean package

CMD ["java", "-jar", "target/*.jar"]