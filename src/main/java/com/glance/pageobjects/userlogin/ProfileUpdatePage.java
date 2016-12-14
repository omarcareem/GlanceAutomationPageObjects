package com.glance.pageobjects.userlogin;



//import java.awt.List;

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
	

	@FindBy(id="changeIdiv")
	 WebElement imagPreview;
	
	@FindBy(id="myFile")
	 WebElement btnchooseImg;
	
	@FindBy(id="butnPass")
	 WebElement btnchangepassword;
	
	@FindBy(id="new_password")
	 WebElement txtNewPassword;
	
	@FindBy(id="con_password")
	 WebElement txtConPassword;
	
	@FindBy(id="emailAddress")
	 WebElement txtEmail;
	
	@FindBy(id="role_data")
	 WebElement drpjobrole;
	
	@FindBy(xpath="//div/input[@id='submit']")
	 WebElement btnUpdate;
	
	@FindBy(xpath="//div/button")
	 WebElement btnCancel;

	//pop up msg Box
	@FindBy(xpath="//div[2]/div/div/div/div/div[3]/div")
	 WebElement lblPopupMsg1;
	
	@FindBy(xpath="//div[2]/div/div/div/div/div[3]/div")
	 WebElement lblPopupMsg2;
	
	@FindBy(xpath="//div[2]/div/div/div/div/div[3]/div")
	 WebElement lblPopupMsg3;
	
	@FindBy(xpath="//div[2]/div/div/div/div/div[3]/div")
	 WebElement lblPopupMsg4;
	
	@FindBy(xpath="//div[2]/div/div/div/div/div[3]/div")
	 WebElement lblPopupMsg5;
	
	@FindBy(xpath="//div[2]/div/div/div/div/div[3]/div")
	 WebElement lblPopupMsg6;
	
	
	
	
	@FindBy(xpath="//div/div[4]/button[@class='btn btn-success']")
	 WebElement btnPopupDone;

	@FindBy(xpath="//div/div[4]/button[@class='btn btn-warning']")
	 WebElement btnPopupOK;
	

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
    		System.out.println("not changed username");
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
	
	public boolean getpopupMsgContent1(String profileUpdateMsgContent) {

		boolean flag = false;

		String popupMessageName = lblPopupMsg1.getText();
		if (popupMessageName.contains(profileUpdateMsgContent)) {
			System.out.println("Profile update try is verified as:  " + popupMessageName);
			flag = true;
		} else {
			System.out.println(" Profile update try is not verified");
			flag = false;
		}
		return flag;

	}
	
	public boolean getpopupMsgContent2(String profileUpdateMsgContent) {

		boolean flag = false;

		String popupMessageName = lblPopupMsg2.getText();
		if (popupMessageName.contains(profileUpdateMsgContent)) {
			System.out.println("Profile update try is verified as:  " + popupMessageName);
			flag = true;
		} else {
			System.out.println(" Profile update try is not verified");
			flag = false;
		}
		return flag;

	}

	public boolean getpopupMsgContent3(String profileUpdateMsgContent) {

		boolean flag = false;

		String popupMessageName = lblPopupMsg3.getText();
		if (popupMessageName.contains(profileUpdateMsgContent)) {
			System.out.println("Profile update try is verified as:  " + popupMessageName);
			flag = true;
		} else {
			System.out.println(" Profile update try is not verified");
			flag = false;
		}
		return flag;

	}
	
	
	public boolean getpopupMsgContent4(String profileUpdateMsgContent) {

		boolean flag = false;

		String popupMessageName = lblPopupMsg4.getText();
		if (popupMessageName.contains(profileUpdateMsgContent)) {
			System.out.println("Profile update try is verified as:  " + popupMessageName);
			flag = true;
		} else {
			System.out.println(" Profile update try is not verified");
			flag = false;
		}
		return flag;

	}
	
	public boolean getpopupMsgContent5(String profileUpdateMsgContent) {

		boolean flag = false;

		String popupMessageName = lblPopupMsg5.getText();
		if (popupMessageName.contains(profileUpdateMsgContent)) {
			System.out.println("Profile update try is verified as:  " + popupMessageName);
			flag = true;
		} else {
			System.out.println(" Profile update try is not verified");
			flag = false;
		}
		return flag;

	}
	
	
	public boolean getpopupMsgContent6(String profileUpdateMsgContent) {

		boolean flag = false;

		String popupMessageName = lblPopupMsg6.getText();
		if (popupMessageName.contains(profileUpdateMsgContent)) {
			System.out.println("Profile update try is verified as:  " + popupMessageName);
			flag = true;
		} else {
			System.out.println(" Profile update try is not verified");
			flag = false;
		}
		return flag;

	}
	
	public void clickPopupDoneBtn(){
    	
    	try{
    		TestLog.log.info("Clicking Done button");
    		btnPopupDone.click();
    		TestLog.log.info("clicked Done button");
    	}
    	 catch(Exception ex){
    		 TestLog.log.info("Could not Click Done button of msg box. "+ex); 
    	 }
    	
    }
	
public void clickPopupOKBtn(){
    	
    	try{
    		TestLog.log.info("Clicking OK button");
    		btnPopupOK.click();
    		TestLog.log.info("clicked OK button");
    	}
    	 catch(Exception ex){
    		 TestLog.log.info("Could not Click OK button of msg box. "+ex); 
    	 }
    	
    }


public boolean getUserNameValue(String valUserName) {

	boolean flag = false;

	String valueOfUserName = txtUserName.getAttribute("value");
	if (valueOfUserName.contains(valUserName)) {
		System.out.println("Profile update as:  " + valueOfUserName);
		flag = true;
	} else {
		System.out.println(" Profile update try is not verified");
		flag = false;
	}
	return flag;

}

    
public boolean getEmailIDValue(String valEmailID) {

	boolean flag = false;

	String valueOfEmailID = txtEmail.getAttribute("value");
	if (valueOfEmailID.contains(valEmailID)) {
		System.out.println("Profile update as:  " + valueOfEmailID);
		flag = true;
	} else {
		System.out.println(" Profile update try is not verified");
		flag = false;
	}
	return flag;

}

public boolean getFirstNameValue(String valFirstName) {

	boolean flag = false;

	String valueOfFirstName = txtFirstName.getAttribute("value");
	if (valueOfFirstName.contains(valFirstName)) {
		System.out.println("Profile update as:  " + valueOfFirstName);
		flag = true;
	} else {
		System.out.println(" Profile update try is not verified");
		flag = false;
	}
	return flag;

}

public boolean getlastNameValue(String valLastName) {

	boolean flag = false;

	String valueOfLastName = txtLastName.getAttribute("value");
	if (valueOfLastName.contains(valLastName)) {
		System.out.println("Profile update as:  " + valueOfLastName);
		flag = true;
	} else {
		System.out.println(" Profile update try is not verified");
		flag = false;
	}
	return flag;

}

public boolean getJobRoleValue(String valJobRole) {

	boolean flag = false;

	String valueOfJobRole = drpjobrole.getAttribute("value");
	if (valueOfJobRole.contains(valJobRole)) {
		System.out.println("Profile update as:  " + valueOfJobRole);
		flag = true;
	} else {
		System.out.println(" Profile update try is not verified");
		flag = false;
	}
	return flag;

}

public boolean getImagePreview(String valJobRole) {

	boolean flag = false;

	String valueOfimage = imagPreview.getAttribute("value");
	if (valueOfimage.contains(valJobRole)) {
		System.out.println("Profile update as:  " + valueOfimage);
		flag = true;
	} else {
		System.out.println(" Profile update try is not verified");
		flag = false;
	}
	return flag;

}
}

