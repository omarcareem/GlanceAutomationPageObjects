/*
 * author: Omar Careem
 * date created: 11/09/2016
 */

package com.glance.pageobjects.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
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

public class CommonPageObject extends BasePage {

	public CommonPageObject(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "example_first")
	WebElement btnFirst;

	@FindBy(id = "example_previous")
	WebElement btnPrevious;

	@FindBy(id = "example_next")
	WebElement btnNext;

	@FindBy(id = "example_last")
	WebElement btnLast;

	@FindBy(name = "example_length")
	WebElement dropDown;

	@FindBy(id = "example_info")
	WebElement lblRecordCount;
	
	
	
	By middlePagination = By.xpath("//div[@id='example_paginate']/span/a");
	By txtSearch = By.xpath("//label/input");
	By tblExample = By.xpath("//table[@id='example']");

	// Page Navigation - First page
	public void firstPageNavigation() {

		try {
			TestLog.log.info("Check First Button eneble");
			if (btnFirst.isEnabled()) {
				TestLog.log.info("Click on First Button");
				btnFirst.click();
			} else {
				TestLog.log.info("Page Navigation button First Disable");
			}
		} catch (Exception ex) {
			TestLog.log.info("Could not find page Navigation button" + ex);
		}
	}


	// Page Navigation - Previous page
	public void previousPageNavigation() {
		try {
			TestLog.log.info("Check Previous Button eneble");
			if (btnPrevious.isEnabled()) {
				TestLog.log.info("Click on Previous Button");
				btnPrevious.click();
			} else {
				TestLog.log.info("Page Navigation button Previous Disable");
			}
		} catch (Exception ex) {
			TestLog.log.info("Could not find page Navigation button" + ex);
		}
	}

	// Page Navigation - Next page
	public void nextPageNavigation() {
		try {
			TestLog.log.info("Check Next Button eneble");
			if (btnNext.isEnabled()) {
				TestLog.log.info("Click on Next Button");
				btnNext.click();
			} else {
				TestLog.log.info("Page Navigation button Previous Disable");
			}
		} catch (Exception ex) {
			TestLog.log.info("Could not find page Navigation button" + ex);
		}
	}

	// Page Navigation - Last page
	public void lastPageNavigation() {
		try {
			TestLog.log.info("Check Last Button eneble");
			if (btnLast.isEnabled()) {
				TestLog.log.info("Click on Last Button");
				btnLast.click();
			} else {
				TestLog.log.info("Page Navigation button Previous Disable");
			}
		} catch (Exception ex) {
			TestLog.log.info("Could not find page Navigation button" + ex);
		}
	}

	// Page navigation - Middle Pages

	public void middlePageNavigation() {
		try {
			List<WebElement> pagination = driver.findElements(middlePagination);
			TestLog.log.info("checkif pagination link exists");

			if (pagination.size() > 0) {
				System.out.println("pagination exists");
				TestLog.log.info("click on pagination link ");
				for (int i = 0; i < pagination.size(); i++) {
					pagination.get(i).click();
				}
			} else {
				System.out.println("pagination not exists");
			}
		} catch (Exception ex) {
			TestLog.log.info("Could not find page Navigation button" + ex);
		}
	}

	

	// Page navigation verification - Actual page count text
	public String actualPage() {
		String recordCount = null;
		try {

			TestLog.log.info("get actual page count text");
			recordCount = lblRecordCount.getText();

		} catch (Exception ex) {
			TestLog.log.info("Could not find dropdown" + ex);
		}
		return recordCount;
	}

	// select the table entry count from the drop down
	public void selectDropDuwn(String dropDownValue) {
		try {
			TestLog.log.info("check dropdown exist");
			if (dropDown.isDisplayed()) {
				TestLog.log.info("select from dropdown list");
				Select drpRecords = new Select(dropDown);
				drpRecords.selectByVisibleText(dropDownValue);
			} else {
				TestLog.log.info("dropdown does not exist");
				System.out.println("Table Entry dropdown not visible");
			}

		} catch (Exception ex) {
			TestLog.log.info("Could not find dropdown" + ex);
		}

	}

	public void expectedRowCount(int rowCount){
			
				TestLog.log.info("verify selection");
				
				Select visibleRecords= new Select(dropDown);
				
				TestLog.log.info("get selection from drop down");
				WebElement element = visibleRecords.getFirstSelectedOption();
				String selectedValue= element.getText();
				int expectedRowCount=0;
				
				try{							
				TestLog.log.info("get actual row count");
				if (rowCount <= 10){
					if(selectedValue=="10"){
						expectedRowCount = rowCount;
							} else if(selectedValue=="25"){
								expectedRowCount = 	rowCount;					
							}else if(selectedValue=="50"){
								expectedRowCount = 	rowCount;						
							}else if(selectedValue=="100"){
								expectedRowCount = 	rowCount;						
							}else{
								TestLog.log.info("no record added");
								System.out.println("No records appeared");
							}
				}
				if (rowCount > 10 || rowCount <= 25){
					if(selectedValue=="10"){
						expectedRowCount = 	10;
							} else if(selectedValue=="25"){
								expectedRowCount = 	rowCount;					
							}else if(selectedValue=="50"){
								expectedRowCount = 	rowCount;						
							}else if(selectedValue=="100"){
								expectedRowCount = 	rowCount;						
							}else{
								System.out.println("No records appeared");
							}
				}
				if (rowCount > 25 || rowCount <= 50){
					if(selectedValue=="10"){
						expectedRowCount = 	10;
							} else if(selectedValue=="25"){
								expectedRowCount = 	25;					
							}else if(selectedValue=="50"){
								expectedRowCount = 	rowCount;						
							}else if(selectedValue=="100"){
								expectedRowCount = 	rowCount;						
							}else{
								System.out.println("No records appeared");
							}
				}
				if (rowCount > 50 || rowCount <= 100){
					if(selectedValue=="10"){
						expectedRowCount = 	10;
							} else if(selectedValue=="25"){
								expectedRowCount = 	25;					
							}else if(selectedValue=="50"){
								expectedRowCount = 	50;						
							}else if(selectedValue=="100"){
								expectedRowCount = 	rowCount;						
							}else{
								System.out.println("No records appeared");
							}
				}
				if (rowCount > 100){
					if(selectedValue=="10"){
						expectedRowCount = 	10;
							} else if(selectedValue=="25"){
								expectedRowCount = 	25;					
							}else if(selectedValue=="50"){
								expectedRowCount = 	50;						
							}else if(selectedValue=="100"){
								expectedRowCount = 	100;						
							}else{
								System.out.println("No records appeared");
							}
				}
			}catch (Exception ex) {
				TestLog.log.info("Could not find dropdown" + ex);
			}
			
		}

	// validate actual row count
	public int actualRowCount() {
		int actualRawCount = 0;

		try {
			actualRawCount = driver.findElements(By.tagName("tr")).size();

		} catch (Exception ex) {
			TestLog.log.info("Could not find table" + ex);
		}
		return actualRawCount;
	}

	// Page count verification - Expected page count
	public void verifyDroDownPageCount(int rowCount) {
		try {
			TestLog.log.info("verify selection");

			Select visibleRecords = new Select(dropDown);

			TestLog.log.info("get table row count");
			WebElement element = visibleRecords.getFirstSelectedOption();
			String selectedValue = element.getText();
			
			TestLog.log.info("get page number count");
			int pageCount;

			TestLog.log.info("get page count");
			if (rowCount < 10) {
				if (selectedValue == "10") {
					TestLog.log.info("get page count");
					pageCount = (int) (Math.ceil(rowCount / 10.0));
					System.out.println(pageCount);
				} else if (selectedValue == "25") {
					TestLog.log.info("get page count");
					pageCount = (int) (Math.ceil(rowCount / 25.0));
					System.out.println(pageCount);
				} else if (selectedValue == "50") {
					TestLog.log.info("get page count");
					pageCount = (int) (Math.ceil(rowCount / 50.0));
					System.out.println(pageCount);
				} else if (selectedValue == "100") {
					TestLog.log.info("get page count");
					pageCount = (int) (Math.ceil(rowCount / 100.0));
					System.out.println(pageCount);
				} else {
					System.out.println("No pages appeared");
				}
			}

			if (rowCount < 25) {
				if (selectedValue == "10") {
					TestLog.log.info("get page count");
					pageCount = (int) (Math.ceil(rowCount / 10.0));
					System.out.println(pageCount);
				} else if (selectedValue == "25") {
					TestLog.log.info("get page count");
					pageCount = (int) (Math.ceil(rowCount / 25.0));
					System.out.println(pageCount);
				} else if (selectedValue == "50") {
					TestLog.log.info("get page count");
					pageCount = (int) (Math.ceil(rowCount / 50.0));
					System.out.println(pageCount);
				} else if (selectedValue == "100") {
					TestLog.log.info("get page count");
					pageCount = (int) (Math.ceil(rowCount / 100.0));
					System.out.println(pageCount);
				} else {
					System.out.println("No pages appeared");
				}
			}

			if (rowCount < 50) {
				if (selectedValue == "10") {
					TestLog.log.info("get page count");
					pageCount = (int) (Math.ceil(rowCount / 10.0));
					System.out.println(pageCount);
				} else if (selectedValue == "25") {
					TestLog.log.info("get page count");
					pageCount = (int) (Math.ceil(rowCount / 25.0));
					System.out.println(pageCount);
				} else if (selectedValue == "50") {
					TestLog.log.info("get page count");
					pageCount = (int) (Math.ceil(rowCount / 50.0));
					System.out.println(pageCount);
				} else if (selectedValue == "100") {
					TestLog.log.info("get page count");
					pageCount = (int) (Math.ceil(rowCount / 100.0));
					System.out.println(pageCount);
				} else {
					System.out.println("No pages appeared");
				}
			}

			if (rowCount < 100) {
				if (selectedValue == "10") {
					TestLog.log.info("get page count");
					pageCount = (int) (Math.ceil(rowCount / 10.0));
					System.out.println(pageCount);
				} else if (selectedValue == "25") {
					TestLog.log.info("get page count");
					pageCount = (int) (Math.ceil(rowCount / 25.0));
					System.out.println(pageCount);
				} else if (selectedValue == "50") {
					TestLog.log.info("get page count");
					pageCount = (int) (Math.ceil(rowCount / 50.0));
					System.out.println(pageCount);
				} else if (selectedValue == "100") {
					TestLog.log.info("get page count");
					pageCount = (int) (Math.ceil(rowCount / 100.0));
					System.out.println(pageCount);
				} else {
					System.out.println("No pages appeared");
				}
			}

			if (rowCount > 100) {
				if (selectedValue == "10") {
					if (selectedValue == "10") {
						TestLog.log.info("get page count");
						pageCount = (int) (Math.ceil(rowCount / 10.0));
						System.out.println(pageCount);
					} else if (selectedValue == "25") {
						TestLog.log.info("get page count");
						pageCount = (int) (Math.ceil(rowCount / 25.0));
						System.out.println(pageCount);
					} else if (selectedValue == "50") {
						TestLog.log.info("get page count");
						pageCount = (int) (Math.ceil(rowCount / 50.0));
						System.out.println(pageCount);
					} else if (selectedValue == "100") {
						TestLog.log.info("get page count");
						pageCount = (int) (Math.ceil(rowCount / 100.0));
						System.out.println(pageCount);
					} else {
						System.out.println("No pages appeared");
					}
				}
			}

		} catch (Exception ex) {
			TestLog.log.info("Could not find dropdown" + ex);
		}
	}

	// Page Count verification - Actual page count
	public int pageCount() {
		TestLog.log.info("get actual page count");
		int pageNumbers = 0;
		try{
			pageNumbers = driver.findElements(By.xpath("//span/a")).size();
			
		}catch (Exception ex) {
			TestLog.log.info("Could not find page count" + ex);
		}
		return pageNumbers;
	}

	//add text to search text box
	public void tableSearch(String searchKey){
		TestLog.log.info("verify text search");
		try{
			driver.findElement(txtSearch).sendKeys(searchKey);
		}catch (Exception ex) {
			TestLog.log.info("Text search verification fails" + ex);
		}
				
	}
	
	//sorting the table according to the colom
	
	public void tableSort(String colomName){
		TestLog.log.info("sort according to the colom ");
		try{
			driver.findElement(By.xpath("//*[contains(text(),'"+colomName+"')]")).click();
		}catch (Exception ex) {
			TestLog.log.info("sorting fails" + ex);
		}
	}
	
	//verify sorting the table according to the colom
	
	public void verifyTableSort(String colomName){
		TestLog.log.info("verification sort according to the colom ");
		
		int eleCount;
        List<String> expUserID = new ArrayList();
        List<String> expUserName = new ArrayList();
        List<String> expFirstName = new ArrayList();
        List<String> expLastName = new ArrayList();
        List<String> expJobRole = new ArrayList();
        
        List<String> actUserID = new ArrayList();
        List<String> actUserName = new ArrayList();
        List<String> actFirstName = new ArrayList();
        List<String> actLastName = new ArrayList();
        List<String> actJobRole = new ArrayList();
        
        
		try{
			TestLog.log.info("find the row count");      
			eleCount = driver.findElements(By.xpath("//*[contains(text(),'"+colomName+"')]")).size();

            System.out.println("Element count: " + eleCount);

            for(int i = 0; i < eleCount; i++){ 
            	TestLog.log.info("capture values");
                
            	expUserID.add(driver.findElement(By.xpath("//*[contains(text(),'User ID')]")).getText());
            	expUserName.add(driver.findElement(By.xpath("//*[contains(text(),'User Name')]")).getText());
            	expFirstName.add(driver.findElement(By.xpath("//*[contains(text(),'First Name')]")).getText());
            	expLastName.add(driver.findElement(By.xpath("//*[contains(text(),'Last Name')]")).getText());
            	expJobRole.add(driver.findElement(By.xpath("//*[contains(text(),'Job Role ')]")).getText());
            	
            	actUserID.add(driver.findElement(By.xpath("//*[contains(text(),'User ID')]")).getText());
            	actUserName.add(driver.findElement(By.xpath("//*[contains(text(),'User Name')]")).getText());
            	actFirstName.add(driver.findElement(By.xpath("//*[contains(text(),'First Name')]")).getText());
            	actLastName.add(driver.findElement(By.xpath("//*[contains(text(),'Last Name')]")).getText());
            	actJobRole.add(driver.findElement(By.xpath("//*[contains(text(),'Job Role ')]")).getText());

            }
            TestLog.log.info("sort according to the coloms");
            if (colomName=="User ID"){
            	Collections.sort(expUserID);
                       	
            for (int i=0;i<expUserID.size();i++) {
                
                if (!(expUserID.get(i).equals(actUserID.get(i)))) {
                                System.out.println("Coloum not sorted: " + i);
                                break;

                }else {
                	System.out.println("expected value: " + expUserID +"actual value:"+actUserID);
                }
            }
            }else if(colomName=="User Name"){
                	Collections.sort(expUserName);
                	
                  for (int j=0;j<expUserName.size();j++) {
                	
                 
               if (!(expUserName.get(j).equals(actUserName.get(j)))) {
                        System.out.println("Coloum not sorted: " + j);
                        break;

        }else {
        	System.out.println("expected value: " + expUserName +"actual value:"+actUserName);
        }
                  }
            }else if(colomName=="First Name"){
            	
                 	Collections.sort(expFirstName);
        	
            for (int k=0;k<expFirstName.size();k++) {
          	
           
         if (!(expFirstName.get(k).equals(actFirstName.get(k)))) {
                  System.out.println("Coloum not sorted: " + k);
                  break;

         }else{
        	 System.out.println("expected value: " + expFirstName +"actual value:"+actFirstName);
         }
            }
            }else        	 
        	 if(colomName=="Last Name"){
        	Collections.sort(expLastName);
        	
            for (int l=0;l<expLastName.size();l++) {
          	
           
         if (!(expLastName.get(l).equals(actLastName.get(l)))) {
                  System.out.println("Coloum not sorted: " + l);
                  break;

            }else{
            	System.out.println("expected value: " + expLastName +"actual value:"+actLastName);
            }
            }
        	 }           	
           if(colomName=="Job Role"){
            	Collections.sort(expJobRole);
            	
                for (int m=0;m<expJobRole.size();m++) {
              	
               
             if (!(expJobRole.get(m).equals(actJobRole.get(m)))) {
                      System.out.println("Coloum not sorted: " + m);
                      break;

                }else{
                	
                	System.out.println("expected value: " + expJobRole +"actual value:"+actJobRole);
                }
                }
           }else{
        	   System.out.println("Coloum not sorted ");       	   
                	
                }
		
                } catch (Exception ex) {
			TestLog.log.info("Coloum not sorted:" + ex);
		}
	}
	
	

	// This method will capture screen shots
	public void takeScreenShotofFailure(String screenShot) throws Exception {

		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
				.format(Calendar.getInstance().getTime());
		System.out.println("Before taking screen shot");
		TestLog.log.info("Before taking screen shot");
		File imageFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		System.out.println("Created imgage file");
		TestLog.log.info("Created imgage file");
		String screenShotName = screenShot + "_" + timeStamp + ".png";

		// It will store all the screenshots in test-output/screenshots folder
		String destDir = System.getProperty("user.dir") + "/"
				+ "test-output/ScreenShots";
		new File(destDir).mkdirs();
		String destFile = destDir + "/" + screenShotName;
		FileUtils.copyFile(imageFile, new File(destFile));
		System.out.println("Saving file");
		TestLog.log.info("Saving file");
	}

	// this method will wait for the page load
	public void waitForPageLoad(int numberOfSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, numberOfSeconds);

		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver wdriver) {
				return ((JavascriptExecutor) driver).executeScript(
						"return document.readyState").equals("complete");
			}
		});
	}

}
