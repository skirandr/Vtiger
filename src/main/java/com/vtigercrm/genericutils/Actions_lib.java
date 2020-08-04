package com.vtigercrm.genericutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Actions_lib {

	public static void find_element(WebElement we,WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.moveToElement(we).perform();
	}
	
}
