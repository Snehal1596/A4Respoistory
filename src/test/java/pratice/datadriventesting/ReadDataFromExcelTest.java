package pratice.datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest {

	public static void main(String[] args) throws Throwable, IOException {
		// TODO Auto-generated method stub
		//1. Get the excel path location and java object of physical Excel file
		FileInputStream fis = new FileInputStream("./src/test/resources/testScriptData.xlsx");
		//2.open WorkBook in read mode
		Workbook wb = WorkbookFactory.create(fis);
		
		//3.Get the control of "Sheet1" sheet
		Sheet sh = wb.getSheet("org");
         
       
		//4.Get the control of "1st" row
		Row row = sh.getRow(1);
        
        //5.Get the control of "2nd" cell and read the String data
		//Cell cel = row.getCell(2);
		//Cell cel = row.getCell(1);
		//String data=cel.getStringCellValue();
		//String data = row.getCell(1).getStringCellValue();
		//double data = row.getCell(3).getNumericCellValue();
		String data = row.getCell(3).toString();
		System.out.println(data);
		
		//6. Close the WorkBook
	     wb.close();
	}
}
