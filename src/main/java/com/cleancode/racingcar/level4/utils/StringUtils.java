package com.cleancode.racingcar.level4.utils;

public class StringUtils {
    public static void checkBlank(String name, String errMsg) {
        if(name == null || name.isBlank())
            throw new IllegalArgumentException(errMsg);
    }
}
