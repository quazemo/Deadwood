public class Role {
	// attributes
	int rank;
	String name;
	boolean isStar;
	boolean occupied;
	int dieRollCounter;

	// constructor
	public Role(int rankNeeded, String roleName, boolean starring, boolean taken) {
		rank = rankNeeded;
		name = roleName;
		isStar = starring;
		occupied = taken;
		dieRollCounter = 0;
	}

	// methods
	void rehearse() {
		dieRollCounter += 1;
	}
	//
	void act(Scene scene, Scene_Room scene_rm, Player player) {
		int actingChance = Game_Board.Die.getValue() + dieRollCounter;
		if (actingChance >= scene.getBudget()) {
			// act remove a chip and credits
			int counter = scene_rm.getShotCount();
			counter -= 1;
			scene_rm.setCounter(counter);
			scene.update();
			if (starring) {
				payStarring(player);
				System.out.println(player + " has received " + credits + " credits!");
			} else {
				payExtra(player);
				System.out.println(player + " has received " + credits + " credit and " + dollars + " dollar!");
			}
		} else {
			// if role is not starring then give extra 1 dollar if failed roll
			if (!starring) {
				scene.payExtraFail();
				System.out.println(player + " has received " + dollars + " dollar!");
			} else {
				System.out.println(player + " didn't receive 0 dollars!");
			}
		}
	}

	// setters
	//
	// getters
	int getRank() {
		int rank = this.rank;
		return rank;
	}
	//
	String getName() {
		String roleName = this.name;
		return roleName;
	}
	//
	boolean isStarring() {
		boolean star = this.isStar;
		return star;
	}
	//
	boolean isOccupied() {
		boolean occ = this.occupied;
		return occ;
	}
}
