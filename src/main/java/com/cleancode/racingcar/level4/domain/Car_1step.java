package com.cleancode.racingcar.level4.domain;


import com.cleancode.racingcar.level4.utils.StringUtils;

import java.util.Random;

/*
* 우승자를 구하기 어려운 설계를 지님
* */
public class Car_1step {


    private static final int MAX_BOUND = 10;
    private static final int FORWARD_NUM = 4;
    private final String name;
    private int position = 0;

    public Car_1step(String name) {
        StringUtils.checkBlank(name, "자동차 이름은 값이 존재해야 한다");
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
    
    public void move(){
        Random random = new Random();
        int randomNo = random.nextInt(MAX_BOUND);
        if(randomNo >= FORWARD_NUM)
            this.position++;
    }
}
