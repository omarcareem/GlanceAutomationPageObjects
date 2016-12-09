package com.glance.pageobjects.usermanagement;




import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.glance.pageobjects.common.BasePage;
import com.glance.pageobjects.logs.TestLog;

public class DeleteUser extends BasePage {

	public DeleteUser(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath=("//div[@class='title_left']/h3"))
	WebElement pagelbl;
	
	@FindBy(id="deleteButton")
	WebElement btnDelete;
	
	@FindBy(id="backButton")
	WebElement btnBack;
	
	@FindBy(xpath=("//button[@class='btn btn-danger']"))   
	WebElement btnOk;
	
	@FindBy(xpath=("//button[@class='btn btn-default']"))   
	WebElement btnClose;
	
	@FindBy(xpath=("//input[@type='search']"))   
	WebElement txtSearch;
	
	//Get the heading of the page
	public boolean getTitle(){
		Boolean flag;
		flag= false;
		String title= pagelbl.getText();
		if (title.contains("User Details")){
			System.out.println("In manage user page");
			flag=true;
		}
		return flag;
		
		
	}

	
	//Select user to delete	
	public void selectUserToDelete(String userDelete){
		try{
			TestLog.log.info("Cancel update");
			txtSearch.sendKeys(userDelete);
			
			WebElement btnDelete=driver.findElement(By.xpath("//i[@class='fa fa-trash']"));
			btnDelete.click();
			
			driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
			btnDelete.click();
			
			TestLog.log.info("Canceled");
		
		} catch (Exception ex) {
			
		}
		
	}
	
	//Delete user 
			public void deleteUsers(){
				try{
					TestLog.log.info("Delete a user");
					
					btnDelete.click(); //Click delete button
					Thread.sleep(5000);

					btnOk.click(); //click ok to conform delete
				    
				    
					TestLog.log.info("User is deleted");
				
				} catch (Exception ex) {
					
				}
				
			}
	
			
	//Verify delete
			public boolean verifyDelete(String userDelete){
				
				txtSearch.sendKeys(userDelete);
				
				boolean flag = true;
				
				WebElement tblUser = driver.findElement(By.xpath("//tbody"));
				List<WebElement> tblRow = tblUser.findElements(By.tagName("tr"));

				outerloop: {
					for (WebElement row : tblRow) {

						List<WebElement> tblData = row
								.findElements(By.xpath("//td[3]"));

						for (WebElement data : tblData) {

							String userName = data.getText();
							System.out.println(userName);
							if (userName.contains(userDelete)) {
								System.out.println("Success");
								flag = false;
								break outerloop;

							}

						}

					}
				}
				return flag;
			}
			
//Cancel Delete user 
			
			public void CancelDeleteUser(){
				try{
					TestLog.log.info("Delete a user");
					btnDelete.click();
					btnClose.click();
				    
					TestLog.log.info("User is deleted");
				
				} catch (Exception ex) {
					
				}
				
			}
//Go back 
			public void goBack(){
				try{
					TestLog.log.info("Navigate back");
					btnBack.click();
					TestLog.log.info("User management page is displayed");
						
				} catch (Exception ex) {
							
				}
				
			}
			

}
