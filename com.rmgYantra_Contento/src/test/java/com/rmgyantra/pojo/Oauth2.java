package com.rmgyantra.pojo;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oauth2 {
@Test
public void oauth2() {
	
	Response res = given()
	.formParam("client_id", "Contento")
	.formParam("client_secret", "4b22052b16250287c405591aa89eca36")
	.formParam("grant_type", "client_credentials")
	.formParam("redirect_uri", "http://example.com")
	.formParam("redirect_uri", "authorization_code")
	
	.when()
	.post("http://coop.apps.symfonycasts.com/token");
	
	String Token=res.jsonPath().get("access_token");
	System.out.println(Token);
	
	given()
	.auth()
	.oauth2(Token)
	.pathParam("USER_ID",2395 )
	
	.when()
	.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/chickens-feed")
	
	.then().log().all();
	
	
}
}
