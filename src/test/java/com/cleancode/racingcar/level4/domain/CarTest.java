package com.cleancode.racingcar.level4.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    void 더_먼_이동거리_구하기() {
        Car car = new Car("pobi", 3);
        assertThat(car.fartherPosition(new Position(2))).isEqualTo(new Position(3));
        assertThat(car.fartherPosition(new Position(5))).isEqualTo(new Position(5));
    }

    @Test
    void 최대이동거리_유무() {
        Position maxPosition = new Position(3);

        assertThat(new Car("pobi", 3).isWinner(maxPosition)).isTrue();
        assertThat(new Car("pobi", 2).isWinner(maxPosition)).isFalse();
    }

    @Test
    void 이동() {
        Car car = new Car("pobi");
        car.move(() -> true);
        assertThat(car).isEqualTo(new Car("pobi", 1));
    }

    @Test
    void 정지() {
        Car car = new Car("pobi");
        car.move(() -> false);
        assertThat(car).isEqualTo(new Car("pobi", 0));
    }

}