#FROM eclipse-temurin:17-jdk-alpine as build
#WORKDIR /workspace/app
#
#COPY mvnw .
#COPY .mvn .mvn
#COPY pom.xml .
#COPY src src
#
#RUN ./mvnw install -DskipTests
#RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)
#
#FROM eclipse-temurin:17-jdk-alpine
#VOLUME /tmp
#ARG DEPENDENCY=/workspace/app/target/dependency
#COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
#COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
#COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
#ENTRYPOINT ["java","-cp","app:app/lib/*","com.brandon_detty.taskman_rest_api.TaskmanRestApiApplication"]



#FROM maven:latest
#
#WORKDIR /taskman
#COPY . .
#RUN mvn clean install
#
#CMD mvn spring-boot:run

FROM eclipse-temurin:17-jdk-alpine
ARG DEP=target/dependency
COPY ${DEP}/BOOT-INF/lib /app/lib
COPY ${DEP}/META-INF /app/META-INF
COPY ${DEP}/BOOT-INF/classes /app
#ENTRYPOINT ["java","-cp","app:app/lib/*","hello.Application"]
ENTRYPOINT ["java","-cp","app:app/lib/*","com.brandon_detty.taskman_rest_api.TaskmanRestApiApplication"]