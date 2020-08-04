package com.vtigercrm.Orgtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtigercrm.genericutils.Excel_lib;
import com.vtigercrm.genericutils.File_lib;
import com.vtigercrm.genericutils.WebDriver_utils;

/**
 * 
 * @author shashi
 *
 */
public class Delete_org_test {

	@Test
	public void Delete_org() throws Throwable {
		WebDriver_utils wlib = new WebDriver_utils();
		File_lib flib = new File_lib();
		Excel_lib elib = new Excel_lib();

		/* Read data from prop file */
		String USERNAME = flib.get_property("username");
		String PASSWORD = flib.get_property("password");
		String URL = flib.get_property("url");
		String BROWSER = flib.get_property("browser");
		String imp_wait = flib.get_property("iw");
		long wait_time = Long.parseLong(imp_wait);

		/* Read Test_script specific data */
		String Org_name = elib.fetch_excel_data("org", 1, 2) + "_" + wlib.get_random_num();
		String Org_type = elib.fetch_excel_data("org", 1, 3);
		// int index = Integer.parseInt(Org_type);

		/* Step 1 ; launch the browser */
		System.setProperty("webdriver.gecko.driver", "./softwares/geckodriver.exe");
		WebDriver driver;
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new FirefoxDriver();
		}
		wlib.Wait_till_pgloads(driver, wait_time);
		driver.get(URL);

		/* Step2 - login */
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		/* step3 - navigate to organisation page */
		driver.findElement(By.linkText("Organizations")).click();

		/* step4 - navigate to create org-page */
		driver.findElement(By.xpath("//img[@alt= 'Create Organization...']")).click();

		/* step 5 - create organisation */
		driver.findElement(By.name("accountname")).sendKeys(Org_name);
		WebElement we = driver.findElement(By.xpath("//select[@name = 'accounttype']"));
		wlib.sel_from_dropdown(we, Org_type);
		driver.findElement(By.xpath("//input[@title = 'Save [Alt+S]']")).click();

		/* step 6 - delete the organisation */
		driver.findElement(By.xpath("(//input[@class = 'crmbutton small delete'])[1]")).click();
		wlib.confirm_alert(driver);

		/* step 7 - confirm delete */
		driver.findElement(By.xpath("//input[@name = 'search_text']")).sendKeys(Org_name);
		WebElement ele2 = driver
				.findElement(By.xpath("//div[@id = 'basicsearchcolumns_real']/select[@id = 'bas_searchfield']"));
		wlib.sel_from_dropdown(ele2, 1);
		driver.findElement(By.xpath("//div[@id = 'basicsearchcolumns_real']/../following-sibling::td[1]//input"))
				.click();
		WebElement we3 = driver.findElement(By.xpath("//span[@class = 'genHeaderSmall']"));
		if (we3.isDisplayed()) {
			System.out.println("Organisation is successfully deleted");
		} else {
			Assert.fail();
		}

	}

}
