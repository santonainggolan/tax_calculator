FROM openjdk:8
ADD target/taxcalculator.jar taxcalculator.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","taxcalculator.jar"]