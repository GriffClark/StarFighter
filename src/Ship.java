import java.util.ArrayList;

public class Ship extends Object{
	
	//TODO build hasMoved and hasAttacked booleans with checks and resets
	protected int speed, range, attack, health, torpedoesLeft, cost;
	protected Debuff debuff;
	protected Player owner;
	protected ArrayList<Object> thingsNearBy = new ArrayList<Object>();
	ArrayList<Location> validLocations = new ArrayList<Location>();

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

	public void scan()
	{
		if(location.getX() <= Model.getGameModel().getGrid().length && location.getY() <= Model.getGameModel().getGrid()[0].length) {			
			int xMin = location.getX() - speed;
			int xMax = location.getX() + speed;
			int yMin = location.getY() - speed;
			int yMax = location.getY() + speed;
			
			//following if statements should make sure that no locations will check out of bounds
			
			if(xMin < 0) {
				xMin = 0;
			}
			if(yMin < 0) {
				yMin = 0;
			}
			if(xMax > Model.getGameModel().getGrid().length) {
				xMax = Model.getGameModel().getGrid().length;
			}
			if(yMax > Model.getGameModel().getGrid().length) {
				yMax = Model.getGameModel().getGrid().length;
			}
			//go through list of objects and see if any of them have matching locations
			for(int i = xMin; i < xMax; i++) {
				for(int j = yMin; j < yMax; j++) {
					//FIXME method is unfinished
					//if you are player 1 search player 2's things
					//otherwise search player 1's things
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
	//FIXME below method getLocations doesn't work because data is not stored in Model.grid like I am trying to reference. Need a better but equally fast way to see if there is someone at that spot
	public void getLocations() {
			if(location.getX() <= Model.getGameModel().getGrid().length && location.getY() <= Model.getGameModel().getGrid()[0].length) {	
				validLocations = new ArrayList<Location>(); //should clear it
				int[] possibleX = new int[speed * 2];
				int[] possibleY = new int[speed*2];
				int x = location.getX() - speed;
				int y = location.getY() - speed;
				for(int i = 0; i < speed * 2; i++) {
					possibleX[i] = x;
					x++;
					possibleY[i] = y;
					y++;
					//should loop through to get all x and y values in range and add them to possibleX and possibleY
				}
				for(int i = 0; i < possibleX.length; i++) {
					for(int j = 0; j < possibleY.length; j++) {
						if(Model.getGameModel().getGrid()[i][j] == null && new Location(i,j) != location) { //cause you don't want your own location, right?
							validLocations.add(new Location(i, j));
						}
					}
				}
			}		
	}
	
	public void move(Location target) {
		for(int i = 0; i < validLocations.size(); i++) {
			if(validLocations.get(i) == target) {
				location = validLocations.get(i);
				scan(); //goes through by known objects
				getLocations(); //goes through by nearby locations
				break;
			}
		}
	}
	
	
	
}
