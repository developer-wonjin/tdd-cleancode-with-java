package com.cleancode.racingcar.level2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator_3step {

    public static final String DEFAULT_DELIMITER = ",|:";
    public static final String CUSTOM_DELIMETER = "//(.)\n(.*)";

    public static int splitAndSum(String text) {
        if(text == null || text.isBlank()){
            return 0;
        }

        Matcher m = Pattern.compile(CUSTOM_DELIMETER).matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] values = m.group(2).split(customDelimiter);
            return sum(values);
        }
        String[] values = text.split(DEFAULT_DELIMITER);
        return sum(values);
    }

    // N번의 작업
    private static int sum(String[] values) { //int[] 타입의 파라미터에 대해서 사용할 수 없다.
        int sum = 0;
        for (String value : values) {
            int number = toInt(value); // 덧셈과 변화작업 두가지를 하고있다.
            sum += number;
        }
        return sum;
    }

    private static int toInt(String value) {
        int number = Integer.parseInt(value);
        if(number < 0)
            throw new RuntimeException("음수는 허용하지 않습니다.");
        return number;
    }
}
