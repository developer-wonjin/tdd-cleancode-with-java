package com.cleancode.racingcar.level1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleStringCalculator {
    public static int[] split(String text) {
        Matcher m = Pattern.compile("\\((.*)\\)").matcher(text);
        if (m.find()) {
//            text = m.group(1);
            text = text.substring(1, text.length() - 1);
        }
        String[] values = text.split(",");
        int[] ret = toInts(values);
        return ret;
    }

    private static int[] toInts(String[] values) {
        int[] ret = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            ret[i] = toInt(values[i]);
        }
        return ret;
    }

    private static int toInt(String values) {
        int number = Integer.parseInt(values);
        if(number < 0)
            throw new RuntimeException("음수는 허용하지 않습니다.");
        return number;
    }

    public static char getCharByIdx(String abc, int idx) {
        if(idx < 0 || idx >= abc.length())
            throw new StringIndexOutOfBoundsException();
        return abc.charAt(idx);
    }
}
