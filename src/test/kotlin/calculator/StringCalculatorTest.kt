package com.att.training.katas.kt.calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(PER_CLASS)
class StringCalculatorTest {

    private val calculator = StringCalculator()

    @Test
    fun `given empty string then return 0`() {
        val result = calculator.add("")
        assertThat(result).isZero()
    }

    @Test
    fun `given single number then return it`() {
        val result = calculator.add("17")
        assertThat(result).isEqualTo(17)
    }

    @ParameterizedTest
    @MethodSource
    fun `given comma or newline separated numbers then return their sum`(data: TestData) {
        val result = calculator.add(data.input)
        assertThat(result).isEqualTo(data.expected)
    }

    fun `given comma or newline separated numbers then return their sum`() = Stream.of(
            TestData(input = "1,2", expected = 3),
            TestData(input = "1\n2", expected = 3),
            TestData(input = "1,2\n3", expected = 6),
            TestData(input = "10\n20,30", expected = 60),
            TestData(input = "10\n20\n30", expected = 60)
    )

    fun `given input with negatives then throw an exception with message containing all negatives`() {
        assertThatIllegalArgumentException().isThrownBy { calculator.add("1,-3,2,-4,-5") }
                .withMessage("Negatives not allowed: [-3, -4, -5]")
    }

    data class TestData(val input: String, val expected: Int)
}