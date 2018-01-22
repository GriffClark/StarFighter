import java.util.ArrayList;
import java.util.Scanner;
public class Controller {
	public static Player p1;
	public static Player p2;
	public ArrayList<Ship> shipsNotChosen = new ArrayList<Ship>();
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
		while(finalLocation == null)
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
		p1=new Player(input);
		System.out.println("enter unique name for player 2");
		boolean complete = false;
		while(complete == false)
		{
			input = s.nextLine();
			if(!(input.equals(p1.getName())))
			{
				complete = true;
			}
		}
		
		System.out.println("Player 1 is " + p1.getName() + " and player 2 is " + p2.getName());
		
	}
	
	
	public static void initShips()
	{
		if(p1 == null || p2 == null)
		{
			System.out.println("attempt to init ships on null players" );
		}
		else
		{
			System.out.println("time to select ships. Player 1 will choose first");
		}
	}
	public static void main(String[] args)
	{
		
	}

}
