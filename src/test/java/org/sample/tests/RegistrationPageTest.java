/**
 * 
 */
package org.sample.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sample.ExtentReportListener.ExtendTestManager;
import org.sample.base.TestBase;
import org.sample.pages.HomePage;
import org.sample.pages.RegistrationPage;



/**
 * @author hasan
 *
 */
@Test(testName="Registration")
@Epic("Regression Tests")
@Feature("User registration")
public class RegistrationPageTest extends TestBase {
	private RegistrationPage RegistrationPage;
	private HomePage HomePage;
	Logger log = Logger.getLogger(RegistrationPageTest.class);
	
	private WebElement fieldHandle = null;
	private String labelHandle = null;
	
	private static final String BASE_URL                = "https://cakesolutions.github.io/cake-qa-test/#/";
	private static final String SITE_TEXT               = "Cake Soloptions FED Test";
	private static final String FIRST_NAME				="TEST FIRST";
	private static final String LAST_NAME				="LAST NAME";
	private static final String EMAIL					="test@example.com";
	private static final String PASSWORD				="mySoluationPass";
	private static final String REPEAT_PASSWORD			="mySoluationPass";
	private static final String REPEAT_PASSWORD_MISS	="missleading";
	
	private static final String FIRST_NAME_LABEL	    ="First name *";
	private static final String LAST_NAME_LABEL			="Last name *";
	private static final String EMAIL_LABEL			    ="Email *";
	private static final String PASSWORD_LABEL			="Password *";
	private static final String REPEAT_PASSWORD_LABEL	="Re-enter Password *";

	private static final String FIRST_NAME_ERROR = "First name is required";
	private static final String LAST_NAME_ERROR = "Last name is required";
	private static final String EMAIL_ERROR = "Email is required";
	private static final String PASSWORD_ERROR = "Password is required";
	private static final String REPEAT_PASSWORD_ERROR = "Password is required";
	
	private static final String FIELDS_ENABLED_CLASS = "help-block";
	private String query="";
	private String enabledClass="";
	private String greetings = "/html/body/div/div[2]/div/div[1]/h2";
	/**
	 * 
	 */
	public RegistrationPageTest() {
		super();
	}

	
	
	@BeforeClass
	@Parameters({ "url","registration_url", "browser" })
	public void setUp(String url, String registration_url, String browser) {

		log.info("\n\n****************** Lauching Browser (Setup)  ******************");
		log.info("\n\n****************** Executing test cases for RegistrationPage ******************");
		initialization(registration_url , browser);
		log.info("\n\n****************** Browser is lauched ***********************\n\n\n");

		RegistrationPage = new RegistrationPage();
		HomePage         = new HomePage();

	}
	@Test(priority = 0, description = "Verify user is on registration form")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Description: Verify User is on registration form")
	@Story("User registration")
	@Parameters({ "url","registration_url", "browser" })
	public void testUserIsOnRegistrationForm(String url, String registration_url, String browser) throws Exception {
		ExtendTestManager.getTest().setDescription("Verify user is on registration form.");
		ExtendTestManager.getTest().log(LogStatus.INFO, "Verify that user is on correct URL.");
		Assert.assertEquals(getCurrentURL(), registration_url,"User is not registration page" );		
	}	
	
	@Test(priority = 1, description = "Validation error messages should be displayed on error")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Description: Validation error messages should be displayed on error")
	@Story("User registration")
	public void testValidationMessagesAreDisplayedOnError() throws Exception {
		ExtendTestManager.getTest().setDescription("Validation error messages should be displayed on error");
		SoftAssert softAssertion= new SoftAssert();
		

		
		ExtendTestManager.getTest().log(LogStatus.INFO, "First name field is display.");
		fieldHandle = RegistrationPage.getFirstName();
		fieldHandle.sendKeys(" ");
		fieldHandle.clear();
		
		/*
		 * To check if validation error message is displayed
		 *
		String error=getFormError();
		if(error!=null) {
			
			ExtendTestManager.getTest().log(LogStatus.INFO, "Validation error message: is displayed "+error);		
		}*/
		query= "//*[text() = '"+ FIRST_NAME_ERROR +"']";
		enabledClass = driver.findElement(By.xpath(query)).getAttribute("class");
		softAssertion.assertEquals(enabledClass, FIELDS_ENABLED_CLASS);
		ExtendTestManager.getTest().log(LogStatus.INFO, "Validation error message: is displayed ");		
		
		
		
		fieldHandle = RegistrationPage.getLastName();		
		labelHandle = fieldHandle.findElement(By.xpath("..")).getText();
		softAssertion.assertEquals(labelHandle.contains(LAST_NAME_LABEL),true);
		
		fieldHandle.sendKeys(" ");
		fieldHandle.clear();
		
		/*
		 * To check if validation error message is displayed
		 */
		query= "//*[text() = '"+ LAST_NAME_ERROR +"']";
		enabledClass = driver.findElement(By.xpath(query)).getAttribute("class");
		softAssertion.assertEquals(enabledClass, FIELDS_ENABLED_CLASS);
		ExtendTestManager.getTest().log(LogStatus.INFO, "Validation error message: is displayed ");
		
		
		ExtendTestManager.getTest().log(LogStatus.INFO, "Email field is display.");
		fieldHandle = RegistrationPage.getEmail();

		labelHandle = fieldHandle.findElement(By.xpath("..")).getText();
		softAssertion.assertEquals(labelHandle.contains(EMAIL_LABEL),true);
		
		ExtendTestManager.getTest().log(LogStatus.INFO, "User enters email address as: <b><i>"+EMAIL+"</i></b>");
		fieldHandle.sendKeys(" ");
		fieldHandle.clear();
		/*
		 * To check if validation error message is displayed
		 */
		query= "//*[text() = '"+ EMAIL_ERROR +"']";
		enabledClass = driver.findElement(By.xpath(query)).getAttribute("class");
		softAssertion.assertEquals(enabledClass, FIELDS_ENABLED_CLASS);
		ExtendTestManager.getTest().log(LogStatus.INFO, "Validation error message: is displayed ");
		
		
		ExtendTestManager.getTest().log(LogStatus.INFO, "Password field is display.");
		fieldHandle = RegistrationPage.getPassword();
		
		labelHandle = fieldHandle.findElement(By.xpath("..")).getText();
		softAssertion.assertEquals(labelHandle.contains(PASSWORD_LABEL),true);
		
		ExtendTestManager.getTest().log(LogStatus.INFO, "User enters password as: <b><i>"+ PASSWORD+"</i></b>");
		fieldHandle.sendKeys(PASSWORD);
		fieldHandle.clear();
		/*
		 * To check if validation error message is displayed
		 */
		query= "//*[text() = '"+ PASSWORD_ERROR +"']";
		enabledClass = driver.findElement(By.xpath(query)).getAttribute("class");
		softAssertion.assertEquals(enabledClass, FIELDS_ENABLED_CLASS);
		ExtendTestManager.getTest().log(LogStatus.INFO, "Validation error message: is displayed ");



		ExtendTestManager.getTest().log(LogStatus.INFO, "Repeat password field is display.");
		fieldHandle = RegistrationPage.getPassword2();
		
		labelHandle = fieldHandle.findElement(By.xpath("..")).getText();
		softAssertion.assertEquals(labelHandle.contains(REPEAT_PASSWORD_LABEL),true);
		
		ExtendTestManager.getTest().log(LogStatus.INFO, "User enters repeat password as: <b><i>"+REPEAT_PASSWORD+"</i></b>");
		fieldHandle.sendKeys(REPEAT_PASSWORD);

		fieldHandle.clear();

		String  we=RegistrationPage.getRepeatPasswordErrorLabel().getAttribute("class");
		
		ExtendTestManager.getTest().log(LogStatus.INFO, "Validation error message: is displayed ");			

		//fieldHandle = RegistrationPage.getCancelButton();

		//fieldHandle.click();
		softAssertion.assertAll();
	}

	@Test(priority = 2, description = "Form field labels should be diplayed to corresponding field")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Description: Form field labels should be diplayed to corresponding field")
	@Story("User registration")
	public void testFieldLabelsAreDisplayed() throws Exception {

		SoftAssert softAssertion= new SoftAssert();

		query= "//*[text() = '"+ FIRST_NAME_ERROR +"']";
		enabledClass = driver.findElement(By.xpath(query)).getAttribute("class");
		softAssertion.assertEquals(enabledClass, FIELDS_ENABLED_CLASS);
		ExtendTestManager.getTest().log(LogStatus.INFO, "Validation error message: is displayed ");		
		

		fieldHandle = RegistrationPage.getLastName();		
		labelHandle = fieldHandle.findElement(By.xpath("..")).getText();
		softAssertion.assertEquals(labelHandle.contains(LAST_NAME_LABEL),true);
		ExtendTestManager.getTest().log(LogStatus.INFO, "Validation error message: is displayed ");		

		
		fieldHandle = RegistrationPage.getEmail();
		labelHandle = fieldHandle.findElement(By.xpath("..")).getText();
		softAssertion.assertEquals(labelHandle.contains(EMAIL_LABEL),true);
		ExtendTestManager.getTest().log(LogStatus.INFO, "Validation error message: is displayed ");		

		query= "//*[text() = '"+ EMAIL_ERROR +"']";
		enabledClass = driver.findElement(By.xpath(query)).getAttribute("class");
		softAssertion.assertEquals(enabledClass, FIELDS_ENABLED_CLASS);
		ExtendTestManager.getTest().log(LogStatus.INFO, "Validation error message: is displayed ");
		
		
		fieldHandle = RegistrationPage.getPassword();
		labelHandle = fieldHandle.findElement(By.xpath("..")).getText();
		softAssertion.assertEquals(labelHandle.contains(PASSWORD_LABEL),true);
		ExtendTestManager.getTest().log(LogStatus.INFO, "Validation error message: is displayed ");

		fieldHandle = RegistrationPage.getPassword2();
		labelHandle = fieldHandle.findElement(By.xpath("..")).getText();
		softAssertion.assertEquals(labelHandle.contains(REPEAT_PASSWORD_LABEL),true);
		ExtendTestManager.getTest().log(LogStatus.INFO, "User enters repeat password as: <b><i>"+REPEAT_PASSWORD+"</i></b>");

		
		softAssertion.assertAll();
	}

	@Test(priority = 3, description = "Verify user is on registration form")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Description: Verify User is on registration form")
	@Story("User registration")
	public void testPasswordRepasswordAreEqual() throws Exception {
		ExtendTestManager.getTest().setDescription("Verify user is on registration form.");

		SoftAssert softAssertion= new SoftAssert();
		
		fieldHandle = RegistrationPage.getFirstName();
		fieldHandle.sendKeys(FIRST_NAME);		
		ExtendTestManager.getTest().log(LogStatus.INFO, "User enters first name as: <b><i>"+FIRST_NAME+"</i></b>");
		
		
		fieldHandle = RegistrationPage.getLastName();
		fieldHandle.sendKeys(LAST_NAME);
		ExtendTestManager.getTest().log(LogStatus.INFO, "User enters last name as: <b><i>"+LAST_NAME +"</i></b>");
		
		
		fieldHandle = RegistrationPage.getEmail();
		fieldHandle.sendKeys(EMAIL);
		ExtendTestManager.getTest().log(LogStatus.INFO, "User enters email address as: <b><i>"+EMAIL+"</i></b>");
		
		
		fieldHandle = RegistrationPage.getPassword();
		fieldHandle.sendKeys(PASSWORD);
		ExtendTestManager.getTest().log(LogStatus.INFO, "User enters password as: <b><i>"+ PASSWORD+"</i></b>");
		

		fieldHandle = RegistrationPage.getPassword2();
		fieldHandle.sendKeys(REPEAT_PASSWORD);
		ExtendTestManager.getTest().log(LogStatus.INFO, "User enters repeat password as: <b><i>"+REPEAT_PASSWORD+"</i></b>");
		

		fieldHandle = RegistrationPage.getRegisterButton();
		
		fieldHandle.click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.xpath(greetings)));
		fieldHandle =RegistrationPage.getRegistrationGreeings() ;
		softAssertion.assertEquals(true, fieldHandle.isDisplayed());
		RegistrationPage.getCompleteRegistration().click();


		softAssertion.assertAll();
	}

	
	@Test(priority = 4, description = "Verify user is on registration form")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Description: Verify User is on registration form")
	@Story("User registration")
	public void testUserCanRegister() throws Exception {
		//HomePage hp = new HomePage();
		log.info("\n\n Object return: " + HomePage.getRegistrationButton());
		HomePage.getRegistrationButton().click();
		ExtendTestManager.getTest().setDescription("Verify user is on registration form.");
		SoftAssert softAssertion= new SoftAssert();
		fieldHandle = RegistrationPage.getFirstName();
		fieldHandle.sendKeys(FIRST_NAME);		
		ExtendTestManager.getTest().log(LogStatus.INFO, "User enters first name as: <b><i>"+FIRST_NAME+"</i></b>");
		

		fieldHandle = RegistrationPage.getLastName();
		fieldHandle.sendKeys(LAST_NAME);
		ExtendTestManager.getTest().log(LogStatus.INFO, "User enters last name as: <b><i>"+LAST_NAME +"</i></b>");
		
		
		fieldHandle = RegistrationPage.getEmail();
		fieldHandle.sendKeys(EMAIL);
		ExtendTestManager.getTest().log(LogStatus.INFO, "User enters email address as: <b><i>"+EMAIL+"</i></b>");
		
		
		fieldHandle = RegistrationPage.getPassword();
		fieldHandle.sendKeys(PASSWORD);
		ExtendTestManager.getTest().log(LogStatus.INFO, "User enters password as: <b><i>"+ PASSWORD+"</i></b>");


		fieldHandle = RegistrationPage.getPassword2();
		fieldHandle.sendKeys(REPEAT_PASSWORD);
		ExtendTestManager.getTest().log(LogStatus.INFO, "User enters repeat password as: <b><i>"+REPEAT_PASSWORD+"</i></b>");
		

		RegistrationPage.getRegisterButton().click();
		softAssertion.assertEquals(true, fieldHandle.isDisplayed());

		softAssertion.assertAll();
		RegistrationPage.getCompleteRegistration().click();
	}


	@AfterClass
	public void tearDown() {
		driver.quit();
		log.info("\n\n****************** Shutdown Browser (tearDown-SearchPropertyForRentTest) *******************");

	}
	
}
