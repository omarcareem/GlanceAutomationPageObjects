package com.glance.pageobjects.dashboard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.glance.pageobjects.common.BasePage;
import com.glance.pageobjects.logs.TestLog;

public class CommonPageTopPane extends BasePage {

	public CommonPageTopPane(WebDriver driver) {
		super(driver);
        PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
   

    
    // user profile pic in the top pane
    @FindBy(xpath="//div[1]/div/div[2]/div/nav/ul/li[1]/a/img")
    WebElement imgUserTop;
 
    //user name in the top pane
  //  @FindBy(xpath="")
  //  WebElement txtUserName;
    
    //drop down icon in the top pane
    @FindBy(xpath="//div/nav/ul/li[1]/a[@class='user-profile dropdown-toggle']")
    WebElement drpDownIcon;
    
    
    @FindBy(xpath="//a[text()='  Profile']")
    WebElement drpProfileOption;
    
     @FindBy(xpath="//span[text()='Settings']") 
     WebElement drpSettingsOption;
     
    @FindBy(xpath="//div/nav/ul/li[1]/ul/li[3]/a") 
     WebElement drpLogoutOption;
     
    @FindBy(xpath="//i[@class='fa fa-bars']") 
     WebElement btnPancake;
     
    @FindBy(id="search") 
     WebElement searchTextBox;
     
    @FindBy(id="frm_submit") 
    WebElement btnSubmit;
    
    //click drop down
    
    public void clickDropDownIcon(String pageLinks){
		try{
    		TestLog.log.info("Selecting");
    		Select dropdown= new Select(drpDownIcon);
			dropdown.selectByVisibleText(pageLinks);
    		TestLog.log.info("Selected "+ pageLinks );
    	}
    	 catch(Exception ex){
    		 TestLog.log.info("Could not select from drop down "+ex); 
    	 }
		
    }
	

    //click profile from the drop down menu
   /* public void clickProfile() {

		try {
			TestLog.log.info("Clicking Profile");
			drpProfileOption.click();
			TestLog.log.info("Clicked");

		} catch (Exception ex) {
          System.out.println("Clicking Profile failed");
		}

	}*/
 
    //click settings from the drop down menu
   /* public void clickSettings() {

		try {
			TestLog.log.info("Clicking Settings");
			drpSettingsOption.click();
			TestLog.log.info("Clicked");

		} catch (Exception ex) {
          System.out.println("Clicking Settings failed");
		}

	}
    */
    //click logout from the drop down menu
    /*public void clickLogout() {

		try {
			TestLog.log.info("Clicking Logout");
			drpLogoutOption.click();
			TestLog.log.info("Clicked");

		} catch (Exception ex) {
          System.out.println("Clicking Logout failed");
		}

	}*/
 
    public void searchTopPane(String searchAPE) {

		try {
			TestLog.log.info("searching");
			searchTextBox.sendKeys(searchAPE);
			TestLog.log.info("searching");

		} catch (Exception ex) {
             System.out.println("search failed");
		}

	}
    
    public void clickGo() {

		try {
			TestLog.log.info("clicking Go");
			btnSubmit.click();
			TestLog.log.info("clicked Go");

		} catch (Exception ex) {
          System.out.println("Cancel Add Group Failed");
		}

	}
    
    public void clickPanCakeIcon() {

		try {
			TestLog.log.info("clicking Pancake");
			btnPancake.click();
			TestLog.log.info("clicked ");

		} catch (Exception ex) {
          System.out.println("Toggling of page failed");
		}

	}
}
