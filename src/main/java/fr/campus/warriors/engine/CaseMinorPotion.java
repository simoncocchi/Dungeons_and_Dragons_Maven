package fr.campus.warriors.engine;

public class CaseMinorPotion extends Case {
	
	private int potionHealing;
	
	public CaseMinorPotion () {
		this.potionHealing = 1;
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
