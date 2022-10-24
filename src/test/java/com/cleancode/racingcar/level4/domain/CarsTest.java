package com.cleancode.racingcar.level4.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class CarsTest {

    @Test
    void findWinners() {

        Car pobi = new Car("pobi", 3);
        Car dole = new Car("dole", 3);
        Car yeli = new Car("yeli", 1);

        List<Car> carList = Arrays.asList(pobi, dole, yeli);
        Cars cars = new Cars(carList);
        List<Car> res = cars.findWinners();
        assertThat(cars.findWinners()).containsExactly(pobi, dole);
    }
}


