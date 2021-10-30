package com.rmgyantra.pojo;

import java.util.HashMap;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BearerToken {
	@Test
	public void bearerToken()
	{
		HashMap map=new HashMap();
		map.put("name","Rest-Sdet-21-Bearer token");
		
		given()
		.auth()
		.oauth2("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")
		.body(map)
		
		.when()
		.post("https://api.github.com/user/repos")
		
		.then().log().all();
	}

}
