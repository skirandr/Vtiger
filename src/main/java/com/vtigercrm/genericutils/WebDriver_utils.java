package com.vtigercrm.genericutils;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author shashi
 *
 */
public class WebDriver_utils {

	public void moveMouse_to_element_and_click(WebDriver driver , WebElement ele)
	{
		Actions act = new Actions(driver);
		act.moveToElement(ele).click().perform();
	}
	
	public void waitForElemnetVsibility(WebDriver driver, WebElement expElemnet) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(expElemnet));
	}
	
	public int get_random_num()
	{
		Random r = new Random();
		return r.nextInt(500);
	}
	
	public void Wait_till_pgloads(WebDriver driver,long wait_time)
	{
		driver.manage().timeouts().implicitlyWait(wait_time, TimeUnit.SECONDS);
	}
	
	public void sel_from_dropdown(WebElement we , int index)
	{
		Select sel = new Select(we);
		sel.selectByIndex(index);
	}
	
	public void sel_from_dropdown(WebElement we , String text)
	{
		Select sel = new Select(we);
		sel.selectByVisibleText(text);
	}
	
	public void confirm_alert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void Page_refresh(WebDriver driver)
	{
		driver.navigate().refresh();
	}
}
