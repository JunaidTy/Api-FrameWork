package EndToEnd;


	import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.rmgyantra.contento.ProjectLibrary;

import contento.GenericUtils.BASEAPIClass;
import contento.GenericUtils.EndPoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
	

	public class CreateProjectEndToEnd extends BASEAPIClass{

		@Test
		public void createProjectAndVerifyInDB() throws Throwable
		{
			
			//create a project thru API
			ProjectLibrary pLib = new ProjectLibrary("Junaid", "contento"+jLib.getRandomNumber(), "Completed", 30);
			
			Response res = given()
			.contentType(ContentType.JSON)
			.body(pLib)
			.when()
			.post(EndPoints.addProject);
			
			res.then().log().all();
			
			//capture the expected data
			String expData = rLib.getJsonData(res,"projectName");
			System.out.println(expData);
			
			//verify it in database
			String query = "select * from project";
			String actData = dLib.getDataFromDB(query, 4, expData);
			
			//validate
			Assert.assertEquals(actData, expData);
			System.out.println("sucessful");
			
			
		}


	}

