package fr.campus.warriors.engine;

public class CaseStandardPotion extends Case {
	
	private int potionHealing;
	
	public CaseStandardPotion () {
		this.potionHealing = 2;
	}
	
	@Override
	public String toString() {
		return "Vous êtes sur une case potion qui rend " + potionHealing + " PV";
		
	}

	@Override
	public void open(Player myHero) {
		myHero.setLife(potionHealing);
		
	}

}
