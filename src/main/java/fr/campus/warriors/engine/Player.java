package fr.campus.warriors.engine;

import fr.campus.warriors.contracts.Hero;

public abstract class Player implements Hero{

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLife() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAttackLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	public abstract void setWeapon(int weaponDammage, String weaponClass);
	
	public abstract void setLife(int potionLife);

	protected abstract void setBattle(int lifePointEnnemy, int attackDammageEnnemy);
}
