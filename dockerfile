FROM adoptopenjdk:16-jre
WORKDIR /target
ADD ./target/libs/guava-30.1.1-jre.jar /target/libs/guava-30.1.1-jre.jar
ADD ./target/mobile-project-1.0-SNAPSHOT.jar mobile-project-1.0-SNAPSHOT.jar
EXPOSE 8080
CMD java -jar mobile-project-1.0-SNAPSHOT.jar