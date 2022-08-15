package iTexttPdf;

import java.io.File;
import java.nio.file.Files;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Pdf;
import org.openqa.selenium.PrintsPage;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.print.PrintOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pdfreportgeneration 
{
	public static void main(String[] args) throws Exception
	{
		WebDriverManager.chromedriver().setup();
		
		// Declaring and initializing the HtmlUnitWebDriver
		HtmlUnitDriver unitDriver = new HtmlUnitDriver();
        
		System.out.println("Execution started");
		
        // open demo site webpage
        unitDriver.get("https://demoqa.com/");
		
        //Print the title of the page
        System.out.println("Title of the page is -> " + unitDriver.getTitle());
        
     // Take screenshot
        File screenshot = ((TakesScreenshot)unitDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyDirectory(screenshot, new File("./Screenshots/image.png"));
        System.out.println("Screenshot saved in folder screenshots");
        
     //PDF File Generation
        unitDriver.get("file:///D:/C%20driver%20backup/Mohs10Tech/Mohs10%20Framework/Report/AutomationReport.html#");
		
		Pdf pdf = ((PrintsPage) unitDriver).print(new PrintOptions());
		
		Files.write(java.nio.file.Paths.get("./PDF Files/graphicalautomationreport230.pdf"),OutputType.BYTES.convertFromBase64Png(pdf.getContent()));
	
		System.out.println("PDF File Generated Successfully");
        
	}

}
