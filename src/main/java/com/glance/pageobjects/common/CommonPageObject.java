/*
 * author: Omar Careem
 * date created: 11/09/2016
 */


package com.glance.pageobjects.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.glance.pageobjects.logs.TestLog;

public class CommonPageObject extends BasePage{
	
	int currentMonthNumber;

	public CommonPageObject(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(id="example_first")
	WebElement btnFirst;
	
	@FindBy(id="example_previous")
	WebElement btnPrevious;
	
	@FindBy(id="example_next")
	WebElement btnNext;
	
	@FindBy(id="example_last")
	WebElement btnLast;
	
	//Page Navigation - First page
		public void FirstPageNavigation(){
			if(btnFirst.isEnabled()){
				btnFirst.click();
			}else{
				System.out.println("Page Navigation button Disable");
			}
		}
		
		
	//Page Navigation - Previous page
		public void previousPageNavigation(){
			if(btnPrevious.isEnabled()){
				btnPrevious.click();
			}else{
				System.out.println("Page Navigation button Disable");
			}
		}

	//Page Navigation - Next page
		public void NextPageNavigation(){
			if(btnNext.isEnabled()){
				btnNext.click();
			}else{
				System.out.println("Page Navigation button Disable");
				}
		}
			
	//Page Navigation - Last page
		public void LPageNavigation(){
			if(btnLast.isEnabled()){
				btnLast.click();
			}else{
				System.out.println("Page Navigation button Disable");
			}
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
