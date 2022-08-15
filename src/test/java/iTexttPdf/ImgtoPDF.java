package iTexttPdf;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

public class ImgtoPDF 
{
	public static void main(String args[]) 
	{
		System.out.println("Program execution started");
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
		System.out.println("Screenshot converted into pdf");
		
	}

}
