package com.cleancode.racingcar.level4.domain;

import com.cleancode.racingcar.level4.utils.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private int tryNo;

    public RacingGame(String carNames, int tryNo) {
        this.cars = initCars(carNames);
        this.tryNo = tryNo;
    }

    private List<Car> initCars(String carNames) {
        StringUtils.checkBlank(carNames, "자동차 이름은 값이 존재해야 한다");
        String[] names = carNames.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public void race(){
        this.tryNo--;
        moveCars();
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    public boolean isOnRacing(){
        return this.tryNo > 0;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> getWinners(){
        return null;
    }
}
