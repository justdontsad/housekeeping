package com.vio.util;

import java.util.UUID;

/**
 * @author vio
 * @date 2020-02-03   21:47
 */
public class UUIDUtil {
    public static String getUUID() {
        return UUID.randomUUID().toString();
    }
}
