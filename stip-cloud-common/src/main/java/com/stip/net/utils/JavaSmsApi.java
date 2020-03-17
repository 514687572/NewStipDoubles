package com.stip.net.utils;

import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Package: com.stip.net.utils
 * @Description:短信http接口的java代 基于Apache HttpClient 4.3
 * @Author: cgnet05
 * @CreatDate: 2019/02/26
 */
public class JavaSmsApi {

    // 单条短信发送地址
    private static String SINGLE_SEND_URL =
            "https://sms.yunpian.com/v2/sms/single_send.json";

    // 批量短信发送地址
    private static String BATCH_SEND_URL =
            "https://sms.yunpian.com/v2/sms/batch_send.json";

    //编码格式。发送编码格式统一用UTF-8
    private static String ENCODING = "UTF-8";
    //编码格式。发送编码格式统一用UTF-8
    private static String APIKEY = "30975ac3b028d72fcf8bac799037ff3e";

    public static void main(String[] args) throws IOException,
            URISyntaxException {


        //修改为您要发送的手机号
        String mobile = "13094466946";
        String temp = "您的验证码是{0}";

        temp = MessageFormat.format(temp, "4595");
        String s = singleSend(temp, mobile);
        JSONObject jsonObject = JSONObject.fromObject(s);
        System.out.println(s.toString());
        System.out.println(jsonObject.toString());
    }

    /**
     * 单条短信发送,智能匹配短信模板
     *
     * @param text
     * @param mobile
     * @return json格式字符串
     */

    public static String singleSend(String text, String mobile) throws IOException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("apikey", APIKEY);
        params.put("text", text);
        params.put("mobile", mobile);

        return post(SINGLE_SEND_URL, params);
    }

    /**
     * 批量发送短信,相同内容多个号码,智能匹配短信模板
     *
     * @param text   需要使用已审核通过的模板或者默认模板
     * @param mobile 接收的手机号,多个手机号用英文逗号隔开
     * @return json格式字符串
     */
    public static String batchSend(String text, String mobile) throws IOException {
        Map<String, String> params = new HashMap<String, String>();//请求参数集合
        params.put("apikey", APIKEY);
        params.put("text", text);
        params.put("mobile", mobile);
        return post(BATCH_SEND_URL, params);//请自行使用post方式请求,可使用Apache HttpClient
    }

    /**
     * 基于HttpClient 4.3的通用POST方法
     *
     * @param url       提交的URL
     * @param paramsMap 提交<参数，值>Map
     * @return 提交响应
     */

    public static String post(String url, Map<String, String> paramsMap) {
        CloseableHttpClient client = HttpClients.createDefault();
        String responseText = "";
        CloseableHttpResponse response = null;
        try {
            HttpPost method = new HttpPost(url);
            if (paramsMap != null) {
                List<NameValuePair> paramList = new ArrayList<
                        NameValuePair>();
                for (Map.Entry<String, String> param : paramsMap.entrySet()) {
                    NameValuePair pair = new BasicNameValuePair(param.getKey(),
                            param.getValue());
                    paramList.add(pair);
                }
                method.setEntity(new UrlEncodedFormEntity(paramList,
                        ENCODING));
            }
            response = client.execute(method);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                responseText = EntityUtils.toString(entity, ENCODING);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return responseText;
    }
}
