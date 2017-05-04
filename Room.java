import java.util.ArrayList;
public class Room {
	// attributes
	String roomName;
	ArrayList<Room> adjRooms;
	ArrayList<Player> occupants;

	// constructor
	public Room(String name, ArrayList<Room> rooms) {
		roomName = name;
		adjRooms = rooms;
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

	// setters
	void setRoomName(String name) {
		this.roomName = name;
	}
	//
	void setAdjRooms(ArrayList<Room> rooms) {
		this.adjRooms = rooms;
	}
	//
	// getters
	String getRoomName() {
		String name = this.roomName;
		return name;
	}
	//
	ArrayList<Room> getAdjRooms() {
		ArrayList<Room> rooms = new ArrayList<Room>();
		return rooms;
	}
	//
	ArrayList<Player> getOccupants() {
		ArrayList<Player> players = new ArrayList<Player>();
		return players;
	}

}