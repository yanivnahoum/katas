package com.att.training.katas.primes;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PrimeFactorsTest {
    
    @Test
    void test1() {
        var factors = PrimeFactors.of(1);
        assertThat(factors).isEmpty();
    }

    @Test
    void test2() {
        var factors = PrimeFactors.of(2);
        assertThat(factors).containsExactly(2);
    }

    @Test
    void test3() {
        var factors = PrimeFactors.of(3);
        assertThat(factors).containsExactly(3);
    }

    @Test
    void test4() {
        var factors = PrimeFactors.of(4);
        assertThat(factors).containsExactly(2, 2);
    }

    @Test
    void test5() {
        var factors = PrimeFactors.of(5);
        assertThat(factors).containsExactly(5);
    }

    @Test
    void test6() {
        var factors = PrimeFactors.of(6);
        assertThat(factors).containsExactly(2, 3);
    }

    @Test
    void test7() {
        var factors = PrimeFactors.of(7);
        assertThat(factors).containsExactly(7);
    }

    @Test
    void test8() {
        var factors = PrimeFactors.of(8);
        assertThat(factors).containsExactly(2, 2, 2);
    }

    @Test
    void test9() {
        var factors = PrimeFactors.of(9);
        assertThat(factors).containsExactly(3, 3);
    }

    @Test
    void test25() {
        var factors = PrimeFactors.of(25);
        assertThat(factors).containsExactly(5, 5);
    }
}
