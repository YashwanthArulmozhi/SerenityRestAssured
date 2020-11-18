package org.restAssured.StepDefinition;


import org.restuAssured.cucumber.serenity.SerenitySteps;

import cucumber.api.java.en.Given;

public class RestAssuredStepDefinition {

	SerenitySteps serenitySteps = new SerenitySteps();
	
	@Given("^Post the end point and validate the response$")
	public void post_the_end_point_and_validate_the_response()
	{
		serenitySteps.getPostResponse();
	}
}
