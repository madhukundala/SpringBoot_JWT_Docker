Application SpringBoot_JWT_Docker


Currently we uses h2 DB as inmemory Database . http://localhost:8080/h2-console
To configure ur owm mysql db , can change the configurations in properties file 
and to deploy in docker , can use the docker script where the app and mysql will be deployed in the docker container .


To install and run   mysql in docker container
docker run --name mysql-standalone -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=testDB -e MYSQL_USER=sa -e MYSQL_PASSWORD=password -d mysql:5.6

To link the application with mysql in docker 

docker run -p 8086:8086 —name urappname —-link mysql-standalone:mysql -d urappname

reactjs   :   npm install less@2.7.3 --save      npm remove less

sudo lsof -i tcp:4200

to check the db tables 

docker exec -it mysql-standalone mysql -uroot -p
use testDB

to know the ip address of docker 
docker inspect 40170375b631 | grep "IPAddress"


if using the script for docker 

Need to insert roles in the table and then only app can be accessed

If using m2 db then its is not required but need to register when ever server restarts .

Swagger : 
http://localhost:8080/swagger-ui.html#/

Healh check 
http://localhost:8080/actuator/health

To sign up 

http://localhost:8080/app/auth/signup
 Req : 
{
	"name": "test123",
	"username": "test123",
	"email": "ma.k@gmail.com",
	"password": "test123"
}

res : {
    "success": true,
    "message": "User registered successfully"
}


http://localhost:8080/app/auth/signin
req :{
	"usernameOrEmail": "test123",
	"password": "test123"
}

REs : {
    "accessToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIiwiaWF0IjoxNTMwMDgwNDc3LCJleHAiOjE1MzA2ODUyNzd9.LeULRlg3h4yOx-B7HP0beysdDLVyl-p2hIItbb1jjZEpCbBkbqq7avksC1NxHesbOvpQoHG-tHliiHw1oo9vQA",
    "tokenType": "Bearer"
}


After this use the token to acces the other end points using authorizations as OAuth 2.0 postman 

For Any queries can contact me on below details :
Email id : madhu.kundala@gmail.com . 