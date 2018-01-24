import java.util.Scanner;

public class TestScenarioOne {
//TODO make a test scenario here where you control a auto generate ship with all features and can move it around and fire on other ships that don't move
	public static void main(String[] args) {
		Controller.initPlayers();
		Controller.initShipsDefault();
		int turnsTaken = 0;
		while(Model.getGameModel().player1.getFleet().ships.size() > 0 && Model.getGameModel().player2.getFleet().ships.size() > 0 ) {
			if(turnsTaken % 2 == 0)
			{
				System.out.println("player 1 turn");
				System.out.println("Your ships are: " + Model.getGameModel().player1.fleet.toString());
				Scanner s = new Scanner(System.in);
				System.out.println("would you like to 'move a ship' or 'end'");
				String input = s.nextLine();
				switch(input) {
				case "move a ship": System.out.println("which ship would you like to move? Format Ship #");
					input = s.nextLine();
					switch (input) {
					case"Ship 0": System.out.println("move to where?");
					//TODO finish test scenario one. Make a move towards method that moves you to the nearst location towards that point
					}
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
