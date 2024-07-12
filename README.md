How To Run The Code : 
  1- you can clone the project and open it on intellij idea 
  2 - this project uses mysql database so you can use docker to install the mysql latest image then enter the following commands : 
        1- pull mysql lastest image through the terminal : docker pull mysql:latest
        2- then you can run the following command to run the container : 
        docker run --name mysql-container \
        -e MYSQL_ROOT_PASSWORD=root \
        -e MYSQL_DATABASE=retail-store \
        -e MYSQL_USER=admin \
        -e MYSQL_PASSWORD=123456 \
        -d mysql:latest

  3- you can run now the spring boot application smoothly .
  4- you must register through the register endpoint in the user controller to insert users to the database

  How to run the tests :
  1- From Intellij go to the test package where you wil find the unit tests for the service and run them all.

  how to the coverage reports can be generated : 
  1- open the terminal inside intellij 
  2- mvn clean verify
  3- you will find the target folder genrated and go to this path to get the report target/site/jacoco/index.html
  4- you can open this file in chrome 
  thanks .

