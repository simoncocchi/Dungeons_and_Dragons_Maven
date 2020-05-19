package fr.campus.warriors.engine;

public class CaseSword extends Case {
	
	private int attaqueDammage;
	private String classRequired;
	
	public CaseSword () {
		this.attaqueDammage = 5;
		this.classRequired = "warrior";
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
