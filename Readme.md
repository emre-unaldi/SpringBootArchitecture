# Spring Boot Architecture
- Java 20
- Spring Boot
- Spring MVC
- Spring Data
- Spring Security
- Spring Rest

## Lesson Steps
> Spring MVC

### Reference Documentation

* [Github](https://github.com/emre-unaldi/SpringBootArchitecture)

```shell
docker
```
* [H2 Console](https://localhost:8001/h2-console)
* [Swagger](https://localhost:8001/swagger-ui.html)

```shell
Step 1
$   ./mvnw clean package -DskipTests

Step 2
$   docker-compose up
$   docker ps

Step 3 
POSTMAN

// ADD
http://localhost:8000/docker/v1/create/product

// List
http://localhost:8000/docker/v1/list/product

// FIND
http://localhost:8000/docker/v1/find/product/1

// DELETE
http://localhost:8000/docker/v1/delete/product/1

Step 4
$   docker exec -it spring_docker_postresql_1 psql -U postgres studentdb

Step 5
$   studentdb = # \dt ==> Tabloları göstermek
$   studentdb = # select * from product
$   studentdb = # \q ==> ÇIKIŞ
```