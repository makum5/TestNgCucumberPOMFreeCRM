package com.freecrm.qe.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestNgListener implements ITestListener {

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		System.out.println("On Feature Finish");		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		System.out.println("On Feature Start");
		System.out.println("Suite Level: "+arg0.getCurrentXmlTest().getParameter("SuiteLevel"));
		System.out.println("Test Level: "+arg0.getCurrentXmlTest().getParameter("TestLevel"));
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("On Test Failure");
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		System.out.println("On Test Start");
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		System.out.println("On Test Success");
		
	}

}
