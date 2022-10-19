package com.cleancode.racingcar.level2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator_5step {

    public static final String DEFAULT_DELIMITER = ",|:";
    public static final String CUSTOM_DELIMETER = "//(.)\n(.*)";

    public static int splitAndSum(String text) {
        if(isBlank(text)){
            return 0;
        }

        Matcher m = Pattern.compile(CUSTOM_DELIMETER).matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] values = split(m.group(2), customDelimiter);
            return sum(toInts(values));
        }
        String[] values = split(text, DEFAULT_DELIMITER);
        return sum(toInts(values)); // 2N번의 작업
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    //테스트 코드를 실패로 만듬.... 원복 시켜라
    private static String[] split(String text, String defaultDelimiter) {
        String[] values = text.split(defaultDelimiter);
        return values;
    }

    // 컴포즈 메소드 패턴
    // N번의 작업
    private static int[] toInts(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = toInt(values[i]); // 변환 작업만 한다.
        }
        return numbers;
    }

    // N번의 작업
    private static int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;                  // 덧셈 작업만 한다.
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
