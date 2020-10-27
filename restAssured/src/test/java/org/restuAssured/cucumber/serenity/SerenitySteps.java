package org.restuAssured.cucumber.serenity;

import org.restAssured.model.CustomerClass;
import org.restAssured.utils.CommonRestMethods;

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
