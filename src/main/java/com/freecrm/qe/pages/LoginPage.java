package com.freecrm.qe.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qe.base.BaseClass;

public class LoginPage extends BaseClass {

	// pageFactory - OR
	@FindBy(name = "email")
	@CacheLookup
	WebElement username;

	@FindBy(name = "password")
	@CacheLookup
	WebElement password;

	@FindBy(xpath = "//div[text()='Login']")
	@CacheLookup
	WebElement loginButton;

	// Initialize Page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions on Page
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public void enterCredentials() {
		username.sendKeys(properties.getProperty("username"));
		password.sendKeys(properties.getProperty("password"));
	}

	public HomePage clickOnLoginButton() {
		loginButton.click();
		return new HomePage();
	}

}
