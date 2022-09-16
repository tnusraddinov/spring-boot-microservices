# spring-boot-microservices
    https://www.youtube.com/watch?v=rbKzR6QWKLI

```
docker-compose -f "docker-compose.yml" up -d
```


### Product service
- http://localhost:8081/
- http://localhost:8081/h2-console

### Order service
- http://localhost:8082/
- http://localhost:8082/h2-console
- http://localhost:8082/actuator/health

### Inventory service
- http://localhost:8083/
- http://localhost:8083/h2-console

### Eureka discovery server
- http://localhost:8761/

### Keycloak auth server
- http://localhost:8181/

```
docker run -p 8181:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:18.0.0 start-dev
```

### Zipkin distributed tracing server
- http://localhost:9411/

```
docker run -d -p 9411:9411 openzipkin/zipkin
```

### API gateway
- http://localhost:8084/eureka/web