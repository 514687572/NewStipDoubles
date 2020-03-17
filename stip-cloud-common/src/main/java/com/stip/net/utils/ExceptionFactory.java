package com.stip.net.utils;

import com.stip.net.base.BizException;

/**
 * @author wangzun
 * @version 2019/4/27 上午9:09
 * @desc
 */
public class ExceptionFactory {

    public static BizException createBizException(int code, String message) {
        return new BizException(code,message);
    }

    public static BizException createWarnBizException(String message) {
        return createBizException(BizException.WARNING_CODE,message);
    }

    public static BizException createErrorBizException(String message) {
        return createBizException(BizException.ERROR_CODE,message);
    }

    public static IllegalArgumentException createIllegalException(String message) {
        return new IllegalArgumentException(message);
    }
}
