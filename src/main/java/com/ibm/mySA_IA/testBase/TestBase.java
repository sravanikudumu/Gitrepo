package com.ibm.mySA_IA.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

import com.google.common.base.Function;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.sun.jna.platform.win32.Netapi32Util.User;

public class TestBase {
    public static final Logger log=Logger.getLogger(TestBase.class.getName());
	public static Properties Repository = new Properties();
	public File f;
	public FileInputStream FI;
	public static WebDriver driver;
	/*public String startTime;
	public static int indexSI = 1;
	public static ExtentReports extent;
	public static ExtentTest test;*/
//Added a Comment
	public void init() throws IOException {
		//extent = new ExtentReports("C:\\Users\\IBM_ADMIN\\git\\Local_DealReg_Outage_Repo\\DealReg_Outage\\src\\main\\java\\com\\ibm\\DealReg_Outage\\screenshots\\test.html");
		
		loadPropertiesFile();
		selectBrowser(Repository.getProperty("browser"));
		log("Navigate to url");
		driver.get(Repository.getProperty("url"));
		String log4jconfpath="log4j.properties";
		PropertyConfigurator.configure(log4jconfpath);
		impliciteWait(20);
	}

	public void loadPropertiesFile() throws IOException {
	
			f = new File(System.getProperty("user.dir") +"/src/main/java/com/ibm/mySA_IA/config/config.properties");
			FI = new FileInputStream(f);
			Repository.load(FI);

		}

	/**
	 * This method initialize browser object
	 * 
	 * @param browser
	 * @return browser driver
	 */
	public WebDriver selectBrowser(String browser) {
		if (browser.equals("firefox") || browser.equals("FIREFOX")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			return driver;
		} else if (browser.equals("chrome") || browser.equals("CHROME")) {
			System.out.println("chrome browser");
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/java/com/ibm/mySA_IA/Resources/chromedriver.exe");
			log("creating object of "+browser.toString());
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			return driver;
		} else if (browser.equals("ie") || browser.equals("IE")) {
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			return driver;
		}
		return null;
	}
	public void log(String data) {
		log.info(data);
		Reporter.log(data);
		//test.log(LogStatus.INFO, data);
}
	public void expliciteWait(WebElement element, int timeToWaitInSec) {
		WebDriverWait wait = new WebDriverWait(driver, timeToWaitInSec);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForPageToLoad(long timeOutInSeconds) {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		try {
			System.out.println("Waiting for page to load...");
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(expectation);
		} catch (Throwable error) {
			System.out.println("Timeout waiting for Page Load Request to complete after " + timeOutInSeconds + " seconds");
			Assert.assertFalse(true, "Timeout waiting for Page Load Request to complete.");

		}
	}

	public void clickWhenReady(By locator, int timeout) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();

	}

	public WebElement fluentWait(final WebElement webElement, int timeinsec) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(timeinsec, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return webElement;
			}
		});

		return element;
	};

	public WebElement getWhenVisible(By locator, int timeout) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element;

	}

	public void waitFor(int sec) throws InterruptedException {
		Thread.sleep(sec * 1000);
	}

	public void impliciteWait(int timeInsec){
		Reporter.log("waiting for page to load...");
		try{
		driver.manage().timeouts().implicitlyWait(timeInsec, TimeUnit.SECONDS);
		Reporter.log("Page is loaded");
		}
		catch(Throwable error){
			Reporter.log("Timeout for Page Load Request to complete after "+ timeInsec + " seconds");
			Assert.assertTrue(false, "Timeout for page load request after "+timeInsec+" second");
		}
	}
	public void closeBrowser() {
		//driver = null;
		driver.close();
	}

	public  void getScreenShot(String fileName) throws IOException {
		File outputFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(outputFile, new File(System.getProperty("user.dir") + "//src//test//java//com//companyname//projectname//screenshots//" + fileName + ".jpg"));
	}
	
	@AfterMethod
	public void tearDown(){
	closeBrowser();
	}

}