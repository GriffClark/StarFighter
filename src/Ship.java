import java.util.ArrayList;

public class Ship extends Object{
	
	protected int speed, range, attack, health, torpedoesLeft, cost;
	protected Debuff debuff;
	protected Player owner;
	protected ArrayList<Object> thingsNearBy = new ArrayList<Object>();
	ArrayList<Weapon> weapons = new ArrayList<Weapon>();
	
	
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
	
	public void takeDamage(int damage ) {
		health -= (int)(((health*debuff.getHealthDebuff()) - damage) +.5);
	}
	
	public int attackDamage() {
		int damageDealt = (int) (attack  - (attack * debuff.getAttackDebuff()) + .5); 
		//so again a large debuff means you will deal less damage, with 1 meaning you will deal no damage
		return damageDealt;
	}
	
	public void dealDamage(Ship target) { //this is the base dealDamage based on your range
		if(Controller.getDistance(target.getLocation(), location) <= range) {
			target.takeDamage((attackDamage()/2)+1);
		}
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
		//scans first for all of player 1's things, then for all of player 2's things
		//adds all nearby things to your arrayList, friend or fo. or should I have it see if it is owned by the same player to not add it?
		
		for(int i = 0 ; i < Model.getGameModel().player1.fleet.ships.size(); i++) {
			Location testLocation = Model.getGameModel().player1.fleet.ships.get(i).getLocation();
			if(Controller.getDistance(testLocation, location) <= range *2) {
				thingsNearBy.add(Model.getGameModel().player1.fleet.ships.get(i));
			}
		}
		
		for(int i = 0 ; i < Model.getGameModel().player2.fleet.ships.size(); i++) {
			Location testLocation = Model.getGameModel().player2.fleet.ships.get(i).getLocation();
			if(Controller.getDistance(testLocation, location) <= range *2) {
				thingsNearBy.add(Model.getGameModel().player1.fleet.ships.get(i));
			}
		}
	}
	
	
}
