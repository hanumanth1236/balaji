package com.Banking.testes;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.stream.FileImageInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class TestBaseClass {
	
	Properties    config ;
	Properties    OR ;
	WebDriver driver;
	
	@BeforeClass
	  public void BeforeClass() throws IOException {
		//create the object for that config.Properties file
		Properties    config = new Properties();
		//if u want to access the config.properties file then we need to use FileInputStream object
		FileInputStream  fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\Banking\\Properties\\config.properties");
		//load config.property file in to config variable through load function
		config.load(fis);
		//create the object for the OR Property file
		Properties  OR = new Properties();
		//If you want to access the OR.Properties file then we need to use FileInputStream object
		FileInputStream  fiss = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\Banking\\Properties\\OR.properties");
		//load the OR.Property file in to OR variable through load function
		OR.load(fiss);
		
		if(config.getProperty("browser").equals("Firefox")) {
			driver = new FirefoxDriver();
		}else {
			System.out.println("Unable to launch the Browsers");
		}
		//Maximize the Browser
		driver.manage().window().maximize();
		
	  }

	//This is Re-Usable code / Re-Usable method for Screen shot
	
	public void takeScreenShot(String UserName){
		//Create file object for where our screen shot need to create
		 File desiredLocation = new File("C:\\Users\\Apeksh\\eclipse-workspace\\com.HR.Core1\\Screenshots\\TestFailures");
		//Convert drive object into TakeScreenShot
		 //Call the getScreenshotAs method to take screen shot file and specifying out put should come in file format
		 File   copyScreenshot  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// 
	}
	
  @AfterClass
  public void afterClass() {
  }

}
