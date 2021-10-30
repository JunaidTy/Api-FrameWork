package com.rmgyantra.pojo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicResponse {
	@Test
	public void staticResponse() {
		 baseURI = "http://localhost";
		 port=8084;
		 
		 String expData="Contento-44";
		 Response res = when().get("/projects");
		 
		 List<String> pNames = res.jsonPath().get("projectName");
		 for(String actData:pNames)
		 {
			 if(actData.equalsIgnoreCase(expData))
			 {
				 Assert.assertEquals(actData,expData);
				 System.out.println(actData+" Data verified");
				 break;
			 }
		 }
		 
	}

}
