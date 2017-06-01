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
		return this.availableRoles;
	}
	//
	public String getSceneName() {
		return this.sceneName;
	}
	//
	public boolean getSceneAvailability() {
		return this.sceneAvailable;
	}
}
