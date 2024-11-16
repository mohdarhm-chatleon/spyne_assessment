FROM maven:3.9.6-eclipse-temurin-17-alpine AS thick

WORKDIR /wow
COPY . .
RUN mvn clean install 

FROM eclipse-temurin:17 AS thin

WORKDIR /coreapiserv
COPY --from=thick /wow/infra/starter.sh .
COPY --from=thick /wow/target/backend-0.0.1-SNAPSHOT.jar .

RUN chmod 755 starter.sh
CMD bash -c "./starter.sh"
