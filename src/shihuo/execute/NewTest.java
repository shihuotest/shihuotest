package shihuo.execute;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Request;
import org.testng.Assert;
import org.testng.annotations.Test;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import shihuo.serve.BuildToken;
import shihuo.serve.CreateExcelFile;
import shihuo.serve.JsonStr;
import shihuo.serve.RequestData;
import shihuo.serve.ShihuoApi;


public class NewTest {
	 /**
	 *goodSupplier服务测试
	 *测试内容：
	 *1、验证接口的status是否为200；
	 *2、验证渠道置顶是否正常；
	 *3、验证接口的数据是否为空。
	 */
//	 @Test
//	 public void test1() throws IOException {
//		 String url ="http://www.shihuo.cn/app_swoole_zone/list?platform=ios&timestamp=1502611800&v=4.8.1&token=4ac5fa7a0159a7e87fc4e928fa8fa3a1&page=1&range=%E7%AF%AE%E7%90%83%E9%9E%8B%2C%E7%B4%A7%E8%BA%AB%E8%A1%A3%2C%E7%90%83%E8%A1%A3%2CT%E6%81%A4%2C%E8%BF%90%E5%8A%A8%E7%9F%AD%E8%A3%A4%2C%E8%BF%90%E5%8A%A8%E9%95%BF%E8%A3%A4%2C%E7%B4%A7%E8%BA%AB%E8%A3%A4%2C%E7%AF%AE%E7%90%83%2C%E6%8A%A4%E8%86%9D%2C%E6%8A%A4%E8%B8%9D%2C%E6%8A%A4%E8%85%95%2C%E6%8A%A4%E8%82%98%2C%E8%BF%90%E5%8A%A8%E8%A2%9C%E5%AD%90%2C%E7%90%83%E9%9E%8B%E6%B4%97%E5%89%82%2C%E8%83%8C%E5%8C%85%2C%E5%85%B6%E4%BB%96&sex=1&type=1";
//		 String userAgent = "Mozilla/5.0 (iPhone; U; CPU OS 10.3.3 like Mac OS X; en-us) AppleWebKit/533.17.9 (KHTML, like Gecko) network/wifi shihuo/4.8.1 iPhone9,2 sc(e22de44c0e282c53670278ee5ac7f02993f51299,appstore)";
//		 Connection connection = Jsoup.connect(url).userAgent(userAgent);
//		 String json = connection.execute().body();
//		 JsonStr jsonStr = new JsonStr();
//		 String a = jsonStr.getValues(json, "data", "filter", "brands");
//		 System.out.println(a);
//		 String regex = "\"(.*?)\"";
//		 Pattern r = Pattern.compile(regex);
//		 Matcher m = r.matcher(a);
//		 List<String> list =new LinkedList<String>();
//		 int i = 0;
//		 while(m.find()){
//			 	list.add(m.group(1));
//		    	System.out.println("123=="+list.get(i));
//		    	i++;
//		    }
//		 CreateExcelFile createExcelFile = new CreateExcelFile();
//		 createExcelFile.createExcelFile("brand", list);
//	 }
//	 @Test
//	 public void test2() throws IOException {
//		 RequestData request = new RequestData();
//		 CreateExcelFile createExcelFile = new CreateExcelFile();
//		 String url ="http://www.shihuo.cn/app_swoole_zone/list";
//		 String userAgent = "Mozilla/5.0 (iPhone; U; CPU OS 10.3.3 like Mac OS X; en-us) AppleWebKit/533.17.9 (KHTML, like Gecko) network/wifi shihuo/4.8.1 iPhone9,2 sc(e22de44c0e282c53670278ee5ac7f02993f51299,appstore)";
//		 Map<String, String> mapdata1 = request.getRequestData("C:\\Users\\gaohuajin\\Desktop\\brand-model.xlsx");
//		 Map<String, String> mapdata2 = request.getRequestData1("C:\\Users\\gaohuajin\\Desktop\\brand.xlsx");
//		 for(int i = 0 ;i< mapdata2.size();i++)
//		 {
//			 Connection connection = Jsoup.connect(url).userAgent(userAgent);
//			 connection.data(mapdata1);
//			 connection.data("brand",mapdata2.get(Integer.toString(i)));
//			 String json = connection.execute().body();
//			 System.out.println("json"+json);
//			 JsonStr jsonStr = new JsonStr();
//			 String a = jsonStr.getValues(json, "data", "info");
//			 JSONArray jsonArray = JSONArray.fromObject(a);
//			 List<String> list =new LinkedList<String>();
//			 for(int j=0;j<jsonArray.size();j++){
//				 JSONObject jsonStr1 = jsonArray.getJSONObject(j);
//				 list.add(jsonStr1.get("id").toString());
//			 }
//			 createExcelFile.createExcelData("C:\\Users\\gaohuajin\\Desktop\\brandExpect.xlsx",mapdata2.get(Integer.toString(i)),list);
//		 }
//	 }
	@Test
	 public void test3() throws IOException {
		 SortedMap<String,String> map = new TreeMap<String,String>();
		 BuildToken buildToken = new BuildToken();
		 map.put("ZoneExpand", "true");
		 map.put("ZoneIsCategory", "true");
		 map.put("brand", "Under Armour/安德玛");
		 map.put("c", "篮球鞋");
		 map.put("page", "1");
		 map.put("page_size", "20");
		 map.put("range", "篮球鞋");
		 map.put("sex", "1");
		 map.put("type", "1");
		 String requestUrl = "http://www.shihuo.cn/app_swoole_zone/list";
		 String url = buildToken.rebuildUrl(requestUrl, map, false);
		 System.out.println("url=== "+url);
	 }
}
