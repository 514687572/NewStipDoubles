package com.stip.net.utils;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * @Package: com.stip.net.utils
 * @Description:
 * @Author: cgnet05
 * @CreatDate: 2019/01/24
 */
public class ConfigUtils {
    /**
     * 文件配置 加载
     */
    public static Map<String, String> prop = ResourceUtil.getResource("mail").getMap();

    /**
     * 获取值
     */
    public static String get(String key) {
        String str = "";
        try {
            str = new String(prop.get(key).getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }
}
