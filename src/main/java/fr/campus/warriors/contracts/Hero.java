package fr.campus.warriors.contracts;

/**
 * This interface contains all data needed by the client about the hero
 */
public interface Hero {

	/**
	 * @return the name of the hero
	 */
	String getName();

	/**
	 * @return the image of the hero
	 */
	String getImage();

	/**
	 * @return the life level of the hero
	 */
	int getLife();

	/**
	 * @return the attack level of the hero
	 */
	int getAttackLevel();
}