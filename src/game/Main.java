package game;

import javax.swing.*;
import game.gui.*;

public class Main {

    public static void main(String[] args) {
        Game game = new Game(20, 20);
        UserInterface ui = new UserInterface(game);

        SwingUtilities.invokeLater(ui);

        while (ui.getBoard()==null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {

            }
        }

        game.setBoard(ui.getBoard());
        game.start();
    }
}
