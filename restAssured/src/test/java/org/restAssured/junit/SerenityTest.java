package org.restAssured.junit;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.SafeHtml.Tag;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.restAssured.cucumber.steps.StepsClass;
import org.restAssured.utils.CommonRestMethods;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

@RunWith(SerenityRunner.class)
public class SerenityTest {
	
	CommonRestMethods restCommonMethods = new CommonRestMethods();
	StepsClass steps = new StepsClass();
	
	@BeforeClass
	public static void init()
	{
		RestAssured.baseURI = "http://restcountries.eu/rest/v1/name";
	}
	
	
	
	@Test
	@Step
	public void getDetails() throws InterruptedException
	{
		String baseUrl = "http://restcountries.eu/rest/v1/name/India";
		Response res = restCommonMethods.getRespose(baseUrl);
		if(restCommonMethods.validateStatusCode() == 200)
		{
		JSONArray arr = new JSONArray(res.asString());
		for(int i=0;i<=arr.length()-1;i++)
		{
			String countryName = restCommonMethods.getValueFromResponseWithJsonObject(i, "name");
			if(countryName.equalsIgnoreCase("India"))
			{
				
				List<String> altSpellings = restCommonMethods.getValueFromResponseWithJsonObjectAndObjectArray(i, "altSpellings");
				for(String singleAltSpelling : altSpellings)
				if(singleAltSpelling.equalsIgnoreCase("Republic of India"))
				{
					steps.printInReport("Alternate Name : "+singleAltSpelling);
					System.out.println("Alternate Name : "+singleAltSpelling);
					break;
				}
				break;
			}
		}
		}
		else
		{
			System.out.println(res.asString());
		}
	}
	
	/*@Test
	public void verifyNorwayCapital() throws InterruptedException
	{
		Response res = SerenityRest.given()
		.when()
		.get("/abc");
	
		if(res.getStatusCode() == 200)
		{
		JSONArray arr = new JSONArray(res.asString());
		List<String> val = new ArrayList<String>();
		for(int i=0;i<=arr.length()-1;i++)
		{
			JSONObject obj = arr.getJSONObject(i);
			if(obj.getString("capital").equalsIgnoreCase("Oslo"))
			{
				System.out.println("Name : "+obj.getString("name"));
				System.out.println("Capital : "+obj.getString("capital"));
				System.out.println("Details of Normway :"+res.asString());
			}
		}
		}
		else
		{
			System.out.println(res.asString());
		}
	}
	*/
}
