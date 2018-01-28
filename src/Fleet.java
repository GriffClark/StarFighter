import java.util.ArrayList;

public class Fleet {
	
	protected ArrayList<Ship> ships = new ArrayList<Ship>();
	Player owner;
	
	public Fleet(Player owner)
	{
		this.owner = owner;
	}
	
	public void addShip (Ship s)
	{
		ships.add(s);
		s.setOwner(owner);
	}
	
	public void fleetCheck()
	{
		int fleetSize = ships.size();
		for(int i = 0; i < fleetSize; i++)
		{
			if(ships.get(i).getHealth() <= 0)
			{
				ships.get(i).setOwner(null); //do I need this line?
				ships.remove(i); //casts it into oblivion for ever and ever
				
			}
		}
	}

	public Ship getShip(int index)
	{
		return ships.get(index);
	}
	
	public ArrayList<Ship> getShip(String name)
	{
		ArrayList<Ship> localShips = new ArrayList<Ship>();
		for(int i = 0; i < ships.size(); i++)
		{
			if(ships.get(i).getName().equals(name))
			{
				localShips.add(ships.get(i));
			}
		}
		return localShips;
	}
	
	public String toString(){
		String r = "";
		for(int i = 0; i < ships.size(); i++) {
			r += ships.get(i).getName() + " at location " + ships.get(i).getLocation().toString();
		}
		return r;
	}

}
