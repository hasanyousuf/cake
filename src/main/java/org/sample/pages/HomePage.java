/**
 * 
 */
package org.sample.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sample.base.TestBase;
import org.testng.Assert;

import io.qameta.allure.Step;


/**
 * @author hasan
 *
 */
public class HomePage extends TestBase{
	private final String REGISTRATION_URL ="https://cakesolutions.github.io/cake-qa-test/#/register";
	
	@FindBy(xpath = "/html/body/div/div[1]/acme-navbar/nav/div/div[1]/a/img")
	private WebElement siteLogo;

	@FindBy(xpath = "//*[@id=\"header-panel\"]/div[1]/p/img")
	private WebElement cakeSolutionlogo;
	
	@FindBy(xpath = "/html/body/div/div[2]/div[2]/div/a")
	private WebElement registerationButton;

	@FindBy(xpath = "//ul//a/parent::*")
	private WebElement links;
	//private List <WebElement> links = new ArrayList<WebElement>();
	
	public WebElement getLinks() {
		return this.links;
	}
	protected WebElement getCakeSolutionLogo() {
		return this.cakeSolutionlogo;
	}
	protected void cakeLogoSolutionDisplayed(){
		Assert.assertTrue(this.getCakeSolutionLogo().isDisplayed(),"Cake solution logo is displayed");
	}
	public WebElement getRegistrationButton() {
		return this.registerationButton;
	}
	public void goToRegistration() {
		this.getRegistrationButton().click();
	}
	protected void verifyRegistrationUrl() {
		Assert.assertEquals(this.getCurrentUrl(),REGISTRATION_URL,"Wrong registration URL");
	}
	public WebElement getSiteLogo() {
		return this.siteLogo;
	}
	
	public String getCurrentUrl() {
		return this.getCurrentUrl();
	}

	/**
	 * 
	 */
	public String getTitle() {
		return driver.getTitle();
	}
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	

}
