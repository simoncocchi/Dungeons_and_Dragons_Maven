package fr.campus.warriors.engine;

public class CaseDragon extends Case {
	
	private int lifePoint;
	private int attackDammage;
	private String ennemyName;
	
	public CaseDragon() {
		this.lifePoint = 15;
		this.attackDammage = 4;
		this.ennemyName = "Dragon";
	}
	
	@Override
	public String toString() {
		return "Vous êtes sur une case combat votre ennemy est un " + ennemyName + " qui a " + lifePoint + " PV et " + attackDammage+ " de dégats";
		
	}

	@Override
	public void open(Player myHero) {
		myHero.setBattle(lifePoint,attackDammage);
		
	}

}
