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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.glance.pageobjects.logs.TestLog;

public class CommonPageObject extends BasePage{

	public CommonPageObject(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
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
