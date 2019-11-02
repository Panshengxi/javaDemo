//package com.xing.xing.service.getJson;
//
//
//import com.xing.xing.response.UserInfo;
//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;
//import sun.net.www.URLConnection;
//
//import java.io.BufferedReader;
//import java.io.Closeable;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.URL;
//import java.text.ParseException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
///*我返回的是一个对象集合，可根据个人需求修改，返回一个对象时跟获取到的数据对象属性一定要相同，不然会报错*/
//public class getData{
////    public static List<UserInfo> getJson(){
////        ArrayList array = new ArrayList<UserInfo>();
////        String walletUrl = "http://";
////        BufferedReader in = null;
////        String result = "";
////        try {
////            URL getwalletAmountUrl = new URL(walletUrl);
////            System.out.println(walletUrl);
////            //打开连接，获取返回信息。
//////            URLConnection context = getwalletAmountUrl.openConnection();
////         URLConnection urlConnection = getwalletAmountUrl.openConnection();
////            in = new BufferedReader(new InputStreamReader(
////                    context.getInputStream(), "UTF-8"));
////            String line;
////            while ((line = in.readLine()) != null){
////                result += line;
////            }
////            result = result.substring(result.indexOf("["),
////                    result.indexOf("]") + 1);
////            JSONArray jsonArray = JSONArray.fromObject(result);
////            for (int i = 0; i < jsonArray.toArray().length; i++) {
////                Object o = jsonArray.get(i);
////                JSONObject jsonObject2 = JSONObject.fromObject(o);
////                UserInfo userInfo = (UserInfo) JSONObject
////                        .toBean(jsonObject2, UserInfo.class);
////                array.add(userInfo);
////            }
//////            nVersion=array.get(0).getNversion();
////
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////        return array;
////    }
//
//    public static String sendGut(String url, Map<String, Object> map, String encoding) throws ParseException, IOException {
//        String body = "";
////        CloseableHttpResponse response = null;
//        Closeable response = null;
//        //client 客户端   ---------------------------- -----   // 创建默认的httpClient实例.
//        CloseableHttpClient client = HttpClients.createDefault();
//        //GET     - 向指定位置获取其内容---------------// 创建httpGet
//        HttpGet httpGet = new HttpGet(url);
//        //StringEntity是httpGet对象的一个实现类
//        httpGet.setHeader("Content-type", "application/json");
////	            httpPut.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
//        //客户端执行。获取数据
//        response = client.execute(httpGet);
//        //通过response里的getEntity()方法获取客户端的返回值，然后return进行返回；
//        HttpEntity entity = response.getEntity();
//        if (entity != null) {
//            body = EntityUtils.toString(entity, encoding);
//        }
//        //
//        EntityUtils.consume(entity);
//        response.close();
//        return body;
//    }
//}
//
