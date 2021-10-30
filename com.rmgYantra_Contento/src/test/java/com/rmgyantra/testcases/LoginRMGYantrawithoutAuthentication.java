package com.rmgyantra.testcases;

import static io.restassured.RestAssured.*;


import org.testng.annotations.Test;

public class LoginRMGYantrawithoutAuthentication {
	@Test
	public void loginRMGYantrawithoutAuthentication() {
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
