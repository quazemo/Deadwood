import java.util.Random;
public class Die extends Random implements Comparable<Die>{
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
		return this.dieValue;
	}
	@Override
	public int compareTo(Die compareD){
		int compareVal = ((Die)compareD).getValue();
		/* For Descending order do like this */
		return (compareVal-this.dieValue);
	}
}
