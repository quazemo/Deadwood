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
	void act(Room room, Player player, Die gbDie) {
		int actingChance = gbDie.getValue() + dieRollCounter;
		if (actingChance >= room.getSceneCard().getBudget()) {
			// act remove a chip and credits
			int counter = room.getShotCount();
			counter -= 1;
			room.setCounter(counter);
			update(room);
			if (isStar) {
				payStarring(player);
				System.out.println(player + " has received 2 credits!");
			} else {
				payExtra(player);
				System.out.println(player + " has received 1 credit and 1 dollar!");
			}
		} else {
			// if role is not starring then give extra 1 dollar if failed roll
			if (!isStar) {
				payExtraFail(player);
				System.out.println(player + " has received 1 dollar!");
			} else {
				System.out.println(player + " didn't receive 0 dollars!");
			}
		}
	}

	void update(Room rm) {
		int shotCounter = rm.getShotCount();
		if (shotCounter == 0) {
			//wrap();
		}
	}
	//
	public void payStarring(Player player) {
		// starring gets 2 credits
		int credits = player.getCredits();
		credits += 2;
		player.setCredits(credits);
	}
	//
	public void payExtra(Player player) {
		// not starring gets 1 dollar and 1 credit
		int credits = player.getCredits();
		int dollars = player.getDollars();
		credits += 1;
		dollars += 1;
		player.setCredits(credits);
		player.setDollars(dollars);
	}

	public void payExtraFail(Player player) {
		int dollars = player.getDollars();
		dollars += 1;
		player.setDollars(dollars);
	}

	// setters
	protected void setOccupied(boolean state) {
		this.occupied = state;
	}
	// getters
	protected int getRank() {
		int rank = this.rank;
		return rank;
	}
	//
	protected String getName() {
		String roleName = this.name;
		return roleName;
	}
	//
	protected boolean isStarring() {
		boolean star = this.isStar;
		return star;
	}
	//
	protected boolean isOccupied() {
		boolean occ = this.occupied;
		return occ;
	}

	protected void setAvailability(boolean t) {
		this.occupied = t;
	}

	public boolean getAvailability() {
		return this.occupied;
	}
}
