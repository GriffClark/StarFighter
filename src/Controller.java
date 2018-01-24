import java.util.ArrayList;
import java.util.Scanner;
public class Controller {

	public static Location generateRandomLocation(int x, int y) {
		while(true) {
			int randomX = (int)(Math.random() * x);
			int randomY = (int)(Math.random() * y);
			
			boolean good = true;
			
			for(int i = 0; i < Model.getGameModel().player1.getFleet().ships.size(); i++) {
				if(Model.getGameModel().player1.getFleet().ships.get(i).getLocation() == new Location(randomX, randomY)) {
					good = false;
				}
			}
			
			for(int i = 0; i < Model.getGameModel().player2.getFleet().ships.size(); i++) {
				if(Model.getGameModel().player2.getFleet().ships.get(i).getLocation() == new Location(randomX, randomY)) {
					good = false;
				}
			}
			
			if(good = true) {
				return new Location(randomX,randomY);
			}
		}
		
	}
	public static int getDistance(Location a, Location b) 
	{
		int dis;
		int x1 = a.getX();
		int y1 = a.getY();
		int x2 = b.getX();
		int y2 = b.getY();
		
		dis=(int)(Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1)));
		
		return dis;
		 
	}
	
	public static ArrayList<Object> scan(Location center, int radius){
		//TODO scan won't work. Need to check by rows or by columns this just gives you a diagonal line that's been checked
		if(center.getX() <= Model.getGameModel().getGrid().length && center.getY() <= Model.getGameModel().getGrid()[0].length) {
		
			ArrayList<Object> things = new ArrayList<Object>();
			
			int[] possibleX = new int[radius * 2];
			int[] possibleY = new int[radius*2];
			int x = center.getX() - radius;
			int y = center.getY() - radius;
			
			
			for(int i = 0; i < radius * 2; i++) {
				possibleX[i] = x;
				x++;
				possibleY[i] = y;
				y++;
				//should loop through to get all x and y values in range and add them to possibleX and possibleY
				
			}
			
			for(int i = 0; i < possibleX.length; i++) {
				for(int j = 0; j < possibleY.length; j++) {
					if(Model.getGameModel().getGrid()[i][j] != null) {
						things.add(Model.getGameModel().getGrid()[i][j]);
					}
				}
				
			}
			return things;
		}		
		else {
			System.out.println("invalid search at " + center.toString());
			return null;
		}
		
		
	}
	public static Location aquireNearestIntercept(Location targetLocation, int speed, Location myLocation)
	{
		//figures out which move gets you closest to the target but still one away. Not sure how to logic this
		int randomX = (int)(Math.random() * /*times the max?*/); //and then what else
		//same for y
		
		//make a location with the x and y
		//return that location
	}

	public static void initPlayers()

	{
		
		System.out.println("start player init");
		Scanner s = new Scanner(System.in);
		System.out.println("input player one name:");
		String input = s.nextLine();
		Model.getGameModel().player1=new Player(input);
		Model.getGameModel().player1.createFleet(Model.getGameModel().player1);
		System.out.println("enter unique name for player 2");
		boolean complete = false;
		while(complete == false)
		{
			input = s.nextLine();
			if(!(input.equals(Model.getGameModel().player1.getName())))
			{
				Model.getGameModel().player2 = new Player(input);
				
				complete = true;
			}
		}
		Model.getGameModel().player2.createFleet(Model.getGameModel().player2);

		System.out.println("Player 1 is " + Model.getGameModel().player1.getName() + " and player 2 is " + Model.getGameModel().player2.getName());

		
	}
	public static void addShip(Player player)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("you have " + player.getCoins() + " to use");
		System.out.println("leftover coins can be used in the port to repair ships");
		System.out.println("Time to build a ship. Which features would you like? Avalabe features are:\n'rail gun' [10] or 'torpedoes'[5]");
		Ship newShip = new Ship();
		String input = keyboard.nextLine();
		if(input.equals("rail gun") && player.getCoins() >= 10) {new RailGun(newShip);} //should give newShip a railGun
		else if (input.equals("torpedoes") && player.getCoins() >= 5){newShip.hasTorpedoes = true;}
		else {System.out.println("no feature selected or you did not have enough coins");}
		System.out.println("input the number of points you want in your ship. For testing this will auto generate ship");
		int number = keyboard.nextInt();
		if(player.getCoins() >= number)
		{
			newShip.setAttack(number);
			newShip.setHealth(number * 2);
			newShip.setSpeed((number/3) + 1);
			newShip.setRange(newShip.getSpeed() + 1);
		}
		else
		{
			System.out.println("you did not enter valid number. You didn't have enough coins. Ship has been auto generated");
			newShip.setAttack(3);
			newShip.setSpeed(2);
			newShip.setHealth(6);
			player.setCoins(player.getCoins()+ number); //counteracts the spendCoins down below
		}
		
		player.spendCoins(number);
		player.fleet.addShip(newShip);
	}
	public static void initShipsCustom()
	{
		if(Model.getGameModel().player1 == null || Model.getGameModel().player2 == null)
		{
			System.out.println("attempt to init ships on null players" );
		}
		else
		{
			Scanner keyboard = new Scanner(System.in);
			//some of this should be seperated out into its own method
			System.out.println("For testing each player will get only two ships");
			System.out.println("time to select ships. Player 1 will choose first");
			while(Model.getGameModel().player1.fleet.ships.size() <2)
			{
				//uses addShip method from Controller
				addShip(Model.getGameModel().player1);
			}
			System.out.println("time for Player 2");
			while(Model.getGameModel().player2.fleet.ships.size() <2)
			{
				addShip(Model.getGameModel().player2);
			}
			
			
			
		}
	}
	
	public static Location moveTowards(Location target, Location myLocation) {
		/*TODO finish this method
		 * figure out where you are
		 * scan the spots around you
		 * find the spot that has the smallest getDistance to target
		 * return that location
		 */
	}
	public static void initShipsDefault() {
		/*
		 * randomly generates ships
		 * ignores coins because both players get random ships
		 * auto places ships for you
		 */
		int shipsToAdd = 5;
		int shipsAdded = 0;
		while(shipsAdded < shipsToAdd) {
			Ship ship = new Ship();
			int featureMaker = (int)(Math.random() * 10);
			ship.setAttack((int)(Math.random() * 50));
			ship.setHealth((int)(Math.random() * 100) + ship.getAttack());
			ship.setSpeed((int)(Math.random() * 10) + 1);
			ship.setName("Ship " + shipsAdded);
			
			ship.weapons.add(new PDC(ship));
			if(featureMaker % 2 == 0) {
				ship.weapons.add(new RailGun(ship));
			}
			int yValue = (int)(Math.random() * Model.getGameModel().getGrid()[0].length);
			ship.setLocation(0, yValue);
			Model.getGameModel().player1.fleet.addShip(ship);
			yValue = (int)(Math.random() * Model.getGameModel().getGrid()[0].length);
			ship.setLocation(Model.getGameModel().getGrid().length -1, yValue); 
			Model.getGameModel().player2.fleet.addShip(ship);	
			shipsAdded++;
		}
		System.out.println("done init ships. Each player has the following:");
		for(int i = 0; i < Model.getGameModel().player1.fleet.ships.size(); i++) {
			Model.getGameModel().player1.fleet.ships.get(i).ls();
			System.out.println();
		}
		
	}
	public static void main(String[] args)
	{
		Model.getGameModel().addFeature("Rail Gun");
		Model.getGameModel().addFeature("PDC");
		Model.getGameModel().addFeature("Ports");
		initPlayers();
		initShipsDefault();
		if(Model.getGameModel().findFeature("Ports") == true) {

			for(int i = 0; i < 3; i++) {
				Port p = new Port();
				p.setName("Port " + i);
				p.setLocation(Controller.generateRandomLocation(Model.getGameModel().getGrid().length, Model.getGameModel().getGrid()[0].length)); //it's a mouthful should I shorten it?
				Model.getGameModel().addPort(p);
			}
		}
		
		//at this point everything should be initialized
		int turnsTaken = 0;
		
		while(Model.getGameModel().player1.getFleet().ships.size() > 0 && Model.getGameModel().player2.getFleet().ships.size() > 0 ) {
			if(turnsTaken % 2 == 0)
			{
				System.out.println("player 1 turn");
			}
			else {
				System.out.println("player 2 turn");
				
			}
			turnsTaken++;
			
			//debug
			if(turnsTaken > 10) {
				break;
			}
		}
		//turns are over go to end phase
		
	
	}

}
