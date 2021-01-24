# About :blue_book:
A POC was developed within the context: "customer registration and address". The code is structured in MVC whose packages are separated by business context, where the coding was done following the S (Single Responsibility Principle) and O (Open Closed Principle) principles of the O.O paradigm. For familiarity, the adopted language was java 8 with maven connecting to Postgresql, an open source relational bank. To facilitate the management of bank scripts Flyway was chosen and for API documentation Swagger. To practice the idea of low code Lombok was used together with SpringBoot.

# Tech Stack :clipboard:
- JUnit4
- Java 8
- Maven
- Postgresql
- Flyway
- Swagger
- SpringBoot
- Lombok

# Running the project :computer:
- Step 1: Choose the folder to download the project and run the clone
```
git clone https://github.com/rickdevbr-io/client.git
```
- Step 2: In the local PostgreSQL create the database test

- Step 3: Boot the project;
```
mvn run
```
- Step 4: Open the API documentation: http://localhost:8080/swagger-ui/

- Step 5: In the student-controller use the endpoints to register, display and delete the customer and their address

- Obs.: For the project to work on a local machine, it will be necessary to use the PostgreSql client or an image of it in a docker.
```
docker run -p 5432:5432 -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres postgres
```
# Performing unit tests :arrow_forward:
- Step 1: Choose the "client" folder or any specific folder, press the right button and run the tests by selecting the option "Run Tests in ...".
