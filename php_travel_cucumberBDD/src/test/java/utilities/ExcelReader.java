package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.*;

public class ExcelReader {

    public List<Map<String, String>> getData(String excelFilePath, String sheetName) {
        List<Map<String, String>> data = new ArrayList<>();
        
        try (FileInputStream fis = new FileInputStream(new File(excelFilePath));
             Workbook workbook = WorkbookFactory.create(fis)) {
            
            Sheet sheet = workbook.getSheet(sheetName);
            Row headerRow = sheet.getRow(0);
            
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row currentRow = sheet.getRow(i);
                Map<String, String> rowMap = new LinkedHashMap<>();
                
                for (int j = 0; j < headerRow.getLastCellNum(); j++) {
                    String key = headerRow.getCell(j).getStringCellValue();

                    Cell cell = currentRow.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    String value = "";
                    if(cell.getCellType() == CellType.STRING) {
                        value = cell.getStringCellValue();
                    } else if (cell.getCellType() == CellType.NUMERIC) {
                        value = String.valueOf((int)cell.getNumericCellValue());
                    }
                    
                    rowMap.put(key, value);
                }
                data.add(rowMap);
            }
        } catch (Exception e) {
            System.out.println("Excel Reading Failed: " + e.getMessage());
        }
        return data;
    }
}