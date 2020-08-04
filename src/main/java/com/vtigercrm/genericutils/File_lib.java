package com.vtigercrm.genericutils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * 
 * @author shashi
 *
 */
public class File_lib {
/**
 * USed to fetch the values from property file based on the key
 * @param key
 * @return
 * @throws IOException
 */
	public String get_property(String key) throws IOException
	{
	  FileInputStream fis = new FileInputStream("./test_data/commondata.properties");
	  Properties p = new Properties();
	  p.load(fis);
	  
	 String value = p.getProperty(key);
	 return value;
	  
			  
	}
}
