package org.restAssured.cucumber.steps;

import net.thucydides.core.annotations.Step;

public class StepsClass {

	
	@Step("Test step with parameters")
	public void printInReport(String data){}
}
