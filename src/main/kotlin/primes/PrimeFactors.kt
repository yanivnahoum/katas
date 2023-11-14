package com.att.training.katas.kt.primes

object PrimeFactors {
    fun of(input: Int): List<Int> {
        val factors = mutableListOf<Int>()
        var dividend = input
        var divisor = 2

        while (dividend > 1) {
            while (dividend % divisor == 0) {
                factors.add(divisor)
                dividend /= divisor
            }
            divisor++
        }

        return factors
    }
}
