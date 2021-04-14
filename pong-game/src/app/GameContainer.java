package app;

import java.awt.Color;

import javax.swing.*;

import java.awt.event.*;
/**
 * GameContainer is a class which creates a wrapper around the canvas of the game. This is responsible for holding the game rendering as well as giving the user ability to close the game and such.
 */
public class GameContainer extends JFrame implements ActionListener{

    Game game;
    JFrame frame;
    JMenuBar menuBar;
    JMenu menu, menu2;
    JMenuItem menuItem1, menuItem2, menuItem3, menuItem4;
    JCheckBoxMenuItem checkItem1, checkItem2;

    GameContainer() {

        menuBar = new JMenuBar();
        menu = new JMenu("Options");
        menuBar.add(menu);
        menu2 = new JMenu("Settings");
        menuBar.add(menu2);

        menuItem1 = new JMenuItem("Start New Game");
        menuItem1.addActionListener(this);
        menu.add(menuItem1);

        menuItem2 = new JMenuItem("Exit Game");
        menuItem2.addActionListener(this);
        menu.add(menuItem2);

        menuItem3 = new JMenuItem("Single-Player Mode");
        menu2.add(menuItem3);

        menuItem4 = new JMenuItem("Multiplayer Mode");
        menu2.add(menuItem4);


        game = new Game();
        this.add(game);
        this.setTitle("Game of Pong");
        this.setResizable(false);
        this.setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setJMenuBar(menuBar);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == menuItem1) {
            //Set scores to zero
        }
        if (e.getSource() == menuItem2) {
            System.exit(0);
        }
        if (e.getSource() == menuItem3) {
            //Set game to single player mode
        }
        if (e.getSource() == menuItem4) {
            //Set game to multi-player mode
        }
    }
}