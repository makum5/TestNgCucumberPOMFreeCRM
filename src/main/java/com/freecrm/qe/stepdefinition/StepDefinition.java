package com.freecrm.qe.stepdefinition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import com.freecrm.qe.base.BaseClass;
import com.freecrm.qe.pages.HomePage;
import com.freecrm.qe.pages.LoginPage;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition extends BaseClass {
	
	LoginPage loginPage;
	HomePage homePage;

	/**
	 ******************* Common steps starts here*********************************
	 */
	@Given("^user is already on login page$")
	public void user_is_already_on_login_page(){
		initialization();
		loginPage = new LoginPage();
		Assert.assertEquals(driver.getTitle(), "CRM","Login Page was not loaded successfully");
	}

	@When("^user enters username and password$")
	public void user_enters_username_and_password(){
		loginPage.enterCredentials();
	}

	@When("^user clicks on login button$")
	public void user_clicks_on_login_button(){
		homePage = loginPage.clickOnLoginButton();
	}
	/**
	 ******************* Common steps ends here*********************************
	 */
	
	/**
	 ******************* Home page feature steps starts here*********************************
	 */
	@Then("^user redirects to \"([^\"]*)\" page and page title should be \"([^\"]*)\"$")
	public void user_redirects_to_home_page(String pageName,String title){
		Assert.assertEquals(driver.getTitle(), title,"Home page was not loaded properly");
	}
	@Then("^\"([^\"]*)\" link should be displayed$")
	public void link_should_be_displayed(String arg1){
		Assert.assertTrue(homePage.verifyContactLinkVisibility(),"Contact link is not displayed on Home Page");
	}
	/**
	 ******************* Home page feature steps ends here*********************************
	 */
	
	@After
	public void teardown(Scenario scenario){
		if(scenario.isFailed()){
			final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		}
		driver.quit();
	}
}
