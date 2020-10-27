package org.restAssured.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RestSpecificationClass {

	public static RequestSpecBuilder reqSpecBuilder;
	public static RequestSpecification reqSpecification;
	
	public static ResponseSpecBuilder resSpecBuilder;
	public static ResponseSpecification resSpecification;
	
	public static RequestSpecification requestSpecification()
	{
		try
		{
		reqSpecBuilder = new RequestSpecBuilder();
		reqSpecBuilder.setContentType(ContentType.JSON);
		return reqSpecification =reqSpecBuilder.build();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return reqSpecification;
	}
	
	public static ResponseSpecification responseSpecification()
	{
		try
		{
		resSpecBuilder = new ResponseSpecBuilder();
		resSpecBuilder.expectHeader("Content-Type", "application/json");
		return resSpecification =resSpecBuilder.build();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return resSpecification;
	}
}
