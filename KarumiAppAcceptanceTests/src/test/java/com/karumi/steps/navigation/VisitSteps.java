package com.karumi.steps.navigation;

import com.karumi.support.KarumiAppService;
import com.karumi.support.NavigationWorld;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertTrue;


public class VisitSteps   {

    KarumiAppService karumiAppService;
    NavigationWorld navigationWorld;

    @Autowired
    public VisitSteps(KarumiAppService karumiAppService, NavigationWorld navigationWorld){
        this.karumiAppService = karumiAppService;
        this.navigationWorld = navigationWorld;
    }

    @When("I visit any page in the domain")
    public void iVisitAnyPage(){
        karumiAppService.getLanding();
    }


    @When("I visit a page that does not exist")
    public void iVisitPageThatDoesNotExist(){
        karumiAppService.getNonExistent();
    }

    @Then("I cannot visit any other page")
    public void cantVisitAnyPage(){
        karumiAppService.getLanding();
        assertTrue(navigationWorld.getLastGetPageResponse().getBody().asString().contains("login"));
    }
}
