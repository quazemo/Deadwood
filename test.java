import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class test{

  public static void main(String[] args) {
    File f = new File("Scene_Cards.txt");
    ArrayList<Role> starring = new ArrayList<Role>();
    ArrayList<Card> deck = new ArrayList<Card>();

    try{
      Scanner lineScanner = new Scanner(f);
      for(int i = 0; i < 40; i++){
        if(lineScanner.hasNextLine()){
          String line = lineScanner.nextLine();
          //System.out.println(line);
          Scanner cardScanner = new Scanner(line).useDelimiter(" ");
          int sNum = cardScanner.nextInt();
          int budget = cardScanner.nextInt();
          String sceneName = cardScanner.next();
          while(cardScanner.hasNext()) {
            try{
              int rank = cardScanner.nextInt();
              String name = cardScanner.next();
              Role role = new Role(rank, name, true, false);
              starring.add(role);

            }
            catch(InputMismatchException e){
              e.printStackTrace();
              System.exit(1);
            }
          }
          Card card = new Card(sNum, budget, sceneName, starring);
          //System.out.println(i + " " + card.getCardName());
          deck.add(card);
          cardScanner.close();
        }
      }
      lineScanner.close();
    }
    catch(FileNotFoundException e){
      System.out.println("Error: File is not found. \n");
      //e.printStackTrace();
    }
  }
}
