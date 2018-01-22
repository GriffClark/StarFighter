import java.util.ArrayList;

public class Ship extends Object{
	
	protected int speed, range, attack, health, torpedoesLeft, cost;
	protected Location location;
	protected boolean hasRailGun, hasTorpedoes;
	protected Player owner;
	
	public Ship(Location location)
	{
		this.location = location;
	}
	
	public Ship ()
	{
		
	}
	public void useAbility()
	{
		
	}
	public Location getLocation()
	{
		return location;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public void fireRailGun(Ship target)
	{
		//targets a ship you see
		if(hasRailGun == true && Controller.getDistance(target.getLocation(), location) <= 10)
		{
			target.setHealth(health -= 10);
		}
	}
	
	public void setOwner(Player owner)
	{
		this.owner = owner;
	}
	public void fireTorpedo (Location targetLocation) //this means if the ship moves the torpedo will not know and still go to the location
	{
		if(hasTorpedoes == true && torpedoesLeft >= 1)
		{
			torpedoesLeft--;
			Torpedo torpedo = new Torpedo(/*place torpedo one away from ship*/, targetLocation);
			torpedo.move(targetLocation);
			
		}
	}
}
