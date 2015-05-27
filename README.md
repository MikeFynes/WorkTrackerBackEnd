Implementation Guide

Back End System

Server requirements:

Apache Tomcat server, minimum requirement version 8.0.15

MySQL server running on localhost of Apache Tomcat server, minimum version 5.5.42 - MySQL

First ensure a MYSQL database is running on the local host of the Tomcat server the application will run on.  Then download the application from GitHub and run the follow-ing in your git terminal.

cd my/project/path 
git clone https://github.com/MikeFynes/WorkTrackerBackEnd.git

Where my/project/path is wherever you intend to save the project on your device.

Open the project in Netbeans or your preferred IDE and change the database path, username and password from the file persistence.xml.  This will ensure the application connects to your database and does not attempt to connect to a database that does not exist.

Clean and build the application.  If you are using Netbeans you can now find the .war package in your project path folder named “dist”.  This is the file you will need to upload to your Tomcat application server.
For testing purposes codes for accessing the front end application have been added manually to the MySQL table named codes, replace this system with your login system of choice.

