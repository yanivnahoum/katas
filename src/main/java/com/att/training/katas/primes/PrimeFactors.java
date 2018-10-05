package com.att.training.katas.primes;

import java.util.ArrayList;
import java.util.List;

class PrimeFactors {

    private PrimeFactors() {
        // No instances allowed
    }

    static List<Integer> of(int num) {
        var factors = new ArrayList<Integer>();

        for (int divisor = 2; num > 1; divisor++) {
            for (; num % divisor == 0; num /= divisor) {
                factors.add(divisor);
            }
        }

        return factors;
    }
}
