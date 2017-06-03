/*************************************************
 * Card Object
 *
 * Responsible for the information of a scene card
 ************************************************/

import java.util.*;

public class Card {
    /* Attributes */
    int sceneNum;
    int budget;
    String cardName;
    ArrayList<Role> starring;
    boolean isCardDone;

    /* Constructor */
    public Card(int num, int b, String cName, ArrayList<Role> sRoles) {
        sceneNum = num;
        budget = b;
        cardName = cName;
        starring = sRoles;
        isCardDone = false;
    }

    /* Methods */
    protected boolean setCardDone(boolean t) {
        return this.isCardDone = t;
    }

    protected String getCardName() {
        return this.cardName;
    }

    protected int getBudget() {
        return this.budget;
    }

    protected ArrayList<Role> getStarringRoles() {
        return this.starring;
    }

    protected String getRole(int i) {
        return this.starring.get(i).getName();
    }

    protected Role getRoleObj(int i) {
        return this.starring.get(i);
    }
}
