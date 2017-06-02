
public class Player implements Comparable<Player> {
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
	protected void setPlayerLocation(String loc) {
		this.location = loc;
	}
	//
	protected void setTurn(boolean turn) {
		this.turnHasHappened = turn;
	}

	// getters
	protected void incDollars(int d) {
		this.dollars = this.dollars + d;
	}
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

	@Override
	public int compareTo(Player compareP){
		int compareRank = ((Player)compareP).getRank();
		/* For Descending order do like this */
		return compareRank-this.rank;
	}
	//
	public boolean getTurn() {
		return this.turnHasHappened;
	}
}
