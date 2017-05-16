// Classes Skeleton Team 15
/* Controller Class should just initialize objects
 * and run main which loops until days are over
 */
import java.util.ArrayList;
import java.util.Scanner;
public class Controller {

	// attributes
	int numPlayers;
	ArrayList<Player> playerOrder = new ArrayList<Player>();

	// constructor
	public Controller() {
		numPlayers = 0;
		playerOrder = new ArrayList<Player>();
	}

	// methods
	/* main */
	public static void main(String[] args) {
		startGame();

	}
	//
	private boolean menu(Player player) {
		System.out.println("------WELCOME TO DEADWOOD------");
		String location = player.getLocation();
		Scanner playerInput = new Scanner(System.in);
		playerInput.toString().toLowerCase();
		String[] options = {"who = displays current player.",
				"where = what room is current player in.",
				"move = move to adjacent room.",
				"work = choose a role to work.",
				"upgrade = upgrade rank via credits or cash.",
				"rehearse = add a rehearse chip.",
				"act = player performs acting role.",
				"end = end players turn."}
		while (!playerInput.equals("end")) {
			System.out.print("Enter one of the following commands: ");

			// if player is acting in role
			if (!player.getRole().equals("no current role")) {
				System.out.println(options[0]);
				System.out.println(options[1]);
				System.out.println(options[5]);
				System.out.println(options[6]);
				System.out.println(options[7]);
				switch(String input) {
					case()
				}
			} else if (!player.getRole().equals("no current role") && (location.equals("Casting_Office"))) {
				System.out.println(options[0]);
				System.out.println(options[1]);
				System.out.println(options[4]);

			}
		}
		return true;
	}
	// temporary game board for debugging purposes
	static void startGame() {
		// create all game objects

	}
	//
	void endGame() {
		/* display game results
		 * ask user to play again (y/n)
		 */
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
