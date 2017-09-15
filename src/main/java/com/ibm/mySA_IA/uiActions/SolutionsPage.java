package com.ibm.mySA_IA.uiActions;



import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ibm.mySA_IA.testBase.TestBase;




public class SolutionsPage extends TestBase {
	WebDriver driver;
	public static final Logger log=Logger.getLogger(SolutionsPage.class.getName());
	
	By Incentive     = By.xpath(".//*[@id='viewTable']/tbody/tr[1]/td[1]/a");
	By solutions     = By.xpath("//a[contains(text(),'Solutions')]");
	By AddNewSolution= By.xpath(".//*[@style='margin-left: 454px;width: 280px;'][contains(text(),'Add New Solution')]");
	By solutionType  = By.xpath("//input[@id='solutionType']");
	By Level1        = By.xpath("//input[@id='level1']");
	By Level1Desc    = By.xpath("//input[@id='level1Desc']");
	By Level2        = By.xpath("//input[@id='level2']");
	By Level2Desc    = By.xpath("//input[@id='level2Desc']");
	By Level3        = By.xpath("//input[@id='level3']");
	By Level3Desc    = By.xpath("//input[@id='level3Desc']");
	By Level4        = By.xpath("//input[@id='level4']");
	By Level4Desc    = By.xpath("//input[@id='level4Desc']");
	By Addbutton     = By.xpath("//button[@id='addnewsolution'][contains(text(),'Add')]");
	By Savebutton     = By.xpath("//a[contains(text(),'Save')]");
	By SearchButton = By.xpath("//input[@placeholder='Solution ID,Type or Level1']");
	By verifysolution= By.xpath("//td[contains(text(),'type')]");
	
	By verifysolution1=By.xpath("//td[contains(.,'Test1')]");
	
	By AddExistingsolution=By.xpath("//a[contains(text(),'Add Existing Solutions')]");
	By checkbox  = By.xpath("//table[@id='viewSolutionTable']/tbody/tr[1]/td[1]//label/div");
	By addSolutionid=By.xpath("//table[@id='viewSolutionTable']/tbody/tr[1]/td[2]");
	By addbutton=By.xpath("//a[@id='addsolution'][contains(text(),'Add')]");
    By solutionid =By.xpath("//table[@id='viewSolutionIncTable']//tbody/tr[1]/td[1]");
	
	public SolutionsPage(WebDriver driver){
		this.driver=driver;
}
	public void ClickOnIncentive(){
		driver.findElement(Incentive).click();
		log("Selected incentive and object is:-" +Incentive.toString());
	}
	public void ClickOnsolutionsTab(){
		driver.findElement(solutions).click();
		log("clicked on solution tab and object is:-" +solutions.toString());
	}
	public void ClickOnAddNewsolution(){
		driver.findElement(AddNewSolution).click();
		log("clicked on add new solution tab and object is:-" +AddNewSolution.toString());
	}
	public void enterSolutionType(String solutiontype){
		driver.findElement(solutionType).sendKeys(solutiontype);
		log("Entered solution type:-"+solutiontype+ "and object is:-"+solutionType.toString());
	}
	public void enterlevel1(String level1){
		driver.findElement(Level1).sendKeys(level1);
		log("Entered level1:-"+level1+ "and object is:-"+Level1.toString());
	}
	public void enterlevel1Desc(String level1desc){
		driver.findElement(Level1Desc).sendKeys(level1desc);
		log("Entered level1 description:-"+level1desc+ "and object is:-"+Level1Desc.toString());
	}
	public void enterlevel2(String level2){
		driver.findElement(Level2).sendKeys(level2);
		log("Entered level2:-"+level2+ "and object is:-"+Level2.toString());
	}
	public void enterlevel2Desc(String level2desc){
		driver.findElement(Level2Desc).sendKeys(level2desc);
		log("Entered level2 description:-"+level2desc+ "and object is:-"+Level2Desc.toString());
	}
	public void enterlevel3(String level3){
		driver.findElement(Level3).sendKeys(level3);
		log("Entered level3:-"+level3+ "and object is:-"+Level3.toString());
	}
	public void enterlevel3Desc(String level3desc){
		driver.findElement(Level3Desc).sendKeys(level3desc);
		log("Entered level3 description:-"+level3desc+ "and object is:-"+Level3Desc.toString());
	}
	public void enterlevel4(String level4){
		driver.findElement(Level4).sendKeys(level4);
		log("Entered level4:-"+level4+ "and object is:-"+Level4.toString());
	}
	public void enterlevel4Desc(String level4desc){
		driver.findElement(Level4Desc).sendKeys(level4desc);
		log("Entered level4 description:-"+level4desc+ "and object is:-"+Level4Desc.toString());
	}
	public void ClickOnAddButton(){
		driver.findElement(Addbutton).click();
		log("clicked on add button and object is:-" +Addbutton.toString());
	}
	public void ClickOnSaveButton(){
		driver.findElement(Savebutton).click();
		log("clicked on Save button and object is:-" +Savebutton.toString());
	}
	public void ClickOnSearchbutton(String searchButton){
		driver.findElement(SearchButton).sendKeys(searchButton);
				log("clicked on searchbutton:-"+searchButton+ "and object is:-"+SearchButton.toString());
	}
	public void ClickOnAddExistingSolution(){
		driver.findElement(AddExistingsolution).click();
		log("clicked on Add Existing Solution and object is:-" +AddExistingsolution.toString());
	}
	public void ClickOnCheckbox(){
		driver.findElement(checkbox).click();
		log("clicked on checkbox and object is:-" +checkbox.toString());
	}
	public void ClickOnAddbutton(){
		driver.findElement(addbutton).click();
		log("clicked on Add button and object is:-" +addbutton.toString());
	}

	
	public void VerifyNewSolution(String expected)
	{
			String actual= driver.findElement(verifysolution).getText();
			System.out.println(actual);
			boolean flag = false;
			if(actual.contains(expected))
			{
				flag = true;
				Assert.assertTrue(flag, "new solution found");
				
		   }else{
			Assert.assertTrue(flag, "new solution not found");
		   }
		 }
	public void VerifyAddedSolution(String expected)
	{
		String actual= driver.findElement(solutionid).getText();
		System.out.println(actual);
		boolean flag = false;
		if(actual.equals(expected))
		{
			flag = true;
			
			log("Verified Actual Text");
			}
		Assert.assertTrue(flag, "added solution found in existing solution list");
		
	 }
	 @Test
		public void addExistingSolution() throws Exception{
		
	    ClickOnIncentive();
		ClickOnsolutionsTab();
		waitFor(3);
		ClickOnAddExistingSolution();
		waitFor(3);
		ClickOnCheckbox();
		waitFor(3);
		ClickOnAddbutton();
		waitFor(5);
		ClickOnSaveButton();
		waitFor(3);
		ClickOnIncentive();
		ClickOnsolutionsTab();
		waitFor(3);
		VerifyAddedSolution("1JF-21RIMAG");
		ClickOnSaveButton();
	 }
	 @Test
		public void verifyAddedSoln() throws Exception{
		
		ClickOnIncentive();
		ClickOnsolutionsTab();
		waitFor(3);
		ClickOnSearchbutton("1JF-21RIMAG");
		waitFor(3);
		VerifyAddedSolution("1JF-21RIMAG");
		ClickOnSaveButton();
}
	 @Test
		public void verifyCreatedSolution() throws Exception{
		
		ClickOnIncentive();
		ClickOnsolutionsTab();
		waitFor(3);
		VerifyAddedSolution("1JF-21RIMAG");
		ClickOnSaveButton();
}	
	 @Test
		public void AddNewSolution() throws Exception{
		
		ClickOnIncentive();
		ClickOnsolutionsTab();
		waitFor(3);
		ClickOnAddNewsolution();
		enterSolutionType("type");
		enterlevel1("Test1");
		enterlevel1Desc("Test1 solution");
		enterlevel2("Test2");
		enterlevel2Desc("Test2 solution");
		enterlevel3("Test3");
		enterlevel3Desc("Test3 solution");
		enterlevel4("Test4");
		enterlevel4Desc("test4 Solutiondesc");
		waitFor(3);
		ClickOnAddButton();
		waitFor(3);
		ClickOnSaveButton();
		waitFor(3);
		ClickOnIncentive();
		ClickOnsolutionsTab();
		waitFor(5);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,450)", "");
		waitFor(5);
		VerifyNewSolution("type");
		ClickOnSaveButton();
		 waitFor(3);
	  }
	 @Test
		public void verifyNewSoln() throws Exception{
		
		ClickOnIncentive();
		ClickOnsolutionsTab();
		waitFor(3);
		ClickOnSearchbutton("type");
		VerifyNewSolution("type");
		ClickOnSaveButton();
		 waitFor(3);
}
	 @Test
		public void verifySolutionIncentive() throws Exception{
		
		ClickOnIncentive();
		ClickOnsolutionsTab();
		waitFor(5);
		VerifyNewSolution("type");
		 waitFor(3);

	 }
}
	
	
