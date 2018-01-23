
public class Rocket extends Projectile{ //same as torpedo but can be shot down by PDCs
	
	protected int fuel;
	
	public Rocket(Location location, Location targetLocation) {
		super(location, targetLocation);
		damage = 15;
		speed = 4;
	}
	
	public Rocket(Location location, Ship target) {
		super(location, target);
		damage = 15; 
		speed = 4;
	}
	
	public Rocket(Location location, Location targetLocation, int damage, int speed) {
		super(location, targetLocation);
		this.damage = damage;
		this.speed = speed;
	}
	
	@Override
	public void move() {
		//same thing but...
		fuel--;
		if(fuel<=0) {
			//detonate
		}
	}

}
