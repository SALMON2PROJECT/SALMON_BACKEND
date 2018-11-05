# Farbod-Somy-BackEnd


# SALMON BACKEND CONTROLLER 
SALMON backend controller is in java language and apply Spring mvc frameork that consist of 3 main part 
1. Dispatcher servlet
1.1 Tomcat (web-container)
1.2 Apache (web-Server)

2.Controllers: 

3.Databas:
PostgreSQL is the reational database that we use in this APPLICATION.
Servlet controller Tomcat
![images](https://user-images.githubusercontent.com/17232450/47887521-208a2e00-de40-11e8-9883-5ae6b589280d.png)
##  How to run ? 
make sure that you put libraies in the proper forler.
run tomcat via your IDE 
run PostgreSQL on 5432 port.
do the CORAS setting for web.xml for appache tomcat. 

##  PostgreSQL
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

##  Appache tomcat
