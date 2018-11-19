# SALMON BACKEND CONTROLLER 

###1.Components

SALMON backend controller is in java language and apply Spring mvc frameork that consist of 3 main commponent 
#### 1.1 Dispatcher servlet
- 1.1.1 Tomcat (web-container)
- 1.2.1 Apache (web-Server)

#### 1.2 Controllers: 

xxxxxxxx xxxx xxxxx xxxxxxx xxxxxxxxx xxxxxxxx x xxx 

#### 1.3.Databas:

PostgreSQL is the reational database that we use in this APPLICATION.
Servlet controller Tomcat
#### 1.4 Architector

![images](https://user-images.githubusercontent.com/17232450/47887521-208a2e00-de40-11e8-9883-5ae6b589280d.png)
##  How to run ? 
make sure that you put libraies in the proper folder.
run tomcat via your IDE 
run PostgreSQL on 5432 port.
do the CORAS setting for web.xml for appache tomcat. 



##Table of contents
<!--ts-->
   * [1 SALMON BACKEND CONTROLLER](#SALMON BACKEND CONTROLLER )
        * [1.1 Dispatcher servlet](#1 Dispatcher servlet)
        * [1.2 Controllers: ](2.Controllers: )
        * [1.3.Databas](#3.Databas)
        * [1.3.Architector](#Architector)
   * [2. How to run backend ](#How to run)
        * [2.1 Setup and requirements](#Setup and requirements)
             * [Current JDK](#Current JDK)
             * [Tools](#Tools)
             * [PostgreSQL](#remote-files)
             * [Multiple files](#multiple-files)
             * [Combo](#combo)
             * [Auto insert and update TOC](#auto-insert-and-update-toc)
       * [2.2 FrontEnd](#tests)
       * [2.3 SALMON-API](#dependency)
   * [3.Tutorials ](#Tutorials)
       * [3.1 initial terminal commands for psql](#initial terminal commands for psql)
   * [Dependency](#dependency)
<!--te-->

##Setup and requirements

#### Current JDK

find the current version according to your operation system JDK

#### Tools 

- Code edditor : Intellij IDE or Eclipce 
- Linux Terminal / PG Admin for psql
- PostgreSQL
- Apache Tomcat 
 
####  PostgreSQL
- create database "workbench" and a corresponding user with all rights granted for the DB.

- initialization on [MacOs](https://chartio.com/resources/tutorials/how-to-start-postgresql-server-on-mac-os-x/) 
- Setting Up PostgreSQL on [MacOs](https://www.tunnelsup.com/setting-up-postgres-on-mac-osx/) 

Start manualy postgrade, you can observe the connections.
```
postgres -D /usr/local/var/postgres
```
Stop manually postgrade
```
pg_ctl -D /usr/local/var/postgres stop -s -m fast
```
if you got the "Too many clients issue" please check the guide on the WIKI folder:
https://github.com/AnalyticsWorkbench/Components/wiki/Bugs-and-errors


Setup connection to Database psql:

please go to project folder and open this file 
WEB-INF/spring-servlet.xml
```
spring-servlet.xml

```
find this tag and customise it according to your psql setting

```
    <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="driverClassName" value="org.postgresql.Driver"/>
        <property name="url" value="jdbc:postgresql://127.0.0.1:2525/YYYYYYYYYY"/>
        <property name="username" value="XXXXXXXXXX"/>
        <property name="password" value="PPPPPPPP"/>
    </bean>
```    

   XXXXXXXXXX = put your database name
   
   YYYYYYYYYY = put your database userName
   
   PPPPPPPPPP = put your password 
    
## Install Appache tomcat

http://tomcat.apache.org/

suggested version:

    version 8.0.0
 
 
#### connect tomcat to psql : 
 go this folder in your system 
 
 win :
 
    C:\TomCat\apache-tomcat-8.0.0-RC5\conf\server.xml
    
 Mac :
 
    /usr/local/Cellar/tomcat/9.0.12/libexec/conf/server.xml  
 
 find the <Engine> tag and put this psql setting inside it.
 ```
  <Realm className="org.apache.catalina.realm.JDBCRealm"
  roleNameCol="ROLENAME" userRoleTable="ROLES" 
  userCredCol="USERPASS" userNameCol="USERNAME" 
  userTable="USERS" connectionPassword="PPPPPPPPPP" 
  connectionName="YYYYYYYYYY" connectionURL=
  "jdbc:postgresql://127.0.0.1:2525/XXXXXXXXXX"
  driverName="org.postgresql.Driver"/>
```  
  XXXXXXXXXX = put your database name
  
  YYYYYYYYYY = put your database userName
  
  PPPPPPPPPP = put your password 
  
  
  
  ####MAC:
 
  =================================================================
  
  go to WEB-INF/lib and find 
  
  #####postgresql-42.2.5.jar
    
  copy this lib to this address:
  
  win :
  ``` 
  C:\TomCat\apache-tomcat-8.0.0-RC5\lib
  ``` 
  mac :
  
  =================================================================
  Adding tomcat library for realm from tomcatSpringLib folder in project:
  
  <img src="https://user-images.githubusercontent.com/17232450/48679245-36ad2380-eb8e-11e8-9d3c-f8eb1956441f.png">
  
  
  
    
   3.Tutorials
   -----------
   
 
### 3.1 initial terminal commands for psql
   
  create user:
  [More info psql ](https://www.postgresql.org/docs/9.0/sql-createdatabase.html)
    make sure you give the essentional rights to the new user *(super user)
  
    $ psql -U testuser testdb 
  
  
  ====================================== 
   create data base :
      
    $ CREATE DATABASE salmondb;
  
  
  ====================================== 
  
  
     $  \dt show user table 
     $ \l check the database 
     $ \c testdb; to connect database 
   
    
  ====================================== 
   List of users and DB 
   
    $  \list 
  
  ====================================== 
  Connect username farbodaprin to salmondb database
  
     $\c salmondb;
  
  
  ====================================== 
     $ select * from users where id=1;
    
  ====================================== 
  Delete / drop database
  
    $ drop database exampleDatabase;
  
  If says cannot do first then drop;
  alter database folan is_template false;
  
  ==================================
  
    $  select * from users where id=1;
  