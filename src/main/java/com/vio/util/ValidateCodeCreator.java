package com.vio.util;

/**
 * @author vio
 * @date 2020-02-03   18:20
 */

public class ValidateCodeCreator {

    public static String getCode() {
        Double code = Double.valueOf(Math.random() * 1000000+10000);
        return String.valueOf(code.intValue());
    }
}
