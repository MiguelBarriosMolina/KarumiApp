package com.karumi.client;


import io.restassured.http.Cookie;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static io.restassured.RestAssured.given;

@Component
/**
 * Client for making calls to a running service. Defaults to port 8080.
 * Modify base.url property in /src/test/resources/application.properties
 *  if the service is not running on http://localhost:8080
 *
 */
public class WebClient {

	private Response response;
	
	@Value("${base.url}")
	private String baseUrl;


	public Response getLoginPage() {
		return given().relaxedHTTPSValidation()
				.when().get(baseUrl + "/login");
	}

	public Response getLoginPage(Cookie cookie) {
		return given().relaxedHTTPSValidation()
				.when().cookie(cookie).get(baseUrl + "/login");
	}

	public Response getMainPage() {
		return given().relaxedHTTPSValidation()
				.when().get(baseUrl + "/");
	}
	public Response getMainPage(Cookie cookie){
		return given().relaxedHTTPSValidation()
				.when().cookie(cookie).get(baseUrl + "/");
	}

	public Response getNonExistentPage() {
		return given().relaxedHTTPSValidation()
				.when().get(baseUrl + "/nonexistent");
	}

	public Response getNonExistentPage(Cookie cookie) {
		return given().relaxedHTTPSValidation()
				.when().cookie(cookie).get(baseUrl + "/nonexistent");
	}

	public Response submitCredentials(String user, String password) {
		return given().relaxedHTTPSValidation()
				.when()
				.body("{username: " + user +", password: " + password + "}")
				.post(baseUrl + "/login");
	}

	public Response logout(){
		return given().relaxedHTTPSValidation()
				.when().post(baseUrl+"/logout");
	}

}



