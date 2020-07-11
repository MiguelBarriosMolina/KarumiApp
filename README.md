# KarumiApp

## What is this?

This is a coding challenge application for Karumi. Everything you can find here is a mockup of a real project.
You are seeing the documentation for the parent module for the Karumi App service.

## Project structure and details

This is a Maven module. This module contains two sub-modules:

    - KarumiAppAcceptanceTests: The acceptance tests for the Karumi App service
    
    - KarumiAppService: The actual code and business logic for the Karumi App

Documentation for each of those can be found in their respective README files.
This application is fully built in Java, with the Spring framework. This is a maven project. To build it, use the following command while in this directory:

> mvn clean install


## Notes:

Are you done?

This is a mockup for a full back-end service. Any implementation found here should not be considered final, even if you do not see any recent commits. The current idea is to do this on my free time during a busy weekend, so there's no chance I will be able to polish this completely.

Why the name?

Karumi is the place I'm applying to. What better way to name this than the KarumiApp

Why 'App'?

This service is called Karumi App for simplicity, but it is not an ideal name. This will handle only credentials for the front-end part of the challenge.
Therefore, in a real environment, this should be called KarumiLogin, KarumiAuth or some similar name that leaves no doubt that this microservice should only handle credentials and authentication. A generic name like "App" invites misuse, where this microservice could end up doing something outside of the scope of authentication, and therefore violating the single responsibility principle. But for our current purposes it is better to divide the work being done into the "KarumiApp" and "KarumiWeb" repositories, which make clear what parts of the project go where, and therefore I will stick with this name.


