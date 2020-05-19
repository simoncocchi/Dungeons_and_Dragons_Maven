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
	
	private java.util.Map<String, GameStateTest> gameStateDictonary;
	
	 public Warriors() {
		this.gameStateDictonary = new HashMap<String, GameStateTest>();
	}

	@Override
	public List<? extends Hero> getHeroes() {
		// TODO Auto-generated method stub
		return List.of(new Warrior(), new Wizard());
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

		return game;
	}

	@Override
	public GameState nextTurn(String gameID) {

		int diceThrowResult = new Dice().diceThrow(1, 6);
	    
	    GameStateTest game = gameStateDictonary.get(gameID);
	    game.setPlayerPositionOnMap(diceThrowResult);
	    
		return game;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
