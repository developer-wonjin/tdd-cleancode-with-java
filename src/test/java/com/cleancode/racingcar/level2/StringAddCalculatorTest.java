package com.cleancode.racingcar.level2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class StringAddCalculatorTest {
    @Test
    void 널_또는_빈문자열_일떄() {

        assertThat(StringAddCalculator.splitAndSum(null)).isEqualTo(0);
        assertThat(StringAddCalculator.splitAndSum("")).isEqualTo(0);
    }

    @Test
    void 쉼표구분자() {
        assertThat(StringAddCalculator.splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    void 콜론구분자() {
        assertThat(StringAddCalculator.splitAndSum("1:2")).isEqualTo(3);
    }

    @Test
    void 커스텀구분자() {
        assertThat(StringAddCalculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    void 음수를_포함할때() {
        assertThatThrownBy(()->{
            StringAddCalculator.splitAndSum("-1,2,3");
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 커스텀구분자_음수를_포함할때() {
        assertThatThrownBy(()->{
            StringAddCalculator.splitAndSum("//;\n-1;2;3");
        }).isInstanceOf(RuntimeException.class);
    }
}