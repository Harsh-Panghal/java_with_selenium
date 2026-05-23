package practice.testNg;

import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WriteExcelDDT {
	XSSFWorkbook workbook;
    XSSFSheet sheet;
    int rowCount = 1;

    @BeforeTest
    public void setupExcel() {
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("TestData");
        XSSFRow headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("First Name");
        headerRow.createCell(1).setCellValue("Last Name");
        headerRow.createCell(2).setCellValue("Email ID");
        
    }

    @DataProvider(name = "WriteData")
    public Object[][] getWriteData() {
        return new Object[][] {	
            {"Harsh", "Choudhary", "harsh@gmail.com"},
            {"Sam", "Singh", "sam@yahoo.com"},
            {"Reena", "Roy", "reena@gmail.com"},
            {"Rahul", "Sharma", "rahul@test.com"}
        };
    }

    @Test(dataProvider = "WriteData")
    public void writeDataToExcel(String fname, String lname, String email) {        
        XSSFRow currentRow = sheet.createRow(rowCount);
  
        currentRow.createCell(0).setCellValue(fname);
        currentRow.createCell(1).setCellValue(lname);
        currentRow.createCell(2).setCellValue(email);
        
        System.out.println("Data added for: " + fname);
        rowCount++; 
    }

    @AfterTest
    public void saveAndCloseExcel() {
        try {
            FileOutputStream file = new FileOutputStream("D:\\java_with_selenium\\Practice_TestNg\\TestData\\writeData.xlsx");            
            workbook.write(file);            
            workbook.close();
            file.close();
            
        } catch (Exception e) {
            System.out.println("File save karne me error aaya: " + e.getMessage());
        }
    }
}