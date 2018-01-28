import java.util.ArrayList;
public class Player {
	
	protected String name;
	protected boolean isTurn;
	protected int coins, iD;
	protected Fleet fleet; //why can this be accessed as if this is public
	
	public Player(String name, int iD)
	{
		this.name = name;
		coins = 50;
		this.iD = iD; //will be 1 for player 1 and 2 for player 2 hard-coded in controller
	}
	
	public int getID() {
		return iD;
	}
	public void createFleet(Player player)
	{
		this.fleet = new Fleet(player);
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
	
	public Fleet getFleet()
	{
		return fleet;
	}
	
	public void setCoins (int coins)
	{
		this.coins = coins;
	}
	
	public int getCoins()
	{
		return coins;
	}
	
	public void spendCoins(int spent)
	{
		this.coins -= spent;
	}
	

}
