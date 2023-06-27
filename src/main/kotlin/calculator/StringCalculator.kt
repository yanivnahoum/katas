package com.att.training.katas.kt.calculator

class StringCalculator {
    fun add(input: String): Int {
        if (input.isEmpty()) return 0

        val tokens = input.split(',', '\n')
        validate(tokens)
        return tokens.sumOf { it.toInt() }
    }

    private fun validate(tokens: List<String>) {
        val negatives = tokens.filter { it.startsWith("-") }
        if (negatives.isNotEmpty()) {
            throw IllegalArgumentException("Negatives not allowed: $negatives")
        }
    }
}
