public class Player {
	// attributes
	String name;
	String location;
	int dollars;
	int credits;
	int rank;
	String roleName;
	boolean turnHasHappened;

	// constructor
	public Player(String playerName, String startLocation, int money, int creds, int playerRank) {
		name = playerName;
		location = startLocation;
		dollars = money;
		credits = creds;
		rank = playerRank;
		roleName = "no current role"; // no role at start
		turnHasHappened = false;
	}
	// methods
	void move(Room location) {

	}
	//
	void chooseRole(boolean isStar) {

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
