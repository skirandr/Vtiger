package com.vtigercrm.Orgtest;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtigercrm.genericutils.Actions_lib;
import com.vtigercrm.genericutils.Dropdown_lib;
import com.vtigercrm.genericutils.File_lib;

public class Create_orgTest {

	@Test
	public void create_org() throws IOException {
		Random r = new Random();
		int num = r.nextInt(500);

		
		File_lib flib = new File_lib();
		/* read data */
		String orgname = "hyundai" + num;
		String industry = "Energy";
		/* step1: navigate to appln login */
		System.setProperty("webdriver.gecko.driver", "./softwares/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		String url = flib.get_property("url");
		String un = flib.get_property("un");
		String pwd = flib.get_property("pwd");
		String iw = flib.get_property("iw");
	    long wait = Long.parseLong(iw);
		driver.get(url);

		driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);

		/* step2: login to appln home page */
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@id = 'submitButton']")).click();

		/* step3: Navigate to organisations page */
		driver.findElement(By.linkText("Organizations")).click();

		/* step4: Navigate to create organisations page */
		driver.findElement(By.xpath("//img[@alt = 'Create Organization...']")).click();

		/* step5 : create organisation */
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		WebElement we = driver.findElement(By.xpath("//select[@name = 'industry']"));
		Dropdown_lib.select_option(we, industry);
		driver.findElement(By.xpath("//input[@class = 'crmbutton small save']")).click();

		/* Step6 : verify the org name */
		String orgname1 = driver.findElement(By.xpath("//span[@class = 'dvHeaderText']")).getText();
		Assert.assertTrue(orgname1.contains(orgname));

		/* step7 : logout */
		WebElement we1 = driver.findElement(By.xpath("//img[@src= 'themes/softed/images/user.PNG' ]"));
		Actions_lib.find_element(we1, driver);
		driver.findElement(By.linkText("Sign Out")).click();
	}

}
