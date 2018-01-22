public class Port {
	
	protected Location location;
	protected String name;
	
	public Port()
	{
		
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void repairShip(Ship ship, int coinsSpent) {
		if(ship.getOwner().getCoins()>=coinsSpent) {
			//no way to tell max health so this is what's going to have to do
			ship.setHealth(ship.getHealth() + (coinsSpent * 2));
		}
		else {
			System.out.println("illigal repair by ship " + ship.getName());
		}
	}

}
