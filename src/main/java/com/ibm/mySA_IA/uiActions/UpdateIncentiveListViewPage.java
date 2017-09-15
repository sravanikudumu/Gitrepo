package com.ibm.mySA_IA.uiActions;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ibm.mySA_IA.testBase.TestBase;

public class UpdateIncentiveListViewPage extends TestBase {
	WebDriver driver;
	 public static final Logger log=Logger.getLogger(UpdateIncentiveListViewPage.class.getName());
	 
	 By updateIncentiveInList = By.xpath("html/body/div[2]/div/div[3]/div/table/tbody/tr[1]/td[1]/a");
	 By Overview =  By.xpath("//a[contains(.,'Overview')]");
	 By Cancelbutton     = By.xpath(".//*[@id='cancel']");
	 By Incentive     = By.xpath(".//*[@id='viewTable']/tbody/tr[1]/td[1]");
	 By Savebutton     = By.xpath("//a[contains(text(),'Save')]");
		
		public UpdateIncentiveListViewPage(WebDriver driver){
			this.driver=driver;
		}
	 public void verifyUpdatedIncentiveInList() throws InterruptedException{
			
			boolean isdisplayed = driver.findElement(updateIncentiveInList).isDisplayed();
			if(isdisplayed){
				driver.findElement(updateIncentiveInList).click();
				
			Assert.assertTrue(true, "update Incentive in list is displayed");
			log("Displayed updated incentive in List and object is"+updateIncentiveInList.toString());
			log("Clicked on updated incentive in List and object is"+updateIncentiveInList.toString());
		
			}else{
			Assert.assertTrue(false, "update Incentive in list is not displayed");
			}
			
}
		public void VerifyOverview(){
			boolean isdisplayed = driver.findElement(Overview).isDisplayed();
			if(isdisplayed){
				//driver.findElement(Overview).click();
			Assert.assertTrue(true, "Overview button displayed");
			log("Overview button displayed and clicked");
			}else{
			Assert.assertTrue(false, "Overview button is not displayed");
			}
		}
		public void ClickOnIncentive(){
			driver.findElement(Incentive).click();
			log("Selected incentive and object is:-" +Incentive.toString());
		}
		 public void ClickOnCancelButton(){
				driver.findElement(Cancelbutton).click();
				log("clicked on Cancel button and object is:-" +Cancelbutton.toString());
			}
			public void ClickOnSaveButton(){
				driver.findElement(Savebutton).click();
				log("clicked on Save button and object is:-" +Savebutton.toString());
			}
			 @Test
			 public void VerifyUpdatedIncentiveInList() throws Exception{
				 verifyUpdatedIncentiveInList();
				 waitFor(5);
				/* JavascriptExecutor jse = (JavascriptExecutor)driver;
				 jse.executeScript("window.scrollBy(0,1000)", "");*/
				 waitFor(3);
				 ClickOnCancelButton();
				 waitFor(3);
			 } 
		 @Test
		 public void verifyOverview() throws InterruptedException{
			 ClickOnIncentive();
			 waitFor(3);
			 VerifyOverview();
			 /*JavascriptExecutor jse = (JavascriptExecutor)driver;
			 jse.executeScript("window.scrollBy(0,1000)", "");*/
			 waitFor(3);
			 ClickOnCancelButton();
			 waitFor(3);
			 }
		
		 }
		 
		 	 
