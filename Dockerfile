FROM openjdk
WORKDIR /app
EXPOSE 8080
COPY ./target/dna-0.0.1-SNAPSHOT.jar ./app.jar
CMD java $JAVA_OPTIONS -jar app.jar
