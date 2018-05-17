# spring-boot-react-poc

A proof of concept for a full stack app with a React front-end and a back-end containing a REST API service built with Java and Spring Boot.

### Claim service API - http://localhost:8080

In server directory:

Run with maven
```sh
$ mvn spring-boot:run
```
or build and run docker image:
```sh
$ docker-compose up
```

| Endpoint        | HTTP Method | CRUD Method | Result        |
|-----------------|-------------|-------------|---------------|
| /v1/claims/     | GET         | READ        | get all claims|
| /v1/claims/{id} | GET         | READ        | get a claim   |
| /v1/claims/     | POST        | CREATE      | create a claim|
| /v1/claims/{id} | PUT         | UPDATE      | update a claim|
| /v1/claims/{id} | DELETE      | DELETE      | delete a claim|


### Client React app - http://localhost:3000

In client directory:
```sh
$ yarn start
```

### Todo:

- Replace H2 in-memory database with a Postgres db.
- Put the client and server in their own docker containers.
- Deploy app to AWS.
- Enhance style of React front-end.
