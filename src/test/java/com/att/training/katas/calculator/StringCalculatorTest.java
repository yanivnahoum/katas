package com.att.training.katas.calculator;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    void init() {
        calculator = new StringCalculator();
    }

    @Test
    void addShouldReturnZeroOnEmptyString() {
        int result = calculator.add("");
        assertThat(result).isZero();
    }

    @Test
    void shouldReturnNumberOnSingleNumber() {
        int result = calculator.add("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldAddTwoNumbers() {
        int result = calculator.add("1,3");
        assertThat(result).isEqualTo(4);
    }

    @Test
    void shouldAddMultipleNumbers() {
        int result = calculator.add("1,3,2");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void shouldAddMultipleNumbersWithNewline() {
        int result = calculator.add("1\n3,2");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void shouldThrowExceptionWhenNegativeInput() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.add("-1,3,-2"))
                .withMessage("Negatives not allowed: [-1, -2]");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> calculator.add("-1,3,-2"))
                .withMessage("Negatives not allowed: [-1, -2]");


        assertThatThrownBy(() -> calculator.add("-1,3,-2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Negatives not allowed: [-1, -2]");
    }
}
