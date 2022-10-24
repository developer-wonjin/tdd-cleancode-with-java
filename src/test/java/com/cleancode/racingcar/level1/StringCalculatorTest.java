package com.cleancode.racingcar.level1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


public class StringCalculatorTest {

    @Test
    void 콤마구분자_있음() {
        assertThat(SimpleStringCalculator.split("1,2")).contains(1);
        assertThat(SimpleStringCalculator.split("1,2")).contains(2);
        assertThat(SimpleStringCalculator.split("1,2")).contains(1,2);
        assertThat(SimpleStringCalculator.split("1,2")).contains(2,1);

        assertThat(SimpleStringCalculator.split("1,2")).containsOnly(1,2);
        assertThat(SimpleStringCalculator.split("1,2")).containsOnly(2,1);
        assertThat(SimpleStringCalculator.split("1,2")).containsOnly(1,1,2);
        assertThat(SimpleStringCalculator.split("1,2")).containsOnly(1,1,2,2);

        assertThat(SimpleStringCalculator.split("1,2")).containsExactly(1,2);

    }

    @Test
    void 콤마구분자_없음() {
        assertThat(SimpleStringCalculator.split("1")).containsExactly(1);
    }

    @Test
    void 괄호_있음() {
        assertThat(SimpleStringCalculator.split("(1,2)")).containsExactly(1,2);
    }

    @Test
    void charAt테스트() {
        assertThat(SimpleStringCalculator.getCharByIdx("abc", 1)).isEqualTo('b');
        assertThat(SimpleStringCalculator.getCharByIdx("abc", 2)).isEqualTo('c');
        assertThatThrownBy(()->{
            SimpleStringCalculator.getCharByIdx("abc", -1);
        }).isInstanceOf(IndexOutOfBoundsException.class);

        assertThatThrownBy(()->{
            SimpleStringCalculator.getCharByIdx("abc", 3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)

        ;
    }
}
