
public class EMWeapon extends Weapon{

	protected int charge, requiredCharge;
	protected boolean isCharged;
	
	public EMWeapon(Ship owner) {
		super(owner);
	}
	
	@Override
	public void reLoad() {
		if(charge >= requiredCharge) {
			isCharged = true;
		}
		else {
			charge++;
		}
		
		if(loaded == false) {
			loaded = true;
		}
	}
	
	public int getCharge() {
		return charge;
	}

	public void setCharge(int charge) {
		this.charge = charge;
	}

	public int getRequiredCharge() {
		return requiredCharge;
	}

	public void setRequiredCharge(int requiredCharge) {
		this.requiredCharge = requiredCharge;
	}

	public boolean isCharged() {
		return isCharged;
	}

	public void setCharged(boolean isCharged) {
		this.isCharged = isCharged;
	}

	@Override
	public void fire(Ship target) {
		
		if(isCharged == true && loaded == true && ammo > 0 && Controller.getDistance(target.getLocation(), owner.getLocation()) <= range) {
			special(target);
			target.setHealth(target.getHealth() - attack);
			ammo--;
		}
		else{System.out.println("no ammo");}
		
	}
	
}
