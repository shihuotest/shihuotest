package shihuo.serve;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import com.google.gson.GsonBuilder;

public class BuildToken {
	 /**
     * 自然排序
     */
    public static String buildToken(SortedMap map) {
        List temp = new ArrayList();
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            String key = (String) entry.getKey();
            if (key != null) {
                int f = key.indexOf("[");
                int l = key.indexOf("]");
                if (f != -1 && l != -1 && f < l)
                    continue;
            }
            try {
                boolean isArray = new GsonBuilder().create().toJsonTree(entry.getValue()).isJsonArray();
                if (isArray)
                    continue;
            } catch (Exception e) {
                e.printStackTrace();
            }
            temp.add(key);
        }
        StringBuilder sb = new StringBuilder();
        String[] str = (String[]) temp.toArray(new String[temp.size()]);
        Arrays.sort(str);
        for (int i = 0; i < str.length; i++) {
            if (map.get(str[i]) == null)
                continue;
            String value = map.get(str[i]).toString();
            sb.append(value);
        }
        return MD5(sb.toString() + "123456").toLowerCase();
    }
    public final static String MD5(String s) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static String rebuildUrl(String url, SortedMap params, boolean isGetMethod) {
        if (params == null)
            params = new TreeMap();
        //基本参数集合
        SortedMap customParamsMap = new TreeMap();
        putCustomParams(customParamsMap);
        String urlSpliceParams;
        customParamsMap.putAll(params);
        customParamsMap.remove("token");//移除之前map中存在的token,该token不参与排序
        customParamsMap.put("token", buildToken(customParamsMap));
        if (!isGetMethod) {
            //post 参数不拼接在URL后面
            for (Object key : params.keySet()) {
                customParamsMap.remove(key);
            }
        }
        urlSpliceParams = buildParams(customParamsMap);
        return url + "?" + urlSpliceParams;
    }
    public static void putCustomParams(SortedMap params) {
        params.put("v", "5.5.6");
        params.put("platform", "android");
        params.put("timestamp", System.currentTimeMillis() + "");
        params.put("clientCode", "868241036737444");
        params.put("channel", "xiaomi");
    }
    public static String buildParams(SortedMap params) {
        StringBuilder urlParams = new StringBuilder();
        for (Object key : params.keySet()) {
            if (params.get(key) == null)
                continue;
            urlParams.append(key).append("=");
            try {
                urlParams.append(URLEncoder.encode(params.get(key).toString(), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
            }
            urlParams.append("&");
        }
        return urlParams.toString().substring(0, urlParams.toString().length() - 1);
    }
}
