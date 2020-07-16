package com.karumi.support;



import com.karumi.client.WebClient;
import io.restassured.http.Cookie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
@Slf4j
public class KarumiAppService {


    @Autowired
    private NavigationWorld navigationWorld;
    @Autowired
    private WebClient webClient;


    public void getLoginPage()throws IOException {
        if(navigationWorld.getSessionCookie().isPresent()){
            navigationWorld.setLastGetPageResponse(webClient.getLoginPage(navigationWorld.getSessionCookie().get()));
        }else{
            navigationWorld.setLastGetPageResponse(webClient.getLoginPage());
        }
    }

    public void getLanding() throws IOException {
        if(navigationWorld.getSessionCookie().isPresent()){
            log.info("getting landing  page with cookie");
            navigationWorld.setLastGetPageResponse(webClient.getMainPage(navigationWorld.getSessionCookie().get()));
        }else{
            navigationWorld.setLastGetPageResponse(webClient.getMainPage());
        }
    }

    public void getNonExistent()throws IOException{
        if(navigationWorld.getSessionCookie().isPresent()){
            navigationWorld.setLastGetPageResponse(webClient.getNonExistentPage(navigationWorld.getSessionCookie().get()));
        }else{
            navigationWorld.setLastGetPageResponse(webClient.getNonExistentPage());
        }
    }

    public void logIn() throws IOException{
        if(navigationWorld.getSessionCookie().isPresent()){
            navigationWorld.setLastAuthenticateResponse(webClient.submitCredentials("testUser", "zXCQA!Bf", navigationWorld.getSessionCookie().get()));
        }else{
            navigationWorld.setLastAuthenticateResponse(webClient.submitCredentials("testUser", "zXCQA!Bf"));
        }
    }

    public void logInWithInvalidCredentials()throws IOException{
        if(navigationWorld.getSessionCookie().isPresent()){
            navigationWorld.setLastAuthenticateResponse(webClient.submitCredentials("wrong", "password", navigationWorld.getSessionCookie().get()));
        }else{
            navigationWorld.setLastAuthenticateResponse(webClient.submitCredentials("testUser", "zXCQA!Bf"));
        }
    }

    public void logOut()throws IOException{
        navigationWorld.setLastAuthenticateResponse(webClient.logout());
    }



}
