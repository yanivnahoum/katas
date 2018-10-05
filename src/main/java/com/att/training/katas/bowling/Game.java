package com.att.training.katas.bowling;

class Game {

    private static final int ALL_PINS = 10;
    private final int[] rolls = new int[21];
    private int currentRoll;

    void roll(int pins) {
        rolls[currentRoll++] += pins;
    }

    int score() {
        int score = 0;
        int frameIndex = 0;
        for (int frame = 0; frame < ALL_PINS; frame++) {
            if (isStrike(frameIndex)) {
                score += ALL_PINS + rolls[frameIndex + 1] + rolls[frameIndex + 2];
                frameIndex += 1;
            }
            else if (isSpare(frameIndex)) {
                score += ALL_PINS + rolls[frameIndex + 2];
                frameIndex += 2;
            }
            else {
                score += rolls[frameIndex] + rolls[frameIndex + 1];
                frameIndex += 2;
            }
        }
        return score;
    }

    private boolean isStrike(int frameIndex) {
        return rolls[frameIndex] == ALL_PINS;
    }

    private boolean isSpare(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1] == ALL_PINS;
    }
}
