package fr.campus.warriors.engine;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import fr.campus.warriors.contracts.GameState;
import fr.campus.warriors.contracts.GameStatus;
import fr.campus.warriors.contracts.Hero;
import fr.campus.warriors.contracts.Map;
import fr.campus.warriors.contracts.WarriorsAPI;

public class Warriors implements WarriorsAPI {
	
	protected Boolean debugMode = false;
	private java.util.Map<String, GameStateTest> gameStateDictonary;
	
	 public Warriors(Boolean debugMode) {
		this.gameStateDictonary = new HashMap<String, GameStateTest>();
		this.debugMode = debugMode;
	}

	@Override
	public List<? extends Hero> getHeroes() {
		PlayerDAO characterelist = new PlayerDAO(BddConnexion.getInstance());
//		
//		class HeroDao { getHeroes() { // Connect à la table , la parcourir et renvoyer son contenu sous forme d'object de Type Warrior, Wizard, etc. } }
		return  characterelist.findAll();
	}

	@Override
	public List<? extends Map> getMaps() {
		// TODO Auto-generated method stub
		return List.of(new BasicMap());
	}

	@Override
	public GameState createGame(String playerName, Hero hero, Map map) {
		GameStateTest game = new GameStateTest(playerName,(Player) hero,(BasicMap) map);
		
		this.gameStateDictonary.put(game.getGameId() ,game);
//		this.dice = ??;

		return game;
	}

	@Override
	public GameState nextTurn(String gameID) {
		int diceThrowResult;
		/*System.out.println(debugMode);
		if (debugMode == true) {
			DiceCsv csv = new DiceCsv();
//			csv.next();
			
			diceThrowResult = 1;
		} else {*/
//			diceThrowResult = this.dice.next(); //new Dice().diceThrow(1, 6);
		//}
		diceThrowResult = new Dice().diceThrow(1, 6);
		
	    
	    GameStateTest game = gameStateDictonary.get(gameID);
	    game.setPlayerPositionOnMap(diceThrowResult);
	    
		return game;
	}

}
