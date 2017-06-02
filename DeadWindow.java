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

    JLayeredPane boardPane;

    public DeadWindow() {
        super("DeadWood Board");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        totalPlayers = new ArrayList<Player>();
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

    private void flipCard(String cardPNG, Room room) {
        JLabel cardLabel = new JLabel();
        ImageIcon cIcon = new ImageIcon(new ImageIcon("cards/" + cardPNG).getImage().getScaledInstance(160, 85, Image.SCALE_DEFAULT));
        cardLabel.setIcon(cIcon);
        cardLabel.setBounds(room.getCardX(),room.getCardY(),cIcon.getIconWidth(),cIcon.getIconHeight());
        cardLabel.setOpaque(true);

        boardPane.add(cardLabel,new Integer(2));
    }
    protected ArrayList<Player> getAllPlayers(){
      return this.totalPlayers;
    }
}
