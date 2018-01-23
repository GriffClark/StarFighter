
public class EMWeapon extends Weapon{

	protected int charge, requiredCharge;
	protected boolean isCharged;
	
	public EMWeapon(Ship owner) {
		super(owner);
	}
	
	@Override
	public boolean canFire() {
		if(ammo>0 && loaded == true && charge >=3) {
			ammo--;
			charge -= 3;
			return true;
		}
		return false;
	}
	
	@Override
	public void reLoad() {
		charge++;
		if(charge >= requiredCharge) {
			isCharged = true;	
		}
		if(loaded == false) {
			loaded = true;
			ammo--;
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
	
}
