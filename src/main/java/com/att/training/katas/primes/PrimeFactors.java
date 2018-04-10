package com.att.training.katas.primes;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {

    private PrimeFactors() {
        // No instances allowed
    }

    public static List<Integer> of(int num) {
        List<Integer> factors = new ArrayList<>();

        for (int divisor = 2; num > 1; divisor++) {
            for (; num % divisor == 0; num /= divisor) {
                factors.add(divisor);
            }
        }

        return factors;
    }
}
