/*************************************************
 * Days Object
 *
 * Responsible for the information of a day and
 * has a conditional to check for the end of game
 ************************************************/

public class Days {
	/* Attributes */
	static int dayCount;
	static int maxDays;
	boolean gameOver;

	/* Constructor */
	public Days() {
		dayCount = 0;
		maxDays = 3;
		gameOver = false;
	}

	/* Methods */
	boolean checkDays() {
		if (dayCount > maxDays) {
			return true;
		}
		return false;
	}

	void endDay() {
		dayCount++;
		if (checkDays()) {
			gameOver = true;
		}
	}

	void setDay(int days) {
		this.dayCount = days;
	}

	int getDay() {
		int currDay = this.dayCount;
		return currDay;
	}

	boolean getGameOver() {
		boolean game = this.gameOver;
		return game;
	}
}
