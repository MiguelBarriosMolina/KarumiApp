# KarumiAppService

## WARNING:

This is a simple mock-up for a login service. This is a simple, easy, and not secure implementation.
The login and authentication implementation should be the most secure part of your code. It should be reviewed by security experts to be considered a secure implementation.
This is NOT a secure implementation. Do NOT use any part of this project code as an actual login solution.

## Overview

This is a coding challenge application for Karumi. Everything you can find here is a mock-up of a real project.
You are seeing the documentation for the business logic for the Karumi App service.

This module contains the implementation and logic for a Spring MVC application exposing a couple of simple web pages with a log in and logout solution.

## Build and deploy

This application is fully built in Java, with the Spring framework.
This is a Maven project. To build it, use the following command while in this directory:

> mvn clean install

You will need to have Maven installed in your machine in order to do this.  You can find instructions for that in the official maven page:
https://maven.apache.org/

Once the application has been built a .jar file will be generated.
You can run the application using the java command and passing the jar file as an argument.
If you are located at the root of this project:

> java -jar target/KarumiAppService-0.0.1-SNAPSHOT.jar

The "mvn clean install" command will also add a copy of this jar file to your local '.m2/repository/Karumi' folder.
You can also execute the program using that jar file.

## IDE and environment configuration

This project uses Lombok as a helpful tool to reduce boilerplate code. Some IDEs might have trouble processing the Lombok annotations out of the box. If the project does not compile in your IDE, please install any Lombok plugin and enable annotation processing.

## Usage and navigation

Once the program is running, you can visit the page at:

>http://localhost:8080/

There are only three pages at the moment, the login page, the landing page, and an error page.
Trying to see any page before logging in will redirect the user to the login page.
Logging in will redirect the user to the login page.
Trying to navigate to any page while logged in will redirect the user to the error page.
Clicking on the logout button will redirect the user to the login page.

## Credentials

The credentials for log in are:

username: testuser
password: zXCQA!Bf

This credentials should NOT be here. The only reason they can be part of this README file or
a github repository in general is because at the moment they only give you permission to see one page with
no information. Any further development will require removing them from here and properly storing and sharing them with users.

## Tests

Currently all the tests for this application are integration tests, since there is no actual code to test under unit tests. Because of that, the tests can be found in the related project "KarumiAppAcceptanceTests"

## Notes

Tests found under this module are only unit tests. While they are a necessary condition for the acceptance of the code, they are not considered the acceptance tests for the application.
Those can be found in the module: KarumiAppAcceptanceTests. Tests created here should only test specific parts (or "units") of the application.
Tests that check complete runs or business requirements should be part of the acceptance test module.

This is a mock-up for a full back-end service. Any implementation found here should not be considered final.

The next steps to finish this application would be, in order of importance:

1. Remove the credentials from the code and use any form of secrets instead of raw values
2. Automate the launch of this application from the acceptance tests, and aggregate both under a parent maven module.
3. Add a sign in solution
4. Add content to the page

Once this is done, we would have a properly built basic application in Spring MVC.
Improving on this would depend completely on the future requisites and functionality we need to add,
 and wether or not Spring MVC is the correct tool to handle those requisites.
