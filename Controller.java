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
		System.out.print("Successful Skeleton Initialized");
	}
	//
	void menu(Player player) {
		// set numPlayers


	}
	// temporary game board for debugging purposes
	static void startGame() {
		// create all game objects
		Controller control = new Controller();
		Days d = new Days();
		Die die = new Die();
		Game_Board gb = new Game_Board();
		//Player player = new Player("bob",, 100, 0, 1);
		Role role1 = new Role(1, "robot1", true, false);
		Role role2 = new Role(3, "robot2", true, false);
		ArrayList<Role> roles = new ArrayList<Role>();
		roles.add(role1);
		roles.add(role2);
		Scene sc1 = new Scene(100, "Transformers");
		sc1.setAvailableRoles(roles);
		Scene_Room scRoom = new Scene_Room();
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
