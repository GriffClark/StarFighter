import java.util.ArrayList;
public class Model {
	
	public  Player player1;
	public Player player2;
	private ArrayList<Object> liveOrdanince= new ArrayList<Object>(); //stores things like torpedoes and mines
	private ArrayList<Port> ports = new ArrayList<Port>();
	private Object[][] grid = new Object[30][10];
	
	public Object[][] getGrid()
	{
		return grid;
	}
	
	
	private Model()
	{
		
	}
	
	public void addPort(Port port) {
		Model.getGameModel().ports.add(port);
	}
	
	public ArrayList<Port> getPorts()
	{
		return Model.getGameModel().ports;
	}
	
	public void setPlayer(int whichPlayer, String name)
	{
		if(whichPlayer == 1)
		{
			player1.setName(name);
		}
		else if(whichPlayer == 2)
		{
			player2.setName(name);
		}
		else
		{
			System.out.println("! Invalid setPlayer for Model.setPlayers()");
		}
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
