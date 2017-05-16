import java.util.ArrayList;
public class Game_Board {

  public void initBoard() {

    // add locations
    readRooms(playerList);
    // add scenes to locations

  }

  // read in and make rooms
  private void readRooms() {
    ArrayList<Player> playerList = createPlayers();
    Scanner input = null;
    try {
      input = new Scanner(new File("Rooms.txt"));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    int lc = 1;
    while (input.hasNextLine()) {
      String line = input.nextLine();
      Scanner lineData = new Scanner(line);
      lineData.useDelimiter("\\s+");
      try {
        String roomName = lineData.next();
        int shots = Integer.valueOf(lineData.next());
        ArrayList<Room> adjRooms = new ArrayList<Room>();
        ArrayList
        // 2 adjRooms
        if (lc == 5) {
          String roomOne = lineData.next();
          String roomTwo = lineData.next();
        }
        // 3 adjRooms
        if ((lc <= 2 && > 0) || (lc == 4) || (lc >= 8 && <= 10) || (lc == 12)) {
          String roomOne = lineData.next();
          String roomTwo = lineData.next();
          String roomThree = lineData.next();
        }
        // 4 adjRooms
        if ((lc == 3) || (lc >= 6 && <= 7) || (lc == 11)) {
          String roomOne = lineData.next();
          String roomTwo = lineData.next();
          String roomThree = lineData.next();
          String roomFour = lineData.next();
        }
        //
        // ranks and roles
        // TODO condense this into a task that looks for end of line characters
        // 2 roles
        if ((lc == 2) || (lc >= 7 && lc <= 8) || (lc == 12)) {
          int rankOne = lineData.next();
          String roleOne = lineData.next();
          int rankTwo = lineData.next();
          String roleTwo = lineData.next();
        }
        // 3 roles
        if ((lc == 5) || (lc == 9) || (lc == 11)) {
          int rankOne = lineData.next();
          String roleOne = lineData.next();
          int rankTwo = lineData.next();
          String roleTwo = lineData.next();
          int rankThree = lineData.next();
          String roleThree = lineData.next();
        }
        // 4 roles
        if ((lc == 1) || (lc == 6) || (lc == 10)) {
          int rankOne = lineData.next();
          String roleOne = lineData.next();
          int rankTwo = lineData.next();
          String roleTwo = lineData.next();
          int rankThree = lineData.next();
          String roleThree = lineData.next();
          int rankFour = lineData.next();
          String roleFour = lineData.next();
        }

      } catch (java.util.InputMismatchException e) {
        e.printStackTrace();
      }
      lc++;
    }
  }

  // make deck
  private ArrayList<Card> createDeck() {

  }

  // randomize card selection
  protected Card selectCard() {
    Random rand = new Random();

  }
  /* enter player names as input
   * create player objects
   * player order is determined here
   */
  private ArrayList<Player> createPlayers() {
    ArrayList<Player> newPlayers = new ArrayList<Player>();
    Scanner scanPlayer = new Scanner(System.in);

    System.out.print("Enter the number of players: ");
    int players = scanPlayer.nextInt();
    for (int i = 0; i < players; i++) {
      System.out.println("Enter player " + (i+1) + "'s name: ");
      String name = scanPlayer.next();
      newPlayers.add(name);
    }
    return newPlayers;
  }

  // store shot counter, die roll, dice counters etc for game board objects.
  // acting 
  //public static Die gameDie = new Die();
  // make board

}
