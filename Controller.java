
/* Controller Class should just initialize objects
 * and run main menu and loops until days are over
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
public class Controller {

	// attributes
	int numPlayers;
	//ArrayList<Player> playerOrder = new ArrayList<Player>();

	// constructor
	public Controller() {
	}
	// methods
	/* main */
	public static void main(String[] args) {
		GameBoard gb = new GameBoard();
		gb.initBoard();
		Days days = new Days();
		int i = gb.allPlayers.size();
		while (days.checkDays()) {
			if (endDayState(gb)) {
				int d = days.getDay() + 1;
				days.setDay(d);
			} else {
				boolean checkTurns = menu(gb.allPlayers.get(i), gb);
				if (checkTurns) {
					i--;
				}
				if (i == 1) {
					i = gb.allPlayers.size();
				}
			}
		}
	}
	//
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
								ArrayList<Role> extraRoles = gb.allRooms.get(j).getExtras();
								System.out.println("Choose a value from the below list: ");
								int sRoles = 0;
								int k = 0;
								for (; k < availableRoles.size(); k++) {
									System.out.println("Starring: ");
									if ((!availableRoles.get(k).isOccupied()) && (player.getRank() >= availableRoles.get(k).getRank())) {
										sRoles++;
										System.out.print(sRoles + ": ");
										System.out.println(availableRoles.get(k).getName());
									}
								}
								int eRoles = k;
								for (int l = 0; l < extraRoles.size(); l++) {
									System.out.println("Extras: ");
									if (!extraRoles.get(l).getAvailability() && player.getRank() >= extraRoles.get(l).getRank()) {
										eRoles++;
										System.out.print(eRoles + ": ");
										System.out.println(extraRoles.get(l).getName());
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

	//
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

	//TODO: finish this plz
	void endScene(Room curr, Card cardRoom){

		//curr.setSceneclosed = true;
		cardRoom.setCardDone(true);
		ArrayList<Player> playersInside = curr.getOccupants();
		ArrayList <Integer> diceVals = new ArrayList<Integer>();
		ArrayList <Integer> rankVals = new ArrayList<Integer>();
		ArrayList<Role> sRoles = cardRoom.getStarringRoles();
		Die die = new Die();

		for(int i = 0; i < playersInside.size(); i++){
			if(playersInside.get(i).getRole().equals("starring")){
				//star bonus
				int numDice = cardRoom.getBudget();
				for (int j = 0; j < numDice; j++){
					diceVals.add(die.getValue());
				}

				for(int j = 0; j < sRoles.size(); j++){
					Role r = sRoles.get(j);
					rankVals.add(r.getRank());
				}
				Collections.sort(diceVals);
				Collections.sort(rankVals);
			}
			System.out.println("You should be getting a Starring bonus \n");

			if(playersInside.get(i).getRole().equals("extra")){
				//extra bonus
				System.out.println("You should be getting a Extra bonus \n");
			}
		}
	}

	//
	int calcScore() {
		return 0;
	}
}
