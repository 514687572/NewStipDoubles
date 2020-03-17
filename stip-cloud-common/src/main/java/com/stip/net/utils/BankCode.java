package com.stip.net.utils;

public enum BankCode {
    GS("工商银行","1002"),
    NY("农业银行","1005"),
    ZG("中国银行","1026"),
    JS("建设银行","1003"),
    ZS("招商银行","1001"),
    YC("邮储银行","1066"),
    JT("交通银行","1020"),
    PF("浦发银行","1004"),
    MS("民生银行","1006"),
    XY("兴业银行","1009"),
    PA("平安银行","1010"),
    ZX("中信银行","1021"),
    HX("华夏银行","1025"),
    GF("广发银行","1027"),
    GD("光大银行","1022"),
    BJ("北京银行","4836"),
    NB("宁波银行","1056"),
    SH("上海银行","1024");


    private BankCode(String name, String code) {
        this.name = name;
        this.code = code;
    }

    private String name;

    public static String getByName(String open) {
        for (BankCode bankCode : BankCode.values()) {
            if (bankCode.getName().equalsIgnoreCase(open)) {
                return bankCode.getCode();
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String code;
}
