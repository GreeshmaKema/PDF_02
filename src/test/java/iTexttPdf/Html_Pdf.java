package iTexttPdf;
/** Program to Create a PDF  file and Save in root directory in java **/

import java.io.FileOutputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;

public class Html_Pdf 
{
	public static void itextpdf() throws Exception 
	{
		String File = "./Screenshots/newpdffile.pdf";
		Document doc = new Document();
		PdfWriter.getInstance(doc, new FileOutputStream(File)); 
		
		doc.open();
		doc.add(new Paragraph("Succesfully created pdf file when selenium could not find the browser element"));
		doc.add(new Paragraph("No Error found"));
		doc.close();
		
	}
	
	public static void main(String args[]) throws Exception
	{
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Tharun/eclipse-workspace/.metadata/pAInITe/Report/AutomationReport.html");
		
		try {
			driver.findElement(By.name("7"));
			System.out.println("Program Running perfect");
			
			
		} catch (Exception e) {
			
			itextpdf();
			System.out.println("pdf file generated  ");
			
		}
		driver.close();
		
	}

}
