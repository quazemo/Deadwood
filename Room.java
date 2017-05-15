import java.util.ArrayList;
public class Room {
	// attributes
	String roomName;
	ArrayList<Room> adjRooms;
	ArrayList<Player> occupants;

	// constructor
	public Room(String name) {
		roomName = name;
		adjRooms = new ArrayList<Room>();
		occupants = new ArrayList<Player>();
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

}
