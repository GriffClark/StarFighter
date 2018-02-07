import java.util.Scanner;
//TODO need a way to figure out when the turn is done either by running out of things to do or by choice
public class TestScenarioOne {
	
	public static void attackTarget() {
		
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
				for(int i = 0; i < Model.getGameModel().player1.getFleet().ships.size(); i++) {
					Model.getGameModel().player1.getFleet().ships.get(i).setHasAttacked(false);
					Model.getGameModel().player1.getFleet().ships.get(i).setHasMoved(false);
				}
				System.out.println("Your ships are: " + Model.getGameModel().player1.getFleet().toString());
				Scanner s = new Scanner(System.in);
				System.out.println("would you like to 'move a ship', 'make an attack' or 'end'");
				String input = s.nextLine();
				switch(input) {
					case "move a ship": 
						System.out.println("which ship would you like to move?");
						input = s.nextLine();
						for(int i = 0; i < Model.getGameModel().player1.getFleet().ships.size(); i++) {
							if(Model.getGameModel().player1.getFleet().ships.get(i).getName().equals(input)) {
								System.out.println("Where would you like ot move it?");
								System.out.println("'x''y'");
								int inX = s.nextInt();
								int inY = s.nextInt();
								Controller.makeAMove(Model.getGameModel().player1.getFleet().getShip(i), new Location(inX,inY));
								break;
							}
						}
						System.out.println("Move has been made");
						
					case "make an attack":
						Ship placeHolder = null;
						System.out.println("Select a ship you would like to attack with");
						for(int i = 0; i < Model.getGameModel().player1.getFleet().ships.size(); i++) {
							Model.getGameModel().player1.getFleet().ships.get(i).ls();
							placeHolder = Model.getGameModel().player1.getFleet().ships.get(i);
						}
						input = s.nextLine();
						for(int i = 0; i < Model.getGameModel().player1.getFleet().ships.size(); i++) {
							if(Model.getGameModel().player1.getFleet().ships.get(i).getName().equals(input)) {
								System.out.println(" you chose " + Model.getGameModel().player1.getFleet().ships.get(i).getName() + " at location " + Model.getGameModel().player1.getFleet().ships.get(i).getLocation().toString());
								System.out.println("for testing purposes, you will now attack with all weapon that is in range");
								for(int j = 0; j < placeHolder.getThingsNearBy().size(); j++) {
									System.out.println(placeHolder.getThingsNearBy().get(j).getName() + " @Location " + placeHolder.getThingsNearBy().get(j).getLocation().toString());
								}
								System.out.println("enter the name of the ship you would like to attack");
								input = s.nextLine();
								for(int j = 0; j < placeHolder.getThingsNearBy().size(); j++) {
									if(placeHolder.getThingsNearBy().get(j).getName().equals(input)) {
										for(int k = 0; k < placeHolder.getWeapons().size(); k++) {
											placeHolder.getWeapons().get(k).fire((Ship) placeHolder.getThingsNearBy().get(j));
											//FIXME this will error out if a non-ship is entered. Should throw my own exception just not sure what
											break;
											//this should break everything but not sure
										}
									}
								}
							}
						}
				}
			}
			
			else {
				System.out.println("enemy turn");
				System.out.println("enemy has ships: " + Model.getGameModel().player2.getFleet().toString());
				System.out.println("enemy does not move in this scenario");
			}
			//TODO build a visual rep after all ships are moved
			turnsTaken++;
			
		}
	}
}
