# SALMON Application Liturchare and Backend Controller 

We present SALMON, a collab-rating web-based annotation system, which dynamically links and recommends learning resources based on annotations. It facilitates methods of semantic analysis to automatically extract relevant content from lecture materials in the form of PDF web documents. SALMON categorizes documents automatically in a way that finding similar resources becomes faster for the learners, and they can discover communities for exciting topics. We evaluated the categorization of learning materials for our application with a gold standard library created from “Arxiv.org” testing two methods cosine similarity algorithm and greedy string tiling. Results indicate that cosine similarity is a useful method to approximate the similarity between learning materials.

<img src="https://user-images.githubusercontent.com/17232450/60957793-8d29c680-a305-11e9-9a02-59a5b63c9425.png" width= "330px">
                                                 Fig.1.  Anootaion in SALMON


<img src="https://user-images.githubusercontent.com/17232450/60957794-8d29c680-a305-11e9-926f-86a7ac7b9cf5.png" width= "630px">
                                                 Fig.2.  Anootaion UI

<img src="https://user-images.githubusercontent.com/17232450/60956672-8f8b2100-a303-11e9-9b1b-734f2d5340be.png" width= "830px">

<img src="https://user-images.githubusercontent.com/17232450/60956678-91ed7b00-a303-11e9-839a-9c173c6a0e61.png" width= "830px">
Fig.3. SALMON Architecture


# 1.Backend and Components

SALMON backend controller is in java language and applies Spring MVC framework that consists of 3 main components 
Model-View-Controller (MVC) is a pattern used in software engineering to separate the application logic from the user interface. As the name implies, the MVC pattern has three layers.
## 1.1 Backend Architecture

<img src="https://user-images.githubusercontent.com/17232450/60957795-8d29c680-a305-11e9-8cd8-ee1d7895e931.png" width= "730px">
![images](https://user-images.githubusercontent.com/17232450/47887521-208a2e00-de40-11e8-9883-5ae6b589280d.png)


The Model defines the business layer of the application, the Controller manages the flow of the application, and the View defines the presentation layer of the application.
Although the MVC pattern isn’t specific to web applications, it fits very well in this type of applications. In a Java context, the Model consists of simple Java classes, the Controller consists of servlets and the View consists of JSP pages.
Here’re some key features of the pattern:
It separates the presentation layer from the business layer
The Controller performs the action of invoking the Model and sending data to View
The Model is not even aware that it is used by some web application or a desktop application
Let’s have a look at each layer.

### 1.2 Dispatcher servlet

- 1.1.1 Tomcat (web-container)
- 1.2.1 Apache (web-Server)

### 1.3 The Model Layer

This is the data layer which contains business logic of the system, and also represents the state of the application.

It’s independent of the presentation layer, the controller fetches the data from the Model layer and sends it to the View layer.


### 1.4 Controllers: 

Controller layer acts as an interface between View and Model. It receives requests from the View layer and processes them, including the necessary validations.

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
[![SALMON](https://www.oracle.com/technetwork/java/javase/downloads/jdk12-downloads-5295953.html)


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
    
   check your psql port number and put it inside PORT defult : 5432
    
## InstallApacheTomcat
---------------------------------------------------------------------------------------------------

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
  
  
   ####postgresql-42.2.5.jar
    
  copy this lib to this address:
  
  win :
  ``` 
  C:\TomCat\apache-tomcat-8.0.0-RC5\lib
  ``` 
  mac :
  
   ``` 
   /usr/local/opt/tomcat/libexec
  ``` 
 ### Add spring libs to the WEB-INF folder 
  
---------------------------------------------------------------------------------------------------
 please go to the JAVA libs github for salmon and download SpringLibs from [javalibs-Githhub](https://github.com/SALMON2PROJECT/Java-Libraries/tree/master/tomcatSpringLib/lib%20Spring)

  add them to the WEB-INF folder as blow:
  
  
![screenshot 2018-12-21 19 45 49](https://user-images.githubusercontent.com/17232450/50358300-168bce00-0559-11e9-90e5-b483aa0d5ce0.png)


  Adding tomcat library from tomcat folder and above spring libs in project as this photo: 
  
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
  
 
   create data base :
      
    $ CREATE DATABASE salmondb;
  

  $  \dt show user table 
     $ \l check the database 
     $ \c testdb; to connect database 
   
    
  List of users and DB 
   
    $  \list 
  
  Connect username farbodaprin to salmondb database
  
     $\c salmondb
     $ select * from users where id=1;

  Delete / drop database
  
    $ drop database exampleDatabase;
  
  If it  says cannot do first then drop;
  alter database Folan is_template false;

  
    $  select * from users where id=1;
  
  
  to keep the data in database:
  remove drop then second time remove create because double creation cause error in hibernate.
   
  To change the setting go to spring-servlet.xml and change this line :
  ``` 
   <prop key="hibernate.hbm2ddl.auto">create-drop</prop>
  ```
  if you want to drop all tables type this command in the teriminal:
   ```  
  DROP TABLE ant,metadatacollection,otherdata,pdfcore,pdfcorecollection,roles,users;
   ``` 
  ``` 
                    List of relations
    Schema |        Name        | Type  |    Owner    
   --------+--------------------+-------+-------------
    public | ant                | table | farbodaprin
    public | metadatacollection | table | farbodaprin
    public | otherdata          | table | farbodaprin
    public | pdfcore            | table | farbodaprin
    public | pdfcorecollection  | table | farbodaprin
    public | roles              | table | farbodaprin
    public | users              | table | farbodaprin
   ``` 
  
## CORAS BROWSER SETTING ON SERVLET 
---------------------------------------------------------------------------------------------------

open your local tomcat folder => conf => web.xml file and add this filter to the xml file 

https://tomcat.apache.org/tomcat-7.0-doc/config/filter.html


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
  #### Check dependency

after cloning the project open SALMON project with your IDE and check the SalmonController.iml
check your current tomcat version from here:

![screenshot 2018-12-16 00 25 19](https://user-images.githubusercontent.com/17232450/50048315-26269500-00c9-11e9-9cf4-784cd219d88b.png)

replace your version with:

![screenshot 2018-12-16 00 23 21](https://user-images.githubusercontent.com/17232450/50048346-d0062180-00c9-11e9-95af-4d9119e52b09.png)

Here are some additional links for Salmon application features: 

The full presentation of Salmon with entities: 

https://youtu.be/lx0zWMFNiNo (1 Hour))

Quickly test Salmon - Annotation - Unification - Recommendation
https://youtu.be/vRT1AKbf7hs
Collections layout - test the collector agent with standard digital libraries  in Salmon (9 min) 
https://youtu.be/ltprsfvVOjQ

How to setup Salmon 

https://youtu.be/rho76jfKJ0k  (Salmon Backend Setup.  1  (8 min))
https://youtu.be/mJZ35V3qzAM  (Salmon Backend Setup.  2  (5 min))
https://youtu.be/wy9VvvpzOsc  (Salmon Backend Setup.  3  (3 min))

Files:

SALMON in PDF format:
http://185.53.143.115:8090/SALMONFarbodAprin3039071.pdf
https://drive.google.com/file/d/19iXPDlLDwAJz5W009vbvARVojw3g4Us4/view?usp=sharing

Clickable PDF for bibliographies : 
http://185.53.143.115:8090/Bibliography%20for%20SALMON.pdf




