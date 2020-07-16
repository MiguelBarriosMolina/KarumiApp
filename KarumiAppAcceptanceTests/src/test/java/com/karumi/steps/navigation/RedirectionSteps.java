package com.karumi.steps.navigation;

import com.karumi.support.KarumiAppService;
import com.karumi.support.NavigationWorld;
import cucumber.api.java.en.Then;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;


@Slf4j
public class RedirectionSteps{

    private NavigationWorld navigationWorld;

    @Autowired
    public RedirectionSteps(NavigationWorld navigationWorld){
        this.navigationWorld = navigationWorld;
    }

    @Then("I am redirected to the log in page")
    public void iAmRedirectedToLogIn()   {

        assertEquals(302, navigationWorld.getLastGetPageResponse().code());
        assertTrue("Redirection to login page did not happen",
                isRedirectTo("http://localhost:8080/login"));
    }

    @Then("I am redirected to the log in page after logout")
    public void iAmRedirectedToLogInAfterLogout()   {
        assertEquals(200, navigationWorld.getLastGetPageResponse().code());
        assertTrue("Redirection to login page did not happen",
                isAuthRedirectTo("http://localhost:8080/login?logout"));
    }

    @Then("I am redirected to the log in error page")
    public void iAmRedirectedToErrorLogIn()   {
        assertEquals(302, navigationWorld.getLastAuthenticateResponse().code());
        assertTrue("Redirection to login page did not happen",
                isAuthRedirectTo("http://localhost:8080/login?error"));
    }



    @Then("I am redirected to the landing page")
    public void iAmRedirectedToLanding()  {
        assertEquals(302, navigationWorld.getLastAuthenticateResponse().code());
        assertTrue("Redirection to landing page did not happen",
                isAuthRedirectTo("http://localhost:8080/"));
    }


    @Then("I am redirected to the error page")
    public void iAmRedirectedToError() throws IOException {
        assertEquals(404, navigationWorld.getLastGetPageResponse().code());
        assertTrue("Redirection to error page did not happen",
                isErrorRedirect());

    }

    private boolean isRedirectTo(String location){
        return navigationWorld.getLastGetPageResponse().header("Location").equalsIgnoreCase(location);
    }

    private boolean isErrorRedirect() throws IOException{
        return navigationWorld.getLastGetPageResponse().body().string().contains("There's nothing here");
    }

    private boolean isAuthRedirectTo(String location){
        return navigationWorld.getLastAuthenticateResponse().header("Location").equalsIgnoreCase(location);
    }

}
