package com.ibm.mySA_IA.testScripts;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.mySA_IA.testBase.TestBase;
import com.ibm.mySA_IA.uiActions.MembershipPage;
import com.ibm.mySA_IA.uiActions.SignInPage;

public class TC_99576_005_VerifySearchInMembershipTab extends TestBase{
	 public static final Logger log=Logger.getLogger(TC_99576_005_VerifySearchInMembershipTab.class.getName());
	 SignInPage signin;
	 MembershipPage membershipPage;
   
	@BeforeClass
	public void setUp() throws Exception{
		init();
		 signin=new SignInPage(driver);
		 signin.LogintoApplication();
		 
	}
	@Test
	public void testVerifySearchInMembership() throws Exception{
	 membershipPage =new MembershipPage(driver);
	 //membershipPage.verifyAddedNewBPinIncentive();
	 membershipPage.verifySearchInMembership();
	}
}