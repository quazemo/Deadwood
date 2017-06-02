import java.util.Scanner;
import java.util.ArrayList;

public class Player {
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
}
