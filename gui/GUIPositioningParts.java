/**
 * Created by brendanbaalke on 6/1/17.
 */
public class GUIPositioningParts {
    String roomName;
    String partName;
    int partX, partY;
    GUIPositioningParts(String rName, String pName, int x, int y) {
        roomName = rName;
        partName = pName;
        partX = x;
        partY = y;
    }

    public int getPartX() {
        return partX;
    }

    public int getPartY() {
        return partY;
    }

    public String getPartName() {
        return partName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public void setPartX(int partX) {
        this.partX = partX;
    }

    public void setPartY(int partY) {
        this.partY = partY;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
}

