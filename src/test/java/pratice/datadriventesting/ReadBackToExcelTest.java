package pratice.datadriventesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import    org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

public class ReadBackToExcelTest {

	public static void main(String[] args) throws Throwable, IOException {
		// TODO Auto-generated method stub
		 FileInputStream fis = new FileInputStream("./src/test/resources/testScriptData2.xlsx");
			
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("Sheet1");
			Row row=sh.getRow(1);
		    Cell cel=row.createCell(4);
		    cel.setCellType(CellType.STRING);
		    cel.setCellValue("Pass");
		    
		   FileOutputStream fos=new FileOutputStream("./src/test/resources/testScriptData2.xlsx");
		    wb.write(fos);
		    wb.close();
		    System.out.println(".......Executed...........");

	}

}
