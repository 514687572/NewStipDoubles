package com.stip.net.utils;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 主键生成
 *
 * @author cja
 */
public class GrnerateUUID {

    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
