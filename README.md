"# WebsocketChat" 

To run standalone:

1) mvn clean install
2) java -jar target/ChatProject-1.0-SNAPSHOT.jar
3) Open this link in two browser - http://localhost:8080/


To run in docker

1) mvn clean install
2) docker build --tag chat .
3) docker run -it -p 8080:8080 chat
4) Open this link in two browser - http://localhost:8080/
