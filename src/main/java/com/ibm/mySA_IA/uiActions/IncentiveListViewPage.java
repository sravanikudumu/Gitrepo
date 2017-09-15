package com.ibm.mySA_IA.uiActions;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ibm.mySA_IA.testBase.TestBase;

public class IncentiveListViewPage extends TestBase {
	WebDriver driver;
	 public static final Logger log=Logger.getLogger(IncentiveListViewPage.class.getName());
	 By newIncentiveInList = By.xpath(".//*[@id='viewTable']/tbody/tr[1]/td[1]");
		
		public IncentiveListViewPage(WebDriver driver){
			this.driver=driver;
		}
	 public void verifyNewIncentiveInList() throws InterruptedException{
			
			boolean isdisplayed = driver.findElement(newIncentiveInList).isDisplayed();
			if(isdisplayed){
				//driver.findElement(newIncentiveInList).click();
			Assert.assertTrue(true, "new Incentive in list is displayed");
			log("Displayed new incentive in List and object is" +newIncentiveInList.toString());
		
			}else{
			Assert.assertTrue(false, "new Incentive in list is not displayed");
			}
			 waitFor(3);
}
	 
	 
	/* @Test
		public void testVerifyIncentive() throws Exception{
		verifyNewIncentive();
		 
		 
		}*/
	 
}