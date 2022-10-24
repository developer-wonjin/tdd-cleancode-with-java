package com.cleancode.racingcar.level4.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @Test
    void create() {
        assertThat(new Name("pobi")).isEqualTo(new Name("pobi"));
    }

    @Test
    void valid(){
        assertThatThrownBy(()->{
            new Name(null);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()->{
            new Name("");
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()->{
            new Name("123456");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
