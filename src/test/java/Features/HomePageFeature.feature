Feature: Home Page Test

@Regression 
Scenario: Verify Home Page Title 

	Given user is already on login page 
	When user enters username and password 
	And user clicks on login button 
	Then user redirects to "home" page and page title should be "CRM"

@Sanity	
Scenario: Verify Contact link on Home Page 

	Given user is already on login page 
	When user enters username and password 
	And user clicks on login button 
	Then user redirects to "home" page and page title should be "CRM"
	Then "contact" link should be displayed
		