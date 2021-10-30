package com.rmgyantra.testcases;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import com.rmgyantra.contento.ProjectLibrary;

import io.restassured.http.ContentType;

public class CreatetheProjectWithExistingProjectId {
	@Test
	public void createtheProjectWithExistingProjectId() {
	baseURI ="http://localhost";
	port=8084;
	//read the data through pojo class
	ProjectLibrary pLib=new ProjectLibrary("Junaid","Cont123","Completed",35);
	//request specification
    given()
    .contentType(ContentType.JSON)
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