public class Scene_Counters {
	// attributes
	int shotCounter;

	// constructor
	public Scene_Room(int shotsNeeded) {
		shotCounter = shotsNeeded;
	}

	// setters
	protected void setCounter(int newCount) {
		this.shotCounter = newCount;
	}
	//
	// getters
	public int getShotCount() {
		int currCount = this.shotCounter;
		return currCount;
	}
}
