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
	public boolean getProfileUpdateTitle(String profileUpdateTitle) {

		boolean flag = false;

		String popupMessageName = lblProfileUpdateTitle.getText();
		if (popupMessageName.contains(profileUpdateTitle)) {
			System.out.println("Navigation verified to:  " + popupMessageName);
			flag = true;
		} else {
			System.out.println("Navigation to profile update page  is not verified");
			flag = false;
		}
		return flag;

	}
	//Form Attributes
	public void changeUsername(String userName){
		try{
    		TestLog.log.info("Changing user Name");
    		txtUserName.clear();
    		txtUserName.sendKeys(userName);
    		TestLog.log.info("Changed user Name to" + userName);
    	}
    	 catch(Exception ex){
    		 TestLog.log.info("Could not enter user name. "+ex); 
    	 }
    	
    }
	
	public void changeFirstName(String firstName){
		try{
    		TestLog.log.info(" Changing user first name");
    		txtFirstName.clear();
    		txtFirstName.sendKeys(firstName);
    		TestLog.log.info("Changed user first name to"+ firstName);
    	}
    	 catch(Exception ex){
    		 TestLog.log.info("Could not enter first name. "+ex); 
    	 }
    	
    }
	
	public void changeLastname(String lastName){
		try{
    		TestLog.log.info("Changing user last Name");
    		txtLastName.clear();
    		txtLastName.sendKeys(lastName);
    		TestLog.log.info("Changed user last Name to "+lastName);
    	}
    	 catch(Exception ex){
    		 TestLog.log.info("Could not enter last name "+ex); 
    	 }
    	
    }
	
	public void viewprofileImg(boolean image){
		try{
    		TestLog.log.info("Checking user profile image");
    		viewImg.equals(image);
    		TestLog.log.info("Checked user profile image" + image);
    	}
    	 catch(Exception ex){
    		 TestLog.log.info("Could not check image "+ex); 
    	 }
		
    }
	
	public void clickchangeImg(){
		try{
    		TestLog.log.info("Clicking change image link");
    		linkChangeImg.click();
    		TestLog.log.info("Clicked change image link");
    	}
    	 catch(Exception ex){
    		 TestLog.log.info("Could not Click on the change image link. "+ex); 
    	 }
		
    }
	
	public void clickChooseImg(){
		try{
    		TestLog.log.info("Clicking choose image button");
    		btnchooseImg.click();
    		TestLog.log.info("Clicked choose image button");
    	}
    	 catch(Exception ex){
    		 TestLog.log.info("Could not Click on the choose image link "+ex); 
    	 }
	
    }
	
	public void changeEmail(String emailAdd){
		try{
    		TestLog.log.info("Changing user last Name");
    		txtEmail.clear();
    		txtEmail.sendKeys(emailAdd);
    		TestLog.log.info("Changed user last Name to "+emailAdd);
    	}
    	 catch(Exception ex){
    		 TestLog.log.info("Could not enter email address "+ex); 
    	 }
    	
    }
	
	
	public void clickChangePssword(){
		try{
    		TestLog.log.info("Clicking change password button");
    		btnchangepassword.click();
    		TestLog.log.info("Clicked change password button");
    	}
    	 catch(Exception ex){
    		 TestLog.log.info("Could not click on change password button. "+ex); 
    	 }
		
    }
	
	public void changeNewPswd(String newPassword){
		try{
    		TestLog.log.info("Entering user new password");
    		txtNewPassword.sendKeys(newPassword);
    		TestLog.log.info("Entered the user new password as" + newPassword);
    	}
    	 catch(Exception ex){
    		 TestLog.log.info("Could not enter password "+ex); 
    	 }
		
    }
	
	public void changeConPassword(String conPassword){
		try{
    		TestLog.log.info("Entering user confirm password");
    		txtConPassword.sendKeys(conPassword);
    		TestLog.log.info("Entered the user confirm password"+ conPassword);
    	}
    	 catch(Exception ex){
    		 TestLog.log.info("Could not enter confirm password "+ex); 
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
    		 TestLog.log.info("Could not select from drop down "+ex); 
    	 }
		
    }
	
	public void clickUpdateBtn(){
    	
    	try{
    		TestLog.log.info("Clicking Update button");
    		btnUpdate.click();
    		TestLog.log.info("clicked Update button");
    	}
    	 catch(Exception ex){
    		 TestLog.log.info("Could not Click oon submit button "+ex); 
    	 }
    	
    }


	public void clickCancelBtn(){
    	
    	try{
    		TestLog.log.info("Clicking cancel button");
    		btnCancel.click();
    		TestLog.log.info("clicked cancel button");
    	}
    	 catch(Exception ex){
    		 TestLog.log.info("Could not Click on the cancel button "+ex); 
    	 }
    	
    }
	
	//Pop up Messages for Success and Unsuccess
	
	public boolean getpopupMsgContent(String profileUpdateMsgContent) {

		boolean flag = false;

		String popupMessageName = lblPopupMsg.getText();
		if (popupMessageName.contains(profileUpdateMsgContent)) {
			System.out.println("Profile update try is verified as:  " + popupMessageName);
			flag = true;
		} else {
			System.out.println(" Profile update try is not verified");
			flag = false;
		}
		return flag;

	}

	
	public void clickPopupOkayBtn(){
    	
    	try{
    		TestLog.log.info("Clicking Okay button");
    		btnPopupOkay.click();
    		TestLog.log.info("clicked Okay button");
    	}
    	 catch(Exception ex){
    		 TestLog.log.info("Could not Click okay button of msg box. "+ex); 
    	 }
    	
    }

	public void clickPopupCloseBtn(){
	
		try{
		TestLog.log.info("Clicking close button");
		btnPopupCancel.click();
		TestLog.log.info("clicked close button");
		}
	 catch(Exception ex){
		 TestLog.log.info("Could not Click close button of msg box. "+ex); 
	 }
	
}
	/*public void getUserNameValue(){
		
		String valUserName = Element.getAttribute(txtUserName);
	
}
*/
    
}

