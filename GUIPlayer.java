/*************************************************
 * GUIPlayer Object
 *
 * Responsible the GUIPlayer information for the
 * in order to implement DeadWindow
 ************************************************/
import javax.swing.*;

public class GUIPlayer {
    /* Attributes */
    JLabel player;
    ImageIcon guiName;
    int xPos, yPos;

    /* Constructor */
    GUIPlayer(JLabel pl, ImageIcon png, int x, int y) {
        player = pl;
        guiName = png;
        xPos = x;
        yPos = y;
    }

    /* Methods */
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
