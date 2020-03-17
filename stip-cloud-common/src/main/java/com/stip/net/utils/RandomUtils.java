package com.stip.net.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * 随机数工具类
 * 
 * @file:RandomUtils.java
 * @data:2014年8月11日
 */
public class RandomUtils {
	
	
	private static final String ALL_CHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String LETTER_CHAR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String NUMBER_CHAR = "0123456789";

	/**
	 * 获取定长的随机数，包含大小写、数字
	 * 
	 * @data:2014年8月11日
	 *
	 * @param length
	 *            随机数长度
	 * @return
	 */
	public static String generateString(int length) {
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(ALL_CHAR.charAt(random.nextInt(ALL_CHAR.length())));
		}
		return sb.toString();
	}

	/**
	 * 获取定长的随机数，包含大小写字母
	 * 
	 * @data:2014年8月11日
	 *
	 * @param length
	 *            随机数长度
	 * @return
	 */
	public static String generateMixString(int length) {
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(LETTER_CHAR.charAt(random.nextInt(LETTER_CHAR.length())));
		}
		return sb.toString();
	}

	/**
	 * 获取定长的随机数，只包含小写字母
	 * 
	 * @data:2014年8月11日
	 *
	 * @param length
	 *            随机数长度
	 * @return
	 */
	public static String generateLowerString(int length) {
		return generateMixString(length).toLowerCase();
	}

	/**
	 * 获取定长的随机数，只包含大写字母
	 * 
	 * @data:2014年8月11日
	 *
	 * @param length
	 *            随机数长度
	 * @return
	 */
	public static String generateUpperString(int length) {
		return generateMixString(length).toUpperCase();
	}

	/**
	 * 获取定长的随机数，只包含数字
	 * 
	 * @data:2014年8月11日
	 *
	 * @param length
	 *            随机数长度
	 * @return
	 */
	public static String generateNumberString(int length) {
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(NUMBER_CHAR.charAt(random.nextInt(NUMBER_CHAR.length())));
		}
		return sb.toString();
	}

	/**
	 * 创建订单编号--根据时间
	 * 
	 * @return
	 */
	public static String createOrderCode() {
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		String now = DateTimeUtils.formatOrderCode(date);
		Random random = new Random();
		String orderCode = String.valueOf(now) + String.valueOf(random.nextInt(90000) + 10000);
		return orderCode;
	}

	public static String createPayCode() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmssSSS");
		return dateFormat.format(new Date());
	}

	/**
	 * 流水号
	 *
	 * @return
	 */
	public static String generateWaterNo() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmssSSS");
		return dateFormat.format(new Date()) + generateNumberString(8);
	}


	/**
	 * 流水号
	 *
	 * @return
	 */
	public static Long waterNoLong() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmssSSS");
		return Long.parseLong(dateFormat.format(new Date()) + generateNumberString(8));
	}

	/**
	 * 流水号
	 *
	 * @return
	 */
	public static Long buildOrderNo() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmss");
		return Long.parseLong(dateFormat.format(new Date()) + generateNumberString(4));
	}
}