/**
 * Created by brendanbaalke on 6/1/17.
 */
public class GUIPositioningRooms {
    String roomName;
    int areaX, areaY;
    GUIPositioningRooms(String rName, int x, int y) {
        roomName = rName;
        areaX = x;
        areaY = y;
    }

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
