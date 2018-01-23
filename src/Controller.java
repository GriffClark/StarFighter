import java.util.ArrayList;
import java.util.Scanner;
public class Controller {

	public static Location generateRandomLocation(int x, int y) {
		int randomX = (int)(Math.random() * x);
		int randomY = (int)(Math.random() * y);
		return new Location(randomX,randomY);
	}
	public static int getDistance(Location a, Location b) //@TODO make this a double
	{
		int dis;
		int x1 = a.getX();
		int y1 = a.getY();
		int x2 = b.getX();
		int y2 = b.getY();
		
		dis=(int)(Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1)));
		
		return dis;
		 
	}
	public static Location aquireNearestIntercept(Location targetLocation, int speed, Location myLocation)
	{
		//figures out which move gets you closest to the target but still one away. Not sure how to logic this
		int randomX = (int)(Math.random() * /*times the max?*/); //and then what else
		//same for y
		
		//make a location with the x and y
		//return that location
	}

	/*TODO
	 * build a scan method that will give you all ships with a radius away from a certain location
	 * Make it so that when ship is attacked it takes less damage for each health it has
	 */
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
	public static void initShips()
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
		
	public static void main(String[] args)
	{
		initPlayers();
		initShips();
		for(int i = 0; i < 3; i++) {
			Port p = new Port();
			p.setName("Port " + i);
			p.setLocation(Controller.generateRandomLocation(Model.getGameModel().getGrid().length, Model.getGameModel().getGrid()[0].length)); //it's a mouthful should I shorten it?
			Model.getGameModel().addPort(p);
		}
		
		//at this point everything should be initialized
		int turnsTaken = 0;
		while(Model.getGameModel().player1.getFleet().ships.size() > 0 && Model.getGameModel().player2.getFleet().ships.size() > 0 ) {
			if(turnsTaken % 2 == 0)
			{
				//player 1 turn
			}
			else {
				//player 2 turn
			}
			turnsTaken++;
		}
		//turns are over go to end phase
		
	}

}
