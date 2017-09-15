package com.ibm.mySA_IA.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ibm.mySA_IA.testBase.TestBase;





public class MembershipPage extends TestBase{
	WebDriver driver;
	public static final Logger log=Logger.getLogger(MembershipPage.class.getName());
	

	    By Cancelbutton     = By.xpath("//a[contains(text(),'Cancel')]");
		By IncentiveInList = By.xpath(".//*[@id='viewTable']/tbody/tr[1]/td[1]/a");
		By Membership = By.xpath(".//*[@id='tab-control-demo-2']");
		By MembershipType = By.xpath(".//*[@id='membership']/div[1]/div/div/div/select/option[contains(text(),'Individual BPs')]");
		By AddMember = By.xpath(".//*[@id='addMember']");
		By Search = By.xpath(".//*[@id='search_mem']");
		By checkbox = By.xpath(".//*[@id='viewMemberTable_tbody']/tr[1]/td[1]/div/label[@for='checkbox_0']");
		By AddBPs = By.xpath(".//button[@id='addMember']");
		By Save = By.xpath(".//*[@id='individualBP']/div/div[4]/div/div[2]/button");
		By Searchfield = By.xpath(".//*[@id='search_inc_mem']");
		By verifyNewBPs = By.xpath(".//*[@id='BPMember']/tbody/tr/td[3]");
		By Membershipoverlay = By.xpath(".//*[@id='BPMember']/tbody");
		By AddButton = By.xpath("//span[@id='addNewBP']");
		By BPName = By.xpath(".//*[@id='bpName']");
		By CEID = By.xpath(".//*[@id='ceid']");
		By Country = By.xpath(".//*[@id='country']");
		By AddBPsButton = By.xpath("//button[@name='addMember']");
		By MembershipTable = By.xpath(".//*[@id='individualBP']/div/div[3]");
		By IndividualBProw =By.xpath(".//*[@id='individualBP']/div/div[3]//tbody");
		By SearchfieldInAddMembers = By.xpath(".//*[@id='viewMemberTable_tbody']/tr[1]/td[3]");
		
		public MembershipPage(WebDriver driver){
			this.driver=driver;
		}
			public void clickonIncentiveInList() {
				driver.findElement(IncentiveInList).click();
				log("Clicked on NewIncentive in List and object is:-" +IncentiveInList.toString());
				
			}
			
			
			public void selectMembershipType(){
				driver.findElement(MembershipType).click();
				log("Clicked on MembershipType Dropdown:-"+MembershipType.toString());
			}
			public void ClickonAddMember(){
				driver.findElement(AddMember).click();
				log("Clicked on AddMember Button:-" +AddMember.toString());
				}
			public void Search(String ceid) throws InterruptedException {
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.scrollBy(0,250)", "");
				Thread.sleep(60);
				
				driver.findElement(Search).sendKeys(ceid);
				Thread.sleep(60);
				log("Entered Ceid in Search filed of AddMember Popup:-"+Search+ "and object is:-"+Search.toString());
				
			}
			public void checkbox() throws InterruptedException {
				
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.scrollBy(0,250)", "");
				Thread.sleep(20);
				driver.findElement(checkbox).click();
				log("Clicked on check box to check it :-"+checkbox.toString());
				
			}
			public void AddBPs(String ceid) throws InterruptedException {
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.scrollBy(0,250)", "");
				Thread.sleep(20);
				driver.findElement(AddBPs).click();
				log("Clicked on AddBPs button :-"+AddBPs.toString());
				Thread.sleep(30);
				 
					String actual= driver.findElement(By.xpath("//td[contains(text(),'10ailwoc')]")).getText();
					System.out.println(actual);
					boolean flag = false;
					if(actual.equals(ceid))
					{
						flag = true;
						System.out.println("Newly added BPs is coming in membership tab before clicking on the Save button");

				   }
					Assert.assertTrue(flag, "actual does not match with expected");
				
			}
			public void Save() throws InterruptedException {
				Thread.sleep(20);
				driver.findElement(Save).click();
				log("Clicked on :-"+Save.toString());
			}
			public void Searchfield(String ceid) throws InterruptedException {
				driver.findElement(Searchfield).sendKeys(ceid);
				Thread.sleep(60);
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.scrollBy(0,250)", "");
				Thread.sleep(60);
				log("Entered Search:-"+Searchfield+ "and object is:-"+Searchfield.toString());	 
					String actual= driver.findElement(By.xpath("//td[contains(text(),'10ailwoc')]")).getText();
					System.out.println(actual);
					boolean flag = false;
					if(actual.equals(ceid))
					{
						flag = true;
						System.out.println("Newly added BPs is verified under membership tab");

				   }
					Assert.assertTrue(flag, "actual does not match with expected");

				
			}
			
			 public void verifyNewBPs(String expected){
				 
				 JavascriptExecutor jse = (JavascriptExecutor)driver;
					jse.executeScript("window.scrollBy(0,250)", "");
					
					 
					String actual= driver.findElement(By.xpath("//td[contains(text(),'10ailwoc')]")).getText();
					log("Verifying Newly Added BPs:-"+"String actual"+ "and object is:-"+"String actual".toString());
					System.out.println(actual);
					boolean flag = false;
					if(actual.equals(expected))
					{
						flag = true;
						System.out.println("Newly added BPs is verified");

				   }
					Assert.assertTrue(flag, "actual does not match with expected");

					//Assert.assertEquals(actual, expected);
				 } 
			 
			 public void Membershipoverlay(String expected){
				 
				 JavascriptExecutor jse = (JavascriptExecutor)driver;
					jse.executeScript("window.scrollBy(0,250)", "");
					
					
					log("Verfying on created incentive for BP membership overlay:-"+Membershipoverlay.toString());
					String actual= driver.findElement(By.xpath("//td[contains(text(),'10ailwoc')]")).getText();
					log("Verifying Newly Added BPs:-"+"String actual"+ "and object is:-"+"String actual".toString());
					System.out.println(actual);
					boolean flag = false;
					if(actual.equals(expected))
					{
						flag = true;
						System.out.println("OverLay verified for newly added BPs");

				   }
					Assert.assertTrue(flag, "actual does not match with expected");
				}
			   public void ClickOnCancelButton(){
					driver.findElement(Cancelbutton).click();
					log("clicked on Save button and object is:-" +Cancelbutton.toString());
				}
			   public void ClickonMembership()
				{
					driver.findElement(Membership).click();
					log("Clicked on Membership tab:-" +Membership.toString());
				}
			   
			   public void ClickonAdd()
				{
					driver.findElement(AddButton).click();
					log("Clicked on Add button and object is:-" +AddButton.toString());
				}
			   public void EnterBPName(String bpName)
				{
					driver.findElement(BPName).sendKeys(bpName);
				    log("Entered BP Name and object is:-" +BPName.toString());
				}
			   public void EnterCEID(String ceid)
				{
					driver.findElement(CEID).sendKeys(ceid);
					log("Entered ceid and object is:-" +CEID.toString());
				}
			   public void EnterCountry(String country)
				{
					driver.findElement(Country).sendKeys(country);
					log("Entered Country and object is:-" +Country.toString());
				}
			   public void ClickonAddBPs()
				{
					driver.findElement(AddBPsButton).click();
					log("Clicked on AddBPs button and object is:-" +AddBPsButton.toString());
				}
			  public void verifynewBPAddedbyceid(){
				  String ceidText=driver.findElement(MembershipTable).getText();
				  //System.out.println(ceidText);
				  if(ceidText.contains("RT7U")){
					  System.out.println("Verified New BP by Ceid in membership table");
				  }else{
					  System.out.println("Verification failed to search New BP by Ceid in membership table");
				  }
			  }
			  public void verifynewBPAddedbyBPname(){
				  String ceidText=driver.findElement(MembershipTable).getText();
				  //System.out.println(ceidText);
				  if(ceidText.contains("Add Bp1")){
					  System.out.println("Verified New BP by BPName in membership table");
				  }else{
					  System.out.println("Verification failed to search New BP by BpName in membership table");
				  }
			  }
				  public void enterSeachField(String ceid){
						driver.findElement(Searchfield).sendKeys(ceid);
						boolean isdisplayed = driver.findElement(IndividualBProw).isDisplayed();
						if(isdisplayed){
							//driver.findElement(newIncentiveInList).click();
						Assert.assertTrue(true, "Displayed individualBP row with CEID");
						log("Displayed individualBP row with CEID and object is" +IndividualBProw.toString());
					
						}else{
						Assert.assertTrue(false, "Individual BP row not displayed");
						}
				  }
						 public void enterSeachField4AddMembership(String ceid) throws InterruptedException{
							 
							 driver.findElement(SearchfieldInAddMembers).sendKeys(ceid);
							 driver.findElement(By.xpath("//p[contains(@class,'ds-text-red-3')]")).getText();
							 waitFor(3);
							 String ceidText=driver.findElement(SearchfieldInAddMembers).getText();
								if(ceidText.contains("18z")){
									//driver.findElement(newIncentiveInList).click();
								Assert.assertTrue(true, "Displayed individualBP row with CEID");
								log("Displayed individualBP row with CEID and object is" +IndividualBProw.toString());
							
								}else{
								Assert.assertTrue(false, "Individual BP row not displayed");
								}
				  }
		
			   
			   
			  @Test
				public void AddNewBPmember() throws Exception{
				    // ClickOnCancelButton();
					 clickonIncentiveInList();
					 waitFor(2);
					 ClickonMembership();
					 waitFor(2);
					 selectMembershipType();
					 waitFor(2);
					 ClickonAddMember();
					 waitFor(3);
					 Search("10ailwoc");
					 waitFor(5);
					 checkbox();
					 waitFor(10);
					 AddBPs("10ailwoc");
					 waitFor(3);
					 Save();
					 waitFor(3);
				}
			  @Test
				public void verifyNewMemberAdded() throws Exception{
					 	
					 clickonIncentiveInList();
					 ClickonMembership();
					 waitFor(30);
					 verifyNewBPs("10ailwoc");
					 ClickOnCancelButton();
					 waitFor(3);
}

				@Test
				public void searchAddedNewMember() throws Exception{
						
					 clickonIncentiveInList();
					 ClickonMembership();
					 waitFor(5);
			         Searchfield("10ailwoc");
			         waitFor(5);
			         ClickOnCancelButton();
			         waitFor(3);

				}
				@Test
				public void verifyBPMembershipOverlay() throws Exception{
					 	
					 clickonIncentiveInList();
					 ClickonMembership();
					 waitFor(5);
					 Membershipoverlay("10ailwoc");
					 waitFor(5);
					 ClickOnCancelButton();
					 waitFor(3);
				}
				@Test
				public void verifyAddedNewBPinIncentive() throws InterruptedException{
					clickonIncentiveInList();
					ClickonMembership();
					selectMembershipType();
					waitFor(10);
					ClickonAddMember();
					waitFor(5);
					ClickonAdd();
					waitFor(5);
					EnterBPName("Add Bp1"+System.currentTimeMillis());
					EnterCEID("RT7U"+System.currentTimeMillis());
					EnterCountry("India");
					waitFor(10);
					ClickonAddBPs();
					waitFor(5);
					verifynewBPAddedbyceid();
					waitFor(3);
				    Save();
					waitFor(3);
				}
				@Test
				public void verifyAddedNewBPinSystem() throws InterruptedException{	
					clickonIncentiveInList();
					ClickonMembership();
					selectMembershipType();
					waitFor(10);
					enterSeachField("RT7U");
					waitFor(3);
				}
				@Test
				public void verifySearchInMembership() throws InterruptedException{
					clickonIncentiveInList();
					ClickonMembership();
					selectMembershipType();
					waitFor(10);
					ClickonAddMember();
					waitFor(5);
					ClickonAdd();
					waitFor(5);
					EnterBPName("Add Bp1"+System.currentTimeMillis());
					EnterCEID("RT7U"+System.currentTimeMillis());
					EnterCountry("India");
					waitFor(10);
					ClickonAddBPs();
					waitFor(5);
					verifynewBPAddedbyBPname();
					waitFor(3);
				    Save();
				    waitFor(3);
					
						
				}
				@Test
				public void verifySearch4AddMember() throws InterruptedException{
					clickonIncentiveInList();
					ClickonMembership();
					selectMembershipType();
					waitFor(10);
					ClickonAddMember();
					waitFor(5);
				  enterSeachField4AddMembership("18z");
				    
						
				}
}
	
		
	


	

	
