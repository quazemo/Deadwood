public class Game_Board {
	public Game_Board() {
	}
	// attributes
	String[] playerLocations = new String[10];
	String[] roleLocations = new String[10];

	// methods
	//
	String getStartLoc(Room loc) {
		String startLocation = "Location";
		return startLocation;
	}
	//
	String getExtraLoc(Room loc) {
		String extraLocation = "extraLoc";
		return extraLocation;
	}
	//
	void setPlayerLocation(Room loc) {

	}
	//
	String getPlayerLocation(Player name) {
		String playerLocation = "playerLocation";
		return playerLocation;
	}
	//
	void move(Room loc, Player name) {

	}
}