package app;

import java.awt.Color;

import javax.swing.*;

/**
 * GameContainer is a class which creates a wrapper around the canvas of the game. This is responsible for holding the game rendering as well as giving the user ability to close the game and such.
 */
public class GameContainer extends JFrame {

    Game game;

    GameContainer() {
        game = new Game();
        this.add(game);
        this.setTitle("Game of Pong");
        this.setResizable(false);
        this.setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
    
}
