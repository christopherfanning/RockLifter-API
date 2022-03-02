# Rock Lifter - API


## General approach
* Spring Boot framework sporting Lombok and Spring Security
* 4 models
* 5 controllers
* 4 services
* Interfacing with a Postgres database by default
* RESTful routing for the API. 
* JWT authorization
* Username - Password authentication 


## Challenges
* Setting up the CORS policy in spring was tricky.  Much research was needed. I hadn't even heard about CORS before running into this problem.
* 



## API endpoints
| Request Type | URL                          | Request Body      | Request Header | Function                 | 
|--------------|------------------------------|-------------------|----------------|--------------------------|
| GET          | /api/project/{projId}        | None              | None           | Get a specific project   |
| POST         | /api/project                 | title, content    | JPA Token      | Create new project       |
| GET          | /api/project/{id}/issue/{id} | None              | None           | Get a specific issue     |
| POST         | /api/project/{id}/issue      | title, content    | JPA Token      | Create A new issue       |
| PUT          | /api/project/{id}/issue/{id} | title, content    | JPA Token      | Update an existing issue |
----
