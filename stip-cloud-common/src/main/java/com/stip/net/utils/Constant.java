package com.stip.net.utils;

/**
 * @Package: com.stip.net
 * @Description:
 * @Author: cgnet05
 * @CreatDate: 2019/01/22
 */
public class Constant {

    public static String SUCCESS="success";
    public static String FAIL="fail";
    public static String FAIL_MESSAGE="user check failed";
    // 通用常量
    public static final String GENERAL_ZERO = "0";
    public static final String GENERAL_ONE = "1";
    public static final String GENERAL_TWO = "2";
    public static final String GENERAL_THREE = "3";
    public static final String GENERAL_FOUR = "4";
    public static final String GENERAL_FIVE = "5";
    public static final String GENERAL_SIX = "6";
    public static final String GENERAL_EIGHT = "8";
    public static final String GENERAL_NINE = "9";

    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;

    public static final String VERIFY_1 = "平台发送找回邮件";
    public static final String VERIFY_2 = "平台发送注册邮件";
    public static final String VERIFY_3 = "验证码 {0}，您正在注册成为新用户，感谢您的支持。";
    public static final String VERIFY_4 = "验证码 {0}，您正在登录，若非本人操作，请勿泄露。";
    public static final String VERIFY_5 = "验证码 {0}，您正在尝试变更重要信息，请妥善保管账户信息。";
    public static final String VERIFY_6 = "验证码 {0}，您正在修改cg.net交易所登录密码，该验证码仅用于身份验证，请勿将验证码泄露给他人使用。";

    public static final String MOBILE = "mobile";
    public static final String EMAIL = "email";
    public static final String ORDER = "order";
    public static final String ORDER_TIME_OUT = "time_out";
    public static final String ORDER_BUY_ORDER_LIMIT = "buy_order_limit";
    public static final String ORDER_SALE_ORDER_LIMIT = "sale_order_limit";
    public static final String ORDER_CANCLE_ORDER_LIMIT = "order_cancle_limit";

    public static final String ALIYUN_STATUS_1 = "01";
    public static final String ALIYUN_STATUS_2 = "02";

    public static final String SHOP_NAME_NULL = "15000";
    public static final String SHOP_MOBILE_NULL = "15001";
    public static final String SHOP_VX_PAY_CODE_NULL = "15002";
    public static final String SHOP_ALIPAY_CODE_NULL = "15003";
    public static final String SHOP_BANK_NAME_NULL = "15004";
    public static final String SHOP_BANK_NO_NULL = "15005";
    public static final String SHOP_ORGANIZATION_NUM_NULL = "15006";
    public static final String SHOP_EXIST_NULL = "15007";
    public static final String SERVER_ERROR = "15008";
    public static final String IDENTITY_AUTH_FAILED = "15009";
    public static final String SHOP_STATUS_EXCEPTION = "15010";

    public static final String ORDER_PRIVATE_KEY_NULL = "1600";
    public static final String ORDER_GAME_MONEY_NULL = "1601";
    public static final String ORDER_PAY_IMG_NULL = "1602";
    public static final String ORDER_PAY_WAY_NULL = "1603";
    public static final String ORDER_ORDER_ID_NULL = "1604";
    public static final String ORDER_NOT_EXISTS = "1605";
    public static final String ORDER_NOT_RECEIVING = "1606";

    public static final String CASH_NAME_NOT_NULL = "1700";
    public static final String CASH_MOBILE_NOT_NULL = "1701";
    public static final String CASH_MONEY_NOT_NULL = "1702";
    public static final String CASH_PAYWAY_NOT_NULL = "1703";
    public static final String CASH_ALIPAY_NOT_NULL = "1704";
    public static final String CASH_VXPAY_NOT_NULL = "1705";
    public static final String CASH_BANK_NOT_NULL = "1706";
    public static final String CASH_MONEY_SHORT = "1707";

    public static final String MARGIN_AMOUNT = "margin_amount";
    //回款支付宝二维码
    public static final String SYS_VX_QR_CODE = "sys_vx_qr_code";
    //回款微信二维码
    public static final String SYS_ALIPAY_QR_CODE = "sys_alipay_qr_code";
    public static final String SYS_BANK = "sys_bank";

    public static final String NOTIFICATION_TITLE = "抢单提醒";
    public static final String MSG_TITLE = "抢单提醒";
    public static final String MSG_CONTENT = "有新的订单，快去看看吧";
    public static final String EXTRASPARAM = "抢单提醒";

    public static final String VERIFY_MEDIA = "您的验证码是{0}";

    public static final String GBB_CN_VERIFY_MEDIA = "您的验证码为{0}";
    public static final String GBB_JP_VERIFY_MEDIA = "あなたの検証コードです{0}";
    public static final String GBB_US_VERIFY_MEDIA = "Your verification{0}";
    public static final String GBB_KO_VERIFY_MEDIA = "인증 코드{0}";

    public static final String MSG_SEND_URL = "http://api.51welink.com/json/sms/g_Submit";

    public static final String USDT = "usdt";
    public static final String MINIAPP_STORE ="store:" ;
    public static final String USER_CHILD = "user:total:child:";
    public static final String USER_STORE = "user:team:api:";

    public static String SHOP_REWARD = "shop_reward";
    public static String ORDER_REWARD = "order_reward";
    public static String INVITER_REWARD = "inviter_reward";

    //保证金支付宝二维码
    public static String SYS_FOR_ALIPAY = "sys_for_alipay";
    //保证金微信二维码
    public static String SYS_FOR_WEIPAY = "sys_for_weipay";

    //用户提现最低限制
    public static String USER_CASH_MIN = "user_cash_min";
    //商家提现最低限制
    public static String SHOP_CASH_MIN = "shop_cash_min";
    //玩家提现手续费
    public static String PLAYER_CASH_MONEY = "player_cash_money";


    /**
     * >>>>>>>>>>>>>>>>>>>>>>>>>>>>.start  redis_key_pre
     */
    //登录token
    public static String MINIAPP_TOKEN = "app:token:";

    //商品详情key
    public static String MINIAPP_PRODUCT_DETAIL = "app:product:detail:";

    //验证码-申请代理商
    public static String APPLY_AGENT = "[华西高科] 验证码 {0}，您正在申请成为代理商，若非本人操作，请勿泄露。";
    /**>>>>>>>>>>>>>>>>>>>>>>>>>>>>.end  redis_key_pre*/

    /**
     * ztmp
     */
    public static String ZTMP_USER_TOKEN = "ZTMP:USER:";


    public static String BONUS_PERCENT = "bonus_percent";

    //助记词开关
    public static String DICT_WORDS_OFF = "dict_words_off";
    //钱包 安卓下载链接
    public static String DICT_DOWN_ANDORID = "dict_down_andorid";
    //钱包 IOS下载链接
    public static String DICT_DOWN_IOS = "dict_down_ios";

    //升V1需邀请人数
    public static String LEVEL_V1_PCOUNT = "level_v1_pcount";
    //升V2需邀请人数
    public static String LEVEL_V2_PCOUNT = "level_v2_pcount";
    //升V3需邀请人数
    public static String LEVEL_V3_PCOUNT = "level_v3_pcount";

    public static long store_type_1 = 20190821999999l;//新增收货库存


    public static long store_type_2 = 20190821888888l;//新增平台库存


    public static long store_type_3 = 20190821777777l;//自提收货库存


    public static long store_type_4 = 20190821666666l;//自提平台库存

}
