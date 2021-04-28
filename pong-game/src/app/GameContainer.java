package app;

import java.awt.Color;
import java.awt.Graphics;

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
    JMenuItem newGame, exitGame, menuItem3, menuItem4;
    JCheckBoxMenuItem checkItem1, checkItem2;

    GameContainer() {

        menuBar = new JMenuBar();
        menu = new JMenu("Options");
        menuBar.add(menu);
        menu2 = new JMenu("Settings");
        menuBar.add(menu2);

        newGame = new JMenuItem("Start New Game");
        newGame.addActionListener(this);
        menu.add(newGame);

        exitGame = new JMenuItem("Exit Game");
        exitGame.addActionListener(this);
        menu.add(exitGame);

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
        if (e.getSource() == newGame) {
            //Set scores to zero
            game.getScore().resetScore();
            game.drawNewPaddles();
            game.drawNewBall();
        }
        if (e.getSource() == exitGame) {
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