# Spring-boot demo project
Demo Spring Boot application running inside docker container linked with MySQL and Redis containers.

## How to run it with Docker
Assume you already have Docker installed. See https://docs.docker.com/installation/.

~~~
git clone https://github.com/chiker/falcon.git
cd falcon
mvn clean package docker:build
~~~

Run MySQL 5.6 in Docker container:

~~~
sudo docker run --name pipeline-mysql -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -e MYSQL_DATABASE=pipeline_db -d mysql:5.6
~~~

Run Redis in Docker container:

~~~
sudo docker run --name pipeline-redis -d redis
~~~

Run demo application in Docker container and link to pipeline-mysql and pipeline-redis:

~~~
sudo docker run -p 8080:8080 --name pipeline-app --link pipeline-mysql:mysql --link pipeline-redis:redis -d falcon/data-pipeline
~~~

You can check the log by
~~~
docker logs data-pipeline
~~~

## Testing

Send JSON request to server

~~~
curl -H 'Content-Type: application/json' -X POST -d '{"id":1,"content":"Hello, User!"}' http://localhost:8080/orders
~~~

Open http://localhost:8080 in browser and you should see messages appearing in the list.