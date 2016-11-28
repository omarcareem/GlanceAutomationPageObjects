package com.glance.pageobjects.userlogin;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.glance.pageobjects.common.BasePage;
import com.glance.pageobjects.logs.TestLog;

public class ProfileUpdatePage extends BasePage {

	public ProfileUpdatePage(WebDriver driver) {
		super(driver);
		 PageFactory.initElements(driver, this);
	}
	
	
	//Title
	@FindBy(xpath="//div[1]/h2")
	 WebElement lblProfileUpdateTitle;
	
	//Form Attributes
	@FindBy(id="user_name")
	 WebElement txtUserName;
	
	@FindBy(id="first-name")
	 WebElement txtFirstName;
	
	@FindBy(id="last_name")
	 WebElement txtLastName;
	
	@FindBy(xpath="//div/div/div[5]/div/img[@class='img-circle profile_img']")
	 WebElement viewImg;
	
	@FindBy(id="linkId")
	 WebElement linkChangeImg;
	
	@FindBy(id="myFile")
	 WebElement btnchooseImg;
	
	@FindBy(id="butnPass")
	 WebElement btnchangepassword;
	
	@FindBy(id="new_password")
	 WebElement txtNewPassword;
	
	@FindBy(id="con_password")
	 WebElement txtConPassword;
	
	@FindBy(id="email")
	 WebElement txtEmail;
	
	@FindBy(id="role_data")
	 WebElement drpjobrole;
	
	@FindBy(xpath="//div/input[@id='submit']")
	 WebElement btnUpdate;
	
	@FindBy(xpath="//div/button")
	 WebElement btnCancel;

	//pop up msg Box
	@FindBy(xpath="//div[3]/div[@class='content']")
	 WebElement lblPopupMsg;
	
	@FindBy(xpath="//div[4]/button[1]")
	 WebElement btnPopupOkay;
	
	@FindBy(xpath="//div[4]/button[2]")
	 WebElement btnPopupCancel;
	
	

	//Title
	public String getProfileUpdateTitle() {

			return lblProfileUpdateTitle.getText();

		}
	
	
	//method to verify the profile update element 
			public boolean FindUserDetailsElement(String expectedMessage){
				boolean flag = false;
				String actualMessage=lblProfileUpdateTitle.getText();
				if (actualMessage.contains(expectedMessage)) {
					flag = true;
					System.out.println("User profile update Navigation Success");
					}
				else {
					System.out.println("User profile update Navigation not Success");
					flag = false;
					}
				
				return flag;
				
			}
	
	//Form Attributes
	public void changeUsername(String UserName){
		try{
    		TestLog.log.info("Changing user Name");
    		txtUserName.clear();
    		txtUserName.sendKeys("UserName");
    		TestLog.log.info("Changed user Name to" + UserName);
    	}
    	 catch(Exception ex){
 	 
    	 }
    	
    }
	
	public void changeFirstName(String FirstName){
		try{
    		TestLog.log.info(" Changing user first name");
    		txtFirstName.clear();
    		txtFirstName.sendKeys("FirstName");
    		TestLog.log.info("Changed user first name to"+ FirstName);
    	}
    	 catch(Exception ex){
 	 
    	 }
    	
    }
	
	public void changeLastname(String LastName){
		try{
    		TestLog.log.info("Changing user last Name");
    		txtLastName.clear();
    		txtLastName.sendKeys("LastName");
    		TestLog.log.info("Changed user last Name to "+LastName);
    	}
    	 catch(Exception ex){
 	 
    	 }
    	
    }
	
	public void viewprofileImg(boolean image){
		try{
    		TestLog.log.info("Checking user profile image");
    		viewImg.equals("image");
    		TestLog.log.info("Checked user profile image" + image);
    	}
    	 catch(Exception ex){
 	 
    	 }
		
    }
	
	public void clickchangeImg(){
		try{
    		TestLog.log.info("Clicking change image link");
    		linkChangeImg.click();
    		TestLog.log.info("Clicked change image link");
    	}
    	 catch(Exception ex){
 	 
    	 }
		
    }
	
	public void clickChooseImg(){
		try{
    		TestLog.log.info("Clicking choose image button");
    		btnchooseImg.click();
    		TestLog.log.info("Clicked choose image button");
    	}
    	 catch(Exception ex){
 	 
    	 }
	
    }
	
	public void changeEmail(String EmailAdd){
		try{
    		TestLog.log.info("Changing user last Name");
    		txtEmail.clear();
    		txtEmail.sendKeys("EmailAdd");
    		TestLog.log.info("Changed user last Name to "+EmailAdd);
    	}
    	 catch(Exception ex){
 	 
    	 }
    	
    }
	
	
	public void clickChangePssword(){
		try{
    		TestLog.log.info("Clicking change password button");
    		btnchangepassword.click();
    		TestLog.log.info("Clicked change password button");
    	}
    	 catch(Exception ex){
 	 
    	 }
		
    }
	
	public void changeNewPswd(String NewPassword){
		try{
    		TestLog.log.info("Entering user new password");
    		txtNewPassword.clear();
    		txtNewPassword.sendKeys("NewPassword");
    		TestLog.log.info("Entered the user new password as" + NewPassword);
    	}
    	 catch(Exception ex){
 	 
    	 }
		
    }
	
	public void changeConPassword(String ConPassword){
		try{
    		TestLog.log.info("Entering user confirm password");
    		txtConPassword.clear();
    		txtConPassword.sendKeys("ConPassword");
    		TestLog.log.info("Entered the user confirm password"+ ConPassword);
    	}
    	 catch(Exception ex){
 	 
    	 }
		
    }
	
	public void selectJobRole(String jobRole){
		try{
    		TestLog.log.info("Selecting");
    		Select dropdown= new Select(drpjobrole);
			dropdown.selectByVisibleText(jobRole);
    		TestLog.log.info("Selected "+ jobRole );
    	}
    	 catch(Exception ex){
 	 
    	 }
		
    }
	
	public void clickUpdateBtn(){
    	
    	try{
    		TestLog.log.info("Clicking Update button");
    		btnUpdate.click();
    		TestLog.log.info("clicked Update button");
    	}
    	 catch(Exception ex){
    	 
    	 }
    	
    }


	public void clickCancelBtn(){
    	
    	try{
    		TestLog.log.info("Clicking cancel button");
    		btnCancel.click();
    		TestLog.log.info("clicked cancel button");
    	}
    	 catch(Exception ex){
    	 
    	 }
    	
    }
	
	//Pop up Messages for Success and Unsuccess
	public String getpopupMsgContent() {

		return lblPopupMsg.getText();

	}

	
	public void clickPopupOkayBtn(){
    	
    	try{
    		TestLog.log.info("Clicking Okay button");
    		btnPopupOkay.click();
    		TestLog.log.info("clicked Okay button");
    	}
    	 catch(Exception ex){
    	 
    	 }
    	
    }

	public void clickPopupCancelBtn(){
	
		try{
		TestLog.log.info("Clicking cancel button");
		btnPopupCancel.click();
		TestLog.log.info("clicked cancel button");
		}
	 catch(Exception ex){
	 
	 }
	
}
    
}

