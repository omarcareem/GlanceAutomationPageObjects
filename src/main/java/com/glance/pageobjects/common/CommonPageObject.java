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
import java.util.Comparator;
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

	int currentMonthNumber;
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

	//@FindBy(name = "example_length")
	//WebElement dropDown;

	@FindBy(id = "example_info")
	WebElement lblRecordCount;
	
	
	By dropDown = By.xpath("//label/select[@name='example_length']");
	By middlePaginationElement = By.xpath("//span/a");
	By middlePaginationCuttent = By.xpath("//a[@ class='paginate_button current']");
	By txtSearch = By.xpath("//input[@type='search']");
	By tblExample = By.xpath("//table[@id='example']");
	

	// Page Navigation - with String value
	public void pageNavigationString(String pagination) {
		
		try {
			TestLog.log.info("Check Next Button eneble");
			if(pagination.equalsIgnoreCase("Next") ){
				if (btnNext.isEnabled()) {
					TestLog.log.info("Click on Next Button");
					btnFirst.click();
					btnNext.click();
				} else {
					TestLog.log.info("Page Navigation button Next Disable");
				}
				TestLog.log.info("Check Pervios Button eneble");
			}else if(pagination.equalsIgnoreCase("Previous") ){
				if (btnPrevious.isEnabled()) {
					TestLog.log.info("Click on Previous Button");
					btnLast.click();
					btnPrevious.click();
				} else {
					TestLog.log.info("Page Navigation button Previous Disable");
				}
			TestLog.log.info("Check Pervios Button eneble");
		}else if(pagination.equalsIgnoreCase("First") ){
			if (btnFirst.isEnabled()) {
				TestLog.log.info("Click on First Button");
				btnFirst.click();
			} else {
				TestLog.log.info("Page Navigation button First Disable");
			}
			TestLog.log.info("Check Pervios Button eneble");
		}else if(pagination.equalsIgnoreCase("Last") ){
			if (btnLast.isEnabled()) {
				TestLog.log.info("Click on Last Button");
				btnLast.click();
			} else {
				TestLog.log.info("Page Navigation button Last Disable");
			}
			TestLog.log.info("Check Pervios Button eneble");
		}else{
			System.out.println("Page navigation not success");
		}
			
		} catch (Exception ex) {
			TestLog.log.info("Could not find page Navigation button" + ex);
		}
	}
	
	//Page navigation for middle paginations
	public void pageNavigationMiddle(int i) {
		TestLog.log.info("Check middle buttons eneble");
		try{
			if(i>0){
				List<WebElement> middlePpaginationEle = driver.findElements(middlePaginationElement);
				TestLog.log.info("checkif pagination link exists");

					TestLog.log.info("click on pagination link ");
					middlePpaginationEle.get(i-1).click();
					
				} 	else{
					System.out.println("Page navigation not success");
				}
		}catch (Exception ex) {
			TestLog.log.info("Could not find page Navigation button" + ex);
		}	
		
	}

	// Page navigation verification String 
	public boolean verifyPageNavigationString(String pagination, int actualRowCount,int actualpageNumbers ) {
		TestLog.log.info("page navigation verification");
		String recordCount = null;
		int currentPageCount = 0;
		String expRecordCount = null;
		int currentRecordCount = 0;
		int startingcount = 0;
		String currentPage=null;
		
		
		boolean flag = false;
		try {
			TestLog.log.info("get actual page number");
			if(pagination.equalsIgnoreCase("First")){
				
				recordCount = lblRecordCount.getText();
				
				expRecordCount =("Showing 1 to 10 of "+actualRowCount + " entries");
				
				if(recordCount.equalsIgnoreCase(expRecordCount)){
					flag = true;
					
				}
			}else if(pagination.equalsIgnoreCase("Last")){
				
				recordCount = lblRecordCount.getText();
				currentPageCount = actualRowCount/10;
				currentRecordCount = currentPageCount*10;			
							
				if(actualRowCount<currentRecordCount){
					
					startingcount =	currentRecordCount-9;
				}else{
					startingcount = (currentRecordCount +1);
				}
				
				expRecordCount = ("Showing "+startingcount+" to "+ actualRowCount+" of "+actualRowCount + " entries");
				if(recordCount.equalsIgnoreCase(expRecordCount)){
					flag = true;
				} 
			}else  if(pagination.equalsIgnoreCase("Next")){
					
						TestLog.log.info("get actual page number");
											
							recordCount = lblRecordCount.getText();
							currentPage = driver.findElement(By.xpath("//span/a[@class='paginate_button current']")).getText(); 
							currentPageCount =Integer.parseInt(currentPage);
							
							expRecordCount =("Showing "+(((currentPageCount)*10)-9) +" to " +((currentPageCount)*10)+" of "+actualRowCount + " entries");
							if(recordCount.equalsIgnoreCase(expRecordCount)){
								flag = true;
							
					}
						
				}else if(pagination.equalsIgnoreCase("Previous")){
					
						TestLog.log.info("get actual page number");
											
							recordCount = lblRecordCount.getText();
							currentPage = driver.findElement(By.xpath("//span/a[@class='paginate_button current']")).getText(); 
							currentPageCount =Integer.parseInt(currentPage);
							
							if(recordCount.equalsIgnoreCase("Showing "+((currentPageCount*10)-9) +" to " +(currentPageCount*10)+" of "+actualRowCount + " entries")){
								flag = true;
							}
					
				}else{
					System.out.println("no page found");
				}
				
		} catch (Exception ex) {
			ex.printStackTrace();
			TestLog.log.info("Could not find page" + ex);
		}
		return flag;
	}

	// Page navigation verification String 
		public boolean verifyPageNavigationMiddle(int middlePagination, int actualRowCount){
			String recordCount = null;
			int currentPageCount = 0;
			String expRecordCount = null;
			String currentPage=null;
			boolean flag = false;
			
			
			try{
				
				if ((middlePagination*10)<actualRowCount){
					recordCount = lblRecordCount.getText();
					currentPage = driver.findElement(By.xpath("//span/a[@class='paginate_button current']")).getText(); 
					currentPageCount =Integer.parseInt(currentPage);
					
					expRecordCount =("Showing "+((currentPageCount*10)-9) +" to " +(currentPageCount*10)+" of "+actualRowCount + " entries");
					if(recordCount.equalsIgnoreCase(expRecordCount)){
						flag = true;
						
					}
				}else{
					recordCount = lblRecordCount.getText();
					currentPage = driver.findElement(By.xpath("//span/a[@class='paginate_button current']")).getText(); 
					currentPageCount =Integer.parseInt(currentPage);
					
					expRecordCount =("Showing "+((currentPageCount*10)-9) +" to " +actualRowCount+" of "+actualRowCount + " entries");
					if(recordCount.equalsIgnoreCase(expRecordCount)){
						flag = true;
						
					}
				}
				
			}catch (Exception ex) {
				ex.printStackTrace();
				TestLog.log.info("Could not find page" + ex);
			}
		
			return flag;
		}
		
	// select the table entry count from the drop down
	public void selectDropDuwn(String dropDownValue) {
		
		try {
			TestLog.log.info("check dropdown exist");
			if (driver.findElement(dropDown).isDisplayed()) {
				TestLog.log.info("select from dropdown list");
				Select drpRecords = new Select(driver.findElement(dropDown));
				drpRecords.selectByVisibleText(dropDownValue);
			} else {
				TestLog.log.info("dropdown does not exist");
				System.out.println("Table Entry dropdown not visible");
			}

		} catch (Exception ex) {
			TestLog.log.info("Could not find dropdown" + ex);
		}

	}

	// expected result of the drop down selection
	public int expectedRowCountDropDown(int actualRawCount){
		
				TestLog.log.info("verify selection");
				
				Select visibleRecords= new Select(driver.findElement(dropDown));
				
				TestLog.log.info("get selection from drop down");
				WebElement element = visibleRecords.getFirstSelectedOption();
				String selectedValue= element.getText();
				int expectedRowCount=0;
				
				try{							
				TestLog.log.info("get actual row count");
				if (actualRawCount <= 10){
					if(selectedValue.equalsIgnoreCase("10")){
						expectedRowCount = actualRawCount;
							} else if(selectedValue.equalsIgnoreCase("25")){
								expectedRowCount = 	actualRawCount;					
							}else if(selectedValue.equalsIgnoreCase("50")){
								expectedRowCount = 	actualRawCount;						
							}else if(selectedValue.equalsIgnoreCase("100")){
								expectedRowCount = 	actualRawCount;						
							}else{
								TestLog.log.info("no record added");
								System.out.println("No records appeared");
							}
				}
				if (actualRawCount > 10 && actualRawCount < 25){
					if(selectedValue.equalsIgnoreCase("10")){
						expectedRowCount = 	10;
							} else if(selectedValue.equalsIgnoreCase("25")){
								expectedRowCount = 	actualRawCount;					
							}else if(selectedValue.equalsIgnoreCase("50")){
								expectedRowCount = 	actualRawCount;						
							}else if(selectedValue.equalsIgnoreCase("100")){
								expectedRowCount = 	actualRawCount;						
							}else{
								System.out.println("No records appeared");
							}
				}
				if (actualRawCount >= 25 && actualRawCount < 50){
					if(selectedValue.equalsIgnoreCase("10")){
						expectedRowCount = 	10;
							} else if(selectedValue.equalsIgnoreCase("25")){
								expectedRowCount = 	25;					
							}else if(selectedValue.equalsIgnoreCase("50")){
								expectedRowCount = 	actualRawCount;						
							}else if(selectedValue.equalsIgnoreCase("100")){
								expectedRowCount = 	actualRawCount;						
							}else{
								System.out.println("No records appeared");
							}
				}
				if (actualRawCount >= 50 && actualRawCount < 100){
					if(selectedValue.equalsIgnoreCase("10")){
						expectedRowCount = 	10;
							} else if(selectedValue.equalsIgnoreCase("25")){
								expectedRowCount = 	25;					
							}else if(selectedValue.equalsIgnoreCase("50")){
								expectedRowCount = 	50;						
							}else if(selectedValue.equalsIgnoreCase("100")){
								expectedRowCount = 	actualRawCount;						
							}else{
								System.out.println("No records appeared");
							}
				}
				if (actualRawCount >= 100){
					if(selectedValue.equalsIgnoreCase("10")){
						expectedRowCount = 	10;
							} else if(selectedValue.equalsIgnoreCase("25")){
								expectedRowCount = 	25;					
							}else if(selectedValue.equalsIgnoreCase("50")){
								expectedRowCount = 	50;						
							}else if(selectedValue.equalsIgnoreCase("100")){
								expectedRowCount = 	100;						
							}else{
								System.out.println("No records appeared");
							}
				}
			}catch (Exception ex) {
				TestLog.log.info("Could not find dropdown" + ex);
			}
				return expectedRowCount;
			
		}

	//Actual result from the drop down selection
	public int actualRowCountDropDown(String dropDownValue){
		int actualRowCountDropDown = 0;
		List<WebElement> rowCount = driver.findElements(By.tagName("tr"));
		
		if(!(dropDownValue==null)){
			actualRowCountDropDown = (rowCount.size()-1);
		}
		return actualRowCountDropDown;
	}
	
		
	// validate actual row count of the full table
	public int actualRowCount() {
		int actualRawCount = 0;
		List<WebElement> paginationCount = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a"));
		int rowCountPagination = paginationCount.size();
		try {
			
			if (rowCountPagination > 0) {
				TestLog.log.info("click on pagination link ");
				for (int i = 0; i < rowCountPagination; i++) {
					driver.findElements(By.xpath("//div[@id='example_paginate']/span/a")).get(i).click();
					actualRawCount = (actualRawCount + driver.findElements(By.tagName("tr")).size())-1;
				}
				
				btnFirst.click();
				
			}

		} catch (Exception ex) {
			
			TestLog.log.info("Could not find table" + ex);
		}
		return actualRawCount;
	}

	// Page Count verification - Actual page count
	public int actualPageCount() {
		TestLog.log.info("get actual page count");
		int actualpageNumbers = 0;
		try{
			actualpageNumbers = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a")).size();
			
		}catch (Exception ex) {
			ex.printStackTrace();
			TestLog.log.info("Could not find page count" + ex);
		}
		return actualpageNumbers;
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
	
	//verify search result
	public int actualSearchResult(String keyWord)throws Exception{
		int actualSearch = 0;
		
		try {
			if(!(keyWord==null)){
				actualSearch = ((driver.findElements(By.tagName("tr")).size())-1);
								
			}else{
				System.out.println("keyWord is null");
			}
			
			
		}catch(Exception ex){
			TestLog.log.info("Could not find search result" + ex);
			throw ex;
		}
		return actualSearch;
	}
		
	//sorting the table according to the coloum	
	public void tableSort(String colomName){
		TestLog.log.info("sort according to the colom ");
		try{
			driver.findElement(By.xpath("//*[contains(text(),'"+colomName+"')]")).click();
		}catch (Exception ex) {
			TestLog.log.info("sorting fails" + ex);
		}
	}
	
	//verify sorting the table according to the coloum	
	public boolean verifyTableSort(String colomName){
					
		TestLog.log.info("verification sort according to the colom ");
		boolean flag = false;
		
        List<String> expColom = new ArrayList();
                
        List<String> actColom = new ArrayList();
        
        List<String> tempColom = new ArrayList();
        
        try{
			TestLog.log.info("get the elements to an arrey"); 
        
        if(colomName.contains("User ID")){
        	List<WebElement> elementUserID= driver.findElements(By.xpath("//tbody/tr/td[2]"));
        	
        	for(WebElement ele: elementUserID){
        		expColom.add(ele.getText());
        		actColom.add(ele.getText());
        		
        	}
        	
        	TestLog.log.info("sort according to the colom as expected");
        	Collections.sort(expColom,new Comparator<String>() {

				public int compare(String o1, String o2) {
						int a = Integer.parseInt(o1);
						int b = Integer.parseInt(o2);
						
					return a-b;
				}
			});
        	System.out.println(expColom);
        	System.out.println(actColom);	
        	
        	
        	for (String i:expColom) {
                
                if ((expColom.equals(actColom))) {
                                System.out.println("User ID coloum sorted");
                                flag=true;
                                break;                               

                }
        	}
        	
        }else if(colomName.contains("User Name")){
        	List<WebElement> elementUserID= driver.findElements(By.xpath("//tbody/tr/td[3]"));
        	
        	for(WebElement ele: elementUserID){
        		expColom.add(ele.getText());
        		actColom.add(ele.getText());
        	}
        	
        	TestLog.log.info("sort according to the colom as expected");
        	Collections.sort(expColom);
        	System.out.println(expColom);
        	System.out.println(actColom);	
        	
        	
        	for (String i:expColom) {
                
                if ((expColom.equals(actColom))) {
                                System.out.println("User Name coloum sorted");
                                flag=true;
                                break;                               

                }
                TestLog.log.info("sort according to the colom as expected");
            	Collections.sort(expColom);
            	System.out.println(expColom);
            	System.out.println(actColom);	
            	
            	
            	for (String j:expColom) {
                    
                    if ((expColom.equals(actColom))) {
                                    System.out.println("User Name coloum sorted");
                                    flag=true;
                                    break;                               

                    }
            	} 
        	}
        }else if(colomName.contains("First Name")){
            	List<WebElement> elementUserID= driver.findElements(By.xpath("//tbody/tr/td[4]"));
            	
            	for(WebElement ele: elementUserID){
            		expColom.add(ele.getText());
            		actColom.add(ele.getText());
            	}
                TestLog.log.info("sort according to the colom as expected");
            	Collections.sort(expColom);
            	System.out.println(expColom);
            	System.out.println(actColom);	
            	
            	
            	for (String j:expColom) {
                    
                    if ((expColom.equals(actColom))) {
                                    System.out.println("First Name coloum sorted");
                                    flag=true;
                                    break;                               

                    }
            	} 
        }else if(colomName.contains("Last Name")){
        	List<WebElement> elementUserID= driver.findElements(By.xpath("//tbody/tr/td[5]"));
        	
        	for(WebElement ele: elementUserID){
        		expColom.add(ele.getText());
        		actColom.add(ele.getText());
        	}
            TestLog.log.info("sort according to the colom as expected");
        	Collections.sort(expColom);
        	System.out.println(expColom);
        	System.out.println(actColom);	
        	
        	
        	for (String k:expColom) {
                
                if ((expColom.equals(actColom))) {
                                System.out.println("Last Name coloum sorted");
                                flag=true;
                                break;                               

                }
        	} 
        }else if(colomName.contains("Job Role")){
        	List<WebElement> elementUserID= driver.findElements(By.xpath("//tbody/tr/td[6]"));
        	
        	for(WebElement ele: elementUserID){
        		expColom.add(ele.getText());
        		actColom.add(ele.getText());
        	}
            TestLog.log.info("sort according to the colom as expected");
        	Collections.sort(expColom);
        	System.out.println(expColom);
        	System.out.println(actColom);	
        	
        	
        	for (String l:expColom) {
                
                if ((expColom.equals(actColom))) {
                                System.out.println("Job Role coloum sorted");
                                flag=true;
                                break;                               

                }
        	} 
        } else {System.out.println("coloum does not exist");}
        
                }catch (Exception ex) {
			TestLog.log.info("Coloum not sorted:" + ex);
		}
		
		return flag;
	}
	
	// This method will capture screen shots
	public String takeScreenShotofFailure(String screenShot, WebDriver driver) throws Exception {

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
		return destFile;
		
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
	
	
		public int getCurrentCalendarMonthinInt(String currentMonth){
	        
	       
	        //String currentMonth= Calendar.getInstance().get(Calendar.MONTH);
	        
	        if(currentMonth=="Jan"){
	               currentMonthNumber=1;
	        }else if(currentMonth=="Feb"){
	               currentMonthNumber=2;
	        }else if(currentMonth=="Mar"){
	               currentMonthNumber=3;
	        }else if(currentMonth=="Apr"){
	               currentMonthNumber=4;
	        }else if(currentMonth=="May"){
	               currentMonthNumber=5;
	        }else if(currentMonth=="Jun"){
	               currentMonthNumber=6;
	        }else if(currentMonth=="Jul"){
	               currentMonthNumber=7;
	        }else if(currentMonth=="Aug"){
	               currentMonthNumber=8;
	        }else if(currentMonth=="Sep"){
	               currentMonthNumber=9;
	        }else if(currentMonth=="Oct"){
	               currentMonthNumber=10;
	        }else if(currentMonth=="Nov"){
	               currentMonthNumber=11;
	        }else if(currentMonth=="Dec"){
	               currentMonthNumber=12;
	        }
	        
	        return currentMonthNumber;
	 }

}
