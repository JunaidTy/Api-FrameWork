package com.rmgyantra.testcases;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.rmgyantra.contento.ProjectLibrary;

import io.restassured.http.ContentType;

public class CreatetheprojectwithTextFormate {
	@Test
	public void createtheProjectWithExistingProjectId() {
		baseURI ="http://localhost";
		port=8084;
		//read the data through pojo class
		ProjectLibrary pLib=new ProjectLibrary("Junaid","Cont19203","Completed",35);
		//request specification
	    given()
	    .contentType(ContentType.TEXT)
	    .body(pLib)
		
		//actual request
		.when()
		.post("/addProject")
		//validation
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	}
}
