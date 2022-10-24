package com.cleancode.racingcar.level4.domain;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy{
    private static final int MAX_BOUND = 10;
    private static final int FORWARD_NUM = 4;
    @Override
    public boolean movable() {
        return false;
    }

    protected int getRandomNo() {
        Random random = new Random();
        return random.nextInt(MAX_BOUND);
    }
}
