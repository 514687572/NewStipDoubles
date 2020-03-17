package com.stip.net.utils;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

import java.io.ByteArrayInputStream;

public class QiniuUtils {
    public static final String QN_ACCESS_KEY = "";
    public static final String QN_SECRECT_KEY = "";
    public static final String QN_DOMAIN = "";
    public static final String QN_BUCKET = "";

    public static String qiniuUploadPic(byte[] upload) {
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone2());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传

        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = null;
        try {
            //byte[] uploadBytes = "hello qiniu cloud".getBytes("utf-8");
            byte[] uploadBytes = upload;
            ByteArrayInputStream byteInputStream = new ByteArrayInputStream(uploadBytes);
            Auth auth = Auth.create(QN_ACCESS_KEY, QN_SECRECT_KEY);
            String upToken = auth.uploadToken(QN_BUCKET);
            try {
                Response response = uploadManager.put(byteInputStream, key, upToken, null, null);
                //解析上传成功的结果
                DefaultPutRet putRet = null;
                System.out.println(putRet.key);
                System.out.println(putRet.hash);
                return putRet.hash;
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    //ignore
                }
            }
        } catch (Exception e) {
            //ignore
        }

        return null;
    }

}
