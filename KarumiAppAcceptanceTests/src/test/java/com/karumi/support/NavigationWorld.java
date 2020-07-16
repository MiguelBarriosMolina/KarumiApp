package com.karumi.support;


import io.restassured.http.Cookie;
import io.restassured.response.Response;
import lombok.Data;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Component
@Data
public class NavigationWorld {

    @Getter @Setter
    private Response lastGetPageResponse;

    @Getter @Setter
    private Response lastAuthenticateResponse;


}
