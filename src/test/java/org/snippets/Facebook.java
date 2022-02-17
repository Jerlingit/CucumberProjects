package org.snippets;

import org.base.BaseClassCucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Facebook extends BaseClassCucumber{
	@Given("user is on facebook login page")
	public void user_is_on_facebook_login_page() {
	    browserLaunch("https://www.facebook.com");
	}

		
	@When("user should enter {string} and {string}")
	public void user_should_enter_and(String username, String password) {
		findElementId("email").sendKeys(username);
		   findElementId("pass").sendKeys(password);
	}

	@When("user should click the login button")
	public void user_should_click_the_login_button() {
	    findElementName("login").click();
	}

	@Then("user should verify the success message")
	public void user_should_verify_the_success_message() {
	    System.out.println("Login verified successfully");
	}



}
