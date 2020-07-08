# KarumiAppAcceptanceTests

## Overview

This is a coding challenge application for Karumi. Everything you can find here is a mock-up of a real project.
You are seeing the documentation a the child module of the Karumi App service.

## This module

This module contains the implementation of the acceptance tests for the application.
As part of the build requirements this module makes real calls to the service module to run the tests.
In order for this module to be built, it will need to run a live instance of the service module using docker-compose.

## Building the module

You can run the tests using the following command:

> mvn test

Any maven build of this module will also run the whole acceptance test suite.

## Notes

Tests found under this module are only the acceptance tests.
Unit tests can be found in the module: KarumiAppService. Tests created here should only test business requirements.
