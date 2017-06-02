/**
 * Created by brendanbaalke on 5/27/17.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.LinkedList;

public class DeadWindow extends JFrame {

    public static int flippedCards;
    private JPanel controlPanel;
    private RotatedIcon train;
    private RotatedIcon hotel;

    private JLabel msgLabel;
    private JLabel endTurnButton;
    private JLabel actButton;
    private JLabel cancelButton;
    private JLabel moveButton;
    private JLabel roleDieButton;
    private JLabel upgradeButton;
    private JLabel rehearseButton;

    private Font gameMessages;
    private JLabel boardLabel;
    private JLabel cardLabel_1;
    private JLabel cardLabel_2;
    private JLabel cardLabel_3;
    private JLabel cardLabel_4;
    private JLabel cardLabel_5;
    private JLabel cardLabel_6;
    private JLabel cardLabel_7;
    private JLabel cardLabel_8;
    private JLabel cardLabel_9;
    private JLabel cardLabel_10;

    private JLabel playerLabel_1;
    private JLabel playerLabel_2;
    private JLabel playerLabel_3;

    private ArrayList<GUIPlayer> playerDice;
    public static ArrayList<Player> totalPlayers;
    public static ArrayList<GUIPositioningParts> totalParts;
    public static ArrayList<GUIPositioningRooms> totalRooms;

    JLayeredPane boardPane;

    public DeadWindow() {
        super("DeadWood Board");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        totalPlayers = new ArrayList<Player>();
        totalParts = new ArrayList<GUIPositioningParts>();
        totalRooms = new ArrayList<GUIPositioningRooms>();
        flippedCards = 0;

        boardLabel = new JLabel();
        boardPane = getLayeredPane();
        controlPanel = new JPanel();
        controlPanel.setBounds(949, 0, 200, 720);
        controlPanel.setBackground(Color.BLUE);
        controlPanel.setOpaque(true);

        ImageIcon icon = new ImageIcon(new ImageIcon("board.png").getImage().getScaledInstance(949, 720, Image.SCALE_DEFAULT));
        boardLabel.setIcon(icon);
        boardLabel.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
        // Add the board to the lower layer
        boardPane.add(boardLabel,new Integer(0));
        boardPane.add(controlPanel,new Integer(0));
        // set GUI size, add some space for options
        setSize(icon.getIconWidth()+200,icon.getIconHeight());

        playerDice = createPlayers();

        for (int j = 0; j < playerDice.size(); j++) {
            boardPane.add(playerDice.get(j).getPlayer(),new Integer(3));
        }
    }

    public Player updateTurn(int nextplayer) {
        // change color and send info for next player
        if (nextplayer == 0) {
            controlPanel.setBackground(Color.BLUE);
        } else if (nextplayer == 1) {
            controlPanel.setBackground(Color.RED);
        } else if (nextplayer == 2) {
            controlPanel.setBackground(Color.CYAN);
        } else if (nextplayer == 3) {
            controlPanel.setBackground(Color.GREEN);
        } else if (nextplayer == 4) {
            controlPanel.setBackground(Color.ORANGE);
        } else if (nextplayer == 5) {
            controlPanel.setBackground(Color.PINK);
        } else if (nextplayer == 6) {
            controlPanel.setBackground(Color.MAGENTA);
        } else if (nextplayer == 7) {
            controlPanel.setBackground(Color.YELLOW);
        }
        return totalPlayers.get(nextplayer);
    }
    class boardMouseListener implements MouseListener {
        // listen for buttons else end the day
        // Code for the different button clicks
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == actButton) {
                // this allows them to choose to act in a starring or extra role which are highlighted
            } else if (e.getSource() == rehearseButton) {
                if (!totalPlayers.get(Controller.turns).getRole().equals("no current role")) {
                    // match with the role, and add a counter to their dice role
                }
            } else if (e.getSource() == moveButton) {
                String playerLocation = totalPlayers.get(Controller.turns).getLocation();
                // check the adjrooms and make JLabels for those with mouselisteners
                // if they click that listener then move their dice position and change their string playerLocation
            } else if (e.getSource() == cancelButton) {
                // maybe??? something???
            } else if (e.getSource() == endTurnButton) {
                System.out.println("end of player " + (Controller.turns+1) + " turn");
                if (Controller.turns == (totalPlayers.size()-1)) {
                    Controller.turns = 0;
                    updateTurn(Controller.turns);
                } else {
                    Controller.turns++;
                    updateTurn((Controller.turns));
                }
            } else if (e.getSource() == roleDieButton) {
                // role a die to act etc???
            }
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }
    }
    // end day method call

    public void createButtons() {
        // rehearse
        rehearseButton = new JLabel();
        ImageIcon rIcon = new ImageIcon("buttons/rehearseButton.png");
        rehearseButton.setIcon(rIcon);
        rehearseButton.setBounds(949, 0, rIcon.getIconWidth(), rIcon.getIconHeight());
        rehearseButton.addMouseListener(new boardMouseListener());
        // act
        actButton = new JLabel();
        ImageIcon aIcon = new ImageIcon("buttons/actButton.png");
        actButton.setIcon(aIcon);
        actButton.setBounds(949, 100, aIcon.getIconWidth(), aIcon.getIconHeight());
        actButton.addMouseListener(new boardMouseListener());
        // move
        moveButton = new JLabel();
        ImageIcon mIcon = new ImageIcon("buttons/moveButton.png");
        moveButton.setIcon(mIcon);
        moveButton.setBounds(949, 200, mIcon.getIconWidth(), mIcon.getIconHeight());
        moveButton.addMouseListener(new boardMouseListener());
        // cancel
        cancelButton = new JLabel();
        ImageIcon cIcon = new ImageIcon("buttons/cancelButton.png");
        cancelButton.setIcon(cIcon);
        cancelButton.setBounds(949, 300, cIcon.getIconWidth(), cIcon.getIconHeight());
        cancelButton.addMouseListener(new boardMouseListener());
        // upgrade
        upgradeButton = new JLabel();
        ImageIcon uIcon = new ImageIcon("buttons/upgradeButton.png");
        upgradeButton.setIcon(uIcon);
        upgradeButton.setBounds(949, 400, uIcon.getIconWidth(), uIcon.getIconHeight());
        upgradeButton.addMouseListener(new boardMouseListener());
        // role die
        roleDieButton = new JLabel();
        ImageIcon roleIcon = new ImageIcon("buttons/roleDieButton.png");
        roleDieButton.setIcon(roleIcon);
        roleDieButton.setBounds(949, 500, roleIcon.getIconWidth(), roleIcon.getIconHeight());
        roleDieButton.addMouseListener(new boardMouseListener());
        // end turn
        endTurnButton = new JLabel();
        ImageIcon eIcon = new ImageIcon("buttons/endButton.png");
        endTurnButton.setIcon(eIcon);
        endTurnButton.setBounds(949, 600, eIcon.getIconWidth(), eIcon.getIconHeight());
        endTurnButton.addMouseListener(new boardMouseListener());

        // add buttons to board layer three
        boardPane.add(rehearseButton,new Integer(3));
        boardPane.add(actButton,new Integer(3));
        boardPane.add(moveButton,new Integer(3));
        boardPane.add(cancelButton,new Integer(3));
        boardPane.add(upgradeButton,new Integer(3));
        boardPane.add(roleDieButton,new Integer(3));
        boardPane.add(endTurnButton,new Integer(3));
    }

    public void updateScoreBoard() {
        // display a seperate JFrame after the end of each round to show stats
        // rank
        // credits
        // cash
        // standing
        // fame???
        // role
        // roles completed???
    }

    public String textBoxWaitString() {
        final LinkedList<String> holder = new LinkedList<String>();

        final JFrame frame = new JFrame("Setup");

        final JTextField field = new JTextField("Enter a player's name");
        frame.add(field);
        field.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                synchronized (holder) {
                    holder.add(field.getText());
                    holder.notify();
                }
                frame.dispose();
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        // "logic" thread
        synchronized (holder) {

            // wait for input from field
            while (holder.isEmpty()) {
                try {
                    holder.wait();
                } catch (InterruptedException e) {
                    System.out.println("dang");
                }
            }

            String nextString = holder.remove(0);
            return nextString;
        }
    }

    public Integer textBoxWaitInt() {
        final LinkedList<Integer> holder = new LinkedList<Integer>();

        final JFrame frame = new JFrame("Setup");

        final JTextField field = new JTextField("Enter the number of players");
        frame.add(field);
        field.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                synchronized (holder) {
                    holder.add(Integer.parseInt(field.getText()));
                    holder.notify();
                }
                frame.dispose();
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        // "logic" thread
        synchronized (holder) {

            // wait for input from field
            while (holder.isEmpty()) {
                try {
                    holder.wait();
                } catch (InterruptedException e) {
                    System.out.println("dang");
                }
            }

            int nextInt = holder.remove(0);
            return nextInt;
        }
    }

    public ArrayList<GUIPlayer> createPlayers() {
        ArrayList<GUIPlayer> playa = new ArrayList<GUIPlayer>();
        int numPlayers = textBoxWaitInt();
        String[] players = {"b1.png", "r1.png", "c1.png", "g1.png", "o1.png", "p1.png", "v1.png", "y1.png"};
        int xBound = 800;
        int yBound = 210;
        for (int i = 0; i < numPlayers; i++) {
            // create player
            String player = textBoxWaitString();
            JLabel playerLabel = new JLabel();
            ImageIcon pIcon = new ImageIcon("dice/" + players[i]);
            playerLabel.setIcon(pIcon);
            playerLabel.setBounds(xBound,yBound,pIcon.getIconWidth(),pIcon.getIconHeight());
            GUIPlayer pl = new GUIPlayer(playerLabel, pIcon, xBound, yBound);
            if (i < 2) {
                xBound += 46;
                yBound += 0;
            } else if (i == 2) {
                xBound += 0;
                yBound += 46;
            } else if (i >= 3 && i < 5) {
                xBound -= 46;
                yBound += 0;
            } else if (i == 5) {
                xBound += 0;
                yBound += 46;
            } else if (i >= 6 && i < 7) {
                xBound += 46;
                yBound += 0;
            }
            playa.add(pl);
            Player newDeadwoodPlayer = new Player(player, "trailer", 0, 0);
            totalPlayers.add(newDeadwoodPlayer);
        }
        return playa;
    }

    public void addCardsToBoard() {
        // Add a scene card to this room

        // card 1 jail
        cardLabel_1 = new JLabel();
        ImageIcon cIcon1 = new ImageIcon(new ImageIcon("cards/cardBack.png").getImage().getScaledInstance(160, 85, Image.SCALE_DEFAULT));
        cardLabel_1.setIcon(cIcon1);
        cardLabel_1.setBounds(222,27,cIcon1.getIconWidth(),cIcon1.getIconHeight());
        cardLabel_1.setOpaque(true);
        // card 2 train station
        cardLabel_2 = new JLabel();
        ImageIcon train = new ImageIcon(new ImageIcon("cards/cardBack.png").getImage().getScaledInstance(160, 85, Image.SCALE_DEFAULT));

        //train = new RotatedIcon(cIcon2, RotatedIcon.Rotate.UP);
        cardLabel_2.setIcon(train);
        cardLabel_2.setBounds(20,60,train.getIconWidth(),train.getIconHeight());
        cardLabel_2.setOpaque(true);
        // card 3 general store
        cardLabel_3 = new JLabel();
        ImageIcon cIcon3 = new ImageIcon(new ImageIcon("cards/cardBack.png").getImage().getScaledInstance(160, 85, Image.SCALE_DEFAULT));
        cardLabel_3.setIcon(cIcon3);
        cardLabel_3.setBounds(292,228,cIcon3.getIconWidth(),cIcon3.getIconHeight());
        cardLabel_3.setOpaque(true);
        // card 4 bank
        cardLabel_4 = new JLabel();
        ImageIcon cIcon4 = new ImageIcon(new ImageIcon("cards/cardBack.png").getImage().getScaledInstance(160, 85, Image.SCALE_DEFAULT));
        cardLabel_4.setIcon(cIcon4);
        cardLabel_4.setBounds(497,387,cIcon4.getIconWidth(),cIcon4.getIconHeight());
        cardLabel_4.setOpaque(true);
        // card 5 hotel
        cardLabel_5 = new JLabel();
        ImageIcon hotel = new ImageIcon(new ImageIcon("cards/cardBack.png").getImage().getScaledInstance(160, 85, Image.SCALE_DEFAULT));

        //hotel = new RotatedIcon(cIcon5, RotatedIcon.Rotate.DOWN);
        cardLabel_5.setIcon(hotel);
        cardLabel_5.setBounds(766,594,hotel.getIconWidth(),hotel.getIconHeight());
        cardLabel_5.setOpaque(true);
        // card 6 saloon
        cardLabel_6 = new JLabel();
        ImageIcon cIcon6 = new ImageIcon(new ImageIcon("cards/cardBack.png").getImage().getScaledInstance(160, 85, Image.SCALE_DEFAULT));
        cardLabel_6.setIcon(cIcon6);
        cardLabel_6.setBounds(500,226,cIcon6.getIconWidth(),cIcon6.getIconHeight());
        cardLabel_6.setOpaque(true);
        // card 7 main street
        cardLabel_7 = new JLabel();
        ImageIcon cIcon7 = new ImageIcon(new ImageIcon("cards/cardBack.png").getImage().getScaledInstance(160, 85, Image.SCALE_DEFAULT));
        cardLabel_7.setIcon(cIcon7);
        cardLabel_7.setBounds(766,25,cIcon7.getIconWidth(),cIcon7.getIconHeight());
        cardLabel_7.setOpaque(true);
        // card 8 church
        cardLabel_8 = new JLabel();
        ImageIcon cIcon8 = new ImageIcon(new ImageIcon("cards/cardBack.png").getImage().getScaledInstance(160, 85, Image.SCALE_DEFAULT));
        cardLabel_8.setIcon(cIcon8);
        cardLabel_8.setBounds(494,594,cIcon8.getIconWidth(),cIcon8.getIconHeight());
        cardLabel_8.setOpaque(true);
        // card 9 ranch
        cardLabel_9 = new JLabel();
        ImageIcon cIcon9 = new ImageIcon(new ImageIcon("cards/cardBack.png").getImage().getScaledInstance(160, 85, Image.SCALE_DEFAULT));
        cardLabel_9.setIcon(cIcon9);
        cardLabel_9.setBounds(200,390,cIcon9.getIconWidth(),cIcon9.getIconHeight());
        cardLabel_9.setOpaque(true);
        // card 10 secret hideout
        cardLabel_10 = new JLabel();
        ImageIcon cIcon10 = new ImageIcon(new ImageIcon("cards/cardBack.png").getImage().getScaledInstance(160, 85, Image.SCALE_DEFAULT));
        cardLabel_10.setIcon(cIcon10);
        cardLabel_10.setBounds(23,588,cIcon10.getIconWidth(),cIcon10.getIconHeight());
        cardLabel_10.setOpaque(true);

        // Add the cards to layer two
        boardPane.add(cardLabel_1, new Integer(1));
        boardPane.add(cardLabel_2, new Integer(1));
        boardPane.add(cardLabel_3, new Integer(1));
        boardPane.add(cardLabel_4, new Integer(1));
        boardPane.add(cardLabel_5, new Integer(1));
        boardPane.add(cardLabel_6, new Integer(1));
        boardPane.add(cardLabel_7, new Integer(1));
        boardPane.add(cardLabel_8, new Integer(1));
        boardPane.add(cardLabel_9, new Integer(1));
        boardPane.add(cardLabel_10, new Integer(1));

    }

    public void addShotCounters(Room room) {
        if (room.getRoomName().equals("Train_Station")) {
            JLabel trainShot1 = new JLabel();
            JLabel trainShot2 = new JLabel();
            JLabel trainShot3 = new JLabel();

            ImageIcon tShot1 = new ImageIcon(new ImageIcon("shotCounter.png").getImage().getScaledInstance(35, 36, Image.SCALE_DEFAULT));
            ImageIcon tShot2 = new ImageIcon(new ImageIcon("shotCounter.png").getImage().getScaledInstance(35, 36, Image.SCALE_DEFAULT));
            ImageIcon tShot3 = new ImageIcon(new ImageIcon("shotCounter.png").getImage().getScaledInstance(35, 36, Image.SCALE_DEFAULT));

            trainShot1.setIcon(tShot1);
            trainShot2.setIcon(tShot2);
            trainShot3.setIcon(tShot3);

            trainShot1.setBounds(30, 10, tShot1.getIconWidth(), tShot1.getIconHeight());
            trainShot2.setBounds(71, 10, tShot2.getIconWidth(), tShot2.getIconHeight());
            trainShot3.setBounds(113, 10, tShot3.getIconWidth(), tShot3.getIconHeight());

            trainShot1.setOpaque(false);
            trainShot2.setOpaque(false);
            trainShot3.setOpaque(false);

            boardPane.add(trainShot1, new Integer(2));
            boardPane.add(trainShot2, new Integer(2));
            boardPane.add(trainShot3, new Integer(2));

            room.GUIShots.add(trainShot1);
            room.GUIShots.add(trainShot2);
            room.GUIShots.add(trainShot3);

            // add room details while we are at it
            GUIPositioningRooms roomDetails = new GUIPositioningRooms("Train_Station", 21, 100);
            totalRooms.add(roomDetails);
            // add part details while we are at it
            GUIPositioningParts part1 = new GUIPositioningParts("Train_Station", "Crusty_Prospector", 114, 227);
            GUIPositioningParts part2 = new GUIPositioningParts("Train_Station", "Dragged_by_Train", 51, 268);
            GUIPositioningParts part3 = new GUIPositioningParts("Train_Station", "Preacher_with_Bag", 114, 320);
            GUIPositioningParts part4 = new GUIPositioningParts("Train_Station", "Cyrus_the_Gunfighter", 49, 356);
            totalParts.add(part1);
            totalParts.add(part2);
            totalParts.add(part3);
            totalParts.add(part4);

        } else if (room.getRoomName().equals("Jail")) {
            JLabel jailShot1 = new JLabel();
            ImageIcon jShot1 = new ImageIcon(new ImageIcon("shotCounter.png").getImage().getScaledInstance(35, 36, Image.SCALE_DEFAULT));
            jailShot1.setIcon(jShot1);
            jailShot1.setBounds(350, 125, jShot1.getIconWidth(), jShot1.getIconHeight());
            jailShot1.setOpaque(false);
            boardPane.add(jailShot1, new Integer(2));
            room.GUIShots.add(jailShot1);

            // add room details while we are at it
            GUIPositioningRooms roomDetails = new GUIPositioningRooms("Jail", 281, 110);
            totalRooms.add(roomDetails);
            // ''
            GUIPositioningParts part1 = new GUIPositioningParts("Jail", "Prisoner_In_Cell", 419, 25);
            GUIPositioningParts part2 = new GUIPositioningParts("Jail", "Feller_in_Irons", 419, 105);
            totalParts.add(part1);
            totalParts.add(part2);

        } else if (room.getRoomName().equals("General_Store")) {
            JLabel generalShot1 = new JLabel();
            ImageIcon gsShot1 = new ImageIcon(new ImageIcon("shotCounter.png").getImage().getScaledInstance(35, 36, Image.SCALE_DEFAULT));
            generalShot1.setIcon(gsShot1);
            generalShot1.setBounds(249, 224, gsShot1.getIconWidth(), gsShot1.getIconHeight());
            generalShot1.setOpaque(false);
            JLabel generalShot2 = new JLabel();
            ImageIcon gsShot2 = new ImageIcon(new ImageIcon("shotCounter.png").getImage().getScaledInstance(35, 36, Image.SCALE_DEFAULT));
            generalShot2.setIcon(gsShot2);
            generalShot2.setBounds(249, 266, gsShot2.getIconWidth(), gsShot2.getIconHeight());
            generalShot2.setOpaque(false);
            boardPane.add(generalShot1,new Integer(2));
            boardPane.add(generalShot2,new Integer(2));

            room.GUIShots.add(generalShot1);
            room.GUIShots.add(generalShot2);

            // ''
            GUIPositioningRooms roomDetails = new GUIPositioningRooms("General_Store", 370, 282);
            totalRooms.add(roomDetails);
            // ''
            GUIPositioningParts part1 = new GUIPositioningParts("General_Store", "Main_in_Overalls", 236, 237);
            GUIPositioningParts part2 = new GUIPositioningParts("General_Store", "Mister_Keach", 236, 290);
            totalParts.add(part1);
            totalParts.add(part2);

        } else if (room.getRoomName().equals("Saloon")) {
            JLabel saloonShot1 = new JLabel();
            ImageIcon sShot1 = new ImageIcon(new ImageIcon("shotCounter.png").getImage().getScaledInstance(35, 36, Image.SCALE_DEFAULT));
            saloonShot1.setIcon(sShot1);
            saloonShot1.setBounds(496, 173, sShot1.getIconWidth(), sShot1.getIconHeight());
            saloonShot1.setOpaque(false);
            JLabel saloonShot2 = new JLabel();
            ImageIcon sShot2 = new ImageIcon(new ImageIcon("shotCounter.png").getImage().getScaledInstance(35, 36, Image.SCALE_DEFAULT));
            saloonShot2.setIcon(sShot2);
            saloonShot2.setBounds(537, 173, sShot2.getIconWidth(), sShot2.getIconHeight());
            saloonShot2.setOpaque(false);
            boardPane.add(saloonShot1,new Integer(2));
            boardPane.add(saloonShot2,new Integer(2));

            room.GUIShots.add(saloonShot1);
            room.GUIShots.add(saloonShot2);

            // ''
            GUIPositioningRooms roomDetails = new GUIPositioningRooms("Saloon", 632, 280);
            totalRooms.add(roomDetails);
            // ''
            GUIPositioningParts part1 = new GUIPositioningParts("Saloon", "Reluctant_Farmer",777, 300);
            GUIPositioningParts part2 = new GUIPositioningParts("Saloon", "Woman_in_Red_Dress", 777, 240);
            totalParts.add(part1);
            totalParts.add(part2);

        } else if (room.getRoomName().equals("Main_Street")) {
            JLabel mainShot1 = new JLabel();
            JLabel mainShot2 = new JLabel();
            JLabel mainShot3 = new JLabel();

            ImageIcon mShot1 = new ImageIcon(new ImageIcon("shotCounter.png").getImage().getScaledInstance(35, 36, Image.SCALE_DEFAULT));
            ImageIcon mShot2 = new ImageIcon(new ImageIcon("shotCounter.png").getImage().getScaledInstance(35, 36, Image.SCALE_DEFAULT));
            ImageIcon mShot3 = new ImageIcon(new ImageIcon("shotCounter.png").getImage().getScaledInstance(35, 36, Image.SCALE_DEFAULT));

            mainShot1.setIcon(mShot1);
            mainShot2.setIcon(mShot2);
            mainShot3.setIcon(mShot3);

            mainShot1.setBounds(637, 20, mShot1.getIconWidth(), mShot1.getIconHeight());
            mainShot2.setBounds(678, 20, mShot2.getIconWidth(), mShot2.getIconHeight());
            mainShot3.setBounds(721, 20, mShot3.getIconWidth(), mShot3.getIconHeight());

            mainShot1.setOpaque(false);
            mainShot2.setOpaque(false);
            mainShot3.setOpaque(false);

            boardPane.add(mainShot1, new Integer(2));
            boardPane.add(mainShot2, new Integer(2));
            boardPane.add(mainShot3, new Integer(2));

            room.GUIShots.add(mainShot1);
            room.GUIShots.add(mainShot2);
            room.GUIShots.add(mainShot3);

            // ''
            GUIPositioningRooms roomDetails = new GUIPositioningRooms("Main_Street", 919, 30);
            totalRooms.add(roomDetails);
            // ''
            GUIPositioningParts part1 = new GUIPositioningParts("Main_Street", "Railroad_Worker", 637, 22);
            GUIPositioningParts part2 = new GUIPositioningParts("Main_Street", "Falls_off_Roof", 720, 22);
            GUIPositioningParts part3 = new GUIPositioningParts("Main_Street", "Woman_in_Black_Dress", 637, 105);
            GUIPositioningParts part4 = new GUIPositioningParts("Main_Street", "Mayor_McGinty", 720, 105);
            totalParts.add(part1);
            totalParts.add(part2);
            totalParts.add(part3);
            totalParts.add(part4);

        } else if (room.getRoomName().equals("Ranch")) {
            JLabel ranchShot1 = new JLabel();
            ImageIcon rShot1 = new ImageIcon(new ImageIcon("shotCounter.png").getImage().getScaledInstance(35, 36, Image.SCALE_DEFAULT));
            ranchShot1.setIcon(rShot1);
            ranchShot1.setBounds(375, 380, rShot1.getIconWidth(), rShot1.getIconHeight());
            ranchShot1.setOpaque(false);
            JLabel ranchShot2 = new JLabel();
            ImageIcon rShot2 = new ImageIcon(new ImageIcon("shotCounter.png").getImage().getScaledInstance(35, 36, Image.SCALE_DEFAULT));
            ranchShot2.setIcon(rShot2);
            ranchShot2.setBounds(416, 380, rShot2.getIconWidth(), rShot2.getIconHeight());
            ranchShot2.setOpaque(false);
            boardPane.add(ranchShot1,new Integer(2));
            boardPane.add(ranchShot2,new Integer(2));

            room.GUIShots.add(ranchShot1);
            room.GUIShots.add(ranchShot2);

            // ''
            GUIPositioningRooms roomDetails = new GUIPositioningRooms("Ranch", 252, 478);
            totalRooms.add(roomDetails);
            // ''
            GUIPositioningParts part1 = new GUIPositioningParts("Ranch", "Shot_in_Leg", 412, 608);
            GUIPositioningParts part2 = new GUIPositioningParts("Ranch", "Saucy_Fred", 488, 608);
            GUIPositioningParts part3 = new GUIPositioningParts("Ranch", "Man_Under_Horse", 488, 525);
            totalParts.add(part1);
            totalParts.add(part2);
            totalParts.add(part3);

        } else if (room.getRoomName().equals("Secret_Hideout")) {
            JLabel secretShot1 = new JLabel();
            JLabel secretShot2 = new JLabel();
            JLabel secretShot3 = new JLabel();

            ImageIcon scShot1 = new ImageIcon(new ImageIcon("shotCounter.png").getImage().getScaledInstance(35, 36, Image.SCALE_DEFAULT));
            ImageIcon scShot2 = new ImageIcon(new ImageIcon("shotCounter.png").getImage().getScaledInstance(35, 36, Image.SCALE_DEFAULT));
            ImageIcon scShot3 = new ImageIcon(new ImageIcon("shotCounter.png").getImage().getScaledInstance(35, 36, Image.SCALE_DEFAULT));

            secretShot1.setIcon(scShot1);
            secretShot2.setIcon(scShot2);
            secretShot3.setIcon(scShot3);

            secretShot1.setBounds(196, 610, scShot1.getIconWidth(), scShot1.getIconHeight());
            secretShot2.setBounds(236, 610, scShot2.getIconWidth(), scShot2.getIconHeight());
            secretShot3.setBounds(280, 610, scShot3.getIconWidth(), scShot3.getIconHeight());

            secretShot1.setOpaque(false);
            secretShot2.setOpaque(false);
            secretShot3.setOpaque(false);

            boardPane.add(secretShot1, new Integer(2));
            boardPane.add(secretShot2, new Integer(2));
            boardPane.add(secretShot3, new Integer(2));

            room.GUIShots.add(secretShot1);
            room.GUIShots.add(secretShot2);
            room.GUIShots.add(secretShot3);

            // ''
            GUIPositioningRooms roomDetail = new GUIPositioningRooms("Secret_Hideout", 27, 732);
            totalRooms.add(roomDetail);
            // ''
            GUIPositioningParts part1 = new GUIPositioningParts("Secret_Hideout", "Clumsy_Pit_Fighter", 435, 719);
            GUIPositioningParts part2 = new GUIPositioningParts("Secret_Hideout", "Thug_with_Knife", 521, 719);
            GUIPositioningParts part3 = new GUIPositioningParts("Secret_Hideout", "Dangerous_Tom", 435, 808);
            GUIPositioningParts part4 = new GUIPositioningParts("Secret_Hideout", "Penny,_who_is_lost", 521, 808);
            totalParts.add(part1);
            totalParts.add(part2);
            totalParts.add(part3);
            totalParts.add(part4);

        } else if (room.getRoomName().equals("Bank")) {
            JLabel bankShot1 = new JLabel();
            ImageIcon bShot1 = new ImageIcon(new ImageIcon("shotCounter.png").getImage().getScaledInstance(35, 36, Image.SCALE_DEFAULT));
            bankShot1.setIcon(bShot1);
            bankShot1.setBounds(664, 440, bShot1.getIconWidth(), bShot1.getIconHeight());
            bankShot1.setOpaque(false);
            boardPane.add(bankShot1, new Integer(2));
            room.GUIShots.add(bankShot1);

            // ''
            GUIPositioningRooms roomDetail = new GUIPositioningRooms("Bank", 623, 475);
            totalRooms.add(roomDetail);
            // ''
            GUIPositioningParts part1 = new GUIPositioningParts("Bank", "Suspicious_Gentleman", 870, 454);
            GUIPositioningParts part2 = new GUIPositioningParts("Bank", "Flustered_Teller", 870, 404);
            totalParts.add(part1);
            totalParts.add(part2);
        } else if (room.getRoomName().equals("Church")) {
            JLabel churchShot1 = new JLabel();
            ImageIcon chShot1 = new ImageIcon(new ImageIcon("shotCounter.png").getImage().getScaledInstance(35, 36, Image.SCALE_DEFAULT));
            churchShot1.setIcon(chShot1);
            churchShot1.setBounds(495, 540, chShot1.getIconWidth(), chShot1.getIconHeight());
            churchShot1.setOpaque(false);
            JLabel churchShot2 = new JLabel();
            ImageIcon chShot2 = new ImageIcon(new ImageIcon("shotCounter.png").getImage().getScaledInstance(35, 36, Image.SCALE_DEFAULT));
            churchShot2.setIcon(chShot2);
            churchShot2.setBounds(539, 540, chShot2.getIconWidth(), chShot2.getIconHeight());
            churchShot2.setOpaque(false);
            boardPane.add(churchShot1,new Integer(2));
            boardPane.add(churchShot2,new Integer(2));

            room.GUIShots.add(churchShot1);
            room.GUIShots.add(churchShot2);

            // ''
            GUIPositioningRooms roomDetail = new GUIPositioningRooms("Church", 523, 590);
            totalRooms.add(roomDetail);
            // ''
            GUIPositioningParts part1 = new GUIPositioningParts("Church", "Dead_Man", 800, 600);
            GUIPositioningParts part2 = new GUIPositioningParts("Church", "Crying_Woman", 800, 645);
            totalParts.add(part1);
            totalParts.add(part2);
        } else if (room.getRoomName().equals("Hotel")) {
            JLabel hotelShot1 = new JLabel();
            JLabel hotelShot2 = new JLabel();
            JLabel hotelShot3 = new JLabel();

            ImageIcon hShot1 = new ImageIcon(new ImageIcon("shotCounter.png").getImage().getScaledInstance(35, 36, Image.SCALE_DEFAULT));
            ImageIcon hShot2 = new ImageIcon(new ImageIcon("shotCounter.png").getImage().getScaledInstance(35, 36, Image.SCALE_DEFAULT));
            ImageIcon hShot3 = new ImageIcon(new ImageIcon("shotCounter.png").getImage().getScaledInstance(35, 36, Image.SCALE_DEFAULT));

            hotelShot1.setIcon(hShot1);
            hotelShot2.setIcon(hShot2);
            hotelShot3.setIcon(hShot3);

            hotelShot1.setBounds(796, 548, hShot1.getIconWidth(), hShot1.getIconHeight());
            hotelShot2.setBounds(840, 548, hShot2.getIconWidth(), hShot2.getIconHeight());
            hotelShot3.setBounds(880, 548, hShot2.getIconWidth(), hShot2.getIconHeight());

            hotelShot1.setOpaque(false);
            hotelShot2.setOpaque(false);
            hotelShot3.setOpaque(false);

            boardPane.add(hotelShot1, new Integer(2));
            boardPane.add(hotelShot2, new Integer(2));
            boardPane.add(hotelShot3, new Integer(2));

            room.GUIShots.add(hotelShot1);
            room.GUIShots.add(hotelShot2);
            room.GUIShots.add(hotelShot3);

            // ''
            GUIPositioningRooms roomDetail = new GUIPositioningRooms("Hotel", 900, 550);
            totalRooms.add(roomDetail);
            // ''
            GUIPositioningParts part1 = new GUIPositioningParts("Hotel", "Sleeping_Drunkard", 910, 390);
            GUIPositioningParts part2 = new GUIPositioningParts("Hotel", "Faro_Player", 865, 410);
            GUIPositioningParts part3 = new GUIPositioningParts("Hotel", "Falls_from_Balcony", 910, 455);
            GUIPositioningParts part4 = new GUIPositioningParts("Hotel", "Australian_Bartender", 865, 500);
            totalParts.add(part1);
            totalParts.add(part2);
            totalParts.add(part3);
            totalParts.add(part4);
        }
    }

    private void flipCard(String cardPNG, Room room) {
        JLabel cardLabel = new JLabel();
        ImageIcon cIcon = new ImageIcon(new ImageIcon("cards/" + cardPNG).getImage().getScaledInstance(160, 85, Image.SCALE_DEFAULT));
        cardLabel.setIcon(cIcon);
        cardLabel.setBounds(room.getCardX(),room.getCardY(),cIcon.getIconWidth(),cIcon.getIconHeight());
        cardLabel.setOpaque(true);

        boardPane.add(cardLabel,new Integer(2));
    }
}