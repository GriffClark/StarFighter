import java.util.ArrayList;

public class Weapon {

	protected Ship owner;
	protected int ammo, attack, range, uID; //FIXME make each weapon have a unique identifier so that they can be easily referenced from the command line 
	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getuID() {
		return uID;
	}

	public void setuID(int uID) {
		this.uID = uID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	protected boolean loaded;
	String name;
	
	public Weapon(Ship owner) {
		this.owner = owner;
		range = owner.getRange();
	}
	
	public int getAttack() {
		return attack;
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
	
	public void fire(Ship target) {
		if (canFire() == true && Controller.getDistance(owner.getLocation(), target.getLocation()) <= range) {
			special(target);
			target.takeDamage(attack);
		}

		
	}

	public void special(Ship target, ArrayList<Object> thingsNearBy) {
		
		
	}
	
}
