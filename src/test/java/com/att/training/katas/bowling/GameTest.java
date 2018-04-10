package com.att.training.katas.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {
    
    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }
    
    @Test
    void testGutterGame() {
        rollMany(20, 0);
        assertThat(game.score()).isZero();
    }

    private void rollMany(int rolls, int pins) {
        for (int i = 0; i < rolls; i++) {
            game.roll(pins);
        }
    }
    
    @Test
    void testAllOnes() {
        rollMany(20, 1);
        assertThat(game.score()).isEqualTo(20);
    }
    
    @Test
    void testOneSpare() {
        rollMany(2, 0);
        rollSpare();
        game.roll(3);
        rollMany(15, 0);
        assertThat(game.score()).isEqualTo(16);
    }
    
    @Test
    void testOneStrike() {
        rollStrike();
        game.roll(3);
        game.roll(4);
        rollMany(16, 0);
        assertThat(game.score()).isEqualTo(24);
    }
    
    @Test
    void testPerfectGame() {
        rollMany(12, 10);
        assertThat(game.score()).isEqualTo(300);
    }

    private void rollStrike() {
        game.roll(10);
    }

    private void rollSpare() {
        game.roll(5);
        game.roll(5);
    }
}
