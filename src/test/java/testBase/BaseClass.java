package testBase;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClass {
	
	public WebDriver driver;
	public Logger logger;
	
	@BeforeClass
	public void setup()
	{
		
		logger =LogManager.getLogger(this.getClass());
		
		driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	

	public String randomeString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomeNumber()
	{
		String generatednumber=RandomStringUtils.randomNumeric(10);
		return generatednumber;
	}
	
	public String randomAlphaNumeric()
	{
		String generatedstring =RandomStringUtils.randomAlphabetic(3);
		String generatednumber=RandomStringUtils.randomNumeric(3);
		
		return (generatedstring+"@"+generatednumber);
	}

}
