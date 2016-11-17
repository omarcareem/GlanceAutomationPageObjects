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
	@FindBy(xpath="//div/section/form/h1")
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
	
	@FindBy(xpath="//div[4]/button[2]")
	 WebElement popupClosebtn;
	
	//Title
	public String getCreateAccTitle() {

		return lblCreateAccount.getText();

	}

	//Form Attributes
	public void createUsername(String UserName){
	
	try{
		TestLog.log.info("Creating user Name");
		txtUserName.sendKeys("UserName");
		TestLog.log.info("Created user Name"+ UserName);
	}
	 catch(Exception ex){
	 
	 }
}
	

	public void addemailAdd(String EmailAdd){
	
	try{
		TestLog.log.info("Entering user Name");
		txtemailAdd.sendKeys("EmailAdd");
		TestLog.log.info("Entered user Name");
	}
	 catch(Exception ex){
	 
	 }
}
	

	public void createpassword(String Password){
	
		try{
			TestLog.log.info("Creating user password");
			txtPassword.sendKeys("Password");
			TestLog.log.info("Created user password" + Password);
		}
		 catch(Exception ex){
		 
		 }
	}

	public void confirmPassword(String ConPassword){
	
	try{
		TestLog.log.info("Re entering user password");
		txtConPassword.sendKeys("ConPassword");
		TestLog.log.info("Re enterd user password" + ConPassword);
	}
	 catch(Exception ex){
	 
	 }
}


	public void clickSubmitBtn(){
	
	try{
		TestLog.log.info("Clicking submit button");
		btnSubmit.click();
		TestLog.log.info("Clicked submit button");
	}
	 catch(Exception ex){
	 
	 }
}
	
	//For Success  creation of account
	public String getPopupMsg() {

		return lblPopupMsg.getText();

	}
	

	public void clickpopupOkay(){
		
		try{
			TestLog.log.info("Clicking submit button");
			popupClosebtn.click();
			TestLog.log.info("Clicked submit button");
		}
		 catch(Exception ex){
		 
		 }
	}
	
	public void clickpopupClose(){
		
		try{
			TestLog.log.info("Clicking submit button");
			popupClosebtn.click();
			TestLog.log.info("Clicked submit button");
		}
		 catch(Exception ex){
		 
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