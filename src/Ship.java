import java.util.ArrayList;

public class Ship extends Object{
	
	protected int speed, range, attack, health, torpedoesLeft, cost;
	protected Debuff debuff;
	protected Player owner;
	protected ArrayList<Object> thingsNearBy = new ArrayList<Object>();
	
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
	public void setOwner(Player owner)
	{
		this.owner = owner;
	}
	public Player getOwner()
	{
		return owner;
	}

	//TODO build scan method
	public void scan()
	{
		
	}
	
	
}
