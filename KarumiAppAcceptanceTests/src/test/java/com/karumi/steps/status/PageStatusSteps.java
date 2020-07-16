package com.karumi.steps.status;

import com.karumi.support.KarumiAppService;
import com.karumi.support.NavigationWorld;

import cucumber.api.java.en.Given;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;


public class PageStatusSteps  {

    private KarumiAppService karumiAppService;
    private NavigationWorld navigationWorld;

    @Autowired
    public PageStatusSteps(KarumiAppService karumiAppService, NavigationWorld navigationWorld){
        this.karumiAppService = karumiAppService;
        this.navigationWorld = navigationWorld;
    }

    @Given("the web page is up and running")
    public void givenPageIsUpAndRunning() throws IOException {
        navigationWorld.clear();
        karumiAppService.getLoginPage();
        Assert.assertNotEquals(navigationWorld.getLastGetPageResponse().code(), 404);
    }

}
