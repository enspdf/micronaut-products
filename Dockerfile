FROM openjdk:14-alpine
COPY build/libs/micronaut-products-*-all.jar micronaut-products.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "micronaut-products.jar"]