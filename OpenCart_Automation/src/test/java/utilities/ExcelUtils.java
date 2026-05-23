package utilities;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
    public static Object[][] getExcelData(String fileName, String sheetName) {
        Object[][] data = null;
        try {
            String filePath = System.getProperty("user.dir") + "//src//test//resources//testdata//" + fileName;
            FileInputStream fis = new FileInputStream(filePath);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet(sheetName);
            
            int rows = sheet.getPhysicalNumberOfRows();
            int cols = sheet.getRow(0).getLastCellNum();
            
            data = new Object[rows - 1][cols]; 
            DataFormatter formatter = new DataFormatter(); 
            
            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    data[i - 1][j] = formatter.formatCellValue(sheet.getRow(i).getCell(j));
                }
            }
            workbook.close();
            fis.close();
        } catch (Exception e) {
            System.out.println("❌ Excel read error: " + e.getMessage());
        }
        return data;
    }
}