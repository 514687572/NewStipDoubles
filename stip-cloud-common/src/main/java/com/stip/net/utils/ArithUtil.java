package com.stip.net.utils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * double计算 不丢失精度
 * 
 * @author
 * 
 */
public class ArithUtil {
	/**
	 * 提供精确加法计算的add方法
	 * 
	 * @param value1
	 *            被加数
	 * @param value2
	 *            加数
	 * @return 两个参数的和
	 */
	public static double add(double value1, double value2) {
		BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
		BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
		double dou = b1.add(b2).doubleValue();
		BigDecimal b3 = new BigDecimal(dou);
		double f1 = b3.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return f1;
	}

	/**
	 * 提供精确减法运算的sub方法
	 * 
	 * @param value1
	 *            被减数
	 * @param value2
	 *            减数
	 * @return 两个参数的差
	 */
	public static double sub(double value1, double value2) {
		BigDecimal b1 = new BigDecimal(Double.valueOf(value1) + "");
		BigDecimal b2 = new BigDecimal(Double.valueOf(value2) + "");
		double dou = b1.subtract(b2).doubleValue();
		BigDecimal b3 = new BigDecimal(dou);
		double f1 = b3.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return f1;
	}

	/**
	 * 提供精确乘法运算的mul方法
	 *
	 * @param value1
	 *            被乘数
	 * @param value2
	 *            乘数
	 * @return 两个参数的积
	 */
	public static double mul(double value1, double value2) {
		BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
		BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
		double dou = b1.multiply(b2).doubleValue();
		BigDecimal b3 = new BigDecimal(dou);
		double f1 = b3.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return f1;
	}


	/**
	 * 提供精确乘法运算的mul方法
	 *
	 * @param value1
	 *            被乘数
	 * @param value2
	 *            乘数
	 * @return 两个参数的积
	 */
	public static double mul(double value1, double value2,int scale) {
		BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
		BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
		double dou = b1.multiply(b2).doubleValue();
		BigDecimal b3 = new BigDecimal(dou);
		double f1 = b3.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
		return f1;
	}

	/**
	 * 提供精确的除法运算方法div
	 * 
	 * @param value1
	 *            被除数
	 * @param value2
	 *            除数
	 * @param scale
	 *            精确范围
	 * @return 两个参数的商
	 * @throws IllegalAccessException
	 */
	public static double div(double value1, double value2, int scale) throws IllegalAccessException {
		// 如果精确范围小于0，抛出异常信息
		if (scale < 0) {
			throw new IllegalAccessException("精确度不能小于0");
		}
		BigDecimal b1 = new BigDecimal(Double.valueOf(value1) + "");
		BigDecimal b2 = new BigDecimal(Double.valueOf(value2) + "");
		double dou = b1.divide(b2,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
		BigDecimal b3 = new BigDecimal(dou);
		double f1 = b3.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
		return f1;
	}

	public static Integer toFen(String value) {
		double f1 = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return (int) (f1 * 100);
	}

	public static Integer toFen(double value) {
		double f1 = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return (int) mul(f1, 100);
	}

	public static void main(String[] args) throws IllegalAccessException {
		System.out.println(div(3,13,2));
		SimpleDateFormat format =  new SimpleDateFormat( "yyyy-MM-dd" );

		Long time=new Long(1544010785);
		System.out.println((long)123);
		String d = format.format(time);
		try {
			Date date=format.parse(d);
			System.out.println(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

    public static BigDecimal subScale(double value1,double value2,int scale) {
		BigDecimal b1 = new BigDecimal(Double.valueOf(value1) + "");
		BigDecimal b2 = new BigDecimal(Double.valueOf(value2) + "");
		double dou = b1.subtract(b2).doubleValue();
		BigDecimal b3 = new BigDecimal(dou);
		double f1 = b3.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
		return BigDecimal.valueOf(f1);
    }

	public static BigDecimal addScale(double value1, double value2, int scale) {
		BigDecimal b1 = new BigDecimal(Double.valueOf(value1) + "");
		BigDecimal b2 = new BigDecimal(Double.valueOf(value2) + "");
		double dou = b1.add(b2).doubleValue();
		BigDecimal b3 = new BigDecimal(dou);
		double f1 = b3.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
		return BigDecimal.valueOf(f1);
	}
}
