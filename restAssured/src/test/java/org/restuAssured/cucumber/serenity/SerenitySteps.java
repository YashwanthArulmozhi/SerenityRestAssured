package org.restuAssured.cucumber.serenity;

import org.json.JSONObject;
import org.restAssured.model.CustomerClass;
import org.restAssured.utils.CommonRestMethods;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Step;

public class SerenitySteps {

	CommonRestMethods restCommonMethods = new CommonRestMethods();
	
	@Step(" Create new Record ")
	public Response createRecord(String url,String name,String job)
	{
		try
		{
			CustomerClass customer = new CustomerClass();
			customer.setName(name);
			customer.setJob(job);
			
			return restCommonMethods.postAndGetRespose(url,customer);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	
	String baseURI = "https://reqres.in/api/users";

	@Step
	public void getPostResponse()
	{
	JSONObject json = new JSONObject();
	json.put("name","Yashwanth");
	json.put("Job","Engineer");
	
	Response res = RestAssured.given()
			.body(json.toString())
			.post(baseURI);
	String responseValue = res.asString();
	System.out.println("String : "+responseValue);
	System.out.println("Repsose Code : "+res.getStatusCode());
	}
	
	public int getStatusCodeForCreateRecord()
	{
		try
		{
			return restCommonMethods.validateStatusCode();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}
}
