package com.ibm.mySA_IA.testScripts;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import com.ibm.mySA_IA.testBase.TestBase;
import com.ibm.mySA_IA.uiActions.CreateIncentivePage;
import com.ibm.mySA_IA.uiActions.IncentiveListViewPage;
import com.ibm.mySA_IA.uiActions.MembershipPage;
import com.ibm.mySA_IA.uiActions.SignInPage;
import com.ibm.mySA_IA.uiActions.SolutionsPage;
import com.ibm.mySA_IA.uiActions.UpdateIncentiveListViewPage;
import com.ibm.mySA_IA.uiActions.UpdateIncentivePage;

public class TC_99578_002_VerifySolution extends TestBase{
	 public static final Logger log=Logger.getLogger(TC_99578_002_VerifySolution.class.getName());
	    SignInPage signin;
		CreateIncentivePage createIncentive;
		IncentiveListViewPage incentiveListViewPage;
		UpdateIncentivePage updateIncentivePage;
		UpdateIncentiveListViewPage updateIncentiveListViewPage;
		SolutionsPage solutionsPage;
		MembershipPage membershipPage;

	@BeforeClass
	public void setUp() throws Exception{
		    init();
			signin = new SignInPage(driver);
			signin.LogintoApplication();
			
			solutionsPage=new SolutionsPage(driver);
			solutionsPage.addExistingSolution();
			solutionsPage.verifyAddedSoln();
			solutionsPage.verifyCreatedSolution();
			solutionsPage.AddNewSolution();
		
	}
	@Test
	public void testVerifyNewSoln() throws Exception{
		solutionsPage.verifyNewSoln();
		
	


	}
}

