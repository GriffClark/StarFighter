
public class Object {
	
	protected int speed;
	protected String name;
	protected Location location;
	
	public void move(Location target, int speed)
	{
		//moves as close to target as it can
		if(target.getEmpty() == true)
		{
			location = target;
			//this is incorrect. Use the scan method in controller that needs to be built
		}
	}
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
