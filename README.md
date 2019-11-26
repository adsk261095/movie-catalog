#Movie-Catalog Application

Welcome to the movie-catalog wiki!

In this project, I have used micro-service architecture to develop the application.

## This application has 3 main services:
### 1. movie-catalog-service
`spring.application.name=movie-catalog-service`

`server.port=8081 `

### 2. movie-info-service
`spring.application.name=movie-info-service`

`server.port=8082`

### 3.movie-rating-service
`spring.application.name=movie-rating-service`

`server.port=8083`

### Then we have the **Edureka server** (Discovery server):
`server.port=8761`

`eureka.client.register-with-eureka=false`

`eureka.client.fetch-registry=false`

***

### Some Important Points:
* All the 3 microservices have registered with the Edureka server as Edureka Client(@EnableEdurekaClient)
* If there are multiple instances of the same microservice running on different ports and they are registered with EdurekaServer. Then Edureka also does load balancing(using @LoadBalance) among these same instances of the microservice.
* REST Api request are made using RestTemplate instance(singleton class, using @Bean)

## API:
### 1. movie-catalog-service

localhost:8081/catalog/{userId}

**Response:** Gets the movie info and ratings that are rated by this user.

`{`

`name:"avengers",`

`description:"action",`

`rating:3,`

`}`

_Note: In the movie-catalog-service response, we get name of the movie from movie-info-service and rating of the movie from movie-rating-service._

### 2. movie-info-service

localhost:8082/movies/{movieId}

**Response:** Gets the movie info corresponding to this movie Id.

`{`

`name:"avengers",`

`movieId:"123"`

`}`


### 3. movie-rating-service

localhost:8083/user/{userId}

**Response:** Gets the movieId, movieRating, movieFrequency corresponding to this userId.

`{`

`movieId: "123",`

`rating: 4,`

`frequency: 30`

`}`

