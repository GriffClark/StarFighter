import java.util.Scanner;
//TODO need a way to figure out when the turn is done either by running out of things to do or by choice
public class TestScenarioOne {
	
	public static void moveAShip(Location target) {
		Scanner s = new Scanner(System.in);
		System.out.println("here are your ships");
			for(int i = 0; i < Model.getGameModel().player1.fleet.ships.size(); i++) {
				System.out.println(Model.getGameModel().player1.getFleet().getShip(i).getName());
			}
			System.out.println("select a ship you would like to move by typing it's name");
			String input = s.nextLine();
			for(int i = 0; i < Model.getGameModel().player1.fleet.ships.size(); i++) {
				if(Model.getGameModel().player1.fleet.ships.get(i).getName().equals(input)) {
					Model.getGameModel().player1.fleet.ships.get(i).move(target);
				}
			}
			//FIXME this methos is backwards you should be passing in a ship and then selecting the location you wante to move to
	}
	
	public static void attackTarget() {
		Ship myShip = null;
		Scanner s = new Scanner(System.in);
		System.out.println("here are your ships");
			for(int i = 0; i < Model.getGameModel().player1.fleet.ships.size(); i++) {
				System.out.println(Model.getGameModel().player1.getFleet().getShip(i).toString());
			}
			System.out.println("select a ship you would like to attack with by typing it's name");
			String input = s.nextLine();
			for(int i = 0; i < Model.getGameModel().player1.fleet.ships.size(); i++) {
				if(Model.getGameModel().player1.fleet.ships.get(i).getName().equals(input)) {
					myShip = Model.getGameModel().player1.fleet.ships.get(i);
				}
			}
			
			System.out.println("here are the ships that " + myShip.getName() + " has on it's radar");
			myShip.scan(myShip.getOwner());
			for(int i = 0 ; i < myShip.getThingsNearBy().size(); i++) {
				System.out.println(myShip.getThingsNearBy().get(i).toString());
				//this might also print ordinance but whatever I don't care rn
			}
			
			System.out.println("here are your weapons");
			for(int i = 0; i < myShip.weapons.size(); i++) {
				System.out.println(myShip.weapons.get(i).toString());
			}
			
			System.out.println("enter the name of a ship you would like to attack with " + myShip.getName());
			input = s.nextLine();
			for(int i = 0 ; i < myShip.getThingsNearBy().size(); i++) {
				if(input.equals(myShip.thingsNearBy.get(i).getName())) {
					//TODO finish attack method
					/*
					 * select your weapon
					 * check if it target is in range of the weapon
					 * see if you need to move to be in range of the target
					 * if you need to move, move
					 * otherwise make an attack with that weapon on target
					 */
				}
			}
			
	}
//TODO make a test scenario here where you control a auto generate ship with all features and can move it around and fire on other ships that don't move
	public static void main(String[] args) {
		Controller.initPlayers();
		Controller.initShipsDefault();
		int turnsTaken = 0;
		while(Model.getGameModel().player1.getFleet().ships.size() > 0 && Model.getGameModel().player2.getFleet().ships.size() > 0 ) {
			if(turnsTaken % 2 == 0)
			{
				
				System.out.println("player 1 turn");
				for(int i = 0; i < Model.getGameModel().player1.fleet.ships.size(); i++) {
					Model.getGameModel().player1.fleet.ships.get(i).setHasAttacked(false);
					Model.getGameModel().player1.fleet.ships.get(i).setHasMoved(false);
				}
				System.out.println("Your ships are: " + Model.getGameModel().player1.fleet.toString());
				Scanner s = new Scanner(System.in);
				System.out.println("would you like to 'move a ship', 'make an attack' or 'end'");
				String input = s.nextLine();
				switch(input) {
					case "move a ship": //FIXME move so that you select the ship and pass it into the method. Also make it so hasMoved = false
						System.out.println("enter 'x''y'");
						int x = s.nextInt();
						int y = s.nextInt();
						moveAShip(new Location(x,y)); //you select the ship that you want to use while in the method. This should probalby be it's own selectAShip method
					case "make an attack":
						attackTarget(); //this can also move ship 
						
				
				}
			}
			
			else {
				System.out.println("enemy turn");
				System.out.println("enemy has ships: " + Model.getGameModel().player2.fleet.toString());
				System.out.println("enemy does not move in this scenario");
			}
			//TODO build a visual rep after all ships are moved
			turnsTaken++;
			
		}
	}
}
