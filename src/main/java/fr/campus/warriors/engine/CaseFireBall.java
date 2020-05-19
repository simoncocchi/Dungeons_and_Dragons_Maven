package fr.campus.warriors.engine;

public class CaseFireBall extends Case {
	
	private int attaqueDammage;
	private String classRequired;
	
	public CaseFireBall () {
		this.attaqueDammage = 7;
		this.classRequired = "wizard";
	}
	
	@Override
	public String toString() {
		return "Vous êtes sur une case arme pour " + classRequired + " qui donne +  " + attaqueDammage + " d'attaque";
		
	}

	@Override
	public void open(Player myHero) {
		myHero.setWeapon(attaqueDammage, classRequired);
		
	}
}
