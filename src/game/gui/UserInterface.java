package game.gui;

import java.awt.*;
import javax.swing.*;
import game.*;

public class UserInterface implements Runnable{
    private JFrame frame;
    private Game game;
    private Board board;
    private KeyboardListener listener;


    public UserInterface(Game game) {
        this.game = game;
    }

    @Override
    public void run() {
        frame = new JFrame("Snake");
        int width = game.getWidth()*20+20;
        int height = game.getHeight()*20+40;
        frame.setPreferredSize(new Dimension(width, height));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    public void createComponents(Container container) {
        this.board = new Board(game);
        container.add(board);
        this.listener = new KeyboardListener(game, game.getSnake());
        frame.addKeyListener(listener);
    }

    public Board getBoard() {
        return board;
    }

}
