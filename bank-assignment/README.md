# Description

This is a SpringBoot REST Web API backend build with Gradle (gradle wrapper file included)
Application is expect MySQL BDMS running in 3306 
Dummy data can be found in doc/data.sql (converted from accountsdb.accdb)

The server will handle requests to view statements by performing simple search on date and amount ranges

# Build

gradle clean build

# Run Application 

./gradlew bootRun