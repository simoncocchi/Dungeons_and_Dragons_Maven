package fr.campus.warriors.engine;

import java.util.ArrayList;
import java.util.List;

import fr.campus.warriors.contracts.Map;

public class BasicMap implements Map {
	
	protected int numberOfCase = 64;
	protected List<Case> boardGame;

	@Override
	public String getName() {
		return "BasicMap";
	}
	
	public BasicMap() {
		this.boardGame = new ArrayList<Case>();
		for (int i = 0; i < numberOfCase; i++) {
			
			if(i == 45 || i == 52 || i == 56 || i == 62 ) {
				boardGame.add(new CaseDragon());
			} else if (i == 10 || i == 20 || i == 25 || i == 32 || i == 35 || i == 36 || i == 37 || i == 40 || i == 44 || i == 47) {
				boardGame.add(new CaseSorcer());
			} else if (i == 3 || i == 6 || i == 9 || i == 12 || i == 15 || i == 18 || i == 21 || i == 24 || i == 27 || i == 30) {
				boardGame.add(new CaseGobelin());
			} else if (i == 2 || i == 11 || i == 14 || i == 19 || i == 26 ) {
				boardGame.add(new CaseBow());
			} else if (i == 5 || i == 22 || i == 38 ) {
				boardGame.add(new CaseMace());
			} else if (i == 42 || i == 53 ) {
				boardGame.add(new CaseSword());
			} else if (i == 1 || i == 4 || i == 8 || i == 17 || i == 23 ) {
				boardGame.add(new CaseThunder());
			} else if (i == 48 || i == 49 ) {
				boardGame.add(new CaseFireBall());
			} else if (i == 7 || i == 13 || i == 28 || i == 29 || i == 33 ) {
				boardGame.add(new CaseMinorPotion());
			} else if (i == 31 || i == 39 || i == 43 ) {
				boardGame.add(new CaseStandardPotion());
			} else if (i == 41 ) {
				boardGame.add(new CaseBigPotion());
			} else {
				boardGame.add(new CaseEmpty());
			}
		}
	}
	
	public Object getBoardToString(int caseToReturn){
		
		return boardGame.get(caseToReturn).toString();
	}
	
	public Case getBoardCase(int caseToReturn){
		
		return (Case) boardGame.get(caseToReturn);
	}
	
	
	@Override
	public int getNumberOfCase() {
		return numberOfCase;
	}

}
