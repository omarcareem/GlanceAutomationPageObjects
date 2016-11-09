/*
 * author: Omar Careem
 * date created: 11/09/2016
 */

package com.glance.pageobjects.common;

import org.openqa.selenium.WebDriver;

public class BasePage {

	// Initializing the Webdriver
	public WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;

	}

}
