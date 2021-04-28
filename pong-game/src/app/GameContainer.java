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
    JMenuItem newGame, exitGame, singlePlayer, multiPlayer;
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

        singlePlayer = new JMenuItem("Single-Player Mode");
        singlePlayer.addActionListener(this);
        menu2.add(singlePlayer);

        multiPlayer = new JMenuItem("Multiplayer Mode");
        multiPlayer.addActionListener(this);
        menu2.add(multiPlayer);


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
        if (e.getSource() == singlePlayer) {
            //Set game to single player mode
            game.setSinglePlayer();
            game.getScore().resetScore();
            game.drawNewPaddles();
            game.drawNewBall();
        }
        if (e.getSource() == multiPlayer) {
            //Set game to multi-player mode
            game.setMultiPlayer();
            game.getScore().resetScore();
            game.drawNewPaddles();
            game.drawNewBall();
        }
    }
}