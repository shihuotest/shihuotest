package shihuo.serve;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RequestData {
	public static Map<String, String> getRequestModelData(String paths) throws FileNotFoundException, IOException{
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream(paths));
		XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
		Map<String, String> map = new LinkedHashMap<String, String>();
		for(int i= 1;i<xssfSheet.getLastRowNum()+1;i++)
		{
			XSSFRow row = xssfSheet.getRow(i);
			row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);//这个是把某个单元格转换成文本格式
			map.put(row.getCell(0).toString(), row.getCell(1).toString());
		}
		return map;
	}
	public static Map<String, String> getRequestValueData(String paths) throws FileNotFoundException, IOException{
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream(paths));
		XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
		
		
		Map<String, String> map = new LinkedHashMap<String, String>();
		for(int i= 0;i<xssfSheet.getLastRowNum()+1;i++)
		{
			XSSFRow row = xssfSheet.getRow(i);
			row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);//这个是把某个单元格转换成文本格式
			map.put(Integer.toString(i), row.getCell(0).toString());
		}
		return map;
	}
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Map<String, String> test = 	getRequestValueData("C:\\Users\\gaohuajin\\Desktop\\app_swoole_zone\\price_value.xlsx");
		int i = 1;
		System.out.println("测试"+test.get(""+i).toString());
		for (String keys : test.keySet()) {
			System.out.println("keys= "+keys+",values= "+test.get(keys));
		}
		String a = "http://www.baidu.com";
		String b = "?id=13";
		for(int j = 0 ; j < 5 ; j++){
			System.out.println(a);
			a = b;
		}
	}
}