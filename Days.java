public class Days {
	// attributes
	int dayCount;
	int maxDays;
	boolean gameOver;

	// constructor
	public Days() {
		dayCount = 0;
		maxDays = 3; // will be variable later
		gameOver = false;
	}

	// methods
	boolean checkDays() {
		if (dayCount == maxDays) {
			return true;
		}
		return false;
	}
	//
	void endDay() {
		dayCount++;
		if (checkDays()) {
			gameOver = true;
		}
	}
	// setters
	void setDays(int days) {
		this.dayCount = days;
	}
	//
	// getters
	int getDay() {
		int currDay = this.dayCount;
		return currDay;
	}
	//
	boolean getGameOver() {
		boolean game = this.gameOver;
		return game;
	}
}