import java.util.ArrayList;
public class Scene {
	// attributes
	int budget;
	boolean sceneAvailable;
	ArrayList<Role> availableRoles;
	String sceneName;

	// constructor
	public Scene(int budg, String scene) {
		budget = budg;
		sceneAvailable = true;
		availableRoles = new ArrayList<Role>();
		sceneName = scene;
	}

	// methods
	//
	void removeRoles() {
		// remove from availableRoles list

	}
	void update(Scene_Room sc_rm) {
		int shotCounter = sc_rm.getShotCount();
		if (shotCounter == 0) {
			wrap();
		}
	}
	//
	public void payStarring(Player player) {
		// starring gets 2 credits
		int credits = player.getCredits();
		credits += 2;
		player.setCredits(credits);
	}
	//
	public void payExtra(Player player) {
		// not starring gets 1 dollar and 1 credit
		int credits = player.getCredits();
		int dollars = player.getDollars();
		credits += 1;
		dollars += 1;
		player.setCredits(credits);
		player.setDollars(dollars);
	}
	//
	public void payExtraFail(Player player) {
		int dollars = player.getDollars();
		dollars += 1;
		player.setDollars(dollars);
	}
	//
	public void bonusPayout(Player player, int numDice) {

	}
	//
	// bonusPayouts
	void wrap() {

	}

	// setters
	protected void setBudget(int sceneBudget) {
		this.budget = sceneBudget;
	}
	//
	protected void setAvailableRoles(ArrayList<Role> roles) {
		this.availableRoles = roles;
	}
	//
	protected void setSceneName(String name) {
		this.sceneName = name;
	}
	//
	protected void setSceneAvailability(boolean available) {
		this.sceneAvailable = available;
	}
	// getters
	//
	public int getBudget() {
		int currBudget = this.budget;
		return currBudget;
	}
	//
	public ArrayList<Role> getavailableRoles() {
		ArrayList<Role> ableRoles = this.availableRoles;
		return ableRoles;
	}
	//
	public String getSceneName() {
		String name = this.sceneName;
		return name;
	}
	//
	public boolean getSceneAvailability() {
		boolean available = this.sceneAvailable;
		return available;
	}
}
