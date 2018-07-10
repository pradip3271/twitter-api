package utils;

import java.util.Properties;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestServices {
	
static Properties properties;
	
	static {
	
		properties = Helper.loadResourceProperties("./src/test/resources/endpoints.properties");
	}

	public static Response updateStatus(RequestSpecification request, String text) {
		return request.queryParam("status", text).when().post(properties.getProperty("STATUSES-UPDATE"));
	}

}
