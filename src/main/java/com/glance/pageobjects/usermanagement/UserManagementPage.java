package com.glance.pageobjects.usermanagement;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.glance.pageobjects.common.CommonPageObject;

public class UserManagementPage extends CommonPageObject {
	
	//calling constructor
	public UserManagementPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	//object identification using page factory model
	@FindBy (xpath= "//div[@class='x_title']/h2")
	WebElement lblUserDetails;
	
	@FindBy(name="example_length")
	WebElement dropdown;
	
	@FindBy(xpath= "//input[@type='search']")
	WebElement txtSearch;
	
	
	
	//Object identification using page object method
	
	//By linkPaginationButton=By.xpath(a[text()='"+buttonNumber+"']);
	By tblExample = By.xpath("//table[@id='example']");
	By clmUserName = By.xpath("//table[@id='example']/tbody/tr/td[3]");
	By clmActionEdit = By.xpath("//table[@id='example']/tbody/tr/td[7]/div/a[1]");
	By clmActionDelete = By.xpath("//table[@id='example']/tbody/tr/td[7]/div/a[2]");
	By dropdownEntries = By.xpath("//select[@name='example_length']/option");
	
	//method to verify the UserDetais element 
	public void FindUserDetailsElement(){
		if (lblUserDetails.isDisplayed()){
			System.out.println("User Detail Page Navigation Success");
		} else {
			System.out.println("User Detail Page Navigation not Success");
		}
		
	}
	
	//select the table entry count from the drop down
	public void selectTableEntries(String numberOfRecords){
		if (dropdown.isDisplayed()){
			Select drpRecords= new Select(dropdown);
			drpRecords.selectByVisibleText(numberOfRecords);
		}else{
			System.out.println("Table Entry dropdown not visible");
		}
	}
	
	//search for a record
	public void SearchRecords(String searchKey){
		if (txtSearch.isEnabled()){
			txtSearch.sendKeys(searchKey);
			txtSearch.sendKeys(Keys.ENTER);	
		}else{
			System.out.println("Search textbox Disable");
		}		
	}
	
	

}
