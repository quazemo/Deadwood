import java.util.Scanner;
import java.util.ArrayList;

public class Player implements Comparable<Player>{ //implements Comparable

	// attributes
	String name;
	String location;
	int dollars;
	int credits;
	int rank;
	String roleName;
	String guiName;
	boolean turnHasHappened;

	// constructor
	public Player(String playerName, String trailer, int money, int creds) {
		name = playerName;
		location = trailer;
		dollars = money;
		credits = creds;
		rank = 1;
		guiName = null;
		roleName = "no current role"; // no role at start
		turnHasHappened = false;
	}
	// methods
	// Allows Player to move to adj. rooms
	void move(GameBoard gb) { //Room location
		// get adj rooms of cur room of Player
		// then allow player to choose which room to go to.
		ArrayList<String> adjRooms = null;
		for (int p = 0; p < gb.allRooms.size(); p++) {
			if (this.getLocation().equals(gb.allRooms.get(p).getRoomName())) {
				adjRooms = gb.allRooms.get(p).getAdjRooms();
			}
		}
		Scanner input = new Scanner(System.in);
		int newLocNum = 0;
		System.out.println("Please select the number of the room you would like to move to:\n");


		for(int i = 0; i < adjRooms.size(); i++) {
			System.out.println((i+1) + ": " + adjRooms.get(i));
		}

		newLocNum = input.nextInt();
		while((newLocNum > (adjRooms.size() + 1)) || (newLocNum == 0) || (newLocNum < 0)){
			System.out.println("Please enter in a valid room.\n");
			newLocNum = input.nextInt();
		}

		location = adjRooms.get(newLocNum);
		input.close();
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

	protected void incDollars(int d) {
		this.dollars = this.dollars + d;
	}
	//
	protected void incCredits(int c) {
		this.credits = this.credits + c;
	}

	protected void decDollars(int d) {
		this.dollars = this.dollars - d;
	}
	//
	protected void decCredits(int c) {
		this.credits = this.credits + c;
	}

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
	protected void setPlayerLocation(String loc) {
		this.location = loc;
	}
	//
	protected void setTurn(boolean turn) {
		this.turnHasHappened = turn;
	}

	// getters
	//
	public String getPlayerName() {
		return this.name;
	}
	//
	public int getDollars() {
		return this.dollars;
	}
	//
	public int getCredits() {
		return this.credits;
	}
	//
	public int getRank() {
		return this.rank;
	}
	//
	public String getRole() {
		return this.roleName;
	}
	//
	public String getLocation() {
		return this.location;
	}
	//
	public boolean getTurn() {
		return this.turnHasHappened;
	}

	@Override
	public int compareTo(Player compareP){
		int compareRank = ((Player)compareP).getRank();
		/* For Descending order do like this */
		return compareRank-this.rank;
	}

	/*@Override
	public String toString() {
        return "[ name=" + name + ", location=" + location + ", dollars=" + dollars + "rank" + rank + "role name" + roleName + "]";
    }*/
}
