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
	void closeRoles() {
		// remove from availableRoles list
	}
	void update() {
		if (counter == 0) {
			wrap();
		}
	}
	//
	void wrap() {

	}
	// setters
	void setBudget(int sceneBudget) {
		this.budget = sceneBudget;
	}
	//
	void setAvailableRoles(ArrayList<Role> roles) {
		this.availableRoles = roles;
	}
	//
	void setSceneName(String name) {
		this.sceneName = name;
	}
	//
	void setSceneAvailability(boolean available) {
		this.sceneAvailable = available;
	}
	// getters
	//
	int getBudget() {
		int currBudget = this.budget;
		return currBudget;
	}
	//
	ArrayList<Role> getavailableRoles() {
		ArrayList<Role> ableRoles = this.availableRoles;
		return ableRoles;
	}
	//
	String getSceneName() {
		String name = this.sceneName;
		return name;
	}
	//
	boolean getSceneAvailability() {
		boolean available = this.sceneAvailable;
		return available;
	}
}
