import java.util.ArrayList;
public class Room {
	public Room() {
	}
	// attributes
	String roomName;
	ArrayList<Room> adjRoom = new ArrayList<Room>();
	ArrayList<Player> occupants = new ArrayList<Player>();

	// methods
	void addPlayer(Player player) {

	}
	//
	void removePlayer(Player player) {

	}
	//
	ArrayList<Room> getAdjRooms() {
		ArrayList<Room> rooms = new ArrayList<Room>();
		return rooms;
	}
}