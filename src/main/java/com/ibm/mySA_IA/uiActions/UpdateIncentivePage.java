package com.ibm.mySA_IA.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ibm.mySA_IA.testBase.TestBase;

public class UpdateIncentivePage extends TestBase{
	
	WebDriver driver;
	public static final Logger log=Logger.getLogger(UpdateIncentivePage.class.getName());
	By newIncentiveInList = By.xpath(".//*[@id='viewTable']/tbody/tr[1]/td[1]");
	By Overview =  By.xpath("//a[contains(.,'Overview')]");
	By Description =By.xpath("//textarea[@name='incentiveDescription']");
	By Save = By.xpath("//button[@value='submit']");
   // By DaysPriorExpiration =By.xpath(".//*[@id='priorExpiration']");
    
	public UpdateIncentivePage(WebDriver driver){
		this.driver=driver;
		
	}
	
	public void clickOnNewIncentiveInList(){
		driver.findElement(newIncentiveInList).click();
		log("Click on New Incentive in list and object is:-"+newIncentiveInList.toString());
	}
		public void VerifyOverview(){
			boolean isdisplayed = driver.findElement(Overview).isDisplayed();
			if(isdisplayed){
				
			Assert.assertTrue(true, "Overview button displayed");
			log("Verified Overview Button");
			}else{
			Assert.assertTrue(false, "Overview button is not displayed");
			}
		}
		public void clickOnSavebutton(){
			driver.findElement(Save).click();
			log("clicked on Save button and object is:-" +Save.toString());
		}
		
		public void editDescription(String description){
			driver.findElement(Description).clear();
			driver.findElement(Description).sendKeys(description);
			log("Updated description:-"+description+ "and object is:-"+Description.toString());
		}	

	/*	public void enterDaysPriorExpiration(String daysPriorExpiration){
			
			driver.findElement(DaysPriorExpiration).sendKeys(daysPriorExpiration);
			log("Updated description:-"+daysPriorExpiration+ "and object is:-"+DaysPriorExpiration.toString());
		}	*/
		
		@Test
		public void verifyOverview() throws Exception{
			clickOnNewIncentiveInList();
			waitFor(2);
			VerifyOverview();
			waitFor(2);
			clickOnSavebutton();
			waitFor(5);
			}
		@Test
		public void updateIncentive() throws Exception{
			clickOnNewIncentiveInList();
			editDescription("test"+System.currentTimeMillis());
			waitFor(3);
			clickOnSavebutton();
			waitFor(5);
}
}