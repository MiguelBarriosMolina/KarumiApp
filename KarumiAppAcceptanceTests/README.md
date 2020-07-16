# KarumiAppAcceptanceTests

## Overview

This is a coding challenge application for Karumi. Everything you can find here is a mock-up of a real project.
You are seeing the documentation of the acceptance tests of the Karumi App service.

## This module

This module contains the implementation of the acceptance tests for the application.
In order for the tests to pass, the KarumiAppService maven module needs to be running on your machine.
You can find instructions to run it in its README file

## Building the module

You can run the whole test suite using the following command:

> mvn test

Any maven build of this module will also run the whole acceptance test suite.
Running this module automatically deploys the service from Jar file located in KarumiAppService/target/
The build will fail if the jar is not present, but it is auto generated on building the KarumiAppService module or the parent module.



## Notes

Tests found under this module are only the acceptance tests. Since the business logic is not located here, any future unit tests will have to be added in the other module.
