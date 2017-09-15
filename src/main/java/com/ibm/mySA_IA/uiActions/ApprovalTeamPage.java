package com.ibm.mySA_IA.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ibm.mySA_IA.testBase.TestBase;


public class ApprovalTeamPage extends TestBase {
	WebDriver driver;
	public static final Logger log=Logger.getLogger(ApprovalTeamPage.class.getName());
	
	
	By Incentive = By.xpath(".//*[@id='viewTable']/tbody/tr[1]/td[1]/a");
	By ApprovalTab = By.xpath("//a[contains(text(),'Approval Team')]");
	By AddApprover = By.xpath("//a[contains(text(),'Add Approver')]");
	By ApproverName = By.xpath("//input[@id='search_addApp']");
	By selectApprover = By.xpath("//table[@id='addApproverTable']/tbody/tr/td[1]/a");
	//By SaveButton = By.xpath("html/body/form/div/div[2]/div[2]/div[3]/div/div/div[4]/div/div[2]/button");
	By SaveButton = By.xpath("//button[contains(@onclick,'saveApproverMethod()')]");
	By SearchButton = By.xpath(".//*[@id='search_approver']");
	By verifyapprover = By.xpath("//table[@id='approverTable']/tbody/tr[1]/td[1]");
	
	
	public ApprovalTeamPage(WebDriver driver){
		this.driver=driver;
		
	}
	public void ClickOnIncentive(){
		driver.findElement(Incentive).click();
		log("Selected incentive and object is:-" +Incentive.toString());
	}
	
	public void ClickOnApprovalTab(){
		driver.findElement(ApprovalTab).click();
		log("clicked on ApprovalTab and object is:-"+ApprovalTab.toString());
	}

	public void ClickOnAddApproverbutton(){
		driver.findElement(AddApprover).click();
				log("clicked on AddApproverbutton and object is:-"+AddApprover.toString());
	}
	public void enterApproverName(String approverName){
		driver.findElement(ApproverName).sendKeys(approverName);
		log("Entered ApproverName:-"+approverName+ "and object is:-"+ApproverName.toString());
	}
	
	public void selectApprover(){
		driver.findElement(selectApprover).click();
		log("selected Approver and object is:-"+selectApprover.toString());
	}
	
	
	public void ClickOnSaveButton(){
		driver.findElement(SaveButton).click();
		log("clicked on SaveButton and object is:-"+SaveButton.toString());	
}
	public void ClickOnSearchbutton(String searchButton){
		driver.findElement(SearchButton).sendKeys(searchButton);
				log("clicked on searchbutton:-"+searchButton+ "and object is:-"+SearchButton.toString());
	}
	
	public void VerifyAddApprover(String expected)
	{
			String actual= driver.findElement(verifyapprover).getText();
			System.out.println(actual);
			boolean flag = false;
			if(actual.contains(expected))
			{
				flag = true;
				
		   }
			Assert.assertTrue(flag, "actual does not match with expected");
			
		 }
		
	 @Test
		public void AddNewApprover() throws Exception{

        ClickOnIncentive();
		ClickOnApprovalTab();
	    ClickOnAddApproverbutton();
	    enterApproverName("rsaxenan");
		waitFor(3);
	    selectApprover();
		waitFor(3);
        ClickOnAddApproverbutton();
        enterApproverName("ssingha6");
		selectApprover();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,1000)", "");
		waitFor(5);
		ClickOnSaveButton();
		waitFor(2);
		ClickOnIncentive();
        ClickOnApprovalTab();
		VerifyAddApprover("Rohit Saxena   ");
		ClickOnSaveButton();
		  }
	 @Test
		public void verifyNewApprover() throws Exception{

			ClickOnIncentive();
		    ClickOnApprovalTab();
			waitFor(3);
			ClickOnSearchbutton("rsaxena");
			VerifyAddApprover("Rohit Saxena   ");
			ClickOnSaveButton();
}
	 @Test
		public void verifyCreatedIncentive() throws Exception{ 
	
				ClickOnIncentive();
				ClickOnApprovalTab();
				waitFor(3);
				VerifyAddApprover("Rohit Saxena   ");
		 }
		
	}
	



