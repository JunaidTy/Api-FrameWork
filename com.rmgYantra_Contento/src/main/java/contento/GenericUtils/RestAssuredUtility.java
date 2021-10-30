package contento.GenericUtils;

import io.restassured.response.Response;

public class RestAssuredUtility {
	
	/**
	 * this class contains generic methods pertaining to rest-assured
	 * @author JAnsari
	 * @return 
	 *
	 */
		
		public String getJsonData(Response res, String jsonPath)
		{
			String value =res.jsonPath().get(jsonPath);
			return value;
		}

	}
