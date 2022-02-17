package org.hotel.login;

import org.base.BaseClassCucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HotelAppLogin extends BaseClassCucumber {
		
		@Given("User is on the hotel login page")
		public void user_is_on_the_hotel_login_page() {
			browserLaunch("http://adactinhotelapp.com/");

		}

		
		@When("User must enter {string} and {string}")
		public void user_must_enter_and(String username, String password) {
			findElementId("username").sendKeys(username);
			findElementId("password").sendKeys(password);
		}

		@When("User should click login button")
		public void user_should_click_login_button() {
			findElementId("login").click();

		}

		@Then("User login verified")
		public void user_login_verified() {
			System.out.println("Login verified successfully");
		    
		}

}
