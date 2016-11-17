package com.glance.pageobjects.usermanagement;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
//import org.testng.Assert;

import com.glance.pageobjects.common.BasePage;
import com.glance.pageobjects.logs.TestLog;

public class EditGroupMembership extends BasePage {

	public EditGroupMembership(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	

	@FindBy(id="select_group")
	WebElement drpEditSelectGroup;
	
	@FindBy(xpath=("//select[@name='example_length']"))   
	WebElement drpShowEntries;
	
	@FindBy(xpath=("//input[@type='search']"))   
	WebElement txtSearch;
	
	@FindBy(xpath=("//i[@class='fa fa-chevron-up']"))   
	WebElement btnHide;
	
	@FindBy(xpath=("//a[@id='1']"))   
	WebElement btnDelete;
	
	@FindBy(id="example_first")
	WebElement nvgtFirst;
	
	@FindBy(id="example_last")
	WebElement nvgtLast;
	
	@FindBy(id="example_next")
	WebElement nvgtNext;
	
	@FindBy(id="example_previous")
	WebElement nvgtPrevious;
	
	@FindBy(xpath=("//a[@class='paginate_button current']"))   
	WebElement nvgtNumber;
	
	
	/*@FindBy(xpath=("//table[@id='example']"))
	WebElement table;
	*/
	public void SelectGroup(String Group){
		try{
			TestLog.log.info("Selecting group");
			Select dropdown= new Select(drpEditSelectGroup);
			dropdown.selectByVisibleText(Group);
			
			TestLog.log.info("Group selected");
		
		} catch (Exception ex) {
			
		}
		
	}
	
	public void ShowEntries(String Entries) {
		try{
			TestLog.log.info("Changing number of visible entries");
			Select dropdown= new Select(drpShowEntries);
			dropdown.selectByVisibleText(Entries);
		
			TestLog.log.info("Visible entries changed");
	
		} catch (Exception ex) {
		
		}
	
	}
	public void Search(String KeyWord) {
		try{
			TestLog.log.info("Searching based on key word");
			txtSearch.sendKeys(KeyWord,Keys.ENTER);
	
			TestLog.log.info("Entries with keyword are shown");
	
		} catch (Exception ex) {
		
		}
	
	}
	
	public void Hide() {
		try{
			TestLog.log.info("Hiding the details");
			btnHide.click();
			TestLog.log.info("Details were hide");
			
		} catch (Exception ex) {
		
		}
			
	}
		
	public void Delete(String user) {
		try{
			TestLog.log.info("Deleting the user");
			
			WebElement btnDelete = driver.findElement(By.xpath("//td[text()='"+user+"']/../td[7]/div[@class='fa-hover']"));
			btnDelete.click();

			Alert Alert1 = driver.switchTo().alert(); //Switch driver to alert
			
			/*String alertText1 = Alert1.getText(); //Getting the text displayed in alert
			Assert.assertEquals(txtAlert, alertText1); //Verify the displayed text in the alert
			*/
	
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		    Alert1.accept(); //Accept alert

			TestLog.log.info("Details were deleted");
			
		} catch (Exception ex) {
		
		}
			
	}
	
	public void CancelDelete(String user) {
		try{
			TestLog.log.info("Deleting the user");

			WebElement btnDelete = driver.findElement(By.xpath("//td[text()='"+user+"']/../td[7]/div[@class='fa-hover']"));
			btnDelete.click();

			Alert Alert1 = driver.switchTo().alert(); //Switch driver to alert
			
			
			/*String alertText1 = Alert1.getText(); //Getting the text displayed in alert
			Assert.assertEquals(txtAlert, alertText1); //Verify the displayed text in the alert
			*/
	
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		    Alert1.dismiss(); //Cancel alert

			TestLog.log.info("Details were deleted");
			
		} catch (Exception ex) {
		
		}
			
	}
	
	public void NavigateFirst() {
		try{
			TestLog.log.info("Navigating to first page");
			nvgtFirst.click();
			TestLog.log.info("Showing first page");
			
		} catch (Exception ex) {
		
		}
			
	}
	
	public void NavigateLast() {
		try{
			TestLog.log.info("Navigating to last page");
			nvgtLast.click();
			TestLog.log.info("Showing last page");
			
		} catch (Exception ex) {
		
		}
			
	}
	
	public void NavigateNext() {
		try{
			TestLog.log.info("Navigating to next page");
			nvgtNext.click();
			TestLog.log.info("Showing next page");
			
		} catch (Exception ex) {
		
		}
			
	}
	
	public void NavigatePrevious() {
		try{
			TestLog.log.info("Navigating to previous page");
			nvgtPrevious.click();
			TestLog.log.info("Showing previous page");
			
		} catch (Exception ex) {
		
		}
	
}
	
	public void NavigateNumber() {
		try{
			TestLog.log.info("Navigating to specific page");
			nvgtNumber.click();
			TestLog.log.info("Showing specific page");
			
		} catch (Exception ex) {
		
		}
	
}
	}
