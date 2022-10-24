package com.cleancode.racingcar.level4.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {
    @Test
    void create_bad() {
        //안 좋은 코드
        Position position = new Position(3);
        assertThat(position.getPosition()).isEqualTo(3);
    }

    @Test
    void create_good() {
        assertThat(new Position(3)).isEqualTo(new Position(3));
    }

    @Test
    void valid() {
        assertThatThrownBy(()->{
            new Position(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void move() {
        Position position = new Position(3);
        assertThat(position.move()).isEqualTo(new Position(4));
    }
}
