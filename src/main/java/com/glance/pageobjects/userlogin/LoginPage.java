package com.glance.pageobjects.userlogin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.glance.pageobjects.common.BasePage;
import com.glance.pageobjects.logs.TestLog;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// Title
	@FindBy(xpath = "//div/section/form/h1")
	WebElement lblLoginForm;

	// LoginForm attributes
	@FindBy(id = "login_id")
	WebElement txtUserName;

	@FindBy(id = "pwd")
	WebElement txtPassword;

	@FindBy(id = "valEncrpt")
	WebElement btnlogin;

	// MessageBox
	@FindBy(xpath = "//div/span[@id=jconfirm-box18893']")
	WebElement lblLoginError;

	@FindBy(xpath = "//div[4]/button[1]")
	WebElement btnMsgBoxOkay;

	@FindBy(xpath = "//div[4]/button[2]")
	WebElement btnMsgBoxCancel;

	// Links to other Pages
	@FindBy(xpath = "//div/p/a[@class='to_register']")
	WebElement linkCreateAccount;

	@FindBy(xpath = "//div[3]/a")
	WebElement linkLostPasssword;

	
	
	// Get the title of Login Page
	public String getLoginTitle() {

		return lblLoginForm.getText();

	}
	
	// return heading.getText().toString().contains("Apply to join our network as a developer");



	//Form Attributes
	public void enterUsername(String UserName) {

		try {
			TestLog.log.info("Entering user Name");
			txtUserName.sendKeys(UserName);
			TestLog.log.info("Entered user Name as" + UserName);
		} catch (Exception ex) {

		}
	}

	public void enterPassword(String Password) {

		try {
			TestLog.log.info("Entering Password");
			txtPassword.sendKeys(Password);
			TestLog.log.info("Entered the password as" + Password);
		} catch (Exception ex) {

		}
	}

	public void clickLoginBtn() {

		try {
			TestLog.log.info("Clicking login button");
			btnlogin.click();
			TestLog.log.info("clicked login button");
		} catch (Exception ex) {

		}

	}

	//Link to other pages
	public void navigateCreateAccountPage() {

		try {
			TestLog.log.info("Navigating to Create Account Page");
			linkCreateAccount.click();
			TestLog.log.info("Navigated to Create Account Page");
		} catch (Exception ex) {

		}
	}

	public void navigateLostPasswordPage() {

		try {
			TestLog.log.info("Navigating to Create Account Page");
			linkCreateAccount.click();
			TestLog.log.info("Navigated to Create Account Page");
		} catch (Exception ex) {

		}
	}

	//pop up msgBox
	public String getLoginError() {

		return lblLoginError.getText();

	}
	
	public void clickErrorOK() {

		try {
			TestLog.log.info("Clicking okay button");
			btnMsgBoxOkay.click();
			TestLog.log.info("clicked okay button");
		} catch (Exception ex) {

		}

	}
	
	public void clickErrorCancel() {

		try {
			TestLog.log.info("Clicking cancel button");
			btnMsgBoxCancel.click();
			TestLog.log.info("clicked cancel button");
		} catch (Exception ex) {

		}

	}

	

}
