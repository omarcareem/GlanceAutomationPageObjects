package com.glance.pageobjects.usermanagement;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.glance.pageobjects.common.BasePage;
import com.glance.pageobjects.logs.TestLog;

public class DeleteUser extends BasePage {

	public DeleteUser(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath=("//div[@class='x_title']/h2"))
	WebElement Pagelbl;
	
	@FindBy(id="deleteButton")
	WebElement btnDelete;
	
	@FindBy(id="backButton")
	WebElement btnBack;
	
	
	//Get the heading of the page
	public String getTitle(){
		return Pagelbl.getText();
		
		
	}
	
	//Verify the heading
	public void getlabl(String labl){
		String actual=Pagelbl.getText();
		Assert.assertEquals(labl, actual);
	}
	
	//Delete user by accepting alert
			public void DeleteUsers(String alertDelete, String success){
				try{
					TestLog.log.info("Delete a user");
					
					btnDelete.click(); //Click delete button
					
					
					Alert Alert1 = driver.switchTo().alert(); //Switch driver to alert
					String alertText1 = Alert1.getText(); //Getting the text displayed in alert
					Assert.assertEquals(alertDelete, alertText1);
					
				
					
				    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

				    Alert1.accept(); //Accept alert
				    
				    Alert Alert2=driver.switchTo().alert();
				    String alertText2=Alert2.getText();
				    Assert.assertEquals(success, alertText2);
				    
				    Alert2.accept();
				    
				    
					TestLog.log.info("User is deleted");
				
				} catch (Exception ex) {
					
				}
				
			}

			//Dismissing alert
					public void CancelAlert(String alertCancel){
						try{
							TestLog.log.info("Cancel alert");
							btnDelete.click();
							
							Alert Alert = driver.switchTo().alert();
							String alertText2 = Alert.getText();
							Assert.assertEquals(alertCancel, alertText2);
							
							//System.out.println("Alert text is " + alertText);
							
						    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

						    Alert.dismiss(); //Dismissing alert
							
							TestLog.log.info("User is deleted");
						
						} catch (Exception ex) {
							
						}
						
					}
	//Go back 
			public void GoBack(){
				try{
					TestLog.log.info("Navigate back");
					btnBack.click();
					TestLog.log.info("User management page is displayed");
						
				} catch (Exception ex) {
							
				}
				
			}

}
