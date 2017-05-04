import java.util.Random;
public class Die extends Random {
	// attributes
	int dieValue;
	// constructor
	public Die() {
		dieValue = 0;
	}

	// methods
	int generateRandomNumber() {
		Random rand = new Random();
		int dieValue = rand.nextInt(5) + 1;
		return dieValue;
	}
	// getter
	int getValue() {
		dieValue = generateRandomNumber();
		return dieValue;
	}
}