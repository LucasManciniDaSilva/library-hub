#!/bin/bash

driver="NADA"
url="NADA"
username="NADA"
password="NADA"
environment="NADA"

getProperties() {
  driver=com.mysql.cj.jdbc.Driver
  url="jdbc:mysql:\/\/${DATABASE_HOST:-localhost}:${DATABASE_PORT:-3306}\/api_all-chars?useSSL=false"
  username=${DATABASE_USER_NAME:-api_all-chars}
  password=${DATABASE_USER_PASSWORD:-api_all-chars}
}

setPomDbDeploy(){
/bin/cp pom-unparsed.xml pom.xml
pom=pom.xml

sed  -i -e  's/\${spring.database.driverClassName}/'"$driver"'/g' $pom
sed  -i -e  's/\${spring.datasource.url}/'"$url"'/g' $pom
sed  -i -e  's/\${spring.datasource.username}/'"$username"'/g' $pom
sed  -i -e  's/\${spring.datasource.password}/'"$password"'/g' $pom
}

runDbDeploy(){
mvn clean test dbdeploy:update
}

debug(){
	echo "driver $driver"
	echo "url $url"
	echo "username $username"
	echo "password  $password"
}


main(){
  environment=$1
  getProperties
  setPomDbDeploy
  runDbDeploy
}
main $*

