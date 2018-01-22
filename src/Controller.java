import java.util.ArrayList;
import java.util.Scanner;
public class Controller {
	public static Player player1;
	public static Player player2;
	public static Player[] players = new Player[2];
	public static ArrayList<Object> liveOrdanince= new ArrayList<Object>(); //stores things like torpedoes and mines
	
	public static double getDistance(Location a, Location b) //@TODO make this a double
	{
		double dis;
		int x1 = a.getX();
		int y1 = a.getY();
		int x2 = b.getX();
		int y2 = b.getY();
		
		dis=Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
		
		return dis;
		 
	}
	public static Location aquireIntercept(Location targetLocation, int speed, Location myLocation)
	{
		int numberOfTries = 0;
		while(true) //will loop until it finds a valid location
		{
			Location testLocation = Controller.generateValidLocation(myLocation, speed);
			if(Controller.getDistance(targetLocation, testLocation) < 2)
			{
				if(Controller.getDistance(targetLocation, myLocation)<= speed )
				{
					return testLocation;
				}
				else {
					numberOfTries++;
				}
			}
			else
			{
				numberOfTries++;
			}
			if(numberOfTries > 20)
			{
				return myLocation; //prevents an infinite loop, give up and stay where you are.
			}
		}
		
	}
	public static ArrayList<Ship> getShips()
	{
		return Model.getGameModel().getShips();
	}
	public static Location generateValidLocation (Location location, int speed)
	{
		ArrayList<Ship> ships = new ArrayList<Ship>();
		int numShips = Controller.getShips().size();
		for(int i = 0; i < numShips; i++)
		{
			ships.add( Controller.getShips().get(i));
		}
		Location finalLocation = null;
		int xRange = (location.getX() + speed) - (location.getX() - speed) + 1;
		int yRange = (location.getY() + speed) - (location.getY() - speed) +1;
		int tries = 0;
		while(finalLocation == null || tries < 100)
		{
			tries ++;
			//should also put something in here to make sure the same locations don't get tested over and over
			int randomX = (int)((Math.random() * xRange) + (location.getX() - speed));
			int randomY = (int)((Math.random() * yRange) + (location.getY()  -speed));
			Location testLocation = new Location(randomX, randomY );
			boolean isTestLocationValid = true;
			
			for(int i = 0; i < ships.size(); i++)
			{
				if(testLocation == ships.get(i).getLocation())
				{
					isTestLocationValid = false;
				}
				
			}
			if(isTestLocationValid == true)
			{
				finalLocation = testLocation;
			}
			
		}
		return finalLocation;
	}
	/*TODO
	 * build a scan method that will give you all ships with a radius away from a certain location
	 */
	public static void initPlayers()

	{
		System.out.println("start player init");
		Scanner s = new Scanner(System.in);
		System.out.println("input player one name:");
		String input = s.nextLine();
		player1=new Player(input);
		player1.createFleet(player1);
		System.out.println("enter unique name for player 2");
		boolean complete = false;
		while(complete == false)
		{
			input = s.nextLine();
			if(!(input.equals(player1.getName())))
			{
				player2 = new Player(input);
				
				complete = true;
			}
		}
		player2.createFleet(player2);

		System.out.println("Player 1 is " + player1.getName() + " and player 2 is " + player2.getName());
		players[0] = player1;
		players[1] = player2;
		
	}
	public static void addShip(Player player)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("you have " + player.getCoins() + " to use");
		System.out.println("leftover coins can be used in the port to repair ships");
		System.out.println("Time to build a ship. Which features would you like? Avalabe features are:\n'rail gun' [10] or 'torpedoes'[5]");
		Ship newShip = new Ship();
		String input = keyboard.nextLine();
		if(input.equals("rail gun") && player.getCoins() >= 10) {newShip.hasRailGun = true;}
		else if (input.equals("torpedoes") && player.getCoins() >= 5){newShip.hasTorpedoes = true;}
		else {System.out.println("no feature selected or you did not have enough coins");}
		System.out.println("input the number of points you want in your ship. For testing this will auto generate ship");
		int number = keyboard.nextInt();
		if(player.getCoins() >= number)
		{
			newShip.setAttack(number);
			newShip.setHealth(number * 2);
			newShip.setSpeed((number/3) + 1);
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
	public static void initShips()
	{
		if(player1 == null || player2 == null)
		{
			System.out.println("attempt to init ships on null players" );
		}
		else
		{
			Scanner keyboard = new Scanner(System.in);
			//some of this should be seperated out into its own method
			System.out.println("For testing each player will get only two ships");
			System.out.println("time to select ships. Player 1 will choose first");
			while(player1.fleet.ships.size() <2)
			{
				addShip(player1);
			}
			System.out.println("time for Player 2");
			while(player2.fleet.ships.size() <2)
			{
				addShip(player2);
			}
			
			
			
		}
	}
	public static void main(String[] args)
	{
		initPlayers();
		initShips();
		
		
	}

}
