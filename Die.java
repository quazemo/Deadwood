/*************************************************
 * Die Object
 *
 * Responsible for all Days information and
 * has a conditional to check for the end of game
 ************************************************/
import java.util.Random;

public class Die extends Random implements Comparable<Die>{
	/* Attributes */
	int dieValue;

	/* Constructor */
	public Die() {
		dieValue = 0;
	}

	/* Methods */
	void generateRandomNumber() {
		Random rand = new Random();
		dieValue = rand.nextInt(5) + 1;
	}

	int getValue() {
		return dieValue;
	}

	@Override
	public int compareTo(Die compareD){
		int compareVal = ((Die)compareD).getValue();
		// for descending order
		return (compareVal-this.dieValue);
	}
}
