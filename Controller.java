// Classes Skeleton Team 15
/* Controller Class should just initialize objects
 * and run main which loops until days are over
 */
import java.util.ArrayList;
import java.util.*;


public class Controller {

	// attributes
	int numPlayers;
	ArrayList<Player> playerOrder = new ArrayList<Player>();

	// constructor
	public Controller() {
		numPlayers = 0;
		playerOrder = new ArrayList<Player>();
		//dice = new Die[];
	}

	// methods
	/* main */
	public static void main(String[] args) {
		startGame();
		System.out.print("Successful Skeleton Initialized \n");

	}
	//
	void createPlayers(int numPlayers) {
		/* enter player names as input
		 * create player objects
		 * player order is determined here
		 */
	}
	//
	void menu() {
		// set numPlayers
	}
	//
	static void startGame() {

	}
	//
	void endGame() {
		/* display game results
		 * ask user to play again (y/n)
		 */
	}
	void endScene(Room curr, Card cardRoom){

		//curr.setSceneclosed = true;
		cardRoom.setCardDone(true);
		ArrayList<Player> playersInside = curr.getOccupants();
		ArrayList <Integer> diceVals = new ArrayList<Integer>();
		ArrayList <Integer> rankVals = new ArrayList<Integer>();
		ArrayList<Role> sRoles = cardRoom.getStarringRoles();
		Die die = new Die();

		for(int i = 0; i < playersInside.size(); i++){
			if(playersInside.get(i).getRole().equals("starring")){
				//star bonus
				int numDice = cardRoom.getBudget();
				for (int j = 0; j < numDice; j++){
					diceVals.add(die.getValue());
				}

				for(int j = 0; j < sRoles.size(); j++){
					Role r = sRoles.get(j);
					rankVals.add(r.getRank());
				}
				Collections.sort(diceVals);
				Collections.sort(rankVals);
				}
				System.out.println("You should be getting a Starring bonus \n");

			if(playersInside.get(i).getRole().equals("extra")){
				//extra bonus
				System.out.println("You should be getting a Extra bonus \n");
			}
		}
	}
	//
	int calcScore() {
		return 0;
	}
	//
	void setNumPlayers(int playerTotal) {
		this.numPlayers = playerTotal;
	}
}
