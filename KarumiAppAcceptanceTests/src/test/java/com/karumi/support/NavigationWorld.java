package com.karumi.support;


import io.restassured.http.Cookie;
import lombok.Data;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;


@Component
@Data
@Slf4j
public class NavigationWorld {

    private String lastSessionId;

    @Getter
    private Response lastGetPageResponse;

    public void setLastGetPageResponse(Response lastGetPageResponse) {
        updateSessionId(lastGetPageResponse);
        this.lastGetPageResponse = lastGetPageResponse;
    }

    public void setLastAuthenticateResponse(Response lastAuthenticateResponse) {
       updateSessionId(lastAuthenticateResponse);
        this.lastAuthenticateResponse = lastAuthenticateResponse;
    }

    @Getter
    private Response lastAuthenticateResponse;

    public Optional<Cookie> getSessionCookie(){
        if(lastSessionId != null){
            return Optional.of(new Cookie.Builder("JSESSIONID", lastSessionId).build());
        }
        return Optional.empty();
    }


    public void updateSessionId(Response response) {
        String setCookieHeader = response.headers().get("Set-Cookie");
        if(setCookieHeader != null) {
           Arrays.stream(setCookieHeader.split(";"))
            .filter(s -> s.contains("JSESSIONID")).findAny().ifPresent(this::setLastSessionId);
           this.lastSessionId = lastSessionId.replace("JSESSIONID=", "");
        }
    }

    public void clear(){
        this.lastSessionId = null;
        this.lastGetPageResponse = null;
        this.lastAuthenticateResponse = null;
    }

}
