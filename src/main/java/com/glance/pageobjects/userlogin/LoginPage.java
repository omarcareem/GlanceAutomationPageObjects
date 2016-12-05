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
	@FindBy(xpath = "//div[3]/div")
	WebElement lblLoginError;

	@FindBy(xpath = "//div[4]/button[1]")
	WebElement btnMsgBoxOkay;

	@FindBy(xpath = "//div[4]/button[2]")
	WebElement btnMsgBoxCancel;

	// Links to other Pages
	@FindBy(xpath = "//div[5]/p/a[@class='to_register']")
	WebElement linkCreateAccount;

	@FindBy(xpath = "//div[3]/a")
	WebElement linkLostPasssword;

	
	
	// Get the title of Login Page
	public boolean getLoginTitle(String lblLoginTitle) {

		boolean flag = false;

		String popupMessageName = lblLoginForm.getText();
		if (popupMessageName.contains(lblLoginTitle)) {
			System.out.println("Navigated to  " + popupMessageName);
			flag = true;
		} else {
			System.out.println("Not navigated to LoginPage");
			flag = false;
		}
		return flag;

	}



	//Form Attributes
	public void enterUsername(String userName) {

		try {
			
			TestLog.log.info("Entering user Name");
			txtUserName.clear();
			txtUserName.sendKeys(userName);
			TestLog.log.info("Entered user Name as" + userName);
		} catch (Exception ex) {
			TestLog.log.info("Could not enter user name "+ex); 

		}
	}

	public void enterPassword(String password) {

		try {
			TestLog.log.info("Entering Password");
			txtPassword.clear();
			txtPassword.sendKeys(password);
			TestLog.log.info("Entered the password as" + password);
		} catch (Exception ex) {
			TestLog.log.info("Could not enter password. "+ex); 

		}
	}

	public void clickLoginBtn() {

		try {
			TestLog.log.info("Clicking login button");
			btnlogin.click();
			TestLog.log.info("clicked login button");
		} catch (Exception ex) {
			
			TestLog.log.info("Could not click login. "+ex); 

		}

	}

	//Link to other pages
	public void navigateCreateAccountPage() {

		try {
			TestLog.log.info("Navigating to Create Account Page");
			linkCreateAccount.click();
			TestLog.log.info("Navigated to Create Account Page");
		} catch (Exception ex) {
			
			TestLog.log.info("Could not click create account link "+ex); 

		}
	}

	public void navigateLostPasswordPage() {

		try {
			TestLog.log.info("Navigating to Create Account Page");
			linkLostPasssword.click();
			TestLog.log.info("Navigated to Create Account Page");
		} catch (Exception ex) {
			
			TestLog.log.info("Could not Click lost password link. "+ex); 

		}
	}

	//pop up msgBox
	public boolean verifyLoginError(String lblLoginErrormsg) {

				boolean flag = false;

				String popupMessageName = lblLoginError.getText();
				if (popupMessageName.contains(lblLoginErrormsg)) {
					System.out.println("Invalid login try is verified:  " + popupMessageName);
					flag = true;
				} else {
					System.out.println("Ivalid Login error is not verified");
					flag = false;
				}
				return flag;

			}

	
	public void clickErrorOK() {

		try {
			TestLog.log.info("Clicking okay button");
			btnMsgBoxOkay.click();
			TestLog.log.info("clicked okay button");
		} catch (Exception ex) {
			
			TestLog.log.info("Could not Click okay button of msg box. "+ex); 
		}

	}
	
	public void clickErrorCancel() {

		try {
			TestLog.log.info("Clicking cancel button");
			btnMsgBoxCancel.click();
			TestLog.log.info("clicked cancel button");
		} catch (Exception ex) {
			TestLog.log.info("Could not Click cancel button of msg box. "+ex); 

		}

	}

	

}
