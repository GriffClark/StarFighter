
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
		 int numberOfTries = 0;
		 Location curretnTestLocation = Controller.generateValidLocation(location, speed);
			while(true) //will loop until it finds a valid location
			{
				Location testLocation = Controller.generateValidLocation(location, speed);
				if(Controller.getDistance(targetLocation, testLocation) < Controller.getDistance(targetLocation, curretnTestLocation))
				{
					
				}

				numberOfTries++;
				if(numberOfTries > 50)
				{
					break; //prevents an infinite loop, give up and stay where you are.
				}
			}
			

	}
}
