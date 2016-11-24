package com.glance.pageobjects.usermanagement;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.glance.pageobjects.common.CommonPageObject;
import com.glance.pageobjects.logs.TestLog;

public class UserManagementPage extends CommonPageObject {
	
	//calling constructor
	public UserManagementPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	//object identification using page factory model
	@FindBy (xpath= "//div[@class='x_title']/h2")
	WebElement lblUserDetails;
	
	@FindBy(xpath="//a[@class='collapse-link']/i")
	WebElement btnMaxMin;
	
	@FindBy(xpath ="//a[@class='close-link']")
	WebElement btnDelete;
	
	
	//Object identification using page object method
	
	By tblExample = By.xpath("//table[@id='example']");
	
	
	//method to verify the UserDetais element 
	public void FindUserDetailsElement(){
		try{
			TestLog.log.info("verify page navigation");
			if (lblUserDetails.isDisplayed()){
				
				System.out.println("User Detail Page Navigation Success");
			} else {
				System.out.println("User Detail Page Navigation not Success");
			}
		}catch (Exception ex) {
			TestLog.log.info("User Detail Page Navigation not Success" + ex);
		}	
	}
	
	//verify actual table content from search 
	public int actualSearchResult(String searchKey ){
		 
		int searchRowCount =0;
		try{
			TestLog.log.info("verify page navigation after search");
			
			searchRowCount = driver.findElements(By.xpath("//*[contains(text(),'"+searchKey+"'))]")).size();
		
		}catch (Exception ex) {
			TestLog.log.info("User Detail Page Navigation not Success" + ex);
		}	
		return searchRowCount;
	}
	
	
	//click edit link in user management
	public void tableEditLink(String UserID){
		try{
			TestLog.log.info("verify click edit link");
			
			int rowCount = -1;
		    int columnCount = 0;
		    
		    WebElement table = driver.findElement(tblExample);
		    List<WebElement> allRows = table.findElements(By.tagName("tr"));
		    TestLog.log.info("get colom list");
		    for (WebElement row : allRows) {
		        rowCount++;
		        List<WebElement> rowCells = row.findElements(By.tagName("td"));
		        TestLog.log.info("get row list");
		        for (WebElement cell : rowCells) {
		            columnCount++;

		            String userIDValue = cell.getText();
		            TestLog.log.info("click Edit link");
		            if (userIDValue.equals(UserID)) {
		                driver.findElement(By.xpath("//table[@id='example']/tbody/tr[rowCount]/td[7]/div/a[1]")).click();
		                
		            }
		        }
		        columnCount = 0;
		    }
			
			
		}catch (Exception ex) {
			TestLog.log.info("Edit link not visible" + ex);
		}	
	}
	
	//click edit link in user management
		public void tableDeleteLink(String UserID){
			try{
				TestLog.log.info("verify click Delete link");
				
				int rowCount = -1;
			    int columnCount = 0;
			    WebElement table = driver.findElement(tblExample);
			    List<WebElement> allRows = table.findElements(By.tagName("tr"));
			    TestLog.log.info("get row list");
			    for (WebElement row : allRows) {
			        rowCount++;
			        List<WebElement> rowCells = row.findElements(By.tagName("td"));
			        TestLog.log.info("get colom list");
			        for (WebElement cell : rowCells) {
			            columnCount++;

			            String userIDValue = cell.getText();
			            TestLog.log.info("click Delete link");
			            if (userIDValue.equals(UserID)) {
			                driver.findElement(By.xpath("//table[@id='example']/tbody/tr[rowCount]/td[7]/div/a[2]")).click();
			                
			            }
			        }
			        columnCount = 0;
			    }
				
				
			}catch (Exception ex) {
				TestLog.log.info("Delete link not visible" + ex);
			}	
		}
		
		//click on minimize once the table maximized
		public void buttonMin(){
			 TestLog.log.info("click Min button");
			try{
				btnMaxMin.click();
			}catch (Exception ex) {
				TestLog.log.info("Max Min button not visible" + ex);
			}	
			
		}
		
		//verify on table minimized
		
		public String verifyButtonMin(){
			 TestLog.log.info("Verify Min button");
			 String minimize = null;
			try{
				minimize = driver.findElement(By.xpath("//i[@class='fa fa-chevron-down']")).getAttribute("class");
			}catch (Exception ex) {
				TestLog.log.info("Min button not visible" + ex);
			}	
			return minimize;
		}
		
		//click on maximize once table minimized
				public void buttonMax(){
					 TestLog.log.info("click Max button");
					try{
						btnMaxMin.click();
					}catch (Exception ex) {
						TestLog.log.info("Max Min button not visible" + ex);
					}	
					
				}
				
				//verify on table maximized 
				
				public String verifyButtonMax(){
					 TestLog.log.info("Verify Max button");
					 String maximize = null;
					try{
						maximize = driver.findElement(By.xpath("//i[@class='fa fa-chevron-up']")).getAttribute("class");
					}catch (Exception ex) {
						TestLog.log.info("Max button not visible" + ex);
					}	
					return maximize;
				}
	
				//click on delete button
				public void buttondelete(){
					 TestLog.log.info("click delete button");
					try{
						btnDelete.click();
					}catch (Exception ex) {
						TestLog.log.info("Delete button not visible" + ex);
					}	
					
				}
				
				//verify on table maximized 
				
				public boolean verifyButtonDelete(){
					 TestLog.log.info("Verify Delete button");
					 
					 boolean Output = false;
					 
					try{
						if(btnDelete.isDisplayed()){
							TestLog.log.info("Delete button is visible");
							Output = false;
						}else{
							Output = true;
						}
					}catch (Exception ex) {
						TestLog.log.info("Delete button is visible" + ex);
					}	
					return Output;
				}
			
		
	
	
	
	
	
	
	
	
	
	
	
}
