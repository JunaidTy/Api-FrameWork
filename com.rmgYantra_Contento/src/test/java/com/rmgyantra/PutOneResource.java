package com.rmgyantra;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PutOneResource {
	@Test
	public void putdata()
	{
	JSONObject jobj=new JSONObject();
	jobj.put("createdBy", "JunaidAnsari");
	jobj.put("projectName", "Contento");
	jobj.put("status", "Completed");
	jobj.put("teamSize", 45);
	
	RequestSpecification reqspec = RestAssured.given();
	reqspec.contentType(ContentType.JSON);
	reqspec.body(jobj);
	
	Response res = reqspec.post("http://localhost:8084/projects/TY_PROJ_006");
	ValidatableResponse validate = res.then();
	validate.assertThat().statusCode(200);
	validate.assertThat().contentType("application/json");
	validate.log().all();
	
	}


}
