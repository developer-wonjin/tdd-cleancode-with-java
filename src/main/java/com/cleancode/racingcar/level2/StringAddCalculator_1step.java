package com.cleancode.racingcar.level2;

public class StringAddCalculator_1step {

    public static int splitAndSum(String text) {
        int result = 0;
        if(text == null || text.isBlank()){
            result = 0;
        }else{
            String[] values = text.split(",");
            for (String value : values) {
                result += Integer.parseInt(value);
            }
        }
        return result;
    }
}
