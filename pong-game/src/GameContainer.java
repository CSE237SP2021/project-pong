import java.awt.Color;

import javax.swing.*;

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
    }
    
}
