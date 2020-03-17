package com.stip.net.utils;

/**
 * @author wangzun
 * @version 2019/5/1 下午12:56
 * @desc 订单状态常量
 */
public class HxgkOrderStatus {

    //订单状态：1待支付，2待发货，3待收货，4待评论，5已完成，6已取消
    public static final Integer WAIT_PAY = 1;
    public static final Integer WAIT_SEND = 2;
    public static final Integer WAIT_GET = 3;
    public static final Integer WAIT_COMMENT = 4;
    public static final Integer FINISHED = 5;
    public static final Integer CANCELED = 6;


}
