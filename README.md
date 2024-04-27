# E-Commerce API

## Description
This project provides APIs for managing an E-commerce system, including functionalities such as retrieving wish lists, total sale amount, and top-selling products.

## Tech Stack
- Java
- Spring Boot 3.2.2
- JDK 17
- PostgreSQL
- Docker

## Prerequisites
- JDK 17
- Maven
- Docker

## Setup
1. Clone the repository:
   ```bash
   git clone https://github.com/MasumCse2k12/eCommerce.git

## Build the project
- Go to the project directory & rub below command
- mvn clean install

## Start the PostgreSQL database using Docker
- docker run -d --name postgres -e POSTGRES_PASSWORD=your_password -p 5432:5432 postgres

## Run the application
- java -jar target/eCommerce-1.0.jar
