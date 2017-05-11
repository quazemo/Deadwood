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
	public Player(String playerName, String startLocation, int money, int creds) {
		name = playerName;
		location = startLocation;
		dollars = money;
		credits = creds;
		rank = 1;
		roleName = "no current role"; // no role at start
		turnHasHappened = false;
	}
	// methods
	void move(Room location) {

	}
	//
	void chooseRole(Role role) {
		roleName = role.getName();
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
		this.location = loc.getRoomName();
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
