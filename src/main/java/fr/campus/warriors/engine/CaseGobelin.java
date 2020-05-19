package fr.campus.warriors.engine;

public class CaseGobelin extends Case {

	private int lifePoint;
	private int attackDammage;
	private String ennemyName;
	
	public CaseGobelin() {
		this.lifePoint = 6;
		this.attackDammage = 1;
		this.ennemyName = "Gobelin";
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
