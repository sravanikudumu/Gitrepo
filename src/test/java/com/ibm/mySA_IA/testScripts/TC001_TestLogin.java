package com.ibm.mySA_IA.testScripts;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.mySA_IA.testBase.TestBase;
import com.ibm.mySA_IA.uiActions.SignInPage;



public class TC001_TestLogin extends TestBase{
	 public static final Logger log=Logger.getLogger(TC001_TestLogin.class.getName());
	 SignInPage signin;
    /* String IntranetID="prasanjs@in.ibm.com";
     String Password="PRAsan005";*/
     
	@BeforeClass
	public void setUp() throws Exception{
		init();
	}
	@Test
	public void testLogin() throws Exception{
	 
	 signin=new SignInPage(driver);
	 signin.LogintoApplication();
	
	 
	}

	/*@AfterClass
	public void quitBrowser{
		closeBrowser();
	}*/
}
