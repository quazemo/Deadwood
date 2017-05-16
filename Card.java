import java.util.*;

public class Card{
  int sceneNum;
  int budget;
  String cardName;
  ArrayList<Role> starring;
  boolean isCardDone;


  public Card(int num, int b, String cName, ArrayList<Role> sRoles) {
    sceneNum = num;
    budget =  b;
    cardName = cName;
    starring = sRoles;
    isCardDone = false;

	}

  protected String getCardName(){
    return this.cardName;
  }

  protected int getBudget(){
    return this.budget;
  }

  protected ArrayList<Role> getStarringRoles(){
    return this.starring;
  }
  protected String getRole(int i) {
    return this.starring.get(i).getName();
  }


}
