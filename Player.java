import java.util.Scanner;
import java.util.ArrayList;

public class Player {
	// attributes
	String name;
	Room location;
	int dollars;
	int credits;
	int rank;
	String roleName;
	boolean turnHasHappened;

	// constructor
	public Player(String playerName, Room trailer, int money, int creds) {
		name = playerName;
		location = trailer;
		dollars = money;
		credits = creds;
		rank = 1;
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
			System.out.println("Please enter a valid input => Starring or Extra");
			input = new Scanner(System.in);
		}else{
			this.roleName = inputRole;
		}

		input.close();

	}
	//
	void rollDie() {
		Die dice = new Die();
		dice.generateRandomNumber();
	}
	//
	int spend() {
		return 0;
	}
	// setters
	//
	protected void setDollars(int newCashBalance) {
		this.dollars = newCashBalance;
	}
	//
	protected void setCredits(int newCreditBalance) {
		this.credits = newCreditBalance;
	}
	//
	protected void setRank(int newRank) {
		this.rank = newRank;
	}
	//
	protected void setRole(String newRole) {
		this.roleName = newRole;
	}
	//
	protected void setPlayerLocation(Room loc) {
		this.location = loc;
	}
	//
	protected void setTurn(boolean turn) {
		this.turnHasHappened = turn;
	}

	// getters
	//
	public String getPlayerName() {
		String playerName = this.name;
		return playerName;
	}
	//
	public int getDollars() {
		int currDollars = this.dollars;
		return currDollars;
	}
	//
	public int getCredits() {
		int currCredits = this.credits;
		return currCredits;
	}
	//
	public int getRank() {
		int currRank = this.rank;
		return currRank;
	}
	//
	public String getRole() {
		String currRole = this.roleName;
		return currRole;
	}
	//
	public String getPlayerLocation() {
		String playerLocation = "playerLocation";
		return playerLocation;
	}
	//
	public boolean getTurn() {
		boolean currTurn = this.turnHasHappened;
		return currTurn;
	}
}
