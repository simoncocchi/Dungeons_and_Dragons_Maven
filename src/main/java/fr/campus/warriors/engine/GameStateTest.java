package fr.campus.warriors.engine;

import java.text.SimpleDateFormat;
import java.util.Date;

import fr.campus.warriors.contracts.GameState;
import fr.campus.warriors.contracts.GameStatus;
import fr.campus.warriors.contracts.Hero;
import fr.campus.warriors.contracts.Map;

public class GameStateTest implements GameState{
	private String myPlayerName;
	private Player myHero;
	private BasicMap selectedMap;
	private GameStatus currentGameStatus;
	private int playerPositionOnMap = 0;
	private int diceValue;
	
	public GameStateTest (String playerName, Player hero, BasicMap map) {
		this.myPlayerName = playerName;
		this.myHero = hero;
		this.selectedMap = map;
	}
	
	//setter playerPositionOnMap
	public void setPlayerPositionOnMap(int valueOfTheDice) {
		diceValue = valueOfTheDice;
		this.playerPositionOnMap += valueOfTheDice;
	}

	private void openCase() {
		Case caseToPlay = (Case) selectedMap.getBoardCase(playerPositionOnMap);
		caseToPlay.open(myHero);
	}
	
	
	@Override
	public String getPlayerName() {
		return this.myPlayerName;
	}
	
	@Override
	public Map getMap() {
		return selectedMap;
	}
	
	@Override
	public String getLastLog() {
		if (getCurrentCase() > 0 &&  getCurrentCase() < 64) {
		return "La valeur du dés lancé est de " + diceValue + ". Vous avancer donc sur la case : " + getCurrentCase() + "/" + selectedMap.getNumberOfCase() +". " + selectedMap.getBoardToString(getCurrentCase());
		} else if (getCurrentCase() >= 64 ) {
			return "Vous avez finie le jeu bien jouer";
		} else {
			return "Vous êtes sur la case : " + getCurrentCase() + "/" + selectedMap.getNumberOfCase();			
		}
			
	}
	
	@Override
	public Hero getHero() {
		return this.myHero;
	}
	
	@Override
	public GameStatus getGameStatus() {
		if (playerPositionOnMap > selectedMap.getNumberOfCase()-1 || myHero.getLife() <= 0) {
			this.currentGameStatus  = GameStatus.FINISHED;
		} else {
			this.currentGameStatus  = GameStatus.IN_PROGRESS;
			openCase();
		}
		
		return this.currentGameStatus;
	}
	
	@Override
	public String getGameId() {
		String date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
		return date;
	}
	
	@Override
	public int getCurrentCase() {
		return playerPositionOnMap;
	}
	}

