import java.util.ArrayList;
public class Player {
	
	protected ArrayList<Ship> ships = new ArrayList<Ship>();
	protected String name;
	protected boolean isTurn;
	protected double coins;
	
	public Player(String name)
	{
		this.name = name;
		coins = 50;
	}
	
	public boolean getIsTurn()
	{
		return isTurn;
	}
	public void setIsTurn (boolean b)
	{
		this.isTurn = b;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	
	public void addShip (Ship ship)
	{
		ships.add(ship);
	}

}
