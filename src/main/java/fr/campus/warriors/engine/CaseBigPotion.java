package fr.campus.warriors.engine;

public class CaseBigPotion extends Case {
	
	private int potionHealing;
	
	public CaseBigPotion () {
		this.potionHealing = 5;
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
