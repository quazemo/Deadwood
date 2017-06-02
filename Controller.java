
/* Controller Class should just initialize objects
 * and run main menu and loops until days are over
 */
import com.sun.management.MissionControl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Controller {

	// attributes
	public static int turns;
	private int cardsFinished;
	private static ArrayList<Player> allPlayers;
	private static int numCards;

	// constructor
	public Controller() {
		turns = 0;
		cardsFinished = 0;
		numCards = 10;

	}
	// methods
	/* main */
	public static void main(String[] args) {
		DeadWindow board = new DeadWindow();
		board.addCardsToBoard();
		board.createButtons();
		allPlayers = board.getAllPlayers();

		board.setVisible(true);
		Days days = new Days();
		GameBoard gb = new GameBoard();
		gb.initBoard();
		Controller missionControl = new Controller();
		//int i = gb.allPlayers.size();
		while (days.checkDays()) {
			// take turns

			/*
			if (endDayState(gb)) {
				int d = days.getDay() + 1;
				days.setDay(d);
			} else {
				/*boolean checkTurns = menu(gb.allPlayers.get(i), gb);
				if (checkTurns) {
					i--;
				}
				if (i == 1) {
					i = gb.allPlayers.size();
				}
				*/
		}
	}
	/*
	private static boolean menu(Player player, GameBoard gb) {
		System.out.println("------WELCOME TO DEADWOOD------");
		String location = player.getLocation();
		Scanner playerInput = null;
		playerInput.toString().toLowerCase();
		boolean moved = false;
		boolean acted = false;
		boolean upgraded = false;
		boolean rehearsed = false;
		String[] options = {"who = displays current player.",
				"where = what room is current player in.",
				"move = move to adjacent room.",
				"work = choose a role to work.",
				"upgrade = upgrade rank via credits or cash.",
				"rehearse = add a rehearse chip.",
				"act = player performs acting role.",
				"end = end players turn."};
		while (!playerInput.equals("end")) {

			playerInput = new Scanner(System.in);
			System.out.print("Enter one of the following commands: ");
			// if player is in an acting role
			if (!player.getRole().equals("no current role")) {
				System.out.println(options[0]); // who
				System.out.println(options[1]); // where
				System.out.println(options[5]); // rehearse
				System.out.println(options[6]); // act
				System.out.println(options[7]); // end
				switch (playerInput.toString()) {
					case "who":
						System.out.println("It is currently " + player.getPlayerName() + "'s turn.");
						break;
					case "where":
						System.out.println("You are in the " + player.getLocation());
						break;
					case "rehearse":
						if (!rehearsed) {
							for (int j = 0; j < gb.allRooms.size(); j++) {
								if (player.getLocation().equals(gb.allRooms.get(j).getRoomName())) {
									for (int k = 0; k < gb.allRooms.get(j).getSceneCard().getStarringRoles().size(); k++) {
										if (player.getRole().equals(gb.allRooms.get(j).getSceneCard().getRole(k))) {
											gb.allRooms.get(j).getSceneCard().getRoleObj(k).rehearse();
											rehearsed = true;
										}
									}
								}
							}
						} else {
							System.out.println("You already rehearsed this turn.");
						}
						break;
					case "act":
						if (!acted) {
							Die die = new Die();
							for (int j = 0; j < gb.allRooms.size(); j++) {
								if (player.getLocation().equals(gb.allRooms.get(j).getRoomName())) {
									for (int k = 0; k < gb.allRooms.get(j).getSceneCard().getStarringRoles().size(); k++) {
										if (player.getRole().equals(gb.allRooms.get(j).getSceneCard().getRole(k))) {
											gb.allRooms.get(j).getSceneCard().getRoleObj(k).act(gb.allRooms.get(j), player, die);
											acted = true;
										}
									}
								}
							}
						} else {
							System.out.println("You have already acted this turn.");
						}
						break;
					case "end":
						playerInput.close();
						return true;
				}
			// if player is not acting and is in the casting office
			} else if (player.getRole().equals("no current role") && (location.equals("Casting_Office"))) {
				System.out.println(options[0]); // who
				System.out.println(options[1]); // where
				System.out.println(options[3]); // move
				System.out.println(options[4]); // upgrade
				System.out.println(options[7]); // end
				switch (playerInput.toString()) {
					case "who":
						System.out.println("It is currently " + player.getPlayerName() + "'s turn.");
						break;
					case "where":
						System.out.println("You are in the " + player.getLocation());
						break;
					case "move":
						if (!moved) {
							player.move(gb);
							moved = true;
						} else {
							System.out.println("You have already moved this turn.");
						}
						break;
					case "upgrade":
						break;
					case "end":
						playerInput.close();
						return true;
				}
			// if player is not acting and is in the trailer
			} else if (player.getRole().equals("no current role") && (location.equals("Trailer"))) {
				System.out.println(options[0]); // who
				System.out.println(options[1]); // where
				System.out.println(options[3]); // move
				System.out.println(options[7]); // end
				switch (playerInput.toString()) {
					case "who":
						System.out.println("It is currently " + player.getPlayerName() + "'s turn.");
						break;
					case "where":
						System.out.println("You are in the " + player.getLocation());
						break;
					case "move":
						if (!moved) {
							player.move(gb);
							moved = true;
						} else {
							System.out.println("You have already moved this turn.")
						}
						break;
					case "end":
						playerInput.close();
						return true;
				}
			// if player is not acting, and is not in the trailer/casting office
			} else if (player.getRole().equals("no current role")) {
				System.out.println(options[0]); // who
				System.out.println(options[1]); // where
				System.out.println(options[4]); // work
				System.out.println(options[3]); // move
				System.out.println(options[7]); // end
				switch (playerInput.toString()) {
					case "who":
						System.out.println("It is currently " + player.getPlayerName() + "'s turn.");
						break;
					case "where":
						System.out.println("You are in the " + player.getLocation());
						break;
					case "work":
						Scanner userInput = new Scanner(System.in);
						for (int j = 0; j < gb.allRooms.size(); j++) {
							if (player.getLocation().equals(gb.allRooms.get(j).getRoomName())) {
								ArrayList<Role> availableRoles = gb.allRooms.get(j).getSceneCard().getStarringRoles();
								ArrayList<SceneExtras> extraRoles = gb.allRooms.get(j).getExtras();
								System.out.println("Choose a value from the below list: ");
								int sRoles = 0;
								int k = 0;
								for (; k < availableRoles.size(); k++) {
									System.out.println("Starring: ");
									if ((!availableRoles.get(k).isOccupied()) && (player.getRank() >= availableRoles.get(k).getRank())) {
										sRoles++;
										System.out.print(sRoles + ": ");
										System.out.println(availableRoles.get(k).getName());
									} else {
										System.out.println("No available starring roles on set.");
									}
								}
								int eRoles = k;
								for (int l = 0; l < extraRoles.size(); l++) {
									System.out.println("Extras: ");
									if (!extraRoles.get(l).getAvailability() && player.getRank() >= extraRoles.get(l).getRank()) {
										eRoles++;
										System.out.print(eRoles + ": ");
										System.out.println(extraRoles.get(l).getName());
									} else {
										System.out.println("No available extra roles on set.");
									}
								}
								int job = 0;
								job = userInput.nextInt();
								while((job <= 0) || (job > eRoles)) {
									System.out.println("please select an available option from above.");
									job = userInput.nextInt();
								}
								if (job > 0 && job <= sRoles) {
									player.setRole(availableRoles.get(job).getName());
									availableRoles.get(job).setOccupied(true);
								} else if ((job > sRoles) && (job <= eRoles)) {
									player.setRole(extraRoles.get(job).getName());
									extraRoles.get(job).setAvailability(true);
								}
							}
						}
					case "move":
						if (!moved) {
							player.move(gb);
							moved = true;
						} else {
							System.out.println("You already moved this turn.");
						}
						break;
					case "end":
						playerInput.close();
						return true;
				}
			}
		}
		return false;
	}
	*/


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
		}
		return deck;
	}

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
			//
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
		//decement total num cards
		numCards = numCards - 1;
	}

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

		Collections.sort(dieVals);
		Collections.reverse(dieVals);

		while(!dieVals.isEmpty()){
			Die d = dieVals.remove(0);
			int dols = d.getValue();

			if(!starPlayers.isEmpty()){
				p = starPlayers.remove(0);
			}
			//d.remove();
			Collections.sort(starPlayers);
			if(p.getPlayerName() == curr.getPlayerName()){
				calcBonus = calcBonus + dols;
			}else{
				for (int i = 0; i < i++;){
					if(p.getPlayerName() == allPlayers.get(i).getPlayerName()){
						allPlayers.get(i).incDollars(dols);
					}
				}
			}
		}
		return calcBonus;
	}


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

	//calculates scores and displays winner with the highest score for the end of the game
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
