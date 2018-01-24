
public class Object {
	
	protected int speed;
	protected String name;
	protected Location location;
		protected boolean isShrouded; //stealth and shit

	public void move(Location target, Object o){
		Object[][] grid = Model.getGameModel().getGrid();		
		if(grid[target.getX()][target.getY()] == null && Controller.getDistance(target, o.getLocation()) <= o.getSpeed())
		{
			location = target;
		}
		else {
			System.out.println("invalid move attempy by " + o.getName());
		}
	}

	public int getSpeed() {
		return speed;
	}
	public void setLoation(Location location){
		this.location = location;
	}
	public Location getLocation() {
		return location;
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
	public boolean getIsShrouded()
	{
		return isShrouded;
	}
	public void setIsShrouded(boolean isShrouded)
	{
		this.isShrouded = isShrouded;
	}

}
