# DB and service codegen

Mission: To incorporate auto-generated DBMS scaffolding (at the model level, specified by the classes in the models folder) that are called by auto-generated CRUDL service methods. In conjunction with swagger, the only missing part of the code stubbing with this inclusion would be the server logic seperating the API controller methods from the repository services. Targeting mongoDB for simplicity, followed by mySQL and SQLite.

I noticed incompatibilities between the OpenAPI specification (or at least how it's parsed by swagger) and what I wanted to do with changes to the YAML specs.

Now the idea is to run your swagger-codegen (Springfox) first, and then to run my script on top of it to scaffold the services and repositories for all the generated models in your project (or ones you specify).

The specific spec for this is that the generator will ignore anything with "DTO" or "Response" because I use always classes with those suffixes as server IO, not for persistence.

## Exec
This server was generated by the [swagger-codegen](https://github.com/swagger-api/swagger-codegen) project.  
By using the [OpenAPI-Spec](https://github.com/swagger-api/swagger-core), you can easily generate a server stub.  
This is an example of building a swagger-enabled server in Java using the SpringBoot framework.  

The underlying library integrating swagger to SpringBoot is [springfox](https://github.com/springfox/springfox)  

Start your server as an simple java application  

You can view the api documentation in swagger-ui by pointing to  
http://localhost:8080/  

Change default port value in application.properties
