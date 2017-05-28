import java.util.Random;
public class Die extends Random {
	// attributes
	int dieValue;
	// constructor
	public Die() {
		dieValue = 0;
	}

	// methods
	void generateRandomNumber() {
		Random rand = new Random();
		dieValue = rand.nextInt(5) + 1;
	}
	// getter
	int getValue() {
		return dieValue;
	}
}
