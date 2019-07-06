Feature: Contact Page Test

@ContactPage 
Scenario: Create Contact_6 

	Given user is already on login page 
	When user enters username and password 
	And user clicks on login button 
	Then user redirects to "home" page and page title should be "CRM"
	Then "contact" link should be displayed
	Then user clicks on "contact" link
	Then user clicks on "new" button
	Then user fill create contact form
	Then user clicks on save button
	Then user verifies added contact