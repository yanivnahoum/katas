package com.att.training.katas.calculator;

import java.util.stream.Stream;

class StringCalculator {
    
    int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        var tokens = tokenize(input);
        validate(tokens);
        return Stream.of(tokens)
                     .mapToInt(Integer::parseInt)
                     .sum();
    }

    private String[] tokenize(String input) {
        return input.split("[,\\n]");
    }

    private void validate(String[] tokens) {
        var negatives = Stream.of(tokens)
                .filter(token -> token.startsWith("-"))
                .toList();

        if (!negatives.isEmpty()) {
            var message = "Negatives not allowed: " + negatives;
            throw new IllegalArgumentException(message);
        }
    }
}
