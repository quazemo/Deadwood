import java.util.Random;
public class Die extends Random {
	// attributes
	int dieValue;

	public Die() {
	}

	// methods
	int generateRandomNumber() {
		Random rand = new Random();
		int dieValue = rand.nextInt(5) + 1;
		return dieValue;
	}
	//
	int getValue() {
		return 0;
	}
}