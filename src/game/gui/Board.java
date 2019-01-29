package game.gui;

import game.*;
import javax.swing.*;
import java.awt.*;


public class Board extends JPanel{
    private Game game;
    private final int PIECE_LENGTH = 20;

    public Board (Game game) {
        this.game = game;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, game.getWidth()*PIECE_LENGTH, game.getHeight()*PIECE_LENGTH);
        g.setColor(Color.RED);
        g.fillOval(game.getApple().getX()*PIECE_LENGTH, game.getApple().getY()*PIECE_LENGTH, PIECE_LENGTH, PIECE_LENGTH);
        g.setColor(Color.GREEN);
        for (Piece piece:game.getSnake().getBody()) {
            g.fill3DRect(piece.getX()*PIECE_LENGTH, piece.getY()*PIECE_LENGTH, PIECE_LENGTH, PIECE_LENGTH, true);
        }
    }
}
