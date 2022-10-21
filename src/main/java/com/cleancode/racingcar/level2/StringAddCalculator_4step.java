package com.cleancode.racingcar.level2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator_4step {

    public static final String DEFAULT_DELIMITER = ",|:";
    public static final String CUSTOM_DELIMETER = "//(.)\n(.*)";

    public static int splitAndSum(String text) {
        if(text == null || text.isBlank()){      // 메소드 추출 가능
            return 0;
        }

        Matcher m = Pattern.compile(CUSTOM_DELIMETER).matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] values = m.group(2).split(customDelimiter);    //코드 중복
            return sum(toIntArray(values));
        }
        String[] values = text.split(DEFAULT_DELIMITER);            //코드 중복
        return sum(toIntArray(values));
    }
    private static int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    private static int[] toIntArray(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = toInt(values[i]);
        }
        return numbers;
    }


    private static int toInt(String value) {
        int number = Integer.parseInt(value);
        if(number < 0)
            throw new RuntimeException("음수는 허용하지 않습니다.");
        return number;
    }
}
