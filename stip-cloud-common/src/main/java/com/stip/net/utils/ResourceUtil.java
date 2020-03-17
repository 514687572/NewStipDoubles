package com.stip.net.utils;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * @Package: com.stip.net.utils
 * @Description:
 * @Author: cgnet05
 * @CreatDate: 2019/01/24
 */
public class ResourceUtil {
    private ResourceBundle resourceBundle;

    private ResourceUtil(String resource) {
        resourceBundle = ResourceBundle.getBundle(resource);
    }

    /**
     * 获取资源
     *
     * @param resource 资源
     * @return 解析
     */
    public static ResourceUtil getResource(String resource) {
        return new ResourceUtil(resource);
    }

    /**
     * 根据key取得value
     *
     * @param key  键值
     * @param args value中参数序列，参数:{0},{1}...,{n}
     * @return
     */
    public String getValue(String key, Object... args) {
        String temp = resourceBundle.getString(key);
        return MessageFormat.format(temp, args);
    }

    /**
     * 获取所有资源的Map表示
     *
     * @return 资源Map
     */
    public Map<String, String> getMap() {
        Map<String, String> map = new HashMap<String, String>();
        for (String key : resourceBundle.keySet()) {
            map.put(key, resourceBundle.getString(key));
        }
        return map;
    }
}
