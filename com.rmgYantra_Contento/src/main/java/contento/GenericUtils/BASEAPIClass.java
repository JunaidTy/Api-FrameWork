package contento.GenericUtils;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

public class BASEAPIClass {
	
	public DataBaseUtility dLib = new DataBaseUtility();
	public RestAssuredUtility rLib = new RestAssuredUtility();
	public JavaUtility jLib = new JavaUtility();
	
	@BeforeSuite
	public void bsConfig() throws Throwable
	{
       dLib.connectToDB();
       baseURI = "http://localhost";
       port = 8084;
      
	}
	
	@AfterSuite
	public void asConfig() throws Throwable {
		dLib.closeDB();
	}

}