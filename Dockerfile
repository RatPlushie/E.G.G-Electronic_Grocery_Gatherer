FROM openjdk:11
ADD target/EGG-GroceryList.jar EGG-GroceryList.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "EGG-GroceryList.jar"]