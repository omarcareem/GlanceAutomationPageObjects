/*
 * author: Omar Careem
 * date created: 11/09/2016
 */


package com.glance.pageobjects.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.glance.pageobjects.logs.TestLog;

public class CommonPageObject extends BasePage{

	public CommonPageObject(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="example_first")
	WebElement btnFirst;
	
	@FindBy(id="example_previous")
	WebElement btnPrevious;
	
	@FindBy(id="example_next")
	WebElement btnNext;
	
	@FindBy(id="example_last")
	WebElement btnLast;
	
	@FindBy(name="example_length")
	WebElement dropDown;
	
	@FindBy(id="example_info")
	WebElement lblRecordCount;
	
	By middlePagination = By.xpath("//div[@id='example_paginate']/span/a");

	
	
		//Page Navigation - First page
		public void firstPageNavigation(){
			
			try{
			TestLog.log.info("Check First Button eneble");	
			if(btnFirst.isEnabled()){
				TestLog.log.info("Click on First Button");	
				btnFirst.click();
			}else{
				TestLog.log.info("Page Navigation button First Disable");
			}
			} catch (Exception ex) {
				TestLog.log.info("Could not find page Navigation button" + ex);
			}
		}
		
		
		//Page Navigation - Previous page
		public void previousPageNavigation(){
			try{
				TestLog.log.info("Check Previous Button eneble");	
				if(btnPrevious.isEnabled()){
					TestLog.log.info("Click on Previous Button");	
					btnPrevious.click();
				}else{
					TestLog.log.info("Page Navigation button Previous Disable");
				}
				} catch (Exception ex) {
					TestLog.log.info("Could not find page Navigation button" + ex);
				}
		}

		//Page Navigation - Next page
		public void nextPageNavigation(){
			try{
				TestLog.log.info("Check Next Button eneble");	
				if(btnNext.isEnabled()){
					TestLog.log.info("Click on Next Button");	
					btnNext.click();
				}else{
					TestLog.log.info("Page Navigation button Previous Disable");
				}
				} catch (Exception ex) {
					TestLog.log.info("Could not find page Navigation button" + ex);
				}
		}
			
		//Page Navigation - Last page
		public void lastPageNavigation(){
			try{
				TestLog.log.info("Check Last Button eneble");	
				if(btnLast.isEnabled()){
					TestLog.log.info("Click on Last Button");	
					btnLast.click();
				}else{
					TestLog.log.info("Page Navigation button Previous Disable");
				}
				} catch (Exception ex) {
					TestLog.log.info("Could not find page Navigation button" + ex);
				}
		}
		
		//Page navigation - Middle Pages
		
		public void middlePageNavigation(){
			try{
				List<WebElement> pagination= driver.findElements(middlePagination);
				TestLog.log.info("checkif pagination link exists");	
				
				if(pagination .size()>0){ 
					System.out.println("pagination exists");
					TestLog.log.info("click on pagination link ");
					for(int i=0; i<pagination .size(); i++){ 
						pagination.get(i).click(); 
						} 
						} else { 
						System.out.println("pagination not exists");
						} 
				} catch (Exception ex) {
					TestLog.log.info("Could not find page Navigation button" + ex);
				}
		}
		
		//select the table entry count from the drop down
		public void selectDropDuwn(String numberOfRecords){
			try{
				System.out.println("check dropdown exist");
				if (dropDown.isDisplayed()){
					System.out.println("select from dropdown list");
					Select drpRecords= new Select(dropDown);
					drpRecords.selectByVisibleText(numberOfRecords);
				}else{
					System.out.println("dropdown does not exist");
					System.out.println("Table Entry dropdown not visible");
				}
				
			} catch (Exception ex) {
				TestLog.log.info("Could not find dropdown" + ex);
			}
			
		}
		
		//Page navigation verification
		public void verifyDroDownn(){
			try{
				System.out.println("verify selection");
				
				Select visibleRecords= new Select(dropDown);
				
				System.out.println("get table row count");
				WebElement element = visibleRecords.getFirstSelectedOption();
				String selectedValue= element.getText();
				int rawcount= driver.findElements(By.tagName("tr")).size(); 
				
				System.out.println("get page number count");
				int pageNumbers = driver.findElements(By.xpath("//span/a")).size();
				int pageCount;
								
				System.out.println("get page count");
				if (rawcount < 10){
					if(selectedValue=="10"){
						System.out.println("get page count");
						pageCount= (rawcount/10);
						System.out.println(pageCount);						
							} else if(selectedValue=="25"){
								System.out.println("get page count");
								pageCount= (rawcount/25);
								System.out.println(pageCount);						
							}else if(selectedValue=="50"){
								System.out.println("get page count");
								pageCount= (rawcount/50);
								System.out.println(pageCount);						
							}else if(selectedValue=="100"){
								System.out.println("get page count");
								pageCount= (rawcount/100);
								System.out.println(pageCount);						
							}else{
								System.out.println("No pages appeared");
							}
				}
				
				if (rawcount < 25){
					if(selectedValue=="10"){
						System.out.println("get page count");
						pageCount= (rawcount/10);
						System.out.println(pageCount);						
							} else if(selectedValue=="25"){
								System.out.println("get page count");
								pageCount= (rawcount/25);
								System.out.println(pageCount);						
							}else if(selectedValue=="50"){
								System.out.println("get page count");
								pageCount= (rawcount/50);
								System.out.println(pageCount);						
							}else if(selectedValue=="100"){
								System.out.println("get page count");
								pageCount= (rawcount/100);
								System.out.println(pageCount);						
							}else{
								System.out.println("No pages appeared");
							}
				}
				
				if (rawcount < 50){
					if(selectedValue=="10"){
						System.out.println("get page count");
						pageCount= (rawcount/10);
						System.out.println(pageCount);						
							} else if(selectedValue=="25"){
								System.out.println("get page count");
								pageCount= (rawcount/25);
								System.out.println(pageCount);						
							}else if(selectedValue=="50"){
								System.out.println("get page count");
								pageCount= (rawcount/50);
								System.out.println(pageCount);						
							}else if(selectedValue=="100"){
								System.out.println("get page count");
								pageCount= (rawcount/100);
								System.out.println(pageCount);						
							}else{
								System.out.println("No pages appeared");
							}
				}
				
				if (rawcount < 100){
					if(selectedValue=="10"){
						System.out.println("get page count");
						pageCount= (rawcount/10);
						System.out.println(pageCount);						
							} else if(selectedValue=="25"){
								System.out.println("get page count");
								pageCount= (rawcount/25);
								System.out.println(pageCount);						
							}else if(selectedValue=="50"){
								System.out.println("get page count");
								pageCount= (rawcount/50);
								System.out.println(pageCount);						
							}else if(selectedValue=="100"){
								System.out.println("get page count");
								pageCount= (rawcount/100);
								System.out.println(pageCount);						
							}else{
								System.out.println("No pages appeared");
							}
				}
				
				if (rawcount > 100){
					if(selectedValue=="10"){
						System.out.println("get page count");
						pageCount= (rawcount/10);
						System.out.println(pageCount);						
							} else if(selectedValue=="25"){
								System.out.println("get page count");
								pageCount= (rawcount/25);
								System.out.println(pageCount);						
							}else if(selectedValue=="50"){
								System.out.println("get page count");
								pageCount= (rawcount/50);
								System.out.println(pageCount);						
							}else if(selectedValue=="100"){
								System.out.println("get page count");
								pageCount= (rawcount/100);
								System.out.println(pageCount);						
							}else{
								System.out.println("No pages appeared");
							}
				}
				
			}
				
			
				
								
				
				
			
		public String recordCount(){
			String recordCount = lblRecordCount.getText();
			return recordCount;			
		}
		
		
	
	//This method will capture screen shots
	public void takeScreenShotofFailure(String screenShot) throws Exception {

		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		System.out.println("Before taking screen shot");
		TestLog.log.info("Before taking screen shot");
		File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		System.out.println("Created imgage file");
		TestLog.log.info("Created imgage file");
		String screenShotName = screenShot + "_" + timeStamp + ".png";

		// It will store all the screenshots in test-output/screenshots folder
		String destDir = System.getProperty("user.dir") + "/" + "test-output/ScreenShots";
		new File(destDir).mkdirs();
		String destFile = destDir + "/" + screenShotName;
		FileUtils.copyFile(imageFile, new File(destFile));
		System.out.println("Saving file");
		TestLog.log.info("Saving file");
	}
	
	//this method will wait for the page load
	public void waitForPageLoad(int numberOfSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, numberOfSeconds);

		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver wdriver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		});
	}
	
	
	

}
