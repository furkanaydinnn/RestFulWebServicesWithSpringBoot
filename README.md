# RestFulWebServicesWithSpringBoot
RestFul WebServices With Spring Boot

Social Media Application
User -> Posts

- Retrieve all users   - GET /users
- Create a user        - POSTS /users
- Retrieve a user      - GET /users/{id}    -> /users/1
- Delete a user        - DELTE /users/{id}. -> /users/1

- Retrieve all posts for a user   - GET /users/{id}/posts
- Create a post for a user        - POST /users/{id}/posts
- Retrieve details of a post      - GET /users/{id}/posts/{post_id}

***********************************************************************************************************


* Customize Exception Handling By extending ResponseEntityExceptionHandler abstract class.
* Implementing HATEOAS for RestFul Services
* Implementing basic internatinalization concepts to static messages in our web app for RestFul Services
* Implementing content negotiation concept for rest services
* Rest Api Documantation by using Swagger documantation. => http://localhost:8080/v2/api-docs , http://localhost:8080/swagger-ui.html
