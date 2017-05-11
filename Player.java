import java.util.*;
public class Player {
	// attributes
	String name;
	Room location; //Room location
	int dollars;
	int credits;
	int rank;
	String roleName;
	boolean turnHasHappened;

	// constructor
	public Player(String playerName, Room trailer, int money, int creds, int playerRank) {
		name = playerName;
		location = trailer;
		dollars = money;
		credits = creds;
		rank = playerRank;
		roleName = "no current role"; // no role at start
		turnHasHappened = false;
	}
	// methods
	//Allows Player to move to adj. rooms
	void move() { //Room location
		//get adj rooms of cur room of Player
		//then allow player to choose which room to go to.
		ArrayList<Room> adjRooms = location.getAdjRooms();
		Scanner input = new Scanner(System.in);
		int newLocNum = 0;
		System.out.println("Please select the number of the room you would like to move to:\n");
		int i = 1;
		while (i < adjRooms.size() + 1){
			System.out.println( "(" + i + ") " + adjRooms.get(i-1));
			i++;
		}

		newLocNum = input.nextInt();
		while((newLocNum > (adjRooms.size() + 1)) || (newLocNum == 0) || (newLocNum < 0)){
			System.out.println("Please enter in a valid room.\n");
			newLocNum = input.nextInt();
		}

		location = adjRooms.get(newLocNum-1);

	}

	//Allows for Player to choose a role
	void chooseRole() {
		System.out.println("Starring or Extra Role?");
		//takes in user input
		Scanner input = new Scanner(System.in);
		String inputRole = input.toString().toLowerCase();
		//check for valid input
		if(!inputRole.equals("starring") && !inputRole.equals("extra")){
			System.out.println("Please enter in valid input => Starring or Extra");
			input = new Scanner(System.in);
		}else{
			this.roleName = inputRole;
		}

		input.close();

	}

	//rolls one die when needed
	int rollDie() {
		Die roll = new Die();
		//int dieRoll = roll.getValue();
		return roll.getValue();
	}

	// setters
	//
	void setDollars(int newCashBalance) {
		this.dollars = newCashBalance;
	}
	//
	void setCredits(int newCreditBalance) {
		this.credits = newCreditBalance;
	}
	//
	void setRank(int newRank) {
		this.rank = newRank;
	}
	//
	void setRole(String newRole) {
		this.roleName = newRole;
	}
	//
	void setPlayerLocation(Room loc) {
		this.location = loc;
	}
	//
	void setTurn(boolean turn) {
		this.turnHasHappened = turn;
	}

	// getters
	//
	String getPlayerName() {
		String playerName = this.name;
		return playerName;
	}
	//
	int getDollars() {
		int currDollars = this.dollars;
		return currDollars;
	}
	//
	int getCredits() {
		int currCredits = this.credits;
		return currCredits;
	}
	//
	int getRank() {
		int currRank = this.rank;
		return currRank;
	}
	//
	String getRole() {
		String currRole = this.roleName;
		return currRole;
	}
	//
	String getPlayerLocation() {
		String playerLocation = "playerLocation";
		return playerLocation;
	}
	//
	boolean getTurn() {
		boolean currTurn = this.turnHasHappened;
		return currTurn;
	}
}
