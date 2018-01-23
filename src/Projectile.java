//TODO should projectiles have a limited amount of fuel before they explode?
public class Projectile extends Object{
	
	protected int damage, speed;
	protected Location targetLocation;
	protected Object target;
	protected Location myLocation;
	
	public Projectile(Location location, Location targetLocation)
	{
		this.location = location;
		this.targetLocation = targetLocation;
	}
	
	public Projectile(Location location, Object target /*maybe you can torpedo ports?*/) {
		this.location = location;
		this.target = target;
	}
	
	public void intercept()
	//better way to do it?
	{		
		 //can I use the Controller.aquireNearestIntercept()
	}
	
	public void move() {
		//if you are close enough, intercept the target
		//else, move towards the target
	}
}
