package com.stip.net.utils;

import com.google.common.collect.Maps;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.SortedMap;

public class HttpUtils {

    public static JSONObject BodyPost(String actionUrl, Map<String, String> params) throws IOException {
        OutputStreamWriter out = null;
        InputStream is = null;
        try {
            URL url = new URL(actionUrl);// 创建连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestMethod("POST"); // 设置请求方式
            connection.setRequestProperty("Accept", "application/json"); // 设置接收数据的格式
            connection.setRequestProperty("Content-Type", "application/json"); // 设置发送数据的格式
            connection.connect();
            out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8"); // utf-8编码
            out.append(JSONObject.fromObject(params).toString());
            out.flush();
            out.close();

            // 读取响应
            is = connection.getInputStream();
            int length = (int) connection.getContentLength();// 获取长度
            if (length != -1) {
                byte[] data = new byte[length];
                byte[] temp = new byte[512];
                int readLen = 0;
                int destPos = 0;
                while ((readLen = is.read(temp)) > 0) {
                    System.arraycopy(temp, 0, data, destPos, readLen);
                    destPos += readLen;
                }
                String result = new String(data, "UTF-8"); // utf-8编码

                return JSONObject.fromObject(result);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public static void main(String[] args) throws IOException {

        SortedMap<String, String> parms = Maps.newTreeMap();
        parms.put("appKey", "3186a9b59de40aa3");
        parms.put("fileHash", "e5461d90e1ad3b7730b48bb2ca0b16a236b619e1ce7d47f8e3bfb5b19288aba6a190d48905ecf23b49e7a14152c442652916ce22a304eb5594e8eb40f5f68f30");
        parms.put("name", "测试存证1");
        parms.put("sign", "300DFEB9D6628446DA4297F1DC9A001B");
        parms.put("type", "1");
        JSONObject jsonObject = BodyPost("https://bs.ebaoquan.org/api/createEvidenceHash", parms);
    }
}
