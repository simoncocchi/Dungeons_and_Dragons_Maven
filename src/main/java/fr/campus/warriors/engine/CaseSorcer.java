package fr.campus.warriors.engine;

public class CaseSorcer extends Case {
	
	private int lifePoint;
	private int attackDammage;
	private String ennemyName;
	
	public CaseSorcer() {
		this.lifePoint = 9;
		this.attackDammage = 2;
		this.ennemyName = "Sorcer";
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
