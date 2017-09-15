package com.ibm.mySA_IA.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.ibm.mySA_IA.testBase.TestBase;

public class CreateIncentivePage extends TestBase{
	WebDriver driver;
    //String IncentiveName= "Test"+System.currentTimeMillis();
	public static final Logger log=Logger.getLogger(CreateIncentivePage.class.getName());
	
	By newIncentivebutton = By.xpath("//a[@id='newincentive']");
	By incentiveName = By.xpath(".//*[@id='incentiveName']");
	By Description = By.xpath(".//*[@id='incentiveDescription']");
	By status = By.xpath(".//*[@id='status']");
	By beginDate = By.xpath(".//*[@id='startDate']");
	By endDate = By.xpath(".//*[@id='endDate']");
	By createIncentive= By.xpath("//button[contains(.,'Create Incentive')]");
	
	
	public CreateIncentivePage(WebDriver driver){
		this.driver=driver;
		
	}
	public void clickOnNewIncentive(){
		driver.findElement(newIncentivebutton).click();
		log("clicked on newIncentive button and object is:-" +newIncentivebutton.toString());
	}
	//String emailAddress = "email"+System.currentTimeMillis()+"@gmail.com";
	public void enterincentiveName(String IncentiveName){
		driver.findElement(incentiveName).sendKeys(IncentiveName);
		log("Entered incentiveName:-"+IncentiveName+ "and object is:-"+incentiveName.toString());
	}

	public void enterDescription(String description){
		driver.findElement(Description).sendKeys(description);
		log("Entered Description:-"+description+ "and object is:-"+Description.toString());
	}
	public void selectStatus(String Status){
		new Select(driver.findElement(status)).selectByVisibleText(Status);
		log("selected Status:-"+Status+ "and object is:-"+status.toString());
	}
	
	public void enterBeginDate(String date){
		driver.findElement(beginDate).sendKeys(date);
		log("Entered BeginDate:-"+date+ "and object is:-"+beginDate.toString());
	}
	public void enterEndDate(String date){
		driver.findElement(endDate).sendKeys(date);
		log("Entered endDate:-"+date+ "and object is:-"+endDate.toString());
	}
	public void clickOnCreateIncentive(){
		driver.findElement(createIncentive).click();
		log("clicked on CreateIncentive button and object is:-" +createIncentive.toString());
	}
	
	
		public void testCreateIncentive() throws Exception{
			 	
			 clickOnNewIncentive();
			 enterincentiveName("Test"+System.currentTimeMillis());
			 enterDescription("Test"+System.currentTimeMillis());
			 selectStatus("Pending");
			 enterBeginDate("08/12/2017");
			 enterEndDate("08/20/2017");
			 waitFor(3);
			 clickOnCreateIncentive();
			 waitFor(3);
			
			
	}
}
