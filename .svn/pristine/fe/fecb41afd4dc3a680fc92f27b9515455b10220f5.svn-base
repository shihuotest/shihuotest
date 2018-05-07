package shihuo.serve;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateExcelFile {

	public static void main(String[] args) throws IOException {
		List<String> id = new LinkedList<String>();
		id.add("123");
		id.add("234");
		id.add("456");
		createExcelData("C:\\Users\\gaohuajin\\Desktop\\brandExpect.xlsx","test1",id);
	}
	public static boolean createExcelFile(String filePath) throws IOException{
		File file = new File(filePath);
		if (file.exists()) {
			return false;
		}else {
			XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
//			XSSFSheet sheet = xssfWorkbook.createSheet("case");
			FileOutputStream fout = new FileOutputStream(filePath);  
			xssfWorkbook.write(fout);  
			fout.close();
			return true;
		}
	}
	public static boolean createExcelData(String filePath,String sheetName,List<String> values) throws IOException{
		createExcelFile(filePath);
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream(filePath));
		XSSFSheet sheet = xssfWorkbook.createSheet(sheetName);
		for(int i=0;i<values.size();i++){
			XSSFRow xssfRow = sheet.createRow(i);
			xssfRow.createCell(0).setCellValue(values.get(i));
			xssfRow.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
		}
		FileOutputStream fout = new FileOutputStream(filePath);  
		xssfWorkbook.write(fout);  
		fout.close();  
		return true;
	}

}
