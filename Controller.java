import java.util.ArrayList;
// Classes Skeleton Team 15
public class Controller {
	public Controller() {
	}

	// attributes
	int numPlayers;
	ArrayList<Player> playerOrder = new ArrayList<Player>();
	
	// methods
	public static void main(String[] args) {
		Controller control = new Controller();
		Day d = new Day();
		Die die = new Die();
		Game_Board gb = new Game_Board();
		Player player = new Player();
		Role role = new Role();
		Scene sc1 = new Scene();
		Scene_Room scRoom = new Scene_Room();
		System.out.print("Successful Skeleton Initialized");
	}
	//
	void createPlayers(int numPlayers) {

	}
	// updates location, rank, and cash by player
	void updateInfo(Player name) {

	}
	//
	boolean playerTurn(String playerName) {
		return false;
	}
	//
	void menu() {

	}
	//
	void startGame() {

	}
	//
	void endGame() {

	}
	//
	int calcScore() {
		return 0;
	}
	//
	void endDay() {

	}
}
