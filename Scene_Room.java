public class Scene_Room {
	// attributes
	int shotCounter;

	// constructor
	public Scene_Room(int shotsNeeded) {
		shotCounter = shotsNeeded;
	}

	// setters
	void setCounter(int newCount) {
		this.shotCounter = newCount;
	}
	//
	// getters
	int getShotCount() {
		int currCount = this.shotCounter;
		return currCount;
	}
}
