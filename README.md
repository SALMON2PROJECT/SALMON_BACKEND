# Salmon

## Components

SALMON backend controller is in java language and applies Spring MVC framework that consists of 3 main components 
#### Dispatcher servlet
- 1.1.1 Tomcat (web-container)
- 1.2.1 Apache (web-Server)

#### Controllers: 

xxxxxxxx xxxx xxxxx xxxxxxx xxxxxxxxx xxxxxxxx x xxx 

#### Database:

PostgreSQL is the relational database that we use in this APPLICATION.
Servlet controller Tomcat
#### Architector

![images](https://user-images.githubusercontent.com/17232450/47887521-208a2e00-de40-11e8-9883-5ae6b589280d.png)
##  How to run? 
Make sure that you put libraries in the proper folder.
Run tomcat via your IDE 
run PostgreSQL on 5432 port.
Do the CORAS setting for web.xml for apache tomcat. 



## Table of contents
<!--ts-->
   * [1.SALMON BACKEND CONTROLLER ](#Salmon)
        * [1.1 Dispatcher servlet](#Dispatcher servlet)
        * [1.2 Controllers: ](#Controllers)
        * [1.3 Databas](#3.Databas)
        * [1.4 Architector](#Architector)
   * [How to run backend](#How to run)
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

## Setup and requirements

#### Current JDK

find the current version according to your operating system JDK

#### Tools 

- Code edditor : Intellij IDE or Eclipce 
- Linux Terminal / PG Admin for psql
- PostgreSQL
- Apache Tomcat 
 
####  PostgreSQL
- create database "workbench" and a corresponding user with all rights granted for the DB.

- initialization on [MacOs](https://chartio.com/resources/tutorials/how-to-start-postgresql-server-on-mac-os-x/) 
- Setting Up PostgreSQL on [MacOs](https://www.tunnelsup.com/setting-up-postgres-on-mac-osx/) 

Start manually postgres, you can observe the connections.
```
postgres -D /usr/local/var/postgres
```
Stop manually postgres
```
pg_ctl -D /usr/local/var/postgres stop -s -m fast
```
if you got the "Too many clients issue" please check the guide on the WIKI folder:
https://github.com/AnalyticsWorkbench/Components/wiki/Bugs-and-errors


Setup connection to Database psql:

please go to the project folder and open this file 
WEB-INF/spring-servlet.xml
```
spring-servlet.xml

```
find this tag and customize it according to your psql setting

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
    
## Install Apache Tomcat

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
  
  
  
    
   Tutorials
   -----------# SALMON BACKEND CONTROLLER 

## 1.Components

SALMON backend controller is in java language and applies Spring MVC framework that consists of 3 main components 
Model-View-Controller (MVC) is a pattern used in software engineering to separate the application logic from the user interface. As the name implies, the MVC pattern has three layers.
## 1.1 Architector

![images](https://user-images.githubusercontent.com/17232450/47887521-208a2e00-de40-11e8-9883-5ae6b589280d.png)


The Model defines the business layer of the application, the Controller manages the flow of the application, and the View defines the presentation layer of the application.
Although the MVC pattern isn’t specific to web applications, it fits very well in this type of applications. In a Java context, the Model consists of simple Java classes, the Controller consists of servlets and the View consists of JSP pages.
Here’re some key features of the pattern:
It separates the presentation layer from the business layer
The Controller performs the action of invoking the Model and sending data to View
The Model is not even aware that it is used by some web application or a desktop application
Let’s have a look at each layer.

### 1.2 Dispatcher servlet

<<<<<<< HEAD
=======
SALMON backend controller is in java language and applies Spring MVC framework that consists of 3 main components 
#### 1.1 Dispatcher servlet
>>>>>>> 18446eece81f4e65125d3a2cc764249d4af33446
- 1.1.1 Tomcat (web-container)
- 1.2.1 Apache (web-Server)

### 1.3 The Model Layer

This is the data layer which contains business logic of the system, and also represents the state of the application.

<<<<<<< HEAD
It’s independent of the presentation layer, the controller fetches the data from the Model layer and sends it to the View layer.


### 1.4 Controllers: 

Controller layer acts as an interface between View and Model. It receives requests from the View layer and processes them, including the necessary validations.
=======
#### 1.3.Database:

PostgreSQL is the relational database that we use in this APPLICATION.
Servlet controller Tomcat
#### 1.4 Architector

![images](https://user-images.githubusercontent.com/17232450/47887521-208a2e00-de40-11e8-9883-5ae6b589280d.png)
##  How to run? Make sure that you put libraries in the proper folder.
Run tomcat via your IDE 
run PostgreSQL on 5432 port.
Do the CORAS setting for web.xml for apache tomcat. 
>>>>>>> 18446eece81f4e65125d3a2cc764249d4af33446

The requests are further sent to Model layer for data processing, and once they are processed, the data is sent back to the Controller and then displayed on the View.

## 1.5 View
This layer represents the output of the application, usually some form of UI. The presentation layer is used to display the Model data fetched by the Controller.

### 1.6 Database:

PostgreSQL is the relational database that we use in this APPLICATION.
Servlet controller Tomcat


## Table of contents
<!--ts-->
   * [1. SALMON BACKEND CONTROLLER ](#Salmon)
   
        * [1.1 DispatcherServlet](#DispatcherServlet)
        * [1.2 Controllers: ](#Controllers)
        * [1.3 Databas](#3.Databas)
   * [2. Architector](#Architector)
        
   * [3. HowToRunSALMON](#HowToRunSALMON)
   
       * [2.1 Setup and requirements for backend](#SetupAndRequirementsForBackend)
        
            * [Current JDK](#CurrentJDK)
            * [Tools](#Tools) 
            * [PostgreSQL](#remote-files)
            * [Install Apache Tomcat](#InstallApacheTomcat)
            * [Combo](#combo)
            * [Auto insert and update TOC](#auto-insert-and-update-toc)
             
       * [2.2 FrontEnd](#tests)
       * [2.3 SALMON-API](#dependency)
       
   * [4. Tutorials ](#Tutorials)
   
       * [3.1 initial terminal commands for psql](#InitialTerminalCommandsForpPsql)
       
   * [Dependency](#dependency)
<!--te-->


## HowToRunSALMON

 - Make sure that you put MVC in the proper folder.
 - Run tomcat via your IDE 
 - run PostgreSQL on 5432 port.
 - Install npm and react and follow the requirements [www.fofd.kie](www.google.com).

## SetupAndRequirementsForBackend

open this gitHub repo 

#### Current JDK

find the current version according to your operating system JDK

#### Tools 

- Code edditor : Intellij IDE or Eclipce 
- Linux Terminal / PG Admin for psql
- PostgreSQL
- Apache Tomcat 
 
#### PostgreSQL
- create database "workbench" and a corresponding user with all rights granted for the DB.

- initialization on [MacOs](https://chartio.com/resources/tutorials/how-to-start-postgresql-server-on-mac-os-x/) 
- Setting Up PostgreSQL on [MacOs](https://www.tunnelsup.com/setting-up-postgres-on-mac-osx/) 

Start manually postgres, you can observe the connections.
```
postgres -D /usr/local/var/postgres
```
Stop manually postgres
```
pg_ctl -D /usr/local/var/postgres stop -s -m fast
```
if you got the "Too many clients issue" please check the guide on the WIKI folder:
https://github.com/AnalyticsWorkbench/Components/wiki/Bugs-and-errors


Setup connection to Database psql:

please go to the project folder and open this file 
WEB-INF/spring-servlet.xml
```
spring-servlet.xml

```
find this tag and customize it according to your psql setting

```
    <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="driverClassName" value="org.postgresql.Driver"/>
        <property name="url" value="jdbc:postgresql://127.0.0.1:PORT/YYYYYYYYYY"/>
        <property name="username" value="XXXXXXXXXX"/>
        <property name="password" value="PPPPPPPP"/>
    </bean>
```    

   XXXXXXXXXX = put your database name
   
   YYYYYYYYYY = put your database userName
   
   PPPPPPPPPP = put your password 
    
<<<<<<< HEAD
   check your psql port number and put it inside PORT defult : 5432
    
## InstallApacheTomcat
---------------------------------------------------------------------------------------------------
=======
## Install Apache Tomcat
>>>>>>> 18446eece81f4e65125d3a2cc764249d4af33446

http://tomcat.apache.org/

suggested version:

    version 8.0.0 or upper  
    
 
    
[![SALMON](https://user-images.githubusercontent.com/17232450/50100074-ddcdbb00-021f-11e9-881b-43973e7fb320.png)](https://youtu.be/rho76jfKJ0k)


[TOMCAT](https://wolfpaulus.com/mac/tomcat/)


## connect tomcat to psql : 
---------------------------------------------------------------------------------------------------

 go this folder in your system and edit server.xml filw
 
 win :
 
    C:\TomCat\apache-tomcat-8.0.0-RC5\conf\server.xml
    
 Mac :
 
    /usr/local/Cellar/tomcat/8.0.0/libexec/conf/server.xml  
    
  [TUTORIAL VIDEO](https://www.youtube.com/watch?v=h_qQOVDTxo8)
 
 find the <Engine> tag and put this psql setting inside it. (over the host tag)
 ```
  <Realm className="org.apache.catalina.realm.JDBCRealm"
  roleNameCol="ROLENAME" userRoleTable="ROLES" 
  userCredCol="USERPASS" userNameCol="USERNAME" 
  userTable="USERS" connectionPassword="PPPPPPPPPP" 
  connectionName="YYYYYYYYYY" connectionURL=
  "jdbc:postgresql://127.0.0.1:PORT-NUMBER/XXXXXXXXXX"
  driverName="org.postgresql.Driver"/>
```  
  XXXXXXXXXX = put your database name
  
  YYYYYYYYYY = put your database userName
  
  PPPPPPPPPP = put your password 
  
  PORT-NUMBER = Enter your port number
  
  
<<<<<<< HEAD
   ####postgresql-42.2.5.jar
=======
  ####MAC:
 
  =================================================================
  go to WEB-INF/lib and find 
  
  #####postgresql-42.2.5.jar
>>>>>>> 18446eece81f4e65125d3a2cc764249d4af33446
    
  copy this lib to this address:
  
  win :
  ``` 
  C:\TomCat\apache-tomcat-8.0.0-RC5\lib
  ``` 
  mac :
<<<<<<< HEAD
  
   ``` 
   /usr/local/opt/tomcat/libexec
  ``` 
 ### Add spring libs to the WEB-INF folder 
  
---------------------------------------------------------------------------------------------------
  please go to the JAVA libs github for salmon and download SpringLibs from [javalibs-Githhub](https://github.com/SALMON2PROJECT/Java-Libraries/tree/master/tomcatSpringLib/lib%20Spring)

  add them to the WEB-INF folder as blow:
  
  
![screenshot 2018-12-21 19 45 49](https://user-images.githubusercontent.com/17232450/50358300-168bce00-0559-11e9-90e5-b483aa0d5ce0.png)


  Adding tomcat library from tomcat folder and above spring libs in project as this photo: 
=======
  ================================================================
  Adding tomcat library for realm from tomcatSpringLib folder in project:
>>>>>>> 18446eece81f4e65125d3a2cc764249d4af33446
  
  <img src="https://user-images.githubusercontent.com/17232450/48679245-36ad2380-eb8e-11e8-9d3c-f8eb1956441f.png">
  
  
  tomcat folder lib on mac :
  
    /usr/local/apache-tomcat-8.0.0-RC5/lib

    
    
  *** if antlr-2.7.7.jar is exist in your spring lib please remove it.
  
Tutorials
---------------------------------------------------------------------------------------------------
   
 
 
### 3.1 initial terminal commands for psql
   
  create user:
  [More info psql ](https://www.postgresql.org/docs/9.0/sql-createdatabase.html)
    make sure you give the essential rights to the new user *(superuser)
  
    $ psql -U testuser testdb 
  
<<<<<<< HEAD
 
=======
  
  
   create data base :
   ====================================== 
      
     $ CREATE DATABASE salmondb;
   show user table 
   
     $  \dt 
   check the database 
     
     $ \l 
     
   to connect database to user 
     
     
     $ \c testdb; 
   
    
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
  
  If it  says cannot do first then drop;
  alter database Folan is_template false;
  
  ==================================
  
    $  select * from users where id=1;
  # SALMON BACKEND CONTROLLER 

###1.Components

SALMON backend controller is in java language and applies Spring MVC framework that consists of 3 main components 
#### 1.1 Dispatcher servlet
- 1.1.1 Tomcat (web-container)
- 1.2.1 Apache (web-Server)

#### 1.2 Controllers: 

xxxxxxxx xxxx xxxxx xxxxxxx xxxxxxxxx xxxxxxxx x xxx 

#### 1.3.Database:

PostgreSQL is the relational database that we use in this APPLICATION.
Servlet controller Tomcat
#### 1.4 Architector

![images](https://user-images.githubusercontent.com/17232450/47887521-208a2e00-de40-11e8-9883-5ae6b589280d.png)
##  How to run? Make sure that you put libraries in the proper folder.
Run tomcat via your IDE 
run PostgreSQL on 5432 port.
Do the CORAS setting for web.xml for apache tomcat. 



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

find the current version according to your operating system JDK

#### Tools 

- Code edditor : Intellij IDE or Eclipce 
- Linux Terminal / PG Admin for psql
- PostgreSQL
- Apache Tomcat 
 
####  PostgreSQL
- create database "workbench" and a corresponding user with all rights granted for the DB.

- initialization on [MacOs](https://chartio.com/resources/tutorials/how-to-start-postgresql-server-on-mac-os-x/) 
- Setting Up PostgreSQL on [MacOs](https://www.tunnelsup.com/setting-up-postgres-on-mac-osx/) 

Start manually postgres, you can observe the connections.
```
postgres -D /usr/local/var/postgres
```
Stop manually postgres
```
pg_ctl -D /usr/local/var/postgres stop -s -m fast
```
if you got the "Too many clients issue" please check the guide on the WIKI folder:
https://github.com/AnalyticsWorkbench/Components/wiki/Bugs-and-errors


Setup connection to Database psql:

please go to the project folder and open this file 
WEB-INF/spring-servlet.xml
```
spring-servlet.xml

```
find this tag and customize it according to your psql setting

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
    
## Install Apache Tomcat

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
  
  ---------------------------------------------------------------------------------------------------
  Adding tomcat library for realm from tomcatSpringLib folder in project:
  
  <img src="https://user-images.githubusercontent.com/17232450/48679245-36ad2380-eb8e-11e8-9d3c-f8eb1956441f.png">
  
  
  
    
   Tutorials
   ---------------------------------------------------------------------------------------------------
   
 
### 3.1 initial terminal commands for psql
   
  create user:
  [More info psql ](https://www.postgresql.org/docs/9.0/sql-createdatabase.html)
    make sure you give the essential rights to the new user *(superuser)
  
    $ psql -U testuser testdb 
  
   
>>>>>>> 18446eece81f4e65125d3a2cc764249d4af33446
   create data base :
      
    $ CREATE DATABASE salmondb;
  
<<<<<<< HEAD

  $  \dt show user table 
=======
  

  
  
     $  \dt show user table 
>>>>>>> 18446eece81f4e65125d3a2cc764249d4af33446
     $ \l check the database 
     $ \c testdb; to connect database 
   
    
<<<<<<< HEAD
  List of users and DB 
=======
  
   List of users and DB 
>>>>>>> 18446eece81f4e65125d3a2cc764249d4af33446
   
    $  \list 
  
  Connect username farbodaprin to salmondb database
  
<<<<<<< HEAD
     $\c salmondb
     $ select * from users where id=1;

=======
     $\c salmondb;
  
  
  
     $ select * from users where id=1;
    
 
  Delete / drop database
    $ drop database exampleDatabase;
  
  If it  says cannot do first then drop;
  alter database Folan is_template false;
    
    $  select * from users where id=1;
  
   
 
### 3.1 initial terminal commands for psql
   
  create user:
  [More info psql ](https://www.postgresql.org/docs/9.0/sql-createdatabase.html)
    make sure you give the essential rights to the new user *(superuser)
  
    $ psql -U testuser testdb 
  
  
 
   create data base :
      
    $ CREATE DATABASE salmondb;
  

  $  \dt show user table 
     $ \l check the database 
     $ \c testdb; to connect database 
   
    
  
  List of users and DB 
   
    $  \list 
  ====================================== 
  Connect username farbodaprin to salmondb database
  
     $\c salmondb
     $ select * from users where id=1;
  ====================================== 
>>>>>>> 18446eece81f4e65125d3a2cc764249d4af33446
  Delete / drop database
  
    $ drop database exampleDatabase;
  
  If it  says cannot do first then drop;
  alter database Folan is_template false;
<<<<<<< HEAD

  
    $  select * from users where id=1;
  
  
## CORAS BROWSER SETTING ON SERVLET 
---------------------------------------------------------------------------------------------------

open your local tomcat folder => conf => web.xml file and add this filter to the xml file 


  ``` 
    <filter>
       <filter-name>CorsFilter</filter-name>
       <filter-class>org.apache.catalina.filters.CorsFilter</filter-class>
       <init-param>
           <param-name>cors.allowed.origins</param-name>
           <param-value>*</param-value>
       </init-param>
       <init-param>
           <param-name>cors.allowed.methods</param-name>
           <param-value>GET,POST,HEAD,OPTIONS,PUT</param-value>
       </init-param>
       <init-param>
           <param-name>cors.allowed.headers</param-name>
           <param-value>Content-Type,X-Requested-With,accept,Origin,Access-Control-Request-Method,Access-Control-Request-Headers</param-value>
       </init-param>
       <init-param>
           <param-name>cors.exposed.headers</param-name>
           <param-value>Access-Control-Allow-Origin,Access-Control-Allow-Credentials</param-value>
       </init-param>
    </filter>
       <filter-mapping>
           <filter-name>CorsFilter</filter-name>
           <url-pattern>/*</url-pattern>
       </filter-mapping>
  ``` 


=======
  ==================================
  
    $  select * from users where id=1;
  
>>>>>>> 18446eece81f4e65125d3a2cc764249d4af33446
