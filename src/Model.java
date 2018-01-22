import java.util.ArrayList;
public class Model {
	
	private Player player1;
	private Player player2;
	private Player[] players = new Player[2];
	private ArrayList<Object> liveOrdanince= new ArrayList<Object>(); //stores things like torpedoes and mines
	
	
	private Model()
	{
		
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
			System.out.println("! Invalid whichPlayer for Model.setPlayers()");
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
