package utils;

public class ExcelUtilsTest {

	public static void main(String [] args) {
		String excelPath = "./data/TestData.xlsx";
		String sheetName = "Sheet1";
		ExcelUtil excel = new ExcelUtil(excelPath, sheetName);
		excel.getCellData(1,0);
		excel.getRowCount();
		
	}
}
