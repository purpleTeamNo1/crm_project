# Swagger UI configuration
- ### Step 1: Dependency import
~~~xml
<!--pom.xml-->
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-boot-starter</artifactId>
    <version>3.0.0</version>
</dependency>
~~~
- ### Step2: modify project configuration
  - Add EnableOpenApi annotation on xxxApplication.java class
  ~~~java
  //BackEndApplication.java
    @EnableOpenApi
    @SpringBootApplication
    public class BackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwaggertestApplication.class, args);
    }
  }
  ~~~
  - Add code in application.yml
  ~~~yaml
  spring:
  mvc:
    pathmatch:
      matching-strategy: ant_path_matcher
  ~~~
  Then start the application server and open url: [localhost:8080/swagger-ui/](http://localhost:8080/swagger-ui/), the swagger-ui page will display.