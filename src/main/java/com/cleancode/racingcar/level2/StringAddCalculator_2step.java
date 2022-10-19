package com.cleancode.racingcar.level2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator_2step {

    public static final String DEFAULT_DELIMITER = ",|:";
    public static final String CUSTOM_DELIMETER = "//(.)\n(.*)";

    public static int splitAndSum(String text) {
        int result = 0;
        if(text == null || text.isBlank()){
            result = 0;
        }else{
            Matcher m = Pattern.compile(CUSTOM_DELIMETER).matcher(text);
            if (m.find()) {
                String customDelimiter = m.group(1);
                String[] values = m.group(2).split(customDelimiter);
                for (String value : values) {
                    result += Integer.parseInt(value);
                }
            }else{
                String[] values = text.split(DEFAULT_DELIMITER);
                for (String value : values) {
                    int number = Integer.parseInt(value);
                    if(number < 0){
                        throw new RuntimeException("음수는 허용하지 않습니다.");
                    }
                    result += number;
                }
            }
        }
        return result;
    }
}
