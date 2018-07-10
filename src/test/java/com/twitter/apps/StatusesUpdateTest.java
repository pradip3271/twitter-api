package com.twitter.apps;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;
import utils.RestServices;

public class StatusesUpdateTest extends BaseTest {
	
	@Test
	public void updateStatusAndVerify() {
		
		// Update status and verify the status code and text
		
		Response res = RestServices.updateStatus(request, "I am tweeting frome automation test 3");
		
		res.then().statusCode(200).and().
		body("text", equalTo("I am tweeting frome automation test 3"));
	}
	
	@Test
	public void tweetsPostedByUserName() {
		// 
	}

}
