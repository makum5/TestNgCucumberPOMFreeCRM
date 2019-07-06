package com.freecrm.qe.stepdefinition;

import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import com.freecrm.qe.base.BaseClass;
import com.freecrm.qe.excel.ExcelReader;
import com.freecrm.qe.pages.ContactPage;
import com.freecrm.qe.pages.HomePage;
import com.freecrm.qe.pages.LoginPage;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition extends BaseClass {

	LoginPage loginPage;
	HomePage homePage;
	ContactPage contactPage;
	Scenario scenario;
	ExcelReader excelReader;
	Map<String,String> newContactData;

	/**
	 ******************* Common steps starts here*********************************
	 */
	@Given("^user is already on login page$")
	public void user_is_already_on_login_page() {
		initialization();
		loginPage = new LoginPage();
		Assert.assertEquals(driver.getTitle(), "CRM",
				"Login Page was not loaded successfully");
	}

	@When("^user enters username and password$")
	public void user_enters_username_and_password() {
		loginPage.enterCredentials();
	}

	@When("^user clicks on login button$")
	public void user_clicks_on_login_button() {
		homePage = loginPage.clickOnLoginButton();
	}

	/**
	 ******************* Common steps ends here*********************************
	 */

	/**
	 ******************* Home page feature steps starts here*********************************
	 */
	@Then("^user redirects to \"([^\"]*)\" page and page title should be \"([^\"]*)\"$")
	public void user_redirects_to_home_page(String pageName, String title) {
		Assert.assertEquals(driver.getTitle(), title,
				"Home page was not loaded properly");
	}

	@Then("^\"([^\"]*)\" link should be displayed$")
	public void link_should_be_displayed(String arg1) {
		Assert.assertTrue(homePage.verifyContactLinkVisibility(),
				"Contact link is not displayed on Home Page");
	}

	@Then("^user clicks on \"([^\"]*)\" link$")
	public void user_clicks_on_link(String arg1) {
      contactPage = homePage.clickOnContactLink();
	}

	/**
	 ******************* Home page feature steps ends here*********************************
	 */

	/**
	 ******************** Contact Page feature steps start here****************************
	 */

	@Then("^user clicks on \"([^\"]*)\" button$")
	public void user_clicks_on_button(String arg1) {
		contactPage.clickOnNewContactLink();
	}

	@Then("^user fill create contact form$")
	public void user_fill_create_contact_form() {
		newContactData = excelReader.getRowDataAsMap(excelReader.getSheet("CreateContactData"), scenario.getName());
		contactPage.fillNewContactForm(newContactData.get("FIRST_NAME"), newContactData.get("LAST_NAME"), newContactData.get("ADDRESS"), newContactData.get("PHONE"));
	}

	@Then("^user clicks on save button$")
	public void user_clicks_on_save_button() {
      contactPage.clickOnSaveButton();
	}

	@Then("^user verifies added contact$")
	public void user_verifies_added_contact() {
       Assert.assertTrue(contactPage.verifyNewlyAddedContact(newContactData.get("FIRST_NAME"), newContactData.get("LAST_NAME")));
	}

	/**
	 ******************** Contact Page feature steps end here*******************************
	 */

	@Before
	public void setup(Scenario scenario) {
		this.scenario = scenario;
		excelReader = new ExcelReader(System.getProperty("user.dir")+"/src/main/resource/FreeCRMTestData.xlsx","xlsx");
	}

	@After
	public void teardown() {
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		}
		driver.quit();
	}

}
