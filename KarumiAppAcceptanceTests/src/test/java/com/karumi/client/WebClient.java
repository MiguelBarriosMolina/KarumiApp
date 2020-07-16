package com.karumi.client;


import io.restassured.http.Cookie;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Component;


import java.io.IOException;



/**
 * Client for making calls to a running service. Defaults to port 8080.
 * Modify base.url property in /src/test/resources/application.properties
 *  if the service is not running on baseUrl
 */
@Component
@Slf4j
public class WebClient {


	private OkHttpClient client;

	@Value("${base.url}")
	private String baseUrl;

	@Autowired
	public  WebClient(){
		client = new OkHttpClient().newBuilder()
				.followRedirects(false)
				.build();

	}


	public Response getLoginPage() throws IOException {
		OkHttpClient client = new OkHttpClient().newBuilder()
				.build();
		Request request = new Request.Builder()
				.url(baseUrl+"/login")
				.method("GET", null)
				.addHeader("DNT", "1")
				.addHeader("Upgrade-Insecure-Requests", "1")
				.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.89 Safari/537.36")
				.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
				.addHeader("Sec-Fetch-Site", "none")
				.addHeader("Sec-Fetch-Mode", "navigate")
				.addHeader("Sec-Fetch-User", "?1")
				.addHeader("Sec-Fetch-Dest", "document")
				.addHeader("Cookie", "JSESSIONID=DCE1D7AF257626E9AABBE9FE0E0487B6")
				.build();
		return  client.newCall(request).execute();
	}

	public Response getLoginPage(Cookie cookie) throws IOException {
		OkHttpClient client = new OkHttpClient().newBuilder()
				.build();
		Request request = new Request.Builder()
				.url(baseUrl+"/login")
				.method("GET", null)
				.addHeader("DNT", "1")
				.addHeader("Upgrade-Insecure-Requests", "1")
				.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.89 Safari/537.36")
				.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
				.addHeader("Sec-Fetch-Site", "none")
				.addHeader("Sec-Fetch-Mode", "navigate")
				.addHeader("Sec-Fetch-User", "?1")
				.addHeader("Sec-Fetch-Dest", "document")
				.addHeader("Cookie", "JSESSIONID="+cookie.getValue())
				.build();
		return  client.newCall(request).execute();
	}


	public Response getMainPage()throws IOException{
		Request request = new Request.Builder()
				.url(baseUrl+"/")
				.method("GET", null)
				.addHeader("DNT", "1")
				.addHeader("Upgrade-Insecure-Requests", "1")
				.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.89 Safari/537.36")
				.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
				.addHeader("Sec-Fetch-Site", "none")
				.addHeader("Sec-Fetch-Mode", "navigate")
				.addHeader("Sec-Fetch-User", "?1")
				.addHeader("Sec-Fetch-Dest", "document")
				.addHeader("Cookie", "JSESSIONID=DCE1D7AF257626E9AABBE9FE0E0487B6")
				.build();
		return client.newCall(request).execute();
	}

	public Response getMainPage(Cookie cookie)throws IOException{
		Request request = new Request.Builder()
				.url(baseUrl+"/")
				.method("GET", null)
				.addHeader("DNT", "1")
				.addHeader("Upgrade-Insecure-Requests", "1")
				.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.89 Safari/537.36")
				.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
				.addHeader("Sec-Fetch-Site", "none")
				.addHeader("Sec-Fetch-Mode", "navigate")
				.addHeader("Sec-Fetch-User", "?1")
				.addHeader("Sec-Fetch-Dest", "document")
				.addHeader("Cookie", "JSESSIONID="+cookie.getValue())
				.build();
		return client.newCall(request).execute();
	}


	public Response getNonExistentPage() throws IOException {
		Request request = new Request.Builder()
				.url(baseUrl+"/aaaaaaa")
				.method("GET", null)
				.addHeader("DNT", "1")
				.addHeader("Upgrade-Insecure-Requests", "1")
				.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.89 Safari/537.36")
				.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
				.addHeader("Sec-Fetch-Site", "none")
				.addHeader("Sec-Fetch-Mode", "navigate")
				.addHeader("Sec-Fetch-User", "?1")
				.addHeader("Sec-Fetch-Dest", "document")
				.addHeader("Cookie", "JSESSIONID=DCE1D7AF257626E9AABBE9FE0E0487B6")
				.build();
		return client.newCall(request).execute();

	}

	public Response getNonExistentPage(Cookie cookie) throws IOException {
		Request request = new Request.Builder()
				.url(baseUrl+"/aaaaaaa")
				.method("GET", null)
				.addHeader("DNT", "1")
				.addHeader("Upgrade-Insecure-Requests", "1")
				.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.89 Safari/537.36")
				.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
				.addHeader("Sec-Fetch-Site", "none")
				.addHeader("Sec-Fetch-Mode", "navigate")
				.addHeader("Sec-Fetch-User", "?1")
				.addHeader("Sec-Fetch-Dest", "document")
				.addHeader("Cookie", "JSESSIONID="+cookie.getValue())
				.build();
		return client.newCall(request).execute();

	}

	public Response submitCredentials(String user, String password ) throws IOException {


		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, "password="+password+"&username="+user);
		Request request = new Request.Builder()
				.url(baseUrl+"/login")
				.method("POST", body)
				.addHeader("Origin", baseUrl)
				.addHeader("Upgrade-Insecure-Requests", "1")
				.addHeader("DNT", "1")
				.addHeader("Content-Type", "application/x-www-form-urlencoded")
				.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.89 Safari/537.36")
				.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
				.addHeader("Sec-Fetch-Site", "same-origin")
				.addHeader("Sec-Fetch-Mode", "navigate")
				.addHeader("Sec-Fetch-User", "?1")
				.addHeader("Sec-Fetch-Dest", "document")
				.build();
		return client.newCall(request).execute();
	}

	public Response submitCredentials(String user, String password, Cookie cookie) throws IOException {

		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, "password="+password+"&username="+user);

		Request request = new Request.Builder()
				.url(baseUrl+"/login")
				.method("POST", body)
				.addHeader("Origin", baseUrl)
				.addHeader("Upgrade-Insecure-Requests", "1")
				.addHeader("DNT", "1")
				.addHeader("Content-Type", "application/x-www-form-urlencoded")
				.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.89 Safari/537.36")
				.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
				.addHeader("Sec-Fetch-Site", "same-origin")
				.addHeader("Sec-Fetch-Mode", "navigate")
				.addHeader("Sec-Fetch-User", "?1")
				.addHeader("Sec-Fetch-Dest", "document")
				.build();
		return client.newCall(request).execute();
	}

	public Response logout() throws IOException {
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, "");
		Request request = new Request.Builder()
				.url(baseUrl+"/logout")
				.method("POST", body)
				.addHeader("Origin", baseUrl)
				.addHeader("Upgrade-Insecure-Requests", "1")
				.addHeader("DNT", "1")
				.addHeader("Content-Type", "application/x-www-form-urlencoded")
				.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.89 Safari/537.36")
				.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
				.addHeader("Sec-Fetch-Site", "same-origin")
				.addHeader("Sec-Fetch-Mode", "navigate")
				.addHeader("Sec-Fetch-User", "?1")
				.addHeader("Sec-Fetch-Dest", "document")
				.build();
		return client.newCall(request).execute();
	}

}



