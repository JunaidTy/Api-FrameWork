package com.rmgyantraParameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameter {
	@Test
	public void pathParameter()
	{
		baseURI="http://localhost";
		port=8084;
		
		given()
		.pathParam("projId","TY_PROJ_008")
		
		.when()
		.get("/projects/{projId}")
		
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
	}

}
