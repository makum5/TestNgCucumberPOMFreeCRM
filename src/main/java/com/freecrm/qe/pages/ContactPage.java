package com.freecrm.qe.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qe.base.BaseClass;

public class ContactPage extends BaseClass {

	/**
	 * Dynamic Xpath
	 */
	String checkbox = "(//td[text()='NAME_RUNTIMEREPLACEMENT']/parent::tr/td/div)[1]";

	
	@FindBy(xpath="//div[text()='Contacts']")
	WebElement contactLabel;
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement newContactLink;
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="last_name")
	WebElement lastName;
	
	@FindBy(name="address")
	WebElement address;
	
	@FindBy(xpath="//input[@name='value' and @placeholder='Number']")
	WebElement number;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement saveBtn;
	
	public ContactPage(){
		PageFactory.initElements(driver, this);
	}
	public void clickOnNewContactLink(){
		newContactLink.click();
	}
	public void fillNewContactForm(String fname,String lname,String addrs,String Mobnumber){
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		address.sendKeys(addrs);
		number.sendKeys(Mobnumber);		
	}
	public void clickOnSaveButton(){
		saveBtn.click();
	}
	public boolean verifyNewlyAddedContact(String fname,String lname){
		WebElement savedUserName = driver.findElement(By.xpath("//i[@class='large user red icon']/parent::div[text()='"+fname+" "+lname+"']"));
		return savedUserName.isDisplayed();
	}
}
