package com.att.training.katas.karatechop;

import org.junit.jupiter.api.Test;

import static com.att.training.katas.karatechop.BinarySearch.chop;
import static org.assertj.core.api.Assertions.assertThat;

class ChopTest {
    
    private static final int[] EMPTY = new int[0];

    @Test
    void testEmptyArray() {
        assertThat(chop(3, EMPTY)).isEqualTo(-1);
    }
    
    @Test
    void testElementNotFound() {
        assertThat(chop(3, arrayOf(1))).isEqualTo(-1);
    }
    
    @Test
    void testElementFoundInSingleElementArray() {
        assertThat(chop(1, arrayOf(1))).isEqualTo(0);
    }
    
    @Test
    void testElementFoundInOddArrayOnLeft() {
        assertThat(chop(1, arrayOf(1, 3, 5))).isEqualTo(0);
    }
    
    @Test
    void testElementFoundInOddArrayInMiddle() {
        assertThat(chop(3, arrayOf(1, 3, 5))).isEqualTo(1);
    }
    
    @Test
    void testElementFoundInOddArrayOnRight() {
        assertThat(chop(5, arrayOf(1, 3, 5))).isEqualTo(2);
    }
    
    @Test
    void testElementNotFoundInOddArray() {
        assertThat(chop(0, arrayOf(1, 3, 5))).isEqualTo(-1);
        assertThat(chop(2, arrayOf(1, 3, 5))).isEqualTo(-1);
        assertThat(chop(4, arrayOf(1, 3, 5))).isEqualTo(-1);
        assertThat(chop(6, arrayOf(1, 3, 5))).isEqualTo(-1);
    }
    
    @Test
    void testElementFoundInEvenArrayInIndex0 () {
        assertThat(chop(1, arrayOf(1, 3, 5, 7))).isEqualTo(0);
    }   
    
    
    @Test
    void testElementFoundInEvenArrayInIndex1() {
        assertThat(chop(3, arrayOf(1, 3, 5 ,7))).isEqualTo(1);
    }
    
    @Test
    void testElementFoundInEvenArrayInIndex2() {
        assertThat(chop(5, arrayOf(1, 3, 5, 7))).isEqualTo(2);
    }    
    
    @Test
    void testElementFoundInEvenArrayInIndex3() {
        assertThat(chop(7, arrayOf(1, 3, 5, 7))).isEqualTo(3);
    }    
    
    @Test
    void testElementNotFoundInEvenArray() {
        assertThat(chop(0, arrayOf(1, 3, 5, 7))).isEqualTo(-1);
        assertThat(chop(2, arrayOf(1, 3, 5, 7))).isEqualTo(-1);
        assertThat(chop(4, arrayOf(1, 3, 5, 7))).isEqualTo(-1);
        assertThat(chop(6, arrayOf(1, 3, 5, 7))).isEqualTo(-1);
        assertThat(chop(8, arrayOf(1, 3, 5, 7))).isEqualTo(-1);
    }
    
    private int[] arrayOf(int... i) {
        return i;
    }
}
    