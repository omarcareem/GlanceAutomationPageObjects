package com.glance.pageobjects.usermanagement;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import com.glance.pageobjects.common.BasePage;
import com.glance.pageobjects.logs.TestLog;

public class EditUser extends BasePage {

	public EditUser(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy(xpath=("//div[@class='x_title']/h2")) //page label
	WebElement Pagelbl;
	
	@FindBy(id="user_name") //Edit user name
	WebElement txtUserName;
	
	@FindBy(id="first-name")
	WebElement txtFirstName;
	
	@FindBy(id="last_name")
	WebElement txtLastName;
	
	@FindBy(id="linkId")
	WebElement lnkUserImage;  //user image
	
	@FindBy(id="myFile")
	WebElement btnChooseFile; //choose user image from pc
	
	@FindBy(id="butnPass")
	WebElement btnChangePassword;
	
	@FindBy(id="new_password")
	WebElement txtNewPassword;
	
	@FindBy(id="con_password")
	WebElement txtConfirmPassword;
	
	@FindBy(id="role_data")
	WebElement drpJobRole;
	
	@FindBy(id="submit")
	WebElement btnUpdate;
	
	@FindBy(xpath=("//button[@type='button']"))
	WebElement btnCancel;
	
	
	
	//Verify the heading
	public void getlabl(String Expected){
		String actual=Pagelbl.getText();
		Assert.assertEquals(Expected, actual);
	}
	
	// Edit user name
		public void EditUserName(String UserName){
			try{
				TestLog.log.info("Editing user name");
				
				txtUserName.sendKeys(UserName);
				TestLog.log.info("User name is edited");
			
			} catch (Exception ex) {
				
			}
			
		}

	//Edit first name
		public void EditFirstName(String FirstName){
			try{
				TestLog.log.info("Editing first name");
				txtFirstName.sendKeys(FirstName);
				TestLog.log.info("First name is edited");
			
			} catch (Exception ex) {
				
			}
			
		}

	//Edit last name
		public void EditLastName(String LastName){
			try{
				TestLog.log.info("Editing last name");
				txtLastName.sendKeys(LastName);
				TestLog.log.info("Last name is edited");
			
			} catch (Exception ex) {
				
			}
			
		}

	//Change image
		
		public void EditUserImage(String path){
			try{
				TestLog.log.info("Changing user image");
				
				lnkUserImage.click();
				btnChooseFile.sendKeys(path);
				
				TestLog.log.info("User Image is changed");
			
			} catch (Exception ex) {
				
			}
			
		}
		
	//Change password
		
		public void ChangePassword(String NewPassword, String ConfirmPassword){
			try{
				TestLog.log.info("Changing password");
				
				btnChangePassword.click();
				txtNewPassword.sendKeys(NewPassword);
				txtConfirmPassword.sendKeys(ConfirmPassword);
				
				TestLog.log.info("Password is changed ");
			
			} catch (Exception ex) {
				
			}
			
		}

	//change job  role
		public void ChangeJobRole(String role){
			try{
				TestLog.log.info("Changing job role");
				drpJobRole.click();
				Select dropdown= new Select(drpJobRole);
				dropdown.selectByVisibleText(role);
				
				TestLog.log.info("job role is changed");
			
			} catch (Exception ex) {
				
			}
			
		}
		
	//Update
		public void Update(){
			try{
				TestLog.log.info("Updating details");
				btnUpdate.click();
				TestLog.log.info("Details are updated");
			
			} catch (Exception ex) {
				
			}
			
		}
		
	//Cancel
			public void Cancel(){
				try{
					TestLog.log.info("Cancel update");
					btnCancel.click();
					TestLog.log.info("Canceled");
				
				} catch (Exception ex) {
					
				}
				
			}
}
