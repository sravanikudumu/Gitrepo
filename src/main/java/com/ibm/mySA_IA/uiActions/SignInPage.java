package com.ibm.mySA_IA.uiActions;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ibm.mySA_IA.testBase.TestBase;

public class SignInPage extends TestBase{
	
	WebDriver driver;
	 public static final Logger log=Logger.getLogger(SignInPage.class.getName());
	
	
	
	By RegEmailAddr = By.xpath("//input[@aria-label='Your IBM email address (e.g. jdoe@us.ibm.com)']");
	By Regpassword  = By.xpath("//input[@aria-label='password']");
	By submitbutton = By.xpath("//button[@type='submit']");
	By Incentive    = By.xpath(".//*[@id='viewTable']/tbody/tr[1]/td[1]");
	By newIncentivebutton = By.xpath("//a[@id='newincentive']");
	
	public SignInPage(WebDriver driver){
		this.driver = driver;
	}
	/**
	 * This method will click on sign in link in login page
	 */

	
	public void enterRegisteredEmailAddress(String emailAddress){
		driver.findElement(RegEmailAddr).sendKeys(emailAddress);
		log("Entered Email Address:-"+emailAddress+ "and object is:-"+RegEmailAddr.toString());
	}
	
	public void enterRegisteredPassword(String password){
		driver.findElement(Regpassword).sendKeys(password);
		log("Entered Password:-"+password+ "and object is:-"+Regpassword.toString());
	}
	public void clickonSignIn1(){
	WebElement element = driver.findElement(submitbutton);
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", element);
}
	public void clickonSignIn(){
		driver.findElement(submitbutton).click();
		log("clicked on submit button and object is:-" +submitbutton.toString());
	}
	public void verifySignin(){
		boolean isdisplayed = driver.findElement(submitbutton).isDisplayed();
		if(isdisplayed){
			driver.findElement(submitbutton).click();
		Assert.assertTrue(true, "submit button displayed");
		log("submit button displayed and clicked");
		}else{
		Assert.assertTrue(false, "Overview button is not displayed");
		}
	}
	public void clickOnNewIncentive(){
		driver.findElement(newIncentivebutton).click();
		log("clicked on CreateIncentive button and object is:-" +newIncentivebutton.toString());
	}
	//public void LogintoApplication(String IntranetID,String Password) throws Exception{
	public void LogintoApplication() throws Exception{
		 
			log("==========Starting VerifyloginWithValidCredentials test=========");
			 enterRegisteredEmailAddress("prasanjs@in.ibm.com");
			 enterRegisteredPassword("PRAsan12345");
			 waitFor(3);
			 clickonSignIn1();
			 //verifySignin();
			 waitFor(30);
			//clickOnNewIncentive();
		   log("==========Ending VerifyloginWithValidCredentials test=========");
	   
		}
	
}
	
	/**
	 * This Method is used for login to application
	 */


