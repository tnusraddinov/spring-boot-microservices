# spring-boot-microservices
    https://www.youtube.com/watch?v=rbKzR6QWKLI

### Product service
- http://localhost:8081/
- http://localhost:8081/h2-console

### Order service
- http://localhost:8082/
- http://localhost:8082/h2-console

### Inventory service
- http://localhost:8083/
- http://localhost:8083/h2-console

### Eureka discovery server
- http://localhost:8761/

### Keycloak auth server
    docker run -p 8181:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:18.0.0 start-dev

### API gateway
- http://localhost:8084/eureka/web