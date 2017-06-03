/*************************************************
 * Game Board Object
 *
 * Responsible initializing a game board
 * that has 10 scene cards and 10 rooms
 *
 * Has an aggregartional relationship with
 * Card and Room class
 *
 * Room and Card has aggregartional relationship
 * with the Role class
 ************************************************/
import java.util.*;
import java.io.*;

public class GameBoard {
    /* Attributes */
    public static ArrayList<Room> allRooms;

    /* Constructor */
    public GameBoard() {
        allRooms = new ArrayList<Room>();
    }

    /* Methods */

    /* Makes all the rooms for the creation of the game board */
    public void initBoard() {
        //add locations
        readRooms();
    }

    /* Creates all the rooms */
    private void readRooms() {
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

                int shots = 0;
                shots = lineData.nextInt();
                ArrayList<String> adjRooms = new ArrayList<String>();
                ArrayList<Role> extras = new ArrayList<Role>();

                // 3 adjRooms
                if ((lc == 1) || (lc == 3) || (lc == 4) || (lc == 6) || (lc >= 8 && lc <= 11)){
                    String roomOne = lineData.next();
                    String roomTwo = lineData.next();
                    String roomThree = lineData.next();
                    adjRooms.add(roomOne);
                    adjRooms.add(roomTwo);
                    adjRooms.add(roomThree);
                }
                // 4 adjRooms
                if ((lc == 2) || (lc == 5) || (lc == 7) || (lc == 12)){
                    String roomOne = lineData.next();
                    String roomTwo = lineData.next();
                    String roomThree = lineData.next();
                    String roomFour = lineData.next();
                    adjRooms.add(roomOne);
                    adjRooms.add(roomTwo);
                    adjRooms.add(roomThree);
                    adjRooms.add(roomFour);
                }
                //
                // ranks and roles
                // 2 roles
                if ((lc == 2) || (lc >= 7 && lc <= 8) || (lc == 11) || (lc == 12)) {
                    int rankOne = lineData.nextInt();
                    String roleOne = lineData.next();
                    int rankTwo = lineData.nextInt();
                    String roleTwo = lineData.next();
                    Role extraOne = new Role(rankOne, roleOne, false, false);
                    Role extraTwo = new Role(rankTwo, roleTwo, false, false);
                    extras.add(extraOne);
                    extras.add(extraTwo);
                }
                // 3 roles
                if ((lc == 5) || (lc == 9)) {
                    int rankOne = lineData.nextInt();
                    String roleOne = lineData.next();
                    int rankTwo = lineData.nextInt();
                    String roleTwo = lineData.next();
                    int rankThree = lineData.nextInt();
                    String roleThree = lineData.next();
                    Role extraOne = new Role(rankOne, roleOne, false, false);
                    Role extraTwo = new Role(rankTwo, roleTwo, false, false);
                    Role extraThree = new Role(rankThree, roleThree, false, false);
                    extras.add(extraOne);
                    extras.add(extraTwo);
                    extras.add(extraThree);
                }
                // 4 roles
                if ((lc == 1) || (lc == 6) || (lc == 10)) {
                    int rankOne = lineData.nextInt();
                    String roleOne = lineData.next();
                    int rankTwo = lineData.nextInt();
                    String roleTwo = lineData.next();
                    int rankThree = lineData.nextInt();
                    String roleThree = lineData.next();
                    int rankFour = lineData.nextInt();
                    String roleFour = lineData.next();
                    Role extraOne = new Role(rankOne, roleOne, false, false);
                    Role extraTwo = new Role(rankTwo, roleTwo, false, false);
                    Role extraThree = new Role(rankThree, roleThree, false, false);
                    Role extraFour = new Role(rankFour, roleFour, false, false);
                    extras.add(extraOne);
                    extras.add(extraTwo);
                    extras.add(extraThree);
                    extras.add(extraFour);
                }
                Room room = null;
                if (roomName.equals("Trailer")) {
                    room = new Room(roomName, null, shots, adjRooms, DeadWindow.totalPlayers, extras, 800, 210);
                } else if (roomName.equals("Casting_Office")) {
                    room = new Room(roomName, null, shots, adjRooms, DeadWindow.totalPlayers, extras, 23, 390);
                } else {
                    Card newCard = selectCard();
                    ArrayList<Player> players = new ArrayList<Player>();
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
                }
                allRooms.add(room);
            } catch (java.util.InputMismatchException e) {
                e.printStackTrace();
            }
            lc++;
            lineData.close();
        }
        input.close();
    }

    /* Creates an ArrayList of all the scene cards */
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

    /* Randomize card selection */
    protected Card selectCard(ArrayList<Card> d) {
        Random randGenerate = new Random();
        int index = randGenerate.nextInt(d.size());
        Card selectedCard = d.get(index);
        deck.remove(index);

        return selectedCard;
    }
}
