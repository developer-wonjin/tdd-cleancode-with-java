package com.cleancode.racingcar.level4.domain;

import java.util.ArrayList;
import java.util.List;

// 깨달음1. getter 메소드가 보인다면 무조건 리페토링 껀덕지가 남아있음!!
public class Winners_2step {
    public static List<Car> findWinners(List<Car> cars) {
        return findWinners(cars, maxPostion(cars));
    }

    private static List<Car> findWinners(List<Car> cars, int maxPosition) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if(car.getPosition() == maxPosition){ //getter 메소드가 보인다면 무조건 리페토링 껀덕지가 남아있음!!
                winners.add(car);
            }
        }
        return winners;
    }

    private static int maxPostion(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            if(maxPosition < car.getPosition()){ //getter 메소드 발견!
                maxPosition = car.getPosition(); //getter 메소드 발견!
            }
        }
        return maxPosition;
    }
}
