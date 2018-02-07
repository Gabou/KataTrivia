
package com.adaptionsoft.games.trivia.runner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.UnaryOperator;

import com.adaptionsoft.games.uglytrivia.Game;


public class GameRunner {

	private static boolean notAWinner;

	public static void main(String[] args) {
		Game aGame = new Game();
		
		aGame.add("Chet");
		aGame.add("Pat");
		aGame.add("Sue");
		
		Random rand = new Random();
        List<Integer> roll = new ArrayList<>();
		playGame(aGame, bound -> {
            int random = getRandom(rand, bound);
            roll.add(random);
            return random;
        });


	}

	public static void playGame(Game aGame, UnaryOperator<Integer> getRandom) {
		do {
			aGame.roll(getRandom.apply(5) + 1);

			if (getRandom.apply(9) == 7) {
				notAWinner = aGame.wrongAnswer();
			} else {
				notAWinner = aGame.wasCorrectlyAnswered();
			}
		} while (notAWinner);
	}

	private static int getRandom(Random rand, int bound) {
		return rand.nextInt(bound);
	}
}
