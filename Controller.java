 /*************************************************
  * Deadwood - Model
  *
  * Initializes game board, and respnsible for the
	* back end of the of the Deadwood implementation
	*
	*
	* Has an aggregartional relationship with
  * GameBoard
	*
  ************************************************/
import com.sun.management.MissionControl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Controller {

	/* Attributes */
	public static int turns;
	private int cardsFinished;
	private static int numCards;

	/* Constructor */
	public Controller() {
		turns = 0;
		cardsFinished = 0;
		numCards = 10;
	}

	/* Main */
	public static void main(String[] args) {
		DeadWindow board = new DeadWindow();
		board.addCardsToBoard();
		board.createButtons();
		board.setVisible(true);
		Days days = new Days();

		/*Initializes a Deadwood game board*/
		GameBoard gb = new GameBoard();
		gb.initBoard();

		/* Adding the shot circles on the board */
		for (int i = 0; i < GameBoard.allRooms.size(); i++) {
			board.addShotCounters(GameBoard.allRooms.get(i));
		}

		Controller missionControl = new Controller();
		while (days.checkDays()) {
		}
	}

	/* Methods */
	/* Creates a deck of all the Scene Cards*/
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
		}
		return deck;
	}

	/* Randomly selects a card from a deck */
	protected Card selectCard(ArrayList<Card> d) {
		Random randGenerate = new Random();
		int index = randGenerate.nextInt(d.size());
		Card selectedCard = d.get(index);
		d.remove(index);

		return selectedCard;
	}

	/* Checks if the Day is ready to end */
	protected static boolean endDayState(GameBoard gb) {
		boolean dayOver = false;
		int availableScenes = 10;
		for (int i = 0; i < gb.allRooms.size(); i++) {
			dayOver = gb.allRooms.get(i).getSceneState();
			if (dayOver) {
				availableScenes--;
			}
		}
		if (availableScenes == 1) {
			return true;
		}
		return false;
	}

	/* Closes the room and gives out appropriate bonuses */
	void endScene(Room currRoom, Player currPlayer){
		Card cardRoom = currRoom.getSceneCard();
		ArrayList<Player> playersInside = currRoom.getOccupants();
		ArrayList<Role> sRoles = cardRoom.getStarringRoles();
		ArrayList<Player> sPlayers = new ArrayList<Player>();
		boolean validBonus = getBonus(cardRoom);

		if(validBonus){

			//get starr players
			for(int i = 0; i < playersInside.size(); i++){
				if(playersInside.get(i).getRole().equals("starring")){
					sPlayers.add(playersInside.get(i));
				}
			}
			int calcBonus = starBonus(currPlayer, sPlayers, cardRoom.getBudget());
			currPlayer.incDollars(calcBonus);

			for(int i = 0; i < sPlayers.size(); i++){
				sPlayers.get(i).setRole("no current role");
			}
		}else{
			System.out.println("Card: " + cardRoom.getCardName() + " is complete.");
			for(int i = 0; i < playersInside.size(); i++){
				playersInside.get(i).setRole("no current role");
			}
		}
		//decement total total number of Cards on the board
		numCards = numCards - 1;
	}

	/* Calculates bonus for starring roles */
	protected int starBonus(Player curr, ArrayList<Player> starPlayers, int b){
		ArrayList<Die> dieVals = new ArrayList<Die>();
		Player p = null;
		int calcBonus = 0;

		//sorting star players by rank in descending order
		Collections.sort(starPlayers);
		for(int i = 0; i < b; i++){
			Die die = new Die();
			dieVals.add(die);
		}

		//sorting star dice rolls in descending order
		Collections.sort(dieVals);

		while(!dieVals.isEmpty()){
			Die d = dieVals.remove(0);
			int dols = d.getValue();

			if(!starPlayers.isEmpty()){
				p = starPlayers.remove(0);
			}

			Collections.sort(starPlayers);
			if(p.getPlayerName() == curr.getPlayerName()){
				calcBonus = calcBonus + dols;
			}else{
				for (int i = 0; i < i++;){
					if(p.getPlayerName() == DeadWindow.totalPlayers.get(i).getPlayerName()){
						DeadWindow.totalPlayers.get(i).incDollars(dols);
					}
				}
			}
		}
		return calcBonus;
	}

	
	/* Checks for bonuses should be given */
	protected boolean getBonus(Card c){
		boolean bonus = false;
		ArrayList<Role> stars = c.getStarringRoles();
		for(int i = 0; i < stars.size(); i++){
			if(stars.get(i).isOccupied() == true){
				bonus = true;
				break;
			}
		}
		return bonus;
	}

	/* Calculates total score of all the Players, displays the winner, and closes the game */
	protected static void endGame(ArrayList<Player> all){
		int topScore = 0;
		Player winner = null;
		for(int i = 0; i < all.size(); i++){
			int dols = all.get(i).getDollars();
			int creds = all.get(i).getCredits();
			int rankScore = all.get(i).getRank() * 5;
			int pScore = dols + creds + rankScore;
			if(pScore > topScore){
				pScore = topScore;
				winner = all.get(i);
			}
		}
		System.out.println(winner.getPlayerName() + "Thanks for playing!\n\n Goodbye.");
		System.exit(0);
	}
}
