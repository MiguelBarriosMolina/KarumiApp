# KarumiApp

This is a coding challenge application for Karumi. Everything you can find here is a mockup of a real project.
You are seeing the documentation for the parent module.

This folder contains two child modules:

    KarumiAppAcceptanceTests: The acceptance tests for the Karumi App service.
   
    KarumiAppService: The actual code and business logic for the Karumi App.


Documentation for each of those can be found in their respective README files.

## Building the module

To build the project, run

>mvn clean install

You can find the instructions for installing Maven in the official page: https://maven.apache.org/


Building this parent module will trigger the following steps:

- Build the KarumiAppService child module, generating an executable Jar file.
- Build the KarumiAppAcceptanceTests child module, running the automated tests agains that Jar file
 
## Running the application

   In order to run the application, simply run the jar file generated in KarumiAppService/target
   This file is generated on building this parent module or the KarumiAppService module.
   
   You can find more details, including credentials, in KarumiAppService/README.md

## Notes:

This is a mockup for a full back-end service. Any implementation found here should not be considered final.

This service is called Karumi App for simplicity, but as per the requirements of the coding challenge it will handle only credentials for the front-end part of the challenge.
Therefore, in a real environment, this should be called KarumiLogin or some similar name that leaves no doubt that this microservice should only handle credentials and authentication.
A generic name like "App" invites misuse, where this microservice could end up doing something outside of the scope of authentication, and therefore violating the single responsibility principle.




