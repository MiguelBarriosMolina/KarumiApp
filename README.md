# KarumiApp

This is a coding challenge application for Karumi. Everything you can find here is a mockup of a real project.
You are seeing the documentation for the parent module for the Karumi App service.

This module contains two sub-modules:
    - KarumiAppAcceptanceTests: The acceptance tests for the Karumi App service
    - KarumiAppService: The actual code and business logic for the Karumi App


Documentation for each of those can be found in their respective README files.

This application is fully built in Java, with the Spring framework. This is a maven project. To build it, use the following command while in this directory:

> mvn clean install

If you want to deploy the service using docker-compose, instructions can be found on the KarumiAppService readme.

Notes:

This is a mockup for a full back-end service. Any implementation found here should not be considered final.

This service is called Karumi App for simplicity, but as per the requirements of the coding challenge it will handle only credentials for the front-end part of the challenge.
Therefore, in a real environment, this should be called KarumiLogin or some similar name that leaves no doubt that this microservice should only handle credentials and authentication.
A generic name like "App" invites misuse, where this microservice could end up doing something outside of the scope of authentication, and therefore violating the single responsibility principle.


