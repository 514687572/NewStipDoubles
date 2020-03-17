package com.stip.net.base;

import org.apache.http.HttpStatus;

public class StipResponse<T> {

    /** 系统自定义错误. */
    public static int STATUS_SYSTEM = 10100;

    private int status;

    private String code;

    private String msg;

    private T data;

    public static StipResponse success(String message) {
        StipResponse stipResponse = new StipResponse();
        stipResponse.setStatus(200);
        stipResponse.setMsg(message);
        return stipResponse;
    }

    public static StipResponse success(String message, Object resultObject) {
        StipResponse stipResponse = new StipResponse();
        stipResponse.setStatus(200);
        stipResponse.setMsg(message);
        stipResponse.setData(resultObject);
        return stipResponse;
    }

    public static StipResponse error(String message) {
        StipResponse stipResponse = new StipResponse();
        stipResponse.setStatus(500);
        stipResponse.setMsg(message);
        return stipResponse;
    }

    public static StipResponse error(String code, String message) {
        StipResponse stipResponse = new StipResponse();
        stipResponse.setStatus(HttpStatus.SC_BAD_REQUEST);
        stipResponse.setCode(code);
        stipResponse.setMsg(message);
        return stipResponse;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
