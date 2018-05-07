package shihuo.execute;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.swing.plaf.synth.SynthSpinnerUI;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import shihuo.serve.BuildToken;
import shihuo.serve.Include;
import shihuo.serve.JsonStr;
import shihuo.serve.RequestData;

public class App_swoole_zone {
	RequestData requestData = new RequestData();
	JsonStr jsonStr = new JsonStr();
	BuildToken buildToken = new BuildToken();
	Include include = new Include();
	Date date=new Date();
	DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**
	 * 对app_swoole_zone这个接口进行价格排序测试
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void price_rank_test() throws FileNotFoundException, IOException{
		String file_model_paths="C:\\Users\\gaohuajin\\Desktop\\app_swoole_zone\\price_rank_model.xlsx";
		String file_value_paths="C:\\Users\\gaohuajin\\Desktop\\app_swoole_zone\\price_value.xlsx";
		Map model_data = requestData.getRequestModelData(file_model_paths);
		Map model_value = requestData.getRequestValueData(file_value_paths);
		SortedMap<String,String> requestData = new TreeMap<String,String>();
		requestData.putAll(model_data);
		String url = "http://www.shihuo.cn/app_swoole_zone/list";
		for (int i = 0;i<model_value.size();i++){
			requestData.put("price", model_value.get(""+i).toString());
			String requestUrl = buildToken.rebuildUrl(url, requestData, true);
			Reporter.log(format.format(date)+"请求的地址"+requestUrl);
			Connection connection = Jsoup.connect(requestUrl);
			String json = connection.execute().body();
			String list = jsonStr.getValues(json, "data", "info");
			JSONArray jsonArray = JSONArray.fromObject(list);
			for(int j=0;j<jsonArray.size();j++){
				 JSONObject jsonString = jsonArray.getJSONObject(j);
				 float price = Float.parseFloat(jsonString.get("price").toString());
				 switch (i) {
				 	case 0:
				 		Assert.assertTrue(include.include_0_100(price), "价格不在0-100内");
				 		break;
				 	case 1:
				 		Assert.assertTrue(include.include_100_300(price), "价格不在100-300内");
				 		break;
				 	case 2:
				 		Assert.assertTrue(include.include_300_500(price), "价格不在300-500内");
				 		break;
				 	case 3:
				 		Assert.assertTrue(include.include_500_1000(price), "价格不在500-1000内");
				 		break;
				 	case 4:
				 		Assert.assertTrue(include.include_1000_10000(price), "价格不在1000-10000内");
				 		break;
				 	case 5:
				 		Assert.assertTrue(include.include_10000max(price), "价格不在10000max内");
				 		break;
				}
			 }
			requestData.remove("price");
		}
	}
	@Test
	public void sort_rank_test() throws FileNotFoundException, IOException{
		String file_model_paths="C:\\Users\\gaohuajin\\Desktop\\app_swoole_zone\\sort_rank_model.xlsx";
		String file_value_paths="C:\\Users\\gaohuajin\\Desktop\\app_swoole_zone\\sort_value.xlsx";
		Map model_data = requestData.getRequestModelData(file_model_paths);
		Map model_value = requestData.getRequestValueData(file_value_paths);
		
	}
}
