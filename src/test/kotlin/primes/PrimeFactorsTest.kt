package com.att.training.katas.kt.primes

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(PER_CLASS)
class PrimeFactorsTest {

    @ParameterizedTest
    @MethodSource
    fun `should return expected prime factors`(data: TestData) {
        val factors = PrimeFactors.of(data.input)
        assertThat(factors).containsExactlyElementsOf(data.expected)
    }

    fun `should return expected prime factors`() = Stream.of(
            TestData(input = 1, expected = listOf()),
            TestData(input = 2, expected = listOf(2)),
            TestData(input = 3, expected = listOf(3)),
            TestData(input = 4, expected = listOf(2, 2)),
            TestData(input = 5, expected = listOf(5)),
            TestData(input = 6, expected = listOf(2, 3)),
            TestData(input = 7, expected = listOf(7)),
            TestData(input = 8, expected = listOf(2, 2, 2)),
            TestData(input = 9, expected = listOf(3, 3)),
            TestData(input = 10, expected = listOf(2, 5)),
            TestData(input = 25, expected = listOf(5, 5)),
            TestData(input = 100, expected = listOf(2, 2, 5, 5))
    )

    data class TestData(val input: Int, val expected: List<Int>)
}