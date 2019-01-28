package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Game extends Timer implements ActionListener {

    private int width;
    private int height;
    private Snake snake;
    private Apple apple;
    private boolean gameOver;
    private boolean pause;


    public Game(int delay, ActionListener listener) {
        super(delay, listener);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
