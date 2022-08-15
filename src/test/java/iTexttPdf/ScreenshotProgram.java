package iTexttPdf;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotProgram  
{
	public static void main(String args[]) throws Exception
	{
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");		
	 
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();		
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	driver.get("https://testautomationforum.com/");
	
	TakesScreenshot ts = (TakesScreenshot)driver;
	File srcfile  =  ts.getScreenshotAs(OutputType.FILE);
	
	File destfile = new File("./Screenshots/Firstimg.jpg");
	
	FileUtils.copyFile(srcfile, destfile);
	
	driver.quit();

	}
}
