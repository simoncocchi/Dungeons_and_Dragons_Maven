package fr.campus.warriors.engine;

public class Wizard extends Player {
	private int attackLevel;
	private int maxAttackLevel;
	private int lifePoint;
	private int maxLifePoint;
	
	public  Wizard() {
		this.attackLevel = 8;
		this.lifePoint = 3;
		this.maxAttackLevel = 15;
		this.maxLifePoint = 6;
	}

	

	@Override
	public String getName() {
		return "Super Mage";
	}

	@Override
	public String getImage() {
		return "Url de Super Mage";
	}

	@Override
	public int getLife() {
		return lifePoint;
	}

	@Override
	public int getAttackLevel() {
		return attackLevel;
	}
	
	@Override
	public void setWeapon(int weaponDammage, String weaponClass) {
		if (weaponClass.equals("wizard")) {
			int basicAttackPoint = 8;
			if (basicAttackPoint+weaponDammage <=maxAttackLevel && basicAttackPoint+weaponDammage > attackLevel) {
				attackLevel += weaponDammage;
				System.out.println("Nouvelle arme set");
			} else if (basicAttackPoint+weaponDammage <= maxAttackLevel && basicAttackPoint+weaponDammage <= attackLevel) {
				System.out.println("Cette arme n'augmenterais pas vos dommage");
			}
		} else {
			System.out.println("Cette arme n'est pas pour wizard");
		}
		
	}

	@Override
	public void setLife(int potionLife) {
		if (lifePoint == maxLifePoint) {
			System.out.println("Vos pv sont déja au max");
		} else if (lifePoint+potionLife < maxLifePoint) {
			lifePoint += potionLife;
			System.out.println("Vos PV on augmenté de " + potionLife +" et sont maintenant a " + lifePoint);
		} else {
			lifePoint = maxLifePoint;
			System.out.println("Vos PV sont maintenant a leur maximum " + lifePoint);
		}
		
	}



	@Override
	protected void setBattle(int lifePointEnnemy, int attackDammageEnnemy) {
		if (attackLevel > lifePointEnnemy) {
			
			// comment vider la case ? 
			System.out.println("Vous avez infliger " + attackLevel + " au monstre ennemy, il est n'a pas survécue");
		} else {
			System.out.println("Vous avez infliger " + attackLevel + " a votre ennemy, mais il a survécue. ");
			lifePoint -= attackDammageEnnemy;
			if (lifePoint > 0) {
				System.out.println("Vous avez survécue à l'attaque de l'ennemy");
			} else {
				System.out.println("Vous êtes mort vous n'avez pas survécue a l'attaque ennemy");
			}
		}
		
	}

}
