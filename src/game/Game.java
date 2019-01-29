package game;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import game.gui.*;


public class Game extends Timer implements ActionListener {

    private int width;
    private int height;
    private Snake snake;
    private Apple apple;
    private Board board;
    private boolean gameOver;
    private boolean pause;

    public Game(int width, int height) {
        super(1000, null);

        this.width = width;
        this.height = height;
        this.snake = new Snake(width/2, height/2, Direction.DOWN);
        this.apple = setRandomApple();
        gameOver = false;
        pause = false;

        addActionListener(this);
        setInitialDelay(1000);
    }

    //getters for use with other classes
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Snake getSnake() {
        return snake;
    }

    public Apple getApple() {
        return apple;
    }

    public void setBoard (Board board) { this.board = board; }

    public boolean isGameOver() {
        return gameOver;
    }

    public boolean isPause() {
        return pause;
    }

    public void setPause() {
        if (pause) pause=false;
        else pause=true;
    }

    public int getDelay() {
        return super.getDelay();
    }

    // sets an apple at a random position not occupied by the snake
    public Apple setRandomApple() {

        int randomWidth = new Random().nextInt(this.width);
        int randomHeight = new Random().nextInt(this.height);
        Apple randomApple = new Apple(randomWidth, randomHeight);

        for (Piece snakePiece:snake.getBody()) {
            if (snakePiece.getX()==randomApple.getX()&&snakePiece.getY()==randomApple.getY()) {
                randomApple = new Apple(randomWidth, randomHeight);
            }
        }

        return randomApple;

    }

    //checks if snake hits a wall at the border of the board
    public boolean snakeRunsIntoAWall() {
        if (snake.getHead().getX()<0 || snake.getHead().getY()<0 || snake.getHead().getX()>=width || snake.getHead().getY()>=height) return true;
        else return false;
    }

    //moves the snake, sets a new apple if one on the board is eaten, ends game if snake hits itself or a wall, checks if user paused the game
    @Override
    public void actionPerformed(ActionEvent e) {
        snake.move();
        if (snake.eatsApple(this.apple)) apple=setRandomApple();
        if (snake.eatsItself()||snakeRunsIntoAWall()) {
            gameOver = true;
        }
        if (gameOver) return;
        if (pause) this.stop();
        else this.start();

        board.repaint();
        setDelay(1000/snake.getLength());
    }
}
