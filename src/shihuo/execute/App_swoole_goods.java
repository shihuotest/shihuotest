package shihuo.execute;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SortedMap;
import java.util.TreeMap;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import shihuo.serve.BuildToken;
import shihuo.serve.Check;
import shihuo.serve.JsonStr;

public class App_swoole_goods {
  @Test
  public void getStyles() throws IOException {
	  String zone_name = "实战";
	  String url = "http://www.shihuo.cn/app_swoole_goods/getStyles";
	  SortedMap<String,String> requestData = new TreeMap<String,String>();
	  requestData.put("zone_name", zone_name);
	  BuildToken buildToken = new BuildToken();
	  String requestUrl = buildToken.rebuildUrl(url, requestData, true);
	  Date date=new Date();
	  DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  Reporter.log(format.format(date)+"请求的地址"+requestUrl);
	  Connection connection = Jsoup.connect(requestUrl);
	  String json = connection.execute().body();
	  JsonStr jsonStr = new JsonStr();
	  String numValue = jsonStr.getValues(json, "data", "num");
	  Check check = new Check();
	  Assert.assertTrue(check.isNum(numValue));
  }
}
