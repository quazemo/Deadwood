/*************************************************
 * Scene Object
 *
 * Responsible for the information of a scene
 ************************************************/
import java.util.ArrayList;
public class Scene {
	/* Attributes */
	int budget;
	boolean sceneAvailable;
	ArrayList<Role> availableRoles;
	String sceneName;

	/* Constructor */
	public Scene(int budg, String scene) {
		budget = budg;
		sceneAvailable = true;
		availableRoles = new ArrayList<Role>();
		sceneName = scene;
	}

	/* Methods */
	protected void setBudget(int sceneBudget) {
		this.budget = sceneBudget;
	}

	protected void setAvailableRoles(ArrayList<Role> roles) {
		this.availableRoles = roles;
	}

	protected void setSceneName(String name) {
		this.sceneName = name;
	}

	protected void setSceneAvailability(boolean available) {
		this.sceneAvailable = available;
	}

	public int getBudget() {
		int currBudget = this.budget;
		return currBudget;
	}

	public ArrayList<Role> getavailableRoles() {
		return this.availableRoles;
	}

	public String getSceneName() {
		return this.sceneName;
	}

	public boolean getSceneAvailability() {
		return this.sceneAvailable;
	}
}
