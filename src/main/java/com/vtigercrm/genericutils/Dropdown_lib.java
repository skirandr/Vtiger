package com.vtigercrm.genericutils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Dropdown_lib {
	
	public static void select_option(WebElement we , String option)
	{
		Select s = new Select(we);
		s.selectByVisibleText(option); 
	}

}
