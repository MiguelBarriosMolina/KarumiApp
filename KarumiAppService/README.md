# KarumiAppService

## WARNING:

This is a simple mock-up for a login service. This is a simple, easy, and not secure implementation.
The login and authentication implementation should be the most secure part of your code. It should be reviewed by security experts to be considered a secure implementation.
This is NOT a secure implementation. Do NOT use any part of this project code as an actual login solution.

## Overview

This is a coding challenge application for Karumi. Everything you can find here is a mock-up of a real project.
You are seeing the documentation a the child module of the Karumi App service.

This module contains the implementation and logic for the login and authentication service. It will expose an API that the web page can call to retrieve a JWT token.
Documentation for the API specification can be found under spec/openapi.yml

## Build and deploy


This application is fully built in Java, with the Spring framework. This is a maven project. To build it, use the following command while in this directory:

> mvn clean install


This module will be built and deployed using docker-compose. Once the functionality is implemented, you will be able to run the following command to deploy this in a docker container:

> docker-compose up

## Notes

Tests found under this module are only unit tests. While they are a necessary condition for the acceptance of the code, they are not considered the acceptance tests for the application.
Those can be found in the module: KarumiAppAcceptanceTests. Tests created here should only test specific parts (or "units") of the application.
Tests that check complete runs or business requirements should be part of the acceptance test module.

This is a mock-up for a full back-end service. Any implementation found here should not be considered final.

This service is called Karumi App for simplicity, but as per the requirements of the coding challenge it will handle only credentials for the front-end part of the challenge.
Therefore, in a real environment, this should be called KarumiLogin or some similar name that leaves no doubt that this microservice should only handle credentials and authentication.
A generic name like "App" invites misuse, where this microservice could end up doing something outside of the scope of authentication, and therefore violating the single responsibility principle.


