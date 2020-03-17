package com.stip.net.utils;


import org.apache.log4j.Logger;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @Package: com.stip.net.utils
 * @Description:
 * @Author: cgnet05
 * @CreatDate: 2019/01/24
 */
public class VerifyUtil {
    private static Logger logger = Logger.getLogger(VerifyUtil.class);

    private static String[] fontNames = {"宋体", "华文楷体", "黑体", "微软雅黑", "楷体_GB2312"};
    // 设置字体大小
    private static int fontSize = 22;
    // 文字个数(可调)
    private static int len = 4;
    // 基数(一个文字所占的空间大小)
    private static int base = 30;
    // 图像宽度
    private static int width = base * 4;
    // 图像高度
    private static int height = base;

    private static BufferedImage image = null;

    /**
     * 生成验证码图片
     *
     * @return
     * @throws IOException
     */
    public static Object[] imageCode() throws IOException {
        // 在内存中创建图象
        image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        // 获取图形上下文
        Graphics g = image.getGraphics();
        // 生成随机类
        Random random = new Random();
        // 设定背景色
        g.setColor(getRandColor(230, 255));
        g.fillRect(0, 0, width, height);
        // 设置字体
        g.setFont(new Font(fontNames[getRandom(0, fontNames.length)], Font.CENTER_BASELINE | Font.ITALIC | Font.BOLD, fontSize));
        // 画干扰线
        for (int i = 0; i < len + 2; i++) {
            // 设置画笔颜色 -- 随机
            // g2.setColor(new Color(255, 0, 0));
            g.setColor(new Color(getRandom(0, 150), getRandom(0, 150),
                    getRandom(0, 150)));
            g.drawLine(getRandom(0, 120), getRandom(0, 30), getRandom(0, 120),
                    getRandom(0, 30));
        }

        StringBuffer sb = new StringBuffer();// 用来装载验证码上的文本
        // 取随机产生的认证码(4位数字)
        for (int i = 0; i < len; i++) {
            String rand = String.valueOf(random.nextInt(10));
            sb.append(rand);
            // 将认证码显示到图象中
//            g.setColor(getRandColor(100, 150));// 调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
            g.setColor(new Color(getRandom(0, 150), getRandom(0, 150), getRandom(0, 150)));
            // 设置字体
            g.setFont(new Font(fontNames[getRandom(0, fontNames.length)], Font.BOLD, fontSize));
            g.drawString(rand, 7 + i * base, height - 8);
        }
        for (int i = 0; i < (random.nextInt(5) + 5); i++) {
            g.setColor(new Color(random.nextInt(255) + 1, random.nextInt(255) + 1, random.nextInt(255) + 1));
            g.drawLine(random.nextInt(100), random.nextInt(30), random.nextInt(100), random.nextInt(30));
        }

        return new Object[]{sb.toString(), image};
    }

    /**
     * 给定范围获得随机颜色
     *
     * @param fc
     * @param bc
     * @return
     */
    static Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255)
            fc = 255;
        if (bc > 255)
            bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }

    /*
     * 生成随机数的方法
     */
    private static int getRandom(int start, int end) {
        Random random = new Random();
        return random.nextInt(end - start) + start;
    }

    public static void main(String[] args) throws Exception {
        VerifyUtil tc = new VerifyUtil();
//        tc.drawImage(new FileOutputStream("d:/图片验证码.jpg"));
//        System.out.println("图片验证码为---->" + tc.getCode());
        System.out.println("执行成功~!");
    }
}
