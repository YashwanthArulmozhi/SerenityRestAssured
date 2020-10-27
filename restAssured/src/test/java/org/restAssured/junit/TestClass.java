package org.restAssured.junit;

import org.json.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestClass {

	@BeforeClass
	public static void init()
	{
		RestAssured.baseURI = "https://reqres.in/api/users";
	}
	
	
	@Test
	public void verfyPost()
	{
		try
		{
			JSONObject json = new JSONObject();
			json.put("name","Yashwanth");
			json.put("Job","Engineer");
			
			Response res = RestAssured.given()
					.body(json.toString())
					.post("/users");
			String responseValue = res.asString();
			System.out.println("String : "+responseValue);
			System.out.println("Repsose Code : "+res.getStatusCode());
		}
		catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
}
