
public class Weapon {

	protected Ship owner;
	protected int ammo;
	protected boolean loaded;
	String name;
	
	public Weapon(Ship owner) {
		this.owner = owner;
	}
	
	public boolean canFire() {
		if(ammo>0 && loaded == true) {
			ammo--;
			return true;
		}
		return false;
	}
	
	public void reLoad() {
		loaded = true;
	}
	
	public Ship getOwner() {
		return owner;
	}

	public void setOwner(Ship owner) {
		this.owner = owner;
	}

	public int getAmmo() {
		return ammo;
	}

	public void setAmmo(int ammo) {
		this.ammo = ammo;
	}

	public boolean isLoaded() {
		return loaded;
	}

	public void setLoaded(boolean loaded) {
		this.loaded = loaded;
	}

	public void special(Ship target) {
		//if the weapon has special abilities
	}
	
}
