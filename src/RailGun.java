
public class RailGun extends EMWeapon{

	public RailGun(Ship owner) {
		super(owner);
		name = "Rail Gun";
		attack = 12 + ((1/10) * attack);
		range = 10;
		requiredCharge = 3;
		ammo = 6;
		
	}
	
	@Override
	public void special (Ship target) {
		
	}

}
