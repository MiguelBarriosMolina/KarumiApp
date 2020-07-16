package com.karumi.steps.authentication;

import com.karumi.SpringConfig;
import com.karumi.support.KarumiAppService;
import com.karumi.support.NavigationWorld;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = { SpringConfig.class })
public class AuthenticationSteps{




    private KarumiAppService karumiAppService;
    private NavigationWorld navigationWorld;

    @Autowired
    public AuthenticationSteps(KarumiAppService karumiAppService, NavigationWorld navigationWorld){
        this.karumiAppService = karumiAppService;
        this.navigationWorld = navigationWorld;
    }

    @Given("I am authenticated")
    public void iAmAuthenticated(){
        karumiAppService.logIn();
    }

    @Given("I am not authenticated")
    public void iAmNotAuthenticated(){
        karumiAppService.logOut();
    }

    @When("I submit the correct credentials")
    public void iSubmitCorrectCredentials(){
        karumiAppService.logIn();
    }

    @When("I submit incorrect credentials")
    public void iSubmitIncorrectCredentials(){
        karumiAppService.logInWithInvalidCredentials();
    }

    @When("I click the logout button")
    public void iLogOut(){
        karumiAppService.logOut();
    }
}
