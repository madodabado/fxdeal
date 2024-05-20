# FX Deal Data Warehouse

## Overview

This project is part of a scrum team developing a data warehouse for Bloomberg to analyze FX deals. T
he system accepts deal details and persists them into a database.

## Requirements

- Java 11
- Spring Boot version 2.7.4
- Hibernate JPA
- MySQL 
- Docker 
- Maven 

## Features

- Validate deal details before persisting.
- Prevent duplicate deals.
- Insert all valid deals without rollback on errors.
- logging and error handling.
- Unit testing

## Setup

### Prerequisites

- Ensure you have Java 11 installed.
- Docker  installed.
- MySQL installed and running or you can use MySQL Connection already available in the project its public.

### Database Configuration

Update the `application.properties` file with your database configuration:

```properties
spring.datasource.url=dbc:mysql://104.131.168.21:3306/clusterddw?autoReconnect=true&useUnicode=true
spring.datasource.username=root
spring.datasource.password=xxxxxxx
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect

```
### Docker Deployment

- Make sure that the fxdeal-0.0.1-SNAPSHOT.jar file in the Root folder with the Docker file.
- Run the following command :
   * docker build -t fxdeal . // to build the image
   * docker run --name fxdeal fxdeal // to run the container

### GITHub Repository
- URL:
  * https://github.com/madodabado/fxdeal.git
- Clone 
  * git clone https://github.com/madodabado/fxdeal.git

### Run Spring boot application
- Using maven
 ```
 mvn clean package
 ```
- Navigate to the /target file where the jar file generated
- Execute the jar file
```
    java -jar fxdeal-0.0.1-SNAPSHOT.jar
```



## POSTMAN Test
- Method :POST
- URL : http://localhost:8081/api/deals
- Body (Example) : 
   ``` 
  {

    "dealUniqueId": "123we335245",
    "fromCurrencyIsoCode": "EUR",
    "toCurrencyIsoCode": "EUR",
    "dealTimestamp": "2024-05-20T07:15:30",
    "dealAmount": 10
   }
  ```
  





