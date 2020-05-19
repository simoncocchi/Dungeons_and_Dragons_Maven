package fr.campus.warriors.contracts;

/**
 * This interface describes the game state which should be return after each game turn
 */
public interface GameState {

	/**
	 * @return the player name
	 */
	String getPlayerName();
	
	/**
	 * @return the game unique ID
	 */
	String getGameId();
	
	/**
	 * @return the game status 
	 */
	GameStatus getGameStatus();
	
	/**
	 * @return the current hero
	 */
	Hero getHero();
	
	/**
	 * @return the current map
	 */
	Map getMap();
	
	/**
	 * @return the last log of the game. This log is displayed by the client after each game turn
	 */
	String getLastLog();
	
	/**
	 * @return the current case
	 */
	int getCurrentCase(); 
}
