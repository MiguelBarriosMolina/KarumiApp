package com.karumi.support;



import com.karumi.client.WebClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class KarumiAppService {


    @Autowired
    private NavigationWorld navigationWorld;
    @Autowired
    private WebClient webClient;


    public void getLoginPage() {
        navigationWorld.setLastGetPageResponse(webClient.getLoginPage());
    }

    public void getLanding(){
        navigationWorld.getLastAuthenticateResponse().getCookie("JSESSIONID");
        navigationWorld.setLastGetPageResponse(webClient.getMainPage());
    }

    public void getNonExistent(){
        navigationWorld.setLastGetPageResponse(webClient.getNonExistentPage());
    }

    public void logIn() {
        navigationWorld.setLastAuthenticateResponse(webClient.submitCredentials("testUser", "zXCQA!Bf"));
        navigationWorld.getLastAuthenticateResponse().prettyPrint();

    }

    public void logInWithInvalidCredentials(){
        navigationWorld.setLastAuthenticateResponse(webClient.submitCredentials("wrong", "wrong"));
    }
    public void logOut(){
        navigationWorld.setLastAuthenticateResponse(webClient.logout());
    }



}
