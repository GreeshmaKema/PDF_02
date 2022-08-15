package iTexttPdf;

import java.io.File;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

public class ScreenshottoPDF 
{
	public static void main(String args[]) throws Exception
	{
		System.out.println("Execution Started");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");		
	 
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
		driver.get("file:///C:/Projects/iTexttPdf/test-output/Mohs10%20Framework%20Test%20Suite/Home%20Page%20Test%20Case.html");
	
		// Take screenshot
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("./Screenshots/img22.jpg"));

		// Create the PDF
		Document doc = new Document(PageSize.A0);
		String input = "./Screenshots/img22.jpg";
		String output = "./pdf files/newpdffile.pdf";
		
		try 
		{
			FileOutputStream fos = new FileOutputStream(output);
			PdfWriter writer = PdfWriter.getInstance(doc, fos);
			
			writer.open();
			doc.open();
			doc.add(Image.getInstance(input));
			doc.close();
			writer.close();
	}
		catch (Exception e) {
			e.printStackTrace();
		}
	
		System.out.println("PDF File Generated Successfully:Execution Ended");
		driver.quit();
	
	
	
	}
	}
	
	
	
	//The above code is showing error at getInstance
	/*Document document = new Document();
	PdfWriter.getInstance(document, new FileOutputStream("./pdf files/img2.pdf"));
	document.open();*/
	
		//The below code can be only executed in headless mode
		/*Pdf pdf = ((PrintsPage) driver).print(new PrintOptions()); 
	Files.write(java.nio.file.Paths.get("./PDF Files/graphicalautomationreport230.pdf"),OutputType.BYTES.convertFromBase64Png(pdf.getContent()));*/
	
	


	
	
	
	
	
	