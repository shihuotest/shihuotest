package shihuo.serve;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.sun.org.apache.regexp.internal.recompile;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonStr {
	
	private static String tojsonObject(String jsonObject,String key){
		JSONObject jsonStr = JSONObject.fromObject(jsonObject);
		return jsonStr.get(key).toString();
	}
	private static String tojsonArray(String jsonArray,String key){
		JSONArray getJsonArray =JSONArray.fromObject(jsonArray);
		JSONObject jsonStr = getJsonArray.getJSONObject(0);
		return jsonStr.get(key).toString();
	}
	public static Boolean isArray(String str){
		try {
			JSONArray getJsonArray =JSONArray.fromObject(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public static String getValues(String jsonStr,String key)	{
		if(isArray(jsonStr))
		{
			return tojsonArray(jsonStr,key);
		}else {
			return tojsonObject(jsonStr,key);
		}
	}
	public static String getValues(String jsonStr,String key,String key2)	{
		if(isArray(jsonStr))
		{
			jsonStr = tojsonArray(jsonStr,key);
		}else {
			jsonStr = tojsonObject(jsonStr,key);
		}
		if(isArray(jsonStr))
		{
			return tojsonArray(jsonStr,key2);
		}else {
			return tojsonObject(jsonStr,key2);
		}
	}
	public static String getValues(String jsonStr,String key,String key2,String key3)	{
		if(isArray(jsonStr))
		{
			jsonStr = tojsonArray(jsonStr,key);
		}else {
			jsonStr = tojsonObject(jsonStr,key);
		}
		if(isArray(jsonStr))
		{
			jsonStr = tojsonArray(jsonStr,key2);
		}else {
			jsonStr =  tojsonObject(jsonStr,key2);
		}
		if(isArray(jsonStr)){
			return tojsonArray(jsonStr,key3);
		}else {
			return tojsonObject(jsonStr,key3);
		}
	}
	public static String getValues(String jsonStr,String key,String key2,String key3,String key4)	{
		if(isArray(jsonStr))
		{
			jsonStr = tojsonArray(jsonStr,key);
		}else {
			jsonStr = tojsonObject(jsonStr,key);
		}
		if(isArray(jsonStr))
		{
			jsonStr = tojsonArray(jsonStr,key2);
		}else {
			jsonStr =  tojsonObject(jsonStr,key2);
		}
		if(isArray(jsonStr)){
			jsonStr =  tojsonArray(jsonStr,key3);
		}else {
			jsonStr =  tojsonObject(jsonStr,key3);
		}
		if(isArray(jsonStr)){
			return tojsonArray(jsonStr,key4);
		}else {
			return tojsonObject(jsonStr,key4);
		}
	}
	public static String getValues(String jsonStr,String key,String key2,String key3,String key4,String key5)	{
		if(isArray(jsonStr))
		{
			jsonStr = tojsonArray(jsonStr,key);
		}else {
			jsonStr = tojsonObject(jsonStr,key);
		}
		if(isArray(jsonStr))
		{
			jsonStr = tojsonArray(jsonStr,key2);
		}else {
			jsonStr =  tojsonObject(jsonStr,key2);
		}
		if(isArray(jsonStr)){
			jsonStr =  tojsonArray(jsonStr,key3);
		}else {
			jsonStr =  tojsonObject(jsonStr,key3);
		}
		if(isArray(jsonStr)){
			jsonStr = tojsonArray(jsonStr,key4);
		}else {
			jsonStr = tojsonObject(jsonStr,key4);
		}
		if(isArray(jsonStr)){
			return tojsonArray(jsonStr,key5);
		}else {
			return tojsonObject(jsonStr,key5);
		}
	}
	public static void main(String[] args) {
        String url = "{'status': 0,'msg': 'ok','data': [{'id': '546489','root_type': '1'},{'id': '29184','root_type': '0'},]}";
        String url1 = "{'status': 0,'msg': 'ok','data': {'id': '546489','root_type': '1'}}";
        String url3 = "[{'id': '546489','root_type': '1'},{'id': '29184','root_type': '0'}]";
        String url2= "{'status':0,'msg':'ok','data':{'filter':{'brands': ['adidas/阿迪达斯','Nike/耐克'],'groups':[{'id':17,'name':'test2','tags':[{'id':19,'name':'22','is_selected':'false'},{'id':20,'name':'33','is_selected':'ture'}]}]},'info':[{'id':'1007','tag_name':['团购','双11']},{'id':'1014','tag_name':[]}]}}";
        String value = getValues(url2,"data","filter","groups","tags","id");
        System.out.println(value);
        List<String> list = new LinkedList<String>();
        list.add("[{'id':19,'name':'22','is_selected':'false'}]");
        String[] toBeStored = list.toArray(new String[list.size()]);
        String b="";
        for(int i=0;i<toBeStored.length;i++){
            b+=toBeStored[i];
        }
    }
}
