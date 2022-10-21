package com.cleancode.racingcar.level2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//모든 기능 일단 구현
//상수 정도는 static final 변수로 추출
public class StringAddCalculator_2step {

    public static final String DEFAULT_DELIMITER = ",|:";
    public static final String CUSTOM_DELIMETER = "//(.)\n(.*)";

    public static int splitAndSum(String text) {
        int result = 0; // 지역변수는 코드블록 전반에 걸쳐 신경을 쓰게 만든다.....
        if(text == null || text.isBlank()){
            result = 0;
        }else{
            Matcher m = Pattern.compile(CUSTOM_DELIMETER).matcher(text);
            if (m.find()) {
                String customDelimiter = m.group(1);
                String[] values = m.group(2).split(customDelimiter); //중복코드
                for (String value : values) {                        //중복코드
                    result += Integer.parseInt(value);
                }
            }else{
                String[] values = text.split(DEFAULT_DELIMITER); //중복코드
                for (String value : values) {                    //중복코드
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
