package com.glance.pageobjects.userlogin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.glance.pageobjects.common.BasePage;
import com.glance.pageobjects.logs.TestLog;

public class CreateAccountPage extends BasePage {

	public CreateAccountPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	//Title
	@FindBy(xpath="//div/section/form[@id='registerform']/h1")
	 WebElement lblCreateAccount;
	
	//Create account Form
	@FindBy(id="user_name")
	 WebElement txtUserName;
	
	@FindBy(id="emailAddress")
	WebElement txtemailAdd;
	
	@FindBy(id="password")
	 WebElement txtPassword;
    
	@FindBy(id="con_password")
	 WebElement txtConPassword;
	
	@FindBy(xpath="//div[5]/input[2]")
	 WebElement btnSubmit;
	
	@FindBy(xpath="//div[7]/p/a")
	 WebElement linkLogin;
	
	
	//popup success message
	
	@FindBy(xpath="//div[3]/div")
	 WebElement lblPopupMsg;
	
	@FindBy(xpath="//div[4]/button[1]")
	 WebElement popupOkaybtn;
	
	@FindBy(xpath="//div[3]/div[2]/div/div/div/div/div[4]/button[2]]")
	 WebElement popupClosebtn;
	
	//Title
	
	
	public boolean getCreateAccTitle(String lblCreateAccountTitle) {

		boolean flag = false;

		String popupMessageName = lblCreateAccount.getText();
		if (popupMessageName.contains(lblCreateAccountTitle)) {
			System.out.println("Navigation verified to:  " + popupMessageName);
			flag = true;
		} else {
			System.out.println("Navigation to create Account page  is not verified");
			flag = false;
		}
		return flag;

	}

	//Form Attributes
	public void createUsername(String userName){
	
	try{
		TestLog.log.info("Creating user Name");
		txtUserName.clear();
		txtUserName.sendKeys(userName);
		TestLog.log.info("Created user Name"+ userName);
	}
	 catch(Exception ex){
		 TestLog.log.info("Could not enter user name "+ex); 
	 
	 }
}
	

	public void addemailAdd(String emailAdd){
	
	try{
		TestLog.log.info("Entering user Name");
		txtemailAdd.clear();
		txtemailAdd.sendKeys(emailAdd);
		TestLog.log.info("Entered user Name");
	}
	 catch(Exception ex){
		 TestLog.log.info("Could not enter email address "+ex); 
	 
	 }
}
	

	public void createpassword(String password){
	
		try{
			TestLog.log.info("Creating user password");
			txtPassword.clear();
			txtPassword.sendKeys(password);
			TestLog.log.info("Created user password" + password);
		}
		 catch(Exception ex){
			 TestLog.log.info("Could not enter password. "+ex); 
		 }
	}

	public void confirmPassword(String conPassword){
	
	try{
		TestLog.log.info("Re entering user password");
		txtConPassword.clear();
		txtConPassword.sendKeys(conPassword);
		TestLog.log.info("Re enterd user password" + conPassword);
	}
	 catch(Exception ex){
		 TestLog.log.info("Could not enter confirm password. "+ex); 
	 }
}


	public void clickSubmitBtn(){
	
	try{
		TestLog.log.info("Clicking submit button");
		btnSubmit.click();
		TestLog.log.info("Clicked submit button");
	}
	 catch(Exception ex){
		 TestLog.log.info("Could not Click on submit button. "+ex); 
	 }
}
	
	//For Success  creation of account
	public boolean getPopupMsg(String lblCreateAccPopupmsg) {

		boolean flag = false;

		String popupMessageName = lblPopupMsg.getText();
		if (popupMessageName.contains(lblCreateAccPopupmsg)) {
			System.out.println("Invalid  try is verified:  " + popupMessageName);
			flag = true;
		} else {
			System.out.println("Ivalid try is not verified");
			flag = false;
		}
		return flag;

	}

	public void clickpopupOkay(){
		
		try{
			TestLog.log.info("Clicking okay button");
			popupClosebtn.click();
			TestLog.log.info("Clicked okay button");
		}
		 catch(Exception ex){
			 TestLog.log.info("Could not Click okay button of msg box. "+ex); 
		 }
	}
	
	public void clickpopupClose(){
		
		try{
			TestLog.log.info("Clicking cancel button");
			popupOkaybtn.click();
			TestLog.log.info("Clicked cancel button");
		}
		 catch(Exception ex){
			 TestLog.log.info("Could not Click cancel button of msg box. "+ex); 
		 }
	}
	
	//link to another page
	public void clickLoginLink(){
	
	try{
		TestLog.log.info("Navigating to login page");
		linkLogin.click();
		TestLog.log.info("Navigated to login page");
	}
	 catch(Exception ex){
		 TestLog.log.info("Could not Click on login page link. "+ex); 
	 }
}
	
	
	//if passwords doesn't match
	public void switchtoMsgBoxCreateAccount(){
 		Alert simpleAlert = driver.switchTo().alert();
 	    String alertText = simpleAlert.getText();
 	    System.out.println("Alert text is " + alertText);
 	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 	    simpleAlert.accept();
 	   
 	}
 
	
	
}
