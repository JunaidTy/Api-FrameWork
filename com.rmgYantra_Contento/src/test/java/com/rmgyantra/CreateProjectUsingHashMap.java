package com.rmgyantra;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


public class CreateProjectUsingHashMap {
	@Test
	public void createProject() {
	
	HashMap map=new HashMap();
	map.put("createdBy","Junaid");
	map.put("projectName","Contento1");
	map.put("status","Completed");
	map.put("teamSize",24);
	
	//request specification
    given()
    .contentType(ContentType.JSON)
    .body(map)
	
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
