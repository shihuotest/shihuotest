package shihuo.serve;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.org.apache.xalan.internal.utils.SecuritySupport;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ResultTreeType;
import com.sun.xml.internal.messaging.saaj.soap.StringDataContentHandler;

import shihuo.model.TaobaoGoodsModel;

public class Taobao {
	String url = "https://item.taobao.com/item.htm?id=555109714385";
	String url1= "https://item.taobao.com/item.htm?id=545324016223";
	String userAgent = "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36";
	public Map<String, String> updatePrice() throws IOException {
		Connection connection = Jsoup.connect(url).userAgent(userAgent);
		connection.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		connection.method(Connection.Method.GET);
		Document d = connection.get();
		Elements e = d.select("script");
		Map<String, String> map = new HashMap<String, String>();
		for (Element ea : e){
			if(ea.html().contains("skuMap")){
				int start = ea.html().indexOf("skuMap")+7;
				int end = ea.html().indexOf(",propertyMemoMap");
				String result1 = ea.html().substring(start, end).trim();
				String result2 = result1.substring(result1.indexOf(";")+1).trim();
				String result3 = result2.replace("\"", "").replace("{","").replace("}", "");
				String[] result4 = result3.split(";");
				List<String> list = new ArrayList<String>();
				for(int i=0;i<result4.length;i++){
					String[] result5 = result4[i].split(",");
					if (result5!=null&&result5.length>0) {
						for (int j = 0; j < result5.length; j++) {
							list.add(result5[j]);
						}
					}

				}
				for (int k = 0; k < list.size(); k++) {
					System.out.println("第"+k+"个值为="+list.get(k));
				}
				String skuKey = "20549:";
				String priceKey = "price:";
				String sku;
				String price;
				for (int i=0;i < list.size();i++)
				{
					if(list.get(i).contains(skuKey)){
						sku = list.get(i).substring(skuKey.length());
						System.out.println("sku="+sku);
						for(int j=i;j < list.size();j++){
							if(list.get(j).contains(priceKey)){
								price = list.get(j).substring(priceKey.length());
								System.out.println("price="+price);
								map.put(sku, price);
								System.out.println("集合的数据为"+map.get(sku));
								break;
							}
						}	
					}
				}
				}
		}
		return map;
	}
	public Map<String, String> updatePrice1() throws IOException {
		Connection connection = Jsoup.connect(url1).userAgent(userAgent);
		connection.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		connection.method(Connection.Method.GET);
		Document d = connection.get();
		Elements e = d.select("script");
		String result1 = null;
		for (Element ea : e){
			if(ea.html().contains("skuMap")){
				int start = ea.html().indexOf("skuMap")+12;
				int end = ea.html().indexOf(",propertyMemoMap");
				result1 = ea.html().substring(start, end).trim();
			}
		}
		Gson gson = new Gson();
		TypeToken<Map<String,TaobaoGoodsModel.Price>> typeToken = new TypeToken<Map<String,TaobaoGoodsModel.Price>>() {};
		Map<String, TaobaoGoodsModel.Price> maps = gson.fromJson(result1,typeToken.getType());
		Map<String, String> map1 = new LinkedHashMap<String, String>();
		for (String  keys : maps.keySet()) {
//			System.out.println("keys:"+keys+"price:"+maps.get(keys).price);
			String regex = ":(.*?);";
			// 创建 Pattern 对象
		    Pattern r = Pattern.compile(regex);
		    // 现在创建 matcher 对象
		    Matcher m = r.matcher(keys);
		    String size;
		    String colors;
		    int i=0;
		    while(m.find()){
		    	if(i==0){
		    		size = m.group(1);
		    		map1.put(size, maps.get(keys).price);
		    	}
		    	if(i==1){
		    		colors = m.group(1);
		    	}
		    	i++;
		    }
		}
		return map1;
	}
}
