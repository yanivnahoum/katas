package com.att.training.katas.karatechop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.att.training.katas.karatechop.BinarySearch.chop;
import static org.assertj.core.api.Assertions.assertThat;

class ChopTest {

    @Nested
    class TrivialCases {

        @Test
        void emptyArrayShouldReturnMinusOne() {
            assertThat(chop(3, new int[0])).isEqualTo(-1);
        }

        @Test
        void elementNotFoundShouldReturnMinusOne() {
            assertThat(chop(3, arrayOf(1))).isEqualTo(-1);
        }

        @Test
        void elementFoundInSingleElementArrayShouldReturnZero() {
            assertThat(chop(1, arrayOf(1))).isZero();
        }
    }

    @Nested
    @DisplayName("Arrays with an odd number of elements")
    class OddArrays {

        @Test
        void elementFoundOnLeft() {
            assertThat(chop(1, arrayOf(1, 3, 5))).isZero();
        }

        @Test
        void elementFoundInMiddle() {
            assertThat(chop(3, arrayOf(1, 3, 5))).isEqualTo(1);
        }

        @Test
        void elementFoundOnRight() {
            assertThat(chop(5, arrayOf(1, 3, 5))).isEqualTo(2);
        }

        @Test
        void elementNotFound() {
            assertThat(chop(0, arrayOf(1, 3, 5))).isEqualTo(-1);
            assertThat(chop(2, arrayOf(1, 3, 5))).isEqualTo(-1);
            assertThat(chop(4, arrayOf(1, 3, 5))).isEqualTo(-1);
            assertThat(chop(6, arrayOf(1, 3, 5))).isEqualTo(-1);
        }
    }

    @Nested
    @DisplayName("Arrays with an even number of elements")
    class EvenArrays {

        @Test
        void elementFoundOnLeft () {
            assertThat(chop(1, arrayOf(1, 3, 5, 7))).isZero();
        }

        @Test
        void elementFoundOnMiddleLeft() {
            assertThat(chop(3, arrayOf(1, 3, 5 ,7))).isEqualTo(1);
        }

        @Test
        void elementFoundOnMiddleRight() {
            assertThat(chop(5, arrayOf(1, 3, 5, 7))).isEqualTo(2);
        }

        @Test
        void elementFoundOnRight() {
            assertThat(chop(7, arrayOf(1, 3, 5, 7))).isEqualTo(3);
        }

        @Test
        void elementNotFound() {
            assertThat(chop(0, arrayOf(1, 3, 5, 7))).isEqualTo(-1);
            assertThat(chop(2, arrayOf(1, 3, 5, 7))).isEqualTo(-1);
            assertThat(chop(4, arrayOf(1, 3, 5, 7))).isEqualTo(-1);
            assertThat(chop(6, arrayOf(1, 3, 5, 7))).isEqualTo(-1);
            assertThat(chop(8, arrayOf(1, 3, 5, 7))).isEqualTo(-1);
        }
    }

    private int[] arrayOf(int... i) {
        return i;
    }
}

