import java.util.*;
import java.io.*;

public class GameBoard {
    public static ArrayList<Room> allRooms;
    //public static ArrayList<Player> allPlayers;

    public GameBoard() {
        // default
        allRooms = new ArrayList<Room>();
        //allPlayers = new ArrayList<Player>();
    }

    public void initBoard() {
        // add locations
        readRooms();
        // add scenes to locations
    }

    // read in and make rooms
    private void readRooms() {

      //ArrayList<Player> playerList = createPlayers();
      File f = new File("Rooms.txt");
      ArrayList<Room> allRooms = new ArrayList<Room>();
      ArrayList<Player> players = new ArrayList<Player>();
      ArrayList<Role> noExtras = new ArrayList<Role>();

      //Trailer
      ArrayList<String> adjTrailer = new ArrayList<String>();
      adjTrailer.add("Secret_Hideout");
      adjTrailer.add("Jail");
      adjTrailer.add("Saloon");
      adjTrailer.add("Main_Street");
      Room t = new Room("Trailer", null, 0, adjTrailer, DeadWindow.totalPlayers, noExtras, 800, 210);
      allRooms.add(t);

      //Casting Office
      ArrayList<String> adjCO = new ArrayList<String>();
      adjCO.add("Ranch");
      adjCO.add("Main_Street");
      adjCO.add("Secret_Hideout");
      Room co = new Room("Casting_Office", null, 0, adjCO, DeadWindow.totalPlayers, noExtras, 23, 390);
      allRooms.add(co);

      //all other Rooms
      try{
        Scanner lineScanner = new Scanner(f);
        for(int i = 0; i < 10; i++){
          ArrayList<String> adjRooms = new ArrayList<String>();
          ArrayList<Role> extras = new ArrayList<Role>();
          if(lineScanner.hasNextLine()){
            String line = lineScanner.nextLine();
            //System.out.println(line);
            Scanner roomScanner = new Scanner(line).useDelimiter(" ");
            String roomName = roomScanner.next();
            int shots = roomScanner.nextInt();

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
                  extras.add(role);
                }
                catch(InputMismatchException e){
                  e.printStackTrace();
                  System.exit(1);
                }
              }
            }

            //creating rooms for the Game Board and placing cards
            ArrayList<Card> deck = createDeck();
            Card newCard = selectCard(deck);
            Room room = null;
            if (roomName.equals("Main_Street")) {
                int x = 766;
                int y = 25;
                room = new Room(roomName, newCard, shots, adjRooms, players, extras, x, y);
            } else if (roomName.equals("Saloon")) {
                int x = 500;
                int y = 226;
                room = new Room(roomName, newCard, shots, adjRooms, players, extras, x, y);
            } else if (roomName.equals("Ranch")) {
                int x = 200;
                int y = 390;
                room = new Room(roomName, newCard, shots, adjRooms, players, extras, x, y);
            } else if (roomName.equals("Secret_Hideout")) {
                int x = 23;
                int y = 588;
                room = new Room(roomName, newCard, shots, adjRooms, players, extras, x, y);
            } else if (roomName.equals("Bank")) {
                int x = 497;
                int y = 387;
                room = new Room(roomName, newCard, shots, adjRooms, players, extras, x, y);
            } else if (roomName.equals("Church")) {
                int x = 494;
                int y = 594;
                room = new Room(roomName, newCard, shots, adjRooms, players, extras, x, y);
            } else if (roomName.equals("Hotel")) {
                int x = 766;
                int y = 594;
                room = new Room(roomName, newCard, shots, adjRooms, players, extras, x, y);
            } else if (roomName.equals("Train_Station")) {
                int x = 20;
                int y = 60;
                room = new Room(roomName, newCard, shots, adjRooms, players, extras, x, y);
            } else if (roomName.equals("Jail")) {
                int x = 222;
                int y = 27;
                room = new Room(roomName, newCard, shots, adjRooms, players, extras, x, y);
            } else if (roomName.equals("General_Store")) {
                int x = 292;
                int y = 228;
                room = new Room(roomName, newCard, shots, adjRooms, players, extras, x, y);
            }

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

    // make deck
    private ArrayList<Card> createDeck() {
        File f = new File("Scene_Cards.txt");
        ArrayList<Role> starring = new ArrayList<Role>();
        ArrayList<Card> deck = new ArrayList<Card>();

        try{
            Scanner lineScanner = new Scanner(f);
            for(int i = 0; i < 40; i++){
                if(lineScanner.hasNextLine()){
                    String line = lineScanner.nextLine();
                    Scanner cardScanner = new Scanner(line).useDelimiter("\\s+");
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
    protected Card selectCard(ArrayList<Card> d) {
        Random randGenerate = new Random();
        int index = randGenerate.nextInt(d.size());
        Card selectedCard = d.get(index);
        d.remove(index);

        return selectedCard;
    }

    /* enter player names as input
     * create player objects
     * player order is determined here
     *
    private ArrayList<Player> createPlayers() {
        ArrayList<Player> newPlayers = new ArrayList<Player>();
        Scanner scanPlayer = new Scanner(System.in);

        System.out.print("Enter the number of players: ");
        int players = scanPlayer.nextInt();
        while (players < 0 || players > 4) {
            System.out.println("Please enter a valid number of players (e.g. 1-4)");
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
    */

}
