# Full-Stack Java-React-PrimeReact-Docker Customer-Phone
Full-Stack java-React-PostgreSQL Customer Phone validation using Docker compose

 > This is  Template Example For Full stack  Spring boot as back-End Rest-API And React with Prime-React as Front-End and PostgressSQL as DataBase 
 
 > Application Customer Phone Validation display and filter and sort Operations

 > DataBase Dumped with some init Customer Phones
 

# Entry points
> This FrontEnd URL
- http://localhost:3000/
> This is the Swagger-UI to explore our API's and can play or give it a Test  
- http://localhost:8081/api/swagger-ui-customer-api.html  
> Ports:
 - Back-End:8081
 - DataBase:5432
 - Front-End:3000



# Full-Stack Based on Spring Boot and React with PrimeReact 
 - Spring boot 2.6 
 - React
 - PrimeReact lib
 - Unit tests and Integration tests
 - Spring Data ( JPA )
 - DB -> ( H2 in Memory DB for Integration tests / and PostgreSQL as defualt )
 - JDK 11
 
 # How to use or
 
 ###  In DataBase
 >  Dumped Some sample Customer
 - In SQL Folder dump.sql file where you can free edit as your needs

 
 # To Build Docker and Compose
 > We Have to package our jar file of the Back-End Server
 
 ```
 cd server
 ```
 Then
 ```
    mvn clean compile package
 ```
 OR
 ```
    mvn clean compile package -DskipTests
 ```

 > To build Compose file with
 - Let's go to go Root Folder again
```
 cd ..
 ```
 Then
 ```
   docker-compose up --build
 ```
 > Wait until all up and running then go to front-end URL 
 - http://localhost:3000/
 
 > To delete the contianers 
 ```
 docker-compose down --volumes
 ```
 # Can try Back-End with 
For Back-End navigate to sub Folder server   
```
 cd server
 ```
 Please edit application.properties for DB  Then
```
 mvn spring-boot:run
 ```
 OR
 ```
  ./mvnw spring-boot:run
 ```
 ![image](https://user-images.githubusercontent.com/3534572/157258491-a31d9281-a433-498d-8cff-43c054f82b82.png)

 
 > Thanks :+1: if you have any comments to share with me :shipit:  
 > By @Ismail Shebl

