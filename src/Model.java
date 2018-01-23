import java.util.ArrayList;
public class Model {
	
	public  Player player1;
	public Player player2;
	private ArrayList<Port> ports = new ArrayList<Port>();
	private Object[][] grid = new Object[30][10];
	private ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	
	public Player getPlayer1() {
		return player1;
	}


	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}


	public Player getPlayer2() {
		return player2;
	}


	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}


	public ArrayList<Projectile> getProjectiles() {
		return projectiles;
	}


	public void setProjectiles(ArrayList<Projectile> projectiles) {
		this.projectiles = projectiles;
	}


	public static Model getPrivateModel() {
		return privateModel;
	}


	public static void setPrivateModel(Model privateModel) {
		Model.privateModel = privateModel;
	}


	public void setPorts(ArrayList<Port> ports) {
		this.ports = ports;
	}


	public void setGrid(Object[][] grid) {
		this.grid = grid;
	}


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
