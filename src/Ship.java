import java.util.ArrayList;

public class Ship extends Object{
	
	protected int speed, range, attack, health, torpedoesLeft, cost;
	protected Debuff debuff;
	protected Player owner;
	protected ArrayList<Object> thingsNearBy = new ArrayList<Object>();
	protected ArrayList<Location> validLocations = new ArrayList<Location>();
	protected boolean hasMoved, hasAttacked;

	public ArrayList<Location> getValidLocations() {
		return validLocations;
	}

	public void setValidLocations(ArrayList<Location> validLocations) {
		this.validLocations = validLocations;
	}

	public boolean isHasMoved() {
		return hasMoved;
	}

	public void setHasMoved(boolean hasMoved) {
		this.hasMoved = hasMoved;
	}

	public boolean isHasAttacked() {
		return hasAttacked;
	}

	public void setHasAttacked(boolean hasAttacked) {
		this.hasAttacked = hasAttacked;
	}

	ArrayList<Weapon> weapons = new ArrayList<Weapon>();
	
	
	public Ship(Location location)
	{
		this.location = location;
	}
	
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getTorpedoesLeft() {
		return torpedoesLeft;
	}

	public void setTorpedoesLeft(int torpedoesLeft) {
		this.torpedoesLeft = torpedoesLeft;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public Debuff getDebuff() {
		return debuff;
	}

	public void setDebuff(Debuff debuff) {
		this.debuff = debuff;
	}

	public ArrayList<Object> getThingsNearBy() {
		return thingsNearBy;
	}

	public void setThingsNearBy(ArrayList<Object> thingsNearBy) {
		this.thingsNearBy = thingsNearBy;
	}

	public ArrayList<Weapon> getWeapons() {
		return weapons;
	}

	public void setWeapons(ArrayList<Weapon> weapons) {
		this.weapons = weapons;
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

	public void scan(Player getScanned)
	{
		if(location.getX() <= Model.getGameModel().getGrid().length && location.getY() <= Model.getGameModel().getGrid()[0].length) { //makes sure you are on the grid			
			//loops through all the enemies ships and if they are in sight of your ship add it to thingsNearBy
			for(int i = 0; i < getScanned.fleet.ships.size(); i++) {
				Ship question = getScanned.fleet.ships.get(i);
				if(Controller.getDistance(question.getLocation(), location) <= speed * 2) {
							thingsNearBy.add(question);
				}
			}
		}
	}
		
	
	public void ls() {
		System.out.println(name + " owned by: " + owner.getName() + " \nattack: " + attack + "\thealth: " + health + "\tspeed: " + speed + "\nweapons:");
		for(int i = 0; i < weapons.size(); i++) {
			System.out.print(weapons.get(i).name + " // ");
		}
		System.out.println();
	}
	public void getLocations() {
		validLocations = new ArrayList<Location>();
		for(int i = 0; i < Controller.scanLocations(location, speed).size(); i++) {
			validLocations.add(Controller.scanLocations(location, speed).get(i));		}
	}
	
	public void move(Location target) {
		for(int i = 0; i < validLocations.size(); i++) {
			if(validLocations.get(i) == target) {
				location = validLocations.get(i);
				if(owner.getID() == 1) {
					scan(Model.getGameModel().player2);
				}
				//for now these IDs are hard-coded because I have no better way of doing it
				else if(owner.getID() == 2) {
					scan(Model.getGameModel().player1);
				}
				 //goes through by known objects
				getLocations(); //goes through by nearby locations
				break;
			}
		}
	}
	
	
	
}
