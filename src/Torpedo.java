
public class Torpedo extends Projectile{

	public Torpedo(Location location, Location targetLocation) {
		super(location, targetLocation);
		damage = 12;
		speed = 6;
	}
	
	public Torpedo(Location location, Location targetLocation, int damage, int speed) {
		super(location, targetLocation);
		this.damage = damage;
		this.speed = speed;
	}
	
	@Override
	public void move() {
		//do the same thing as projectile, but if you run into a ship explode 
	}

}
