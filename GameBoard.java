import java.util.*;
import java.io.*;

public class GameBoard {
    public static ArrayList<Room> allRooms;
    public static ArrayList<Player> allPlayers;

    public GameBoard() {
        // default
        allRooms = new ArrayList<Room>();
        allPlayers = new ArrayList<Player>();
    }

    public void initBoard() {
        // add locations
        readRooms();


        // add scenes to locations
    }

    // read in and make rooms
    private void readRooms() {

        ArrayList<Player> playerList = createPlayers();
        File f = new File("Rooms.txt");
        ArrayList<Room> allRooms = new ArrayList<Room>();
        ArrayList<Player> occupants = new ArrayList<Player>();
        ArrayList<Role> noExtras = new ArrayList<Role>();

        //Trailer
        ArrayList<String> adjTrailer = new ArrayList<String>();
        adjTrailer.add("Secret_Hideout");
        adjTrailer.add("Jail");
        adjTrailer.add("Saloon");
        adjTrailer.add("Main_Street");

        Room t = new Room("Trailer", 0, adjTrailer, playerList, noExtras);
        allRooms.add(t);
        //Casting Office
        ArrayList<String> adjCO = new ArrayList<String>();
        adjCO.add("Ranch");
        adjCO.add("Main_Street");
        adjCO.add("Secret_Hideout");

        Room co = new Room("Casting_Office", 0, adjCO, occupants, noExtras);
        allRooms.add(co);

        //all other Rooms
        try{
          Scanner lineScanner = new Scanner(f);
          for(int i = 0; i < 10; i++){
            ArrayList<String> adjRooms = new ArrayList<String>();
            ArrayList<Role> extra = new ArrayList<Role>();
            if(lineScanner.hasNextLine()){
              String line = lineScanner.nextLine();
              //System.out.println(line);
              Scanner roomScanner = new Scanner(line).useDelimiter(" ");
              String roomName = roomScanner.next();
              int s = roomScanner.nextInt();

              while(!roomScanner.hasNextInt()){
                try{
                  String adjName = roomScanner.next();
                  adjRooms.add(adjName);
                }
                catch(InputMismatchException e){
                  e.printStackTrace();
                  System.exit(1);
                }
              }

              if(roomScanner.hasNext()){
                while(roomScanner.hasNext()){
                  try{
                    int rank = roomScanner.nextInt();
                    String name = roomScanner.next();
                    Role role = new Role(rank, name, true, false);
                    extra.add(role);
                  }
                  catch(InputMismatchException e){
                    e.printStackTrace();
                    System.exit(1);
                  }
                }
              }

              Room room = new Room(roomName, s, adjRooms, occupants, extra);
              allRooms.add(room);
              roomScanner.close();
            }
          }
          lineScanner.close();
        }
        catch(FileNotFoundException e){
          System.out.println("Error: File is not found. \n");
        }


        /*checking Rooms
        for(int i = 0; i < allRooms.size(); i++){
          System.out.println(allRooms.get(i).getRoomName());
          System.out.println(allRooms.get(i).getShotCount());
          System.out.println(allRooms.get(i).getAdjRooms());
          //System.out.println(allRooms.get(i).getExtras());
          ArrayList<Role> xtra = allRooms.get(i).getExtras();
          for(int j = 0; j < xtra.size(); j++){
            System.out.println(xtra.get(j).getName());
          }
          System.out.println("--------------------------------");
        }*/
    }

    private ArrayList<Card> createDeck() {
        File f = new File("Scene_Cards.txt");
        ArrayList<Role> starring = new ArrayList<Role>();
        ArrayList<Card> deck = new ArrayList<Card>();

        try{
            Scanner lineScanner = new Scanner(f);
            for(int i = 0; i < 40; i++){
                if(lineScanner.hasNextLine()){
                    String line = lineScanner.nextLine();
                    Scanner cardScanner = new Scanner(line).useDelimiter(" ");
                    int sNum = cardScanner.nextInt();
                    int budget = cardScanner.nextInt();
                    String sceneName = cardScanner.next();

                    //Gathering starring roles into ArrayList
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
                    deck.add(card);
                    cardScanner.close();
                }
            }
            lineScanner.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Error: File is not found. \n");
        }
        return deck;
    }

    // randomize card selection
    protected Card selectCard() {
        Random randGenerate = new Random();
        ArrayList<Card> deck = createDeck();
        int index = randGenerate.nextInt(deck.size());
        Card selectedCard = deck.get(index);
        deck.remove(index);

        return selectedCard;
    }

    /* enter player names as input
     * create player objects
     * player order is determined here
     */
    private ArrayList<Player> createPlayers() {
        ArrayList<Player> newPlayers = new ArrayList<Player>();
        Scanner scanPlayer = new Scanner(System.in);

        System.out.print("Enter the number of players: ");
        while(!scanPlayer.hasNextInt()){ //checks for int
          System.out.println("Please enter a valid number of players (e.g. 2-4)");
          scanPlayer.next();
        }
        int players = scanPlayer.nextInt();
        while ((players < 2 || players > 4)) { // checks if int is out of range
            System.out.println("Please enter a valid number of players (e.g. 2-4)");
            players = scanPlayer.nextInt();
        }

        for (int i = 0; i < players; i++) {
            System.out.println("Enter player " + (i + 1) + "'s name: ");
            String name = scanPlayer.next();
            Player player = new Player(name, "Trailer", 0, 0);
            allPlayers.add(player);
            newPlayers.add(player);
        }
        scanPlayer.close();
        return newPlayers;
    }

}
