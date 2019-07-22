package com.freecrm.qe.runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(features = "src/test/java/Features", glue = { "com.freecrm.qe.stepdefinition" }, dryRun = false,
monochrome = true,
tags = {"@ContactPage"},
plugin = {
		"pretty",
		"json:target/cucumber-json-reports/cucumber.json" }

)
public class MyTestNGRunner {

	private TestNGCucumberRunner testNGCucumberRunner;

	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception {
		System.out.println("Before Class");
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}

	@Test(groups = "cucumber", description = "Automating Free CRM Application", dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeature) {
		System.out.println("Test Method");
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	}

	@DataProvider
	public Object[][] features() {
		System.out.println("Data Provider");
		return testNGCucumberRunner.provideFeatures();
	}
    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
    	System.out.println("After Class");
        testNGCucumberRunner.finish();
    }
}
