
/* Controller Class should just initialize objects
 * and run main menu and loops until days are over
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Controller {

	// attributes
	int numPlayers;
	static int cardsleft;
	//ArrayList<Player> playerOrder = new ArrayList<Player>();

	// constructor
	public Controller() {
		int numPlayers = 0;
		int cardsleft = 0;
	}
	// methods
	/* main */
	public static void main(String[] args) {
		GameBoard gb = new GameBoard();
		gb.initBoard();
		ArrayList<Player> all = gb.getPlayers();
		Days days = new Days();
		int i = gb.allPlayers.size() - 1;
		int numDays = days.getCount() + 1;
		days.setDay(numDays);
		while(numDays!= 0) {
			menu(gb.allPlayers.get(i), gb);
			if(cardsleft == 1){
				numDays = numDays - 1;
			}
			i--;
			if(i == 0){
				i = gb.allPlayers.size() - 1;
			}
		}
		endGame(all);
	}

	private static void menu(Player player, GameBoard gb) {
		System.out.println("------WELCOME TO DEADWOOD------");
		String location = player.getLocation();
		boolean moved = false;
		boolean acted = false;
		boolean upgraded = false;
		boolean rehearsed = false;
		String[] options = {
			  "who = displays current player.",             //0
				"where = what room is current player in.",    //1
				"move = move to adjacent room.",              //2
				"work = choose a role to work.",              //3
				"upgrade = upgrade rank via credits or cash.",//4
				"rehearse = add a rehearse chip.",            //5
				"act = player performs acting role.",         //6
				"end = end players turn."};                   //7

		System.out.println("Hello " + player.getPlayerName());
		System.out.print("Enter one of the following commands: ");
		System.out.println(options[0]); // who
		System.out.println(options[1]); // where
		System.out.println(options[2]); // move
		System.out.println(options[7]); // end
		Scanner playerInput = new Scanner(System.in);

		//while (!playerInput.hasNext()) {

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
					break;
					//return true;
			}
			// if player is in an acting role
			if (!player.getRole().equals("no current role")) {
				System.out.print("Enter one of the following commands: ");
				System.out.println(options[0]); // who
				System.out.println(options[1]); // where
				System.out.println(options[5]); // rehearse
				System.out.println(options[6]); // act
				System.out.println(options[7]); // end
				playerInput = new Scanner(System.in);
				String input = playerInput.toString().toLowerCase();

				switch (input) {
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
						break;
						//return true;
				}
			// if player is not acting and is in the casting office
			} else if (player.getRole().equals("no current role") && (location.equals("Casting_Office"))) {
				System.out.println(options[0]); // who
				System.out.println(options[1]); // where
				System.out.println(options[2]); // move
				System.out.println(options[4]); // upgrade
				System.out.println(options[7]); // end
				playerInput = new Scanner(System.in);
				String input = playerInput.toString().toLowerCase();
				switch (input) {
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
						//return true;
						break;
				}
			// if player is not acting and is in the trailer
			} else if (player.getRole().equals("no current role") && (location.equals("Trailer"))) {
				System.out.println(options[0]); // who
				System.out.println(options[1]); // where
				System.out.println(options[2]); // move
				System.out.println(options[7]); // end
				playerInput = new Scanner(System.in);
				String input = playerInput.toString().toLowerCase();
				switch (input) {
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
						break;
						//return true;
				}
			// if player is not acting, and is not in the trailer/casting office
			} else if (player.getRole().equals("no current role")) {
				System.out.println(options[0]); // who
				System.out.println(options[1]); // where
			  System.out.println(options[3]); // work
				System.out.println(options[2]); // move
				System.out.println(options[7]); // end
				playerInput = new Scanner(System.in);
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
						break;
						//return true;
				}
			}
		//}
		//return false;
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

	void endScene(Room curr, Card cardRoom){

	}

	public static void endGame(ArrayList<Player> all){
		int topScore = 0;
		Player winner = null;
		for(Player p : all){
			int dols = p.getDollars();
			int creds = p.getCredits();
			int rankScore = p.getRank() * 5;
			int pScore = dols + creds + rankScore;
			if(pScore > topScore){
				pScore = topScore;
				winner = p;
			}
		}
		System.out.println(winner.getPlayerName() + "Thanks for playing!\n\n Goodbye.");
		System.exit(0);
	}

	//
	int calcScore() {
		return 0;
	}
}
