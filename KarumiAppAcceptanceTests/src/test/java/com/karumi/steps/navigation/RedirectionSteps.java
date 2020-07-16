package com.karumi.steps.navigation;

import com.karumi.support.KarumiAppService;
import com.karumi.support.NavigationWorld;
import cucumber.api.java.en.Then;

import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertTrue;


public class RedirectionSteps{

    private KarumiAppService karumiAppService;
    private NavigationWorld navigationWorld;

    @Autowired
    public RedirectionSteps(KarumiAppService karumiAppService, NavigationWorld navigationWorld){
        this.karumiAppService = karumiAppService;
        this.navigationWorld = navigationWorld;
    }

    @Then("I am redirected to the log in page")
    public void iAmRedirectedToLogIn(){
        assertTrue("Redirection to login page did not happen",
                navigationWorld.getLastGetPageResponse().getBody().asString().contains("login-button"));
    }


    @Then("I am redirected to the landing page")
    public void iAmRedirectedToLanding(){
        assertTrue("Redirection to landing page did not happen",
                navigationWorld.getLastGetPageResponse().getBody().asString().contains("Lorem"));
    }


    @Then("I am redirected to the error page")
    public void iAmRedirectedToError(){
        assertTrue("Redirection to error page did not happen",
                navigationWorld.getLastGetPageResponse().getBody().asString().contains("There's nothing here"));
    }
}
