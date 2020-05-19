package fr.campus.warriors.engine;

import java.util.ArrayList;

import fr.campus.warriors.contracts.Map;

public class BasicMap implements Map {
	
	protected int NumberOfCase = 64;
	protected ArrayList<Object> BoardGame;

	@Override
	public String getName() {
		return "BasicMap";
	}
	
	public BasicMap() {
		this.BoardGame = new ArrayList<Object>();
		for (int i = 0; i < NumberOfCase; i++) {
			
			if(i == 45 || i == 52 || i == 56 || i == 62 ) {
				BoardGame.add(new CaseDragon());
			} else if (i == 10 || i == 20 || i == 25 || i == 32 || i == 35 || i == 36 || i == 37 || i == 40 || i == 44 || i == 47) {
				BoardGame.add(new CaseSorcer());
			} else if (i == 3 || i == 6 || i == 9 || i == 12 || i == 15 || i == 18 || i == 21 || i == 24 || i == 27 || i == 30) {
				BoardGame.add(new CaseGobelin());
			} else if (i == 2 || i == 11 || i == 14 || i == 19 || i == 26 ) {
				BoardGame.add(new CaseBow());
			} else if (i == 5 || i == 22 || i == 38 ) {
				BoardGame.add(new CaseMace());
			} else if (i == 42 || i == 53 ) {
				BoardGame.add(new CaseSword());
			} else if (i == 1 || i == 4 || i == 8 || i == 17 || i == 23 ) {
				BoardGame.add(new CaseThunder());
			} else if (i == 48 || i == 49 ) {
				BoardGame.add(new CaseFireBall());
			} else if (i == 7 || i == 13 || i == 28 || i == 29 || i == 33 ) {
				BoardGame.add(new CaseMinorPotion());
			} else if (i == 31 || i == 39 || i == 43 ) {
				BoardGame.add(new CaseStandardPotion());
			} else if (i == 41 ) {
				BoardGame.add(new CaseBigPotion());
			} else {
				BoardGame.add(new CaseEmpty());
			}
		}
	}
	
	public Object getBoardToString(int caseToReturn){
		
		return BoardGame.get(caseToReturn).toString();
	}
	
	public Case getBoardCase(int caseToReturn){
		
		return (Case) BoardGame.get(caseToReturn);
	}
	
	
	@Override
	public int getNumberOfCase() {
		return NumberOfCase;
	}

}
