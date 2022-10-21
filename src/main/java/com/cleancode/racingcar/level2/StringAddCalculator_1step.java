package com.cleancode.racingcar.level2;

//기능1만 일단 구현
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
