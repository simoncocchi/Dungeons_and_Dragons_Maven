package fr.campus.warriors.engine;

public class Warrior extends Player {
	private int attackLevel;
	private int maxAttackLevel;
	private int lifePoint;
	private int maxLifePoint;
	
	public  Warrior() {
		this.attackLevel = 5;
		this.lifePoint = 5;
		this.maxAttackLevel = 10;
		this.maxLifePoint = 10;
	}

	@Override
	public String getName() {
		return "Super Guerrier";
	}

	@Override
	public String getImage() {
		return "Url de super Guerrier";
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
		if (weaponClass.equals("warrior")) {
			int basicAttackPoint = 5;
			if (basicAttackPoint+weaponDammage <=maxAttackLevel && basicAttackPoint+weaponDammage > attackLevel) {
				attackLevel += weaponDammage;
				System.out.println("Nouvelle arme set");
			} else if (basicAttackPoint+weaponDammage <= maxAttackLevel && basicAttackPoint+weaponDammage <= attackLevel) {
				System.out.println("Cette arme n'augmenterais pas vos dommage");
			}
		} else {
			System.out.println("Cette arme n'est pas pour warrior");
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
