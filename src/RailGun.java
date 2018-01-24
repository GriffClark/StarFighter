
public class RailGun extends EMWeapon{

	public RailGun(Ship owner) {
		super(owner);
		name = "Rail_Gun";
		attack = 12 + ((1/10) * attack);
		range = owner.getRange() * 3 - 1;
		requiredCharge = 3;
		ammo = 6;
		
	}
	
	@Override
	public void special (Ship target) {
		
	}

}
