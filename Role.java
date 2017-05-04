public class Role {
	// attributes
	int rank;
	String name;
	boolean isStar;
	boolean occupied;

	// constructor
	public Role(int rankNeeded, String roleName, boolean starring, boolean taken) {
		rank = rankNeeded;
		name = roleName;
		isStar = starring;
		occupied = taken;
	}

	// methods
	void rehearse() {
	}
	//
	void act() {
	}
	//
	int payment() {
		return 0;
	}
	// setters
	// no setters yet
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