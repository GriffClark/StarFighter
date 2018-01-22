
public class Projectile extends Object{
	
	protected int damage;
	protected Location targetLocation;
	
	public Projectile(Location location, Location targetLocation)
	{
		this.location = location;
		this.targetLocation = targetLocation;
	}
	
	public void intercept()
	//better way to do it?
	{		
		 //can I use the Controller.aquireNearestIntercept()
	}
}
