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
	void act(Scene scene, Scene_Room scene_rm, Player player, Die gbDie) {
		int actingChance = gbDie.getValue() + dieRollCounter;
		if (actingChance >= scene.getBudget()) {
			// act remove a chip and credits
			int counter = scene_rm.getShotCount();
			counter -= 1;
			scene_rm.setCounter(counter);
			scene.update(scene_rm);
			if (isStar) {
				scene.payStarring(player);
				System.out.println(player + " has received 2 credits!");
			} else {
				scene.payExtra(player);
				System.out.println(player + " has received 1 credit and 1 dollar!");
			}
		} else {
			// if role is not starring then give extra 1 dollar if failed roll
			if (!isStar) {
				scene.payExtraFail(player);
				System.out.println(player + " has received 1 dollar!");
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
