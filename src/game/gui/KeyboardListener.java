package game.gui;

import java.awt.event.*;
import javax.swing.Timer;
import game.*;

public class KeyboardListener implements KeyListener{
    private Snake snake;
    private Game game;

    public KeyboardListener(Game game, Snake snake) {
        this.game = game;
        this.snake = snake;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_UP:
                if (snake.getDirection()!=Direction.DOWN) snake.setDirection(Direction.UP);
                break;

            case KeyEvent.VK_DOWN:
                if (snake.getDirection()!=Direction.UP) snake.setDirection(Direction.DOWN);
                break;

            case KeyEvent.VK_RIGHT:
                if (snake.getDirection()!=Direction.LEFT) snake.setDirection(Direction.RIGHT);
                break;

            case KeyEvent.VK_LEFT:
                if (snake.getDirection()!=Direction.RIGHT) snake.setDirection(Direction.LEFT);
                break;

            case KeyEvent.VK_SPACE:
                game.setPause();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


}
