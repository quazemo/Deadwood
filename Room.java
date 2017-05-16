import java.util.ArrayList;
public class Room {
	// attributes
	String roomName;
	int shotCounters;
	Card sceneCard;
	ArrayList<Room> adjRooms;
	ArrayList<Player> occupants;
	ArrayList<Scene> extras;

	// constructor
	public Room(String name, int shots, ArrayList<Room> rooms, ArrayList<Player> players, ArrayList<Scene> extrasRoles) {
		shotCounters = shots;
		sceneCard = null;
		roomName = name;
		adjRooms = rooms;
		occupants = players;
		extras = extrasRoles;
	}

	// methods
	void addPlayer(Player player) {
		this.occupants.add(player);
	}
	//
	void removePlayer(Player player) {
		this.occupants.remove(player);
	}
	void addRoom(Room room) {
		this.adjRooms.add(room);
	}

	// setters
	protected void setRoomName(String name) { this.roomName = name; }
	//
	protected void setAdjRooms(ArrayList<Room> rooms) { this.adjRooms = rooms; }
	//
	protected void setCounter(int newCount) {
		this.shotCounter = newCount;
	}
	//
	protected void setCard(Card card) { this.sceneCard = card; }
	// getters
	public String getRoomName() {
		String name = this.roomName;
		return name;
	}

	//
	public ArrayList<Room> getAdjRooms() {
		ArrayList<Room> rooms = new ArrayList<Room>();
		return rooms;
	}
	//
	public ArrayList<Player> getOccupants() {
		ArrayList<Player> players = new ArrayList<Player>();
		return players;
	}
	//
	public int getShotCount() {
		int currCount = this.shotCounter;
		return currCount;
	}
	//
	public Card getSceneCard() {
		Card roomCard = this.sceneCard;
		return roomCard;
	}
}
