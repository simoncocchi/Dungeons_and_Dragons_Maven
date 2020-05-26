package fr.campus.warriors.engine;

import fr.campus.warriors.contracts.Hero;

public abstract class Player implements Hero{
	protected String name;
	protected String image;
	protected int attackLevel;
	protected int maxAttackLevel;
	protected int lifePoint;
	protected int maxLifePoint;
	
	public Player(String name, String image, int attackLevel, int maxAttackLevel, int lifePoint, int maxLifePoint) {
		this.name = name;
		this.attackLevel = attackLevel;
		this.image = image;
		this.maxAttackLevel = maxAttackLevel;
		this.lifePoint = lifePoint;
		this.maxLifePoint = maxLifePoint;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getImage() {
		return image;
	}

	@Override
	public int getLife() {
		return lifePoint;
	}

	@Override
	public int getAttackLevel() {
		return attackLevel;
	}

	public abstract void setWeapon(int weaponDammage, String weaponClass);
	
	public abstract void setLife(int potionLife);

	protected abstract void setBattle(int lifePointEnnemy, int attackDammageEnnemy);
}
