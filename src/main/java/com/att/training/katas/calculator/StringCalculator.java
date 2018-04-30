package com.att.training.katas.calculator;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringCalculator {

    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        var tokens = tokenize(input);
        validate(tokens);
        return Stream.of(tokens)
                     .mapToInt(Integer::parseInt)
                     .sum();
    }

    private void validate(String[] tokens) {
        var negatives = Stream.of(tokens)
                                .mapToInt(Integer::parseInt)
                                .filter(i -> i < 0)
                                .toArray();

        if (negatives.length > 0) {
            String message = "Negatives not allowed: " + Arrays.toString(negatives);
            throw new IllegalArgumentException(message);
        }
    }

    private String[] tokenize(String input) {
        return input.split("[,\n]");
    }
}
