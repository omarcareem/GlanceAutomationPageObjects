package com.glance.pageobjects.userlogin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.glance.pageobjects.common.BasePage;
import com.glance.pageobjects.logs.TestLog;

public class LostPasswordPage extends BasePage {

	public LostPasswordPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}


	//Title
	@FindBy(xpath="	//div[1]/h1")
	 WebElement lblLostPasswordTitle;
	
	//Form Attributes
	@FindBy(id="user_name")
	 WebElement txtUserName;
	
	@FindBy(id="email_id")
	 WebElement txtEmailAdd;
	
	@FindBy(id="submit")
	 WebElement submitBtn;
	
	@FindBy(id="backButton")
	 WebElement backBtn;
	
	//Popup msg Box
	@FindBy(xpath="	//div/div[3]/div")
	 WebElement lblLostPasswordmsg1;
	
	@FindBy(xpath="	//div/div[3]/div")
	 WebElement lblLostPasswordmsg2;
	
	@FindBy(xpath="	//div[4]/button[1]")
	 WebElement btnLostPasswordOkay;
	
	@FindBy(xpath="	//div[4]/button[1]")
	 WebElement btnLostPasswordDone;
	
	
	
	
	
	//Title
	public boolean getLostPasswordTitle(String lblLostpasswordtTitle) {

		boolean flag = false;

		String popupMessageName = lblLostPasswordTitle.getText();
		if (popupMessageName.contains(lblLostpasswordtTitle)) {
			System.out.println("Navigated to:  " + popupMessageName);
			flag = true;
		} else {
			System.out.println(" navigation is not verified");
			flag = false;
		}
		return flag;

	}
	
	//Form Attributes
	public void enterUserName(String userName){
		try{
    		TestLog.log.info("Entering user Name");
    		txtUserName.clear();
    		txtUserName.sendKeys(userName);
    		TestLog.log.info("Entered User Name" );
    	}
    	 catch(Exception ex){
    		 TestLog.log.info("Could not enter user name "+ex); 
    	 }
    	
    }
	public void enterEmailAdd(String emailAdd){
		try{
    		TestLog.log.info("Entering Email Address");
    		txtEmailAdd.clear();
    		txtEmailAdd.sendKeys(emailAdd);
    		TestLog.log.info("Entered Email Address");
    	}
    	 catch(Exception ex){
    		 TestLog.log.info("Could not enter email address "+ex); 
    	 }
    	
    }
	
	public void clickSubmitBtn(){
    	
    	try{
    		TestLog.log.info("Clicking submit button");
    		submitBtn.click();
    		TestLog.log.info("clicked submit button");
    	}
    	 catch(Exception ex){
    		 TestLog.log.info("Could not Click click on submit botton "+ex); 
    	 }
    	
    }


	public void clickBackBtn(){
	
	try{
		TestLog.log.info("Clicking back button");
		backBtn.click();
		TestLog.log.info("clicked back button");
	}
	 catch(Exception ex){
		 TestLog.log.info("Could not Click on the back button "+ex); 
	 }
	
}

	//For Unsuccess submission 
	public boolean getLostPasswordMsgContent(String lblLostpasswordtmsg) {

		boolean flag = false;

		String popupMessageName = lblLostPasswordmsg1.getText();
		if (popupMessageName.contains(lblLostpasswordtmsg)) {
			System.out.println("Invalid lost password request error try is verified:  " + popupMessageName);
			flag = true;
		} else {
			System.out.println("Ivalid lost password request error is not verified");
			flag = false;
		}
		return flag;

	}
	
	public boolean getLostPasswordMsgContent1(String lblLostpasswordtmsg) {

		boolean flag = false;

		String popupMessageName = lblLostPasswordmsg2.getText();
		if (popupMessageName.contains(lblLostpasswordtmsg)) {
			System.out.println("Invalid lost password request error try is verified:  " + popupMessageName);
			flag = true;
		} else {
			System.out.println("Ivalid lost password request error is not verified");
			flag = false;
		}
		return flag;

	}

	public void clickPopupOkay(){
		
		try{
			TestLog.log.info("Clicking okay button");
			btnLostPasswordOkay.click();
			TestLog.log.info("clicked okay button");
		}
		 catch(Exception ex){
			 TestLog.log.info("Could not Click okay button of msg box. "+ex); 
		 }
		
	}
	
public void clickPopupDone(){
		
		try{
			TestLog.log.info("Clicking Done button");
			btnLostPasswordDone.click();
			TestLog.log.info("clicked Done button");
		}
		 catch(Exception ex){
			 TestLog.log.info("Could not Click Done button of msg box. "+ex); 
		 }
		
	}
	
	
}
