package fr.campus.warriors.engine;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
	
	public int diceThrow(int minDiceThrow, int maxDiceThrow) {
		maxDiceThrow += 1;
		
		int diceThrowResult = ThreadLocalRandom.current().nextInt(minDiceThrow, maxDiceThrow);
		
		return diceThrowResult;
	}

}
