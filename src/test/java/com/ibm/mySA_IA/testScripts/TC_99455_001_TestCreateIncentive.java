package com.ibm.mySA_IA.testScripts;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.mySA_IA.testBase.TestBase;
import com.ibm.mySA_IA.uiActions.CreateIncentivePage;
import com.ibm.mySA_IA.uiActions.SignInPage;



public class TC_99455_001_TestCreateIncentive extends TestBase{
	 public static final Logger log=Logger.getLogger(TC_99455_001_TestCreateIncentive.class.getName());
	SignInPage signin;
	CreateIncentivePage createIncentive;

	@BeforeClass
	public void setUp() throws Exception{
		init();
		signin = new SignInPage(driver);
		signin.LogintoApplication();
		//signin.LogintoApplication(IntranetID, Password);
	}
	@Test
	public void testCreateIncentive() throws Exception{
	 createIncentive=new CreateIncentivePage(driver);
	 createIncentive.testCreateIncentive();
	}
	
	
	/* 
	 createIncentive.clickOnNewIncentive();
	 //String emailAddress = "email"+System.currentTimeMillis()+"@gmail.com";
	 createIncentive.enterincentiveName("Test7");
	 createIncentive.enterDescription("Test7");
	 createIncentive.selectStatus("Pending");
	 createIncentive.enterBeginDate("08/12/2017");
	 createIncentive.enterEndDate("08/20/2017");
	 waitFor(3);
	createIncentive.clickOnCreateIncentive();*/
	
	}

	/*@AfterClass
	public void quitBrowser{
		closeBrowser();
	}*/


