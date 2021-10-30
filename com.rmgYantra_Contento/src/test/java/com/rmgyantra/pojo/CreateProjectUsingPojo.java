package com.rmgyantra.pojo;



import org.testng.annotations.Test;

import com.rmgyantra.contento.ProjectLibrary;

import contento.GenericUtils.JavaUtility;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingPojo {
	@Test
	public void createProjectUsingPojo() {
	
		baseURI ="http://localhost";
		port=8084;
		JavaUtility jLib=new JavaUtility();
		//read the data through pojo class
		ProjectLibrary pLib=new ProjectLibrary("Junaid","Cont12"+jLib.getRandomNumber(),"Completed",35);
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
