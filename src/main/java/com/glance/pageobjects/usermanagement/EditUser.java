package com.glance.pageobjects.usermanagement;


import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



import com.glance.pageobjects.common.BasePage;
import com.glance.pageobjects.logs.TestLog;

public class EditUser extends BasePage {

	public EditUser(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy(xpath=("//div[@class='x_title']/h2")) //page label
	WebElement pagelbl;
	
	@FindBy(id="user_name") //Edit user name
	WebElement txtUserName;
	
	@FindBy(id="first-name")
	WebElement txtFirstName;
	
	@FindBy(id="last_name")
	WebElement txtLastName;
	
	@FindBy(xpath=("//a[@id='linkId']"))
	WebElement lnkUserImage;		//user image
	
	@FindBy(id="myFile")
	WebElement btnChooseFile; //choose user image from pc
	
	@FindBy(id="email")
	WebElement txtEmail;
	
	
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
	
	@FindBy(xpath=("//button[@class='btn btn-success']"))   
	WebElement btnOk;
	
	@FindBy(xpath=("//button[@class='btn btn-warning']"))   
	WebElement btnWarning;
	
	
	@FindBy(xpath=("//a[@class='paginate_button last disabled']"))   
	WebElement btnLast;
	
	@FindBy(xpath=("//input[@type='search']"))   
	WebElement txtSearch;
	
	

	//Verify the heading
	public boolean verifyLabl(){
		boolean flag=false;
	
		String actual=pagelbl.getText();
		if(actual.contains("All active users ")){
			flag=true;
			
		}
		return flag;
	}
	
	//Cancel edit page
	public void cancelEditPage(){
		btnCancel.click();
	}
	
	// Edit user name
		public void editUserName(String newUserName){
			try{
				TestLog.log.info("Editing user name");
				txtUserName.clear();
				 /*Actions action = new Actions(driver);
				  action.doubleClick(txtUserName);
				  action.perform();*/
				  
				txtUserName.sendKeys(newUserName);
				TestLog.log.info("User name is edited");
			
			} catch (Exception ex) {
				
			}
			
		}

	//Edit first name
		public void editFirstName(String firstName){
			try{
				TestLog.log.info("Editing first name");
				
				Actions action = new Actions(driver);
				  action.doubleClick(txtFirstName);
				  action.perform();
				
				txtFirstName.sendKeys(firstName);
				TestLog.log.info("First name is edited");
			
			} catch (Exception ex) {
				
			}
			
		}

	//Edit last name
		public void editLastName(String lastName){
			try{
				TestLog.log.info("Editing last name");
				
				Actions action = new Actions(driver);
				  action.doubleClick(txtLastName);
				  action.perform();
				
				txtLastName.sendKeys(lastName);
				TestLog.log.info("Last name is edited");
			
			} catch (Exception ex) {
				
			}
			
		}

	//Change image
		
		public void editUserImage(){
			try{
				TestLog.log.info("Changing user image");
				
				//lnkUserImage.click();
				Thread.sleep(2000);
				btnChooseFile.click();
				TestLog.log.info("User Image is changed");
			
			} catch (Exception ex) {
				
			}
			
		}
		
		//Change Email address
		
				public void editEmail(String email){
					try{
						TestLog.log.info("Changing password");
						txtEmail.clear();
						/*Actions action = new Actions(driver);
						  action.doubleClick(txtEmail);
						  action.perform();*/
						
						txtEmail.sendKeys(email);
						
						TestLog.log.info("Password is changed ");
					
					} catch (Exception ex) {
						
					}
					
				}

		
	//Change password
		
		public void changePassword(String newPassword, String confirmPassword){
			try{
				TestLog.log.info("Changing password");
				
				btnChangePassword.click();
				
				txtNewPassword.sendKeys(newPassword);
				txtConfirmPassword.sendKeys(confirmPassword);
				
				TestLog.log.info("Password is changed ");
			
			} catch (Exception ex) {
				
			}
			
		}

	//change job  role
		public void changeJobRole(String role){
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
		public void update(){
			try{
				TestLog.log.info("Updating details");
				btnUpdate.click();
				Thread.sleep(5000);
				
				//btnOk.click();
				TestLog.log.info("Details are updated");
			
			} catch (Exception ex) {
				
			}
			
		}
	//Click ok to updated 
		public void clickOk(){
			try{
				TestLog.log.info("Updating details");
				
				btnOk.click();
				TestLog.log.info("Details are updated");
			
			} catch (Exception ex) {
				
			}
			
		}
		
	//Click on in alert shown when trying to give wrong details 
		public void clickOkWarning(){
			try{
				TestLog.log.info("Updating details");
				
				btnWarning.click();
				TestLog.log.info("Details are updated");
			
			} catch (Exception ex) {
				
			}
			
		}
		
		
	//Verify updated or not
		
		public boolean verifyUpdate(String newUserName, String firstName, String lastName, String role){
			txtSearch.sendKeys(newUserName);
			boolean flag = false;
			

			
			WebElement tblUser = driver.findElement(By.xpath("//tbody"));
			List<WebElement> tblRow = tblUser.findElements(By.tagName("tr"));

			outerloop: {
				for (WebElement row : tblRow) {

					List<WebElement> tblData = row
							.findElements(By.xpath("//td[3]"));

					for (WebElement data : tblData) {

						String newData = data.getText();
						System.out.println(newData);
						if (newData.contains(newUserName)||newData.contains(firstName)||newData.contains(lastName)||newData.contains(role)) {
							System.out.println("Success");
							flag = true;
							break outerloop;

						}

					}

				}
			}
			return flag;
			
		}
		
	
			
			
	//Select user to edit	
	public void selectUserToEdit(String user1){
		try{
			TestLog.log.info("Cancel update");
			
			txtSearch.sendKeys(user1);
			
			//btnLast.click(); //navigate to last page
			Thread.sleep(5000);
			WebElement btnEdit=driver.findElement(By.xpath("//i[@class='fa fa-edit']"));
			btnEdit.click();
			
			TestLog.log.info("Canceled");
		
		} catch (Exception ex) {
			
		}
		
	}
	
//Verify validation of user name end e-mail
	
	public boolean verifyValidation(String alertMgs){
		boolean flag = false;
		String text=driver.getPageSource();
		
		if(text.contains(alertMgs)){
			flag=true;
		}

		return flag;
		
	}
}
