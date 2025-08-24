## new_jwt-Micro
# Update of Application and Apis

## GateWay (Backend) ##
- we need to change the localhost into vm ip address in this file .file path is provided below 
 # gateway/gateway/src/main/resources/application.yml
In this we can change the localhost into frontend application ip address
In this file we need to  update localhost into  the eruka application ip  address inn this lines of the code 
    eureka:
      client:
        serviceUrl:
          defaultZone: http://localhost:8761/eureka/

and we can follow same process for all application need set under the eruka server 

# gateway/gateway/src/main/resources/application.properties 
In above file  path redirect into 'application.properties'  in the application in this we need to change the localhost of Database into vm Database  application ip address and need to change the username and password .the changes need to do as shown below code that is from the file 

# spring.datasource.url=jdbc:mysql://localhost:3306/exam?useSSL=false&serverTimezone=UTC
# spring.datasource.username=${MYSQL_USER:root}
# spring.datasource.password=${MYSQL_PASSWORD:root}


we have to update the ip address here also follow the path of the file 
# gateway/gateway/src/main/java/com/jwt_gateway/config/CorsConfig.java
In this we need to update the localhost into frontend application ip for allowing to use services of  this application to frontend application. line of code to update
#  corsConfig.addAllowedOrigin("http://localhost:4200");


All microservices ip Address need to update here 
# gateway/gateway/src/main/java/com/jwt_gateway/config/GatewayConfig.java
In this file contain the thiscode shown below replace the localhost by the service ip address

 # public RouteLocator routes(RouteLocatorBuilder builder) {
 #       return builder.routes()
 #              .route("service1-route", r -> r.path("/service1/**")
 #                     .filters(f -> f.filter(filter).rewritePath("/service1/(?<segment>.*)",     #                     "/${segment}"))
 #                   .uri("http://localhost:9001"))
 #              .route("service2-route", r -> r.path("/service2/**")
 #                      .filters(f -> f.filter(filter).rewritePath("/service2/(?<segment>.*)",    #                          "/${segment}"))
 #                     .uri("http://localhost:9002"))
 #               .build();
 #  }


## Service1  (Backend) ##
# service1/src/main/resources/application.properties
In above file  path redirect into 'application.properties'  in the application in this we need to change the localhost of Database into vm Database  application ip address and need to change the username and password .the changes need to do as shown below code that is from the file 

# spring.datasource.url=jdbc:mysql://localhost:3306/exam?useSSL=false&serverTimezone=UTC
# spring.datasource.username=${MYSQL_USER:root}
# spring.datasource.password=${MYSQL_PASSWORD:root}

Same Changes as per Gate done on application.yml

In this file 
# service1/src/main/java/com/codingworld/service1/config/SecurityConfig.java
we need to change  as we done Gateway 
   @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(false);
            }
        };
for localhost 


## Service2  (Backend) ##

eruka changes as per gateway  changes need to follow 

for Database Localhost to cloud ip follow the servie1 application changes method

## rabbitmq-backend  (Backend) ##
eruka changes as per gateway  changes need to follow 
 and also need to update  the radis ip application.properties file
 # spring.redis.host=localhost

 And also need to change in this file path of  file also of radis ip 
# rabbitmq-backend/src/main/java/com/example/rabbitmqdemo/service/RabbitMQListener.java
# rabbitmq-backend/src/main/java/com/example/rabbitmqdemo/controller/MessageController.java

in this to file we need update the  ip address of radis 

## Radis  (Backend) ##
eruka changes as per gateway  changes need to follow 

