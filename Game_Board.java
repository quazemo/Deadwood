import java.util.ArrayList;

public class Game_Board {
    static ArrayList<Room> allRooms = new ArrayList<Room>();
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
                int shots = 0;
                if (!roomName.equals("Trailer") || !roomName.equals("Casting_Office")) {
                    shots = Integer.valueOf(lineData.next());
                }
                ArrayList<String> adjRooms = new ArrayList<String>();
                ArrayList<SceneExtras> extras = new ArrayList<SceneExtras>();
                // 2 adjRooms
                if (lc == 5) {
                    String roomOne = lineData.next();
                    String roomTwo = lineData.next();
                    adjRooms.add(roomOne);
                    adjRooms.add(roomTwo);
                }
                // 3 adjRooms
                if ((lc <= 2 && > 0) ||(lc == 4) || (lc >= 8 && <= 10) ||(lc == 12)){
                    String roomOne = lineData.next();
                    String roomTwo = lineData.next();
                    String roomThree = lineData.next();
                    adjRooms.add(roomOne);
                    adjRooms.add(roomTwo);
                    adjRooms.add(roomThree);
                }
                // 4 adjRooms
                if ((lc == 3) || (lc >= 6 && <= 7) ||(lc == 11)){
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
                // TODO condense this into a task that looks for end of line characters
                // 2 roles
                if ((lc == 2) || (lc >= 7 && lc <= 8) || (lc == 12)) {
                    int rankOne = lineData.next();
                    String roleOne = lineData.next();
                    int rankTwo = lineData.next();
                    String roleTwo = lineData.next();
                    SceneExtras extraOne = new SceneExtra(rankOne, roleOne);
                    SceneExtras extraTwo = new SceneExtra(rankTwo, roleTwo);
                    extras.add(extraOne);
                    extras.add(extraTwo);
                }
                // 3 roles
                if ((lc == 5) || (lc == 9) || (lc == 11)) {
                    int rankOne = lineData.next();
                    String roleOne = lineData.next();
                    int rankTwo = lineData.next();
                    String roleTwo = lineData.next();
                    int rankThree = lineData.next();
                    String roleThree = lineData.next();
                    SceneExtras extraOne = new SceneExtra(rankOne, roleOne);
                    SceneExtras extraTwo = new SceneExtra(rankTwo, roleTwo);
                    SceneExtras extraThree = new SceneExtra(rankThree, roleThree);
                    extras.add(extraOne);
                    extras.add(extraTwo);
                    extras.add(extraThree);
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
                    SceneExtras extraOne = new SceneExtra(rankOne, roleOne);
                    SceneExtras extraTwo = new SceneExtra(rankTwo, roleTwo);
                    SceneExtras extraThree = new SceneExtra(rankThree, roleThree);
                    SceneExtras extraFour = new SceneExtra(rankFour, roleFour);
                    extras.add(extraOne);
                    extras.add(extraTwo);
                    extras.add(extraThree);
                    extras.add(extraFour);
                }
                if (roomName.equals("Trailer")) {
                    Room room = new Room(roomName, shots, adjRooms, playerList, extras);
                } else {
                    ArrayList<Player> players = new ArrayList<Player>();
                    Room room = new Room(roomName, shots, adjRooms, players, extras);
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
        int players = scanPlayer.nextInt();
        while (players < 0 || players > 4) {
            System.out.println("Please enter a valid number of players (e.g. 1-4)");
            players = scanPlayer.nextInt();
        }
        for (int i = 0; i < players; i++) {
            System.out.println("Enter player " + (i + 1) + "'s name: ");
            String name = scanPlayer.next();
            Player player = new Player(name, "Trailer", 0, 0);
            newPlayers.add(player);
        }
        scanPlayer.close();
        return newPlayers;
    }

    // store shot counter, die roll, dice counters etc for game board objects.
    // acting
    //public static Die gameDie = new Die();
    // make board

}
