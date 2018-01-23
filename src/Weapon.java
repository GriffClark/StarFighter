
public class Weapon {

	protected Ship owner;
	protected int ammo, range, attack;
	protected boolean loaded;
	String name;
	
	public Weapon(Ship owner) {
		this.owner = owner;
	}
	
	public void fire(Ship target) // is there a way to do it without needing my location passed in?
	{
		if(loaded == true && ammo > 0 && Controller.getDistance(target.getLocation(), owner.getLocation()) <= range) {
			special(target);
			target.setHealth(target.getHealth() - attack);
			ammo--;
		}
		else{System.out.println("no ammo");}
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

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
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
