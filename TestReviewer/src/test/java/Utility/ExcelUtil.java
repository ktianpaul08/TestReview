package Utility;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	 public HashMap<String, String> getData(String feature, String testCaseId) {
	        File file = null;
	        FileInputStream fin = null;
	        XSSFWorkbook workbook = null;
	        XSSFSheet sheet = null;
	        final String excelPath = System.getProperty("user.dir") + "/src/test/resources/TestData/TestData.xlsx";

	        HashMap<String, String> dict = new LinkedHashMap<String, String>();

	        file = new File(excelPath);
	        // Checking whether the file exists or not

	        if (!file.exists()) {
	            System.out.println("File Doesn't Exists! " + excelPath);
	        }

	        // Reading the file
	        try {
	            fin = new FileInputStream(file);
	            workbook = new XSSFWorkbook(fin);
	        } catch (FileNotFoundException e) {
	            System.out.println(e.getMessage());
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        } finally {
	            if (fin != null) {
	                try {
	                    fin.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }

	        sheet = workbook.getSheet(feature);

	        // DataFormatter contains methods for formatting the value stored in an
	        // Cell.
	        DataFormatter dataFormatter = new DataFormatter();
	        Row row = null;

	        // Searching for the matching testcase ROW in the test data sheet
	        for (int rowIndex = 0; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
	            row = sheet.getRow(rowIndex);
	            if (row != null) {
	                Cell first = row.getCell(0);

	                if (first != null) {
	                    String firstCellValue = dataFormatter.formatCellValue(first);
	                    if (firstCellValue.equals(testCaseId)) {
	                        break;
	                    }
	                }
	            }
	        }

	        // Creating the key value pair for already searched testcase row in the
	        // above iteration
	        if (row != null) {
	            for (int colIndex = 0; colIndex < row.getLastCellNum(); colIndex++) {
	                if (sheet.getRow(0).getCell(colIndex) == null) {
	                    break;
	                }
	                String key = dataFormatter.formatCellValue(sheet.getRow(0).getCell(colIndex));
	                String value = dataFormatter.formatCellValue(row.getCell(colIndex));

	                dict.put(key, value);

	            }
	        }

	        // Closing the workbook
	        try {
	            workbook.close();
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        }

	        return dict;
	        
	    }
	
}
