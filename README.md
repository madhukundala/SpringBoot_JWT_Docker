SpringBoot_JWT_Docker


Currently uses h2 DB 
to configure ur owm mysql db , can change the configurations in properties file 
and to deploy in docker , can use the docker script where it will be deployed in the docker container .



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