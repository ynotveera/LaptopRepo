package week5.day2;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LearnExcelRead {

	public static String[][] readExcelData(String fileName) throws InvalidFormatException, IOException {
		// TODO Auto-generated method stub
		XSSFWorkbook workbook = new XSSFWorkbook(new File("./excel/"+fileName+".xlsx"));
		XSSFSheet worksheet = workbook.getSheet("Sheet1");
		int lastRowNum = worksheet.getLastRowNum();
		short lastCellNum = worksheet.getRow(0).getLastCellNum();
		String[][] data = new String[lastRowNum][lastCellNum];
		for (int i = 1; i <= lastRowNum; i++) {
			XSSFRow row = worksheet.getRow(i);
			for (int j = 0; j <lastCellNum ; j++) {
				XSSFCell cell = row.getCell(j);
				data[i-1][j] = cell.getStringCellValue();
				}

		}
		workbook.close();
		return data;
	}

}
