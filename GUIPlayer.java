import javax.swing.*;

/**
 * Created by brendanbaalke on 5/31/17.
 */
public class GUIPlayer {
    JLabel player;
    ImageIcon guiName;
    int xPos, yPos;

    GUIPlayer(JLabel pl, ImageIcon png, int x, int y) {
        player = pl;
        guiName = png;
        xPos = x;
        yPos = y;
    }

    protected void setPlayer(JLabel pl) {
        this.player = pl;
    }
    protected void setGuiName(ImageIcon png) {
        this.guiName = png;
    }
    protected void setxPos(int x) {
        this.xPos = x;
    }
    protected  void setyPos(int y) {
        this.yPos = y;
    }

    public JLabel getPlayer() {
        return this.player;
    }
    public ImageIcon getGuiName() {
        return this.guiName;
    }
}
