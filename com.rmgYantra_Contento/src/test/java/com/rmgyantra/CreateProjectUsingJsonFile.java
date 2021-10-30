package com.rmgyantra;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjectUsingJsonFile {
	@Test
	public void createProjectUsingJsonFile() throws FileNotFoundException
	{
		FileInputStream fis=new FileInputStream("./data.json");
		//request specification
	    given()
	    .contentType(ContentType.JSON)
	    .body(fis)
		
		//actual request
		.when()
		.post("http://localhost:8084/addProject")
		//validation
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
		
		
	}

}
