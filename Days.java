public class Days {
	// attributes
	static int dayCount;
	static int maxDays;
	boolean gameOver;

	// constructor
	public Days() {
		dayCount = 0;
		maxDays = 3; // will be variable later
		gameOver = false;
	}

	// methods
	boolean checkDays() {
		if (dayCount > maxDays) {
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
	void setDay(int days) {
		this.dayCount = days;
	}
	//
	// getters
	int getCount() {
		int currDay = this.dayCount;
		return currDay;
	}
	int getMax() {
		return this.maxDays;
	}
	//
	boolean getGameOver() {
		boolean game = this.gameOver;
		return game;
	}
}
