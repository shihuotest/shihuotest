package shihuo.serve;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.testng.Assert;

import com.google.gson.Gson;
import com.sun.org.apache.xml.internal.security.Init;
import com.sun.xml.internal.ws.api.config.management.policy.ManagementAssertion.Setting;

import net.sf.json.JSONObject;
import shihuo.model.GoodSupplierApiModel;
import shihuo.model.GoodsModel;
import shihuo.model.GoodSupplierApiModel.infoModel;
import shihuo.model.GoodsModel.AttrModel;
import shihuo.model.GoodsModel.ListModel;

public class ShihuoApi {	
	String userAgent = "Mozilla/5.0 (iPhone; U; CPU OS 10.3.2 like Mac OS X; en-us) AppleWebKit/533.17.9 (KHTML, like Gecko) network/wifi shihuo/4.8.0 iPhone9,2 sc(3e42dc8c12b922b449e7374952d5a72379ac6020,appstore)";
	public Map<String,String> getSku(String id,String news_id,String supplier_id) throws IOException{
		Map<String,String> map = new LinkedHashMap<String,String>();
		String url = "http://www.shihuo.cn/app_swoole_zone/getSupplier?platform=ios&timestamp=1500876000&v=4.8.0&token=64cb4be09645e2c7bc3d4dec6f847f78&id="+id+"&news_id="+news_id+"&page=1&page_size=10&size=&sourceType=1&style_id=&supplier_id="+supplier_id+"";
		String url1 = "http://www.shihuo.cn/app_swoole_zone/getSupplier?platform=ios&timestamp=1501054200&v=4.8.0&token=c02273f72d9d80559faea0da723f9319&id="+id+"&news_id="+news_id+"&page=1&page_size=10&size=&sourceType=1&style_id=23997&supplier_id="+supplier_id+"";
		Connection connection = Jsoup.connect(url1).userAgent(userAgent);
		connection.method(Connection.Method.GET);
		String newJson = connection.execute().body();
		Gson gson= new Gson();
		GoodsModel goodsModel = gson.fromJson(newJson, GoodsModel.class);
		List<ListModel> lists = goodsModel.data.supplier_info.list;
		List<AttrModel> attrModel = lists.get(0).skuInfoDetail.attr;
		for (AttrModel attr : attrModel) {
			map.put(attr.value.size, attr.price);
		}
		return map;
	}
	public Map<String, String> getGoodSupplier(Map data) throws IOException{
		Map<String, String> map = new LinkedHashMap<String, String>();
		String url = "http://www.shihuo.cn/service/index";
		Connection connection = Jsoup.connect(url);
		connection.data(data);
		String newJson = connection.execute().body();
		String status = String.valueOf(connection.execute().statusCode());
		Gson gson = new Gson();
		GoodSupplierApiModel goodSupplierApiModel = gson.fromJson(newJson, GoodSupplierApiModel.class);
		List<infoModel> info = goodSupplierApiModel.data.info;
		String count = goodSupplierApiModel.data.count;
		String size = String.valueOf(info.size());
		String id = info.get(0).id;
		String price = info.get(0).price;
		map.put("status", status);
		map.put("count", count);
		map.put("id", id);
		map.put("price", price);
		map.put("size", size);
		return map;
	}
	public void mapTest() {
		Map<String,String> test1 = new LinkedHashMap<String,String>();
		Map<String,String> test2 = new LinkedHashMap<String,String>();
		test1.put("key1", "aaa");
		test1.put("1234", "bbb");
		test1.put("key3", "ccc");
		test2.put("key3", "aaa");
		test2.put("1234", "bbb");
		test2.put("4344", "ccc");
		test2.put("aasd", "ccc");
		test2.put("1111", "ccc");
		for (String e : test1.keySet()) {
			System.out.println("key:"+e+",value:"+test1.get(e));
		}
		for (String e : test2.keySet()) {
			System.out.println("key:"+e+",value:"+test2.get(e));
		}
		Assert.assertEquals(test1, test2);
	}
}