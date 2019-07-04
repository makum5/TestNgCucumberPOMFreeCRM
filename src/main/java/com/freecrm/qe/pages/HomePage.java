package com.freecrm.qe.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qe.base.BaseClass;

public class HomePage extends BaseClass {
	
	@FindBy(xpath="//div[@class='right menu']/span[@class='user-display']")
	@CacheLookup
	WebElement UserNameLabel;
	
	@FindBy(xpath="//span[contains(text(),'Contact')]")
	@CacheLookup
	WebElement contactLink;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	@CacheLookup
	WebElement dealsLink;
	
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	@CacheLookup
	WebElement taskLink;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String getHomePageTitle(){
		return driver.getTitle();
	}
	public boolean verifyContactLinkVisibility(){
		return contactLink.isDisplayed();
	}
	public ContactPage clickOnContactLink(){
		contactLink.click();
		return new ContactPage();
	}

}
