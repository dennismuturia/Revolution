package com.dennis.revolution_test.Framework;

import com.dennis.revolution_test.Models.Games;

import java.util.Random;

public interface Betting {
     final Random r = new Random();
     void getChanceToWin(int percentage, long playerId, Games games);
}
