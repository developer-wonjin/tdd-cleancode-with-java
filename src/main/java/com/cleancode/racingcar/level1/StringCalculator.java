package com.cleancode.racingcar.level1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static final String DEFAULT_DELIMETER = ",|:";
    public static final String CUSTOM_DELIMETER = "//(.)\n(.*)";

    public static int split(String text) {
        if(isBlank(text)){
            return 0;
        }

        Matcher m = Pattern.compile(CUSTOM_DELIMETER).matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] values= getSplit(m.group(2), customDelimiter);
            return intSum(toInts(values));
        }
        String[] values = getSplit(text, DEFAULT_DELIMETER);
        return intSum(toInts(values));
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static String[] getSplit(String text, String defaultDelimeter) {
        return text.split(defaultDelimeter);
    }

    private static int[] toInts(String[] values) {
        int[] arr = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            arr[i] = toInt(values[i]);
        }
        return arr;
    }

    /*
    private static int sum(String[] values) {
        int ret = 0;
        for (String value : values) {
            ret += toInt(value);
        }
        return ret;
    }*/
    private static int intSum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }


    private static int toInt(String value) {
        int number = Integer.parseInt(value);
        if(number < 0)
            throw new IllegalArgumentException("음수는 안돼");
        return number;
    }
}
