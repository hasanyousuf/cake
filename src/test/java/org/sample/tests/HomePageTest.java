/**
 * 
 */
package org.sample.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.apache.log4j.Logger;
import org.sample.base.TestBase;
import org.sample.pages.HomePage;
import org.testng.Reporter;
import org.sample.ExtentReportListener.ExtendManager;
import org.sample.ExtentReportListener.ExtendTestManager;

/**
 * @author hasan
 *
 */
@Test(testName="HomePage")
public class HomePageTest extends TestBase {
	private HomePage HomePage;
		
	Logger log = Logger.getLogger(HomePageTest.class);
	ExtendManager test;
	private static final String BROWSER					= "chrome";
	private static final String BASE_URL 				= "https://cakesolutions.github.io/cake-qa-test/#/";
	private static final String PAGE_TITLE              = "Cake Soloptions FED Test";
	private static final String REGISTRATION_URL 		= "https://cakesolutions.github.io/cake-qa-test/#/register";
	/**
	 * 
	 */
	public HomePageTest() {
		super();
	}

	@BeforeClass
	@Parameters({ "url", "browser" })
	//@Parameters({ "BASE_URL", "BROWSER" })
	public void setUp(String url, String browser) {
		Reporter.log("Browser Opened");
		initialization(BASE_URL, BROWSER);
		log.info("\n\n****************** Browser is lauched ***********************\n\n\n");
		HomePage = new HomePage();
	}
	@Test(priority = 0, description = "Verify home page logo")
	@Description("Test Description: Verify the URL is correct")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Verify the URL is correct")
	@Issue("ALR-789")
    @TmsLink("TMS-123")
	public void testCorrectBaseUrl() throws InterruptedException {
		WebElement fieldHandle = HomePage.getLinks();		
		List<String> strings = Arrays.asList("active", "");
		Iterator<String> stringIt = strings.iterator();
		List<WebElement> allElements= driver.findElements(By.xpath("//ul//a/parent::*"));
		Iterator<WebElement> allIterator = allElements.iterator();
		while(allIterator.hasNext()) {			
			Assert.assertEquals(allIterator.next().getAttribute("class"), stringIt.next(),"Wrong class");
		}
		
		for(WebElement ele :allElements) {
		    System.out.println("Name + Number===>"+ele.getText());
		    System.out.println("Name + Number===>"+ele.getText());
		    System.out.println("Class ===>"+ele.getAttribute("class"));

		log.info("####################");

		ExtendTestManager.getTest().setDescription("Verify that user is right url.");
		ExtendTestManager.getTest().log(LogStatus.INFO, "Opening Welcome Page & validating the URL");
		ExtendTestManager.getTest().log(LogStatus.INFO, "Current URL: "+ getCurrentURL());
		ExtendTestManager.getTest().log(LogStatus.INFO, "Expected URL: "+ BASE_URL);
		Assert.assertEquals(getCurrentURL(), BASE_URL, "Wrong base URL");
		}
	}

	@Test(priority = 2, description = "Verify home page logo")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Description: Verify home page logo")
	@Story("Verify home page logo")
	public void testHomePageLogo() throws Exception {
		ExtendTestManager.getTest().setDescription("Verify home page logo.");
		ExtendTestManager.getTest().log(LogStatus.INFO, "Opening Welcome Page & validating the URL");
		Assert.assertTrue(HomePage.getSiteLogo().isDisplayed());
	}
	
	
	@Test(priority = 3, description = "Verify Home page title")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Description: Verify Home page title")
	@Story("Verify Home page title")
	public void verifyHomePageTitle() throws Exception {
		ExtendTestManager.getTest().setDescription("Verify Home page title.");
		ExtendTestManager.getTest().log(LogStatus.INFO, "Verify Home page title");
			Assert.assertTrue(HomePage.getTitle().contains(PAGE_TITLE), "Wrong Title");
	}
	
	@Test(priority = 4, description = "Go to Registion page")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Description: Verify User can go to registration form")
	@Story("Go to Registion page")
	public void testUserCanGoToRegistrationPage() throws Exception {
		ExtendTestManager.getTest().setDescription("Verify User can go to Registion page.");
		ExtendTestManager.getTest().log(LogStatus.INFO, "Registration button is displayed");
		HomePage.getRegistrationButton().isDisplayed();
		ExtendTestManager.getTest().log(LogStatus.INFO, "Verify that user is on correct URL.");
		HomePage.goToRegistration();
		Assert.assertEquals(getCurrentURL(), REGISTRATION_URL,"User is not registration page" );		
	}

	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		log.info("\n\n****************** Shutdown Browser (tearDown-SearchPropertyForRentTest) *******************");

	}

}
