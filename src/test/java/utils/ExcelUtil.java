package utils;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public  ExcelUtil(String excelPath, String sheetName) {
		try {
		workbook = new XSSFWorkbook(excelPath);
		sheet = workbook.getSheet(sheetName);
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		
	}
	
	
	public static void getCellData(int rowNum , int cellNum) {

			String cellValue = sheet.getRow(1).getCell(0).getStringCellValue();
			System.out.println(cellValue);
			double numericValue = sheet.getRow(1).getCell(2).getNumericCellValue();
			System.out.println(numericValue);

			// this formatter keeps the information as it is. it could be string , double, int. 
			// for example numercValue is converted to double , but formatter keeps int.
			DataFormatter formatter = new DataFormatter();
			Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(cellNum));
			System.out.println(value);
		
	}
   
	public static void getRowCount() {
		
//			another way to find the path of the project and use it instead of dot. 
//			String projectDirectory = System.getProperty("user.dir");
//			System.out.print(projectDirectory);
//			String excelPath = projectDirectory +"/data/TestData.xlsx";

//			String excelPath = "./data/TestData.xlsx";
//			XSSFWorkbook workbook = new XSSFWorkbook(excelPath);
//			XSSFSheet sheet = workbook.getSheet("Sheet1");
		
			int rowNumber = sheet.getPhysicalNumberOfRows();
			System.out.println("Number of rows is : " + rowNumber);
			
		
	}
}
