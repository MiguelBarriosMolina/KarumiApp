package com.karumi.steps.navigation;

import com.karumi.support.KarumiAppService;
import com.karumi.support.NavigationWorld;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@Slf4j
public class VisitSteps   {

    KarumiAppService karumiAppService;
    NavigationWorld navigationWorld;

    @Autowired
    public VisitSteps(KarumiAppService karumiAppService, NavigationWorld navigationWorld){
        this.karumiAppService = karumiAppService;
        this.navigationWorld = navigationWorld;
    }

    @When("I visit any page in the domain")
    public void iVisitAnyPage() throws IOException {
        karumiAppService.getLanding();
    }


    @When("I visit a page that does not exist")
    public void iVisitPageThatDoesNotExist()throws IOException{
        karumiAppService.getNonExistent();
    }

    @Then("I cannot visit any other page")
    public void cantVisitAnyPage()throws IOException{
        karumiAppService.getLanding();
        assertEquals(302, navigationWorld.getLastGetPageResponse().code());
        assertTrue("I can visit the main page",
                isRedirectTo("http://localhost:8080/login"));

    }

    private boolean isRedirectTo(String location){
        return navigationWorld.getLastGetPageResponse().header("Location").equalsIgnoreCase(location);
    }
}
