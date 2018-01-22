import java.util.ArrayList;
public class Model {
	
	private ArrayList<Ship> ships = new ArrayList<Ship>();
	private int[] Players = new int[2];
	
	private Model()
	{
		
	}
	
	public ArrayList<Ship> getShips()
	{
		return ships;
	}
	
	private static Model privateModel = null;
	
	 public static Model getGameModel()
	    {
	      if (privateModel == null)
	      {
	        privateModel = new Model();
	      }
	      
	      return Model.privateModel; //refrencing static SingletonGameModel
	     }
	

}
