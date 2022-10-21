package com.cleancode.racingcar.level4.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners_1step {
    public static List<Car> findWinners(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            if(maxPosition < car.getPosition()){
                maxPosition = car.getPosition();
            }
        }

        //blankLine 앞뒤로 각각 메소드추출이 가능함

        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if(car.getPosition() == maxPosition){
                winners.add(car);
            }
        }
        return winners;
    }
}
