package shihuo.execute;

import org.testng.annotations.Test;

import shihuo.serve.ShihuoApi;
import shihuo.serve.Taobao;

import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class GoodSPriceUpdate {
  Taobao taobao = new Taobao();
  ShihuoApi shihuoApi = new ShihuoApi();
  @Test
  public void f() throws IOException {
//	  taobao.updatePrice();
//	  shihuoApi.getSku("17", "119378", "221005");
	  Map<String, String> shihuoData = shihuoApi.getSku("13", "120162", "130665");
	  for (String keys : shihuoData.keySet()) {
		System.out.println("获取到的识货的数据===keys:"+keys+"price:"+shihuoData.get(keys));
	}
	  Map<String, String> taobaoData = taobao.updatePrice1();
	  for (String keys : taobaoData.keySet()) {
			System.out.println("获取到的淘宝的数据===keys:"+keys+"price:"+taobaoData.get(keys));
		}
	  Assert.assertEquals(shihuoData, taobaoData);
  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
