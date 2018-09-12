package org.sample.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
//import org.sample.util.Retry;
import org.sample.util.Testutil;
import org.sample.util.WebEventListener;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
//	protected static WebDriver driver;
	private static Properties prop;
	private static EventFiringWebDriver e_driver;
	private static WebEventListener eventListener;
	private static final String BROWSER_CHROME = "chrome";
	private static final String BROWSER_FIREFOX = "firefox";
	
	
	
	private static final String CONFIG_FILE_PATH = System.getProperty("user.dir") + "/src/main/java/org/sample/config/config.properties";

	public WebDriver getDriver() {
		return this.driver;
	}
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(CONFIG_FILE_PATH);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Initializing the Page Object
	protected void initialization(String url, String browser) {

		//String browserName = prop.getProperty("browser");
		String browserName = browser;
		if (browserName.equals(BROWSER_CHROME)) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equals(BROWSER_FIREFOX)) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Testutil.PAGE_LOAD_TIME, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Testutil.IMPLICIT_WAIT, TimeUnit.SECONDS);


		driver.get(url);

	}

	protected String validatePageTitle() {
		return driver.getTitle();
	}

	protected String getCurrentURL() {
		return driver.getCurrentUrl();
	}
	public void onStart(ITestContext iTestContext) {
		// TODO Auto-generated method stub
		
	}
	public boolean retry(ITestResult iTestResult) {
		return true;
	}
	public void onTestStart(ITestResult iTestResult) {
		// TODO Auto-generated method stub
		
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		// TODO Auto-generated method stub
		
	}
	public void onTestSkipped(ITestResult iTestResult) {
		// TODO Auto-generated method stub
		
	}
	public void onTestFailure(ITestResult iTestResult) {
		// TODO Auto-generated method stub
		
	}
	public void onFinish(ITestContext iTestContext) {
		// TODO Auto-generated method stub
		
	}
	public void onTestSuccess(ITestResult iTestResult) {
		// TODO Auto-generated method stub
		
	}
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		// TODO Auto-generated method stub
    }
	

}
