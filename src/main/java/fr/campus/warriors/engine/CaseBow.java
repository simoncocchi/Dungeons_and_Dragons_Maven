package fr.campus.warriors.engine;

public class CaseBow extends Case {
	
	private String classRequired; 
	private int attaqueDammage;
	
	public CaseBow () {
		this.attaqueDammage = 1;
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
