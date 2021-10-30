package com.rmgyantra.pojo;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.rmgyantra.contento.ProjectLibrary;

import contento.GenericUtils.JavaUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class RequestChaningDelete {


	@Test
	public void requestChainingDelete() {
		JavaUtility jLib=new JavaUtility();
		baseURI="http://localhost";
		port=8084;
		ProjectLibrary pLib=new ProjectLibrary("Junaid","Contento"+jLib.getRandomNumber(),"Completed",40);
		
		Response res = given()
		.contentType(ContentType.JSON)
				.body(pLib)
				.when()
				.post("/addProject");
	String myProjID = res.jsonPath().get("projectId");
	System.out.println(myProjID);
	
	res.then().log().all();
	
	given()
	.pathParam("projID", myProjID)
	
	.when()
	.delete("/projects/{projID}")
	
	.then().assertThat().statusCode(204).log().all();

	}

}

