package com.cleancode.racingcar.level4.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

// 깨달음1. input , output 정의하는게 중요!!!
// 깨달음2. 상태값을 move(), move(), move() 호출로 인위적으로 만들지 말고
//         생성자로 정해줘라!
// 깨달음3. 테스트를 위한 생성자 오버로딩은 얼마든지!!
// 깨달음4. 테스트를 위한 메소드추가(예. setter)는 절대로 하지 말아야함!!
//         생성자를 활용할 것, final키워드를 사용할 것


public class WinnersTest {

    @Test
    void findWinners() {
        List<Car> cars = new ArrayList<>();

        Car pobi = new Car("pobi", 3);
        cars.add(pobi);
        cars.add(new Car("jason", 2));
        cars.add(new Car("cu", 1));

        List<Car> winners = Winners.findWinners(cars);
        assertThat(winners).contains(pobi);
    }
}
