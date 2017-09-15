package com.ibm.mySA_IA.testScripts;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.mySA_IA.testBase.TestBase;
import com.ibm.mySA_IA.uiActions.CreateIncentivePage;
import com.ibm.mySA_IA.uiActions.IncentiveListViewPage;
import com.ibm.mySA_IA.uiActions.UpdateIncentivePage;
import com.ibm.mySA_IA.uiActions.SignInPage;

public class TC_99471_001_TestUpdateIncentive extends TestBase{
	 public static final Logger log=Logger.getLogger(TC_99471_001_TestUpdateIncentive.class.getName());
	    SignInPage signin;
		CreateIncentivePage createIncentive;
		IncentiveListViewPage incentiveListViewPage;
		UpdateIncentivePage updateIncentivePage;
@BeforeClass
public void setUp() throws Exception{
	init();
	signin = new SignInPage(driver);
	signin.LogintoApplication();
	

	
}
@Test
public void verifyOverview() throws Exception{
	updateIncentivePage=new UpdateIncentivePage(driver);
	updateIncentivePage.updateIncentive();
	
}
}
	
	/*updateIncentivePage.editDescription("test55");
	updateIncentivePage.clickOnSavebutton();*/
	
 
