package com.rmgyantra.testcases;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

public class RMG_API_Authenthentication_01 {
	@Test
	public void loginRMGYantrawithAuthentication() {
		baseURI ="http://localhost";
		port=8084;
		when()
		.get("/projects")
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
		
		
	}

}
