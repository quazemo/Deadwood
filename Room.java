import java.util.ArrayList;
public class Room {
	// attributes
	String roomName;
	int shotCounters;
	Card sceneCard;
	int cardX, cardY;
	//String cardRotated;
	ArrayList<String> adjRooms;
	ArrayList<Player> occupants;
	ArrayList<Role> extras;
	boolean sceneEnd;

	// constructor
	public Room(String name, Card card, int shots, ArrayList<String> rooms, ArrayList<Player> players, ArrayList<Role> extrasRoles, int x, int y) {
		shotCounters = shots;
		sceneCard = card;
		roomName = name;
		adjRooms = rooms;
		occupants = players;
		extras = extrasRoles;
		sceneEnd = false;
		cardX = x;
		cardY = y;
		//cardRotated = rotate;
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
	protected void setRoomName(String name) { this.roomName = name; }
	//
	protected void setAdjRooms(ArrayList<String> rooms) { this.adjRooms = rooms; }
	//
	protected void setCounter(int newCount) {
		this.shotCounters = newCount;
	}
	//
	protected void setCard(Card card) {
		this.sceneCard = card;
	}
	//
	protected void setSceneClosed(boolean state) {
		this.sceneEnd = state;
	}

	// getters
	public String getRoomName() {
		return this.roomName;
	}
	//
	public ArrayList<String> getAdjRooms() {
		return this.adjRooms;
	}
	//
	public ArrayList<Player> getOccupants() {
		return this.occupants;
	}
	//
	public ArrayList<Role> getExtras() {
		return this.extras;
	}
	//
	public int getShotCount() {
		return this.shotCounters;
	}
	//
	public Card getSceneCard() {
		return this.sceneCard;
	}
	//
	public boolean getSceneState() {
		return this.sceneEnd;
	}

	public int getCardX() {
		return this.cardX;
	}
	 public int getCardY() {
		return this.cardY;
	 }
}
