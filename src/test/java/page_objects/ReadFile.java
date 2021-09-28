package page_objects;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
    public String[][] authorizationKRP() throws IOException {
        FileInputStream fis = new FileInputStream("Login_Base.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("account");
        int totalRows = sheet.getLastRowNum() - 1;
        int totalColumns = sheet.getRow(0).getPhysicalNumberOfCells();
        String obj[][] = new String[totalRows][totalColumns];
        for (int i = 0; i < totalRows; i++) {
            obj[i][0] = sheet.getRow(i + 1).getCell(0).getStringCellValue();
            obj[i][1] = sheet.getRow(i + 1).getCell(1).getStringCellValue();
            System.out.println(obj[i][0]);
        }
        return obj;
    }
}
