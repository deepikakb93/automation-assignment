package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.Env;

public class PropertiesUtil {
	//read properties file
	public static String readProperty(Env env,String propertyName)  {
	File propFile= new File(System.getProperty("user.dir")+"//config//"+env+".properties");
	FileReader fileReader=null;
	Properties property = new Properties();
	try {
		fileReader = new FileReader(propFile);
		property.load(fileReader);
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	}
	 catch (IOException e) {

		e.printStackTrace();
	}
	String value=property.getProperty(propertyName.toUpperCase());
	return value;
}
}
