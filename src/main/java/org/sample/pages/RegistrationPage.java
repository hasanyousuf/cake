/**
 * 
 */
package org.sample.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sample.base.TestBase;
import org.testng.Assert;

/**
 * @author hasan
 *
 */
public class RegistrationPage extends TestBase {

	@FindBy(id = "firstName")
	private WebElement firstName;

	@FindBy(id = "lastName")
	private WebElement lastName;

	@FindBy(id = "email")
	private WebElement email;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(id = "passwordConfirm")
	private WebElement password2;

	@FindBy(xpath = "//*[@id=\"signup\"]/div/form/div[1]/span[1]")
	private WebElement firstNameErrorLabel;

	@FindBy(xpath = "//*[@id=\"signup\"]/div/form/div[2]/span")
	private WebElement lastNameErrorLabel;

	@FindBy(xpath = "//*[@id=\"signup\"]/div/form/div[3]/span")
	private WebElement emailErrorLabel;

	@FindBy(xpath = "//*[@id=\"signup\"]/div/form/div[1]/span[1]")
	private WebElement passwordErrorLabel;

	@FindBy(xpath = "//*[@id=\"signup\"]/div/form/div[5]/span")
	private WebElement repeatPasswordErrorLabel;

	@FindBy(xpath = "//*[@id=\"signup\"]/div/form/div[6]/button")
	private WebElement registerButton;

	@FindBy(xpath = "//*[@id=\"signup\"]/div/form/div[6]/a")
	private WebElement cancelButton;

	@FindBy(xpath = "/html/body/div/div[2]/div/div[1]/h2")
	private WebElement registrationGreeings;

	@FindBy(xpath = "/html/body/div/div[2]/div/div[3]/a")
	private WebElement completeRegistration;
	
	public WebElement getCompleteRegistration() {
		return this.completeRegistration;
	}

	public WebElement getRegistrationGreeings() {
		return this.registrationGreeings;
	}

	public WebElement getCancelButton() {
		return this.cancelButton;
	}

	public WebElement getRegisterButton() {
		return this.registerButton;
	}

	public WebElement getRepeatPasswordErrorLabel() {
		return this.repeatPasswordErrorLabel;
	}

	public WebElement getFirstName() {
		return this.firstName;
	}

	public void setFirstName(WebElement firstName) {
		this.firstName = firstName;
	}

	public WebElement getLastName() {
		return this.lastName;
	}

	public void setLastName(WebElement lastName) {
		this.lastName = lastName;
	}

	public WebElement getEmail() {
		return this.email;
	}

	public WebElement getPassword() {
		return this.password;
	}

	public void setPassword(WebElement password) {
		this.password = password;
	}

	public WebElement getPassword2() {
		return this.password2;
	}

	public void setPassword2(WebElement password2) {
		this.password2 = password2;
	}

	/**
	 * 
	 */
	public RegistrationPage() {
		PageFactory.initElements(driver, this);
	}

}
