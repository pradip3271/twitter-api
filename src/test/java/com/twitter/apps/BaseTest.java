package com.twitter.apps;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseTest {
	
	RequestSpecification request;
	
	@BeforeTest
	public void setUp() throws IOException {
		
		System.out.println(">>>>>>>>>>>>>>>>>> BeforeTest");
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("./src/test/resources/env.properties");
		prop.load(fis);
		
		String ConsumerKey = prop.getProperty("CONSUMER-KEY");
		String ConsumerSecret = prop.getProperty("CONSUMER-SECRET");
		String Token = prop.getProperty("TOKEN");
		String TokenSecret = prop.getProperty("TOKEN-SECRET");
		
		RestAssured.baseURI = prop.getProperty("BASE-URI");
		
		request = RestAssured.given().auth().oauth(ConsumerKey, ConsumerSecret, Token, TokenSecret);
				
		
		
	}

}
