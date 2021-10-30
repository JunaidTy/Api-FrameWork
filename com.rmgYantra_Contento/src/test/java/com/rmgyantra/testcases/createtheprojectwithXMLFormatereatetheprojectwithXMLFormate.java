package com.rmgyantra.testcases;

	import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.rmgyantra.contento.ProjectLibrary;

	import io.restassured.http.ContentType;

public class createtheprojectwithXMLFormatereatetheprojectwithXMLFormate {
	
	@Test
		public void createtheProjectWithExistingProjectId() {
			baseURI ="http://localhost";
			port=8084;
			//read the data through pojo class
			ProjectLibrary pLib=new ProjectLibrary("JunaidSS","Cont192031","Completed",35);
			//request specification
		    given()
		    .contentType(ContentType.XML)
		    .body(pLib)
			
			//actual request
			.when()
			.post("/addProject")
			//validation
			.then()
			.assertThat()
			.statusCode(500)
			.contentType(ContentType.JSON)
			.log().all();
		}
	}



