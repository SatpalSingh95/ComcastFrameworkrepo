package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	public String getDataFromPropertiesFile(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream("./configAppData/commondata.properties");
		Properties pObj=new Properties();
		//load all the keys
		pObj.load(fis);
		
		//read/capture the data
		String data=pObj.getProperty(key);
		
		return data;
		
		
	}

}
