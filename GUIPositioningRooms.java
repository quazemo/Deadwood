/*************************************************
 * GUIPositioningRooms
 *
 * Responsible for the room location information for
 * forming the game board
 ************************************************/
 
public class GUIPositioningRooms {
    /* Attributes */
    String roomName;
    int areaX, areaY;

    /* Constructor */
    GUIPositioningRooms(String rName, int x, int y) {
        roomName = rName;
        areaX = x;
        areaY = y;
    }

    /* Methods */
    public String getRoomName() {
        return roomName;
    }

    public int getAreaX() {
        return areaX;
    }

    public int getAreaY() {
        return areaY;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public void setAreaX(int areaX) {
        this.areaX = areaX;
    }

    public void setAreaY(int areaY) {
        this.areaY = areaY;
    }
}
