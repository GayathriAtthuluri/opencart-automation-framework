package com.opencart.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {
	
	
	public static String captureScreenshot(WebDriver driver , String testName)
	{
		
		// Generate timestamp
		
		String timeStamp= new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		
		// screenshot path
		
		String destination=System.getProperty("user.dir")+"/Screenshots/"+testName+"_"+timeStamp+".png";
		
		//capture screenshot
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File target= new File(destination);
		
		
		try {
			FileUtils.copyFile(source, target);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		
		
		
		
		return destination;
		
	}

}

