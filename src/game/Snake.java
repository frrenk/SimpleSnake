package game;

import java.util.*;

/* Controllable snake
@param body: body of the snake made out of Piece object
@param direction: direction in which the snake will move
@param ate: flags the snake to grow a new piece
 */
public class Snake {
    private List<Piece> body;
    private Direction direction;
    private boolean ate;


    public Snake(int x, int y, Direction direction) {
        body = new ArrayList<>();
        body.add(new Piece(x, y));
        this.direction = direction;
        ate = false;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public List<Piece> getBody() {
        return body;
    }

    public Piece getHead() {
        return body.get(body.size()-1);
    }

    public int getLength() {
        return body.size();
    }

    //check if snake ate an apple, change ate to true.
    public boolean eatsApple(Piece piece) {
        if (getHead().getX()==piece.getX() && getHead().getY()==piece.getY()) {
            ate=true;
            return true;
        }
        else return false;
    }

    //check if snake hit itself
    public boolean eatsItself() {
        for (int i = 0; i<body.size()-1; i++) {
            if (body.get(i).getX()==getHead().getX() && body.get(i).getY()==getHead().getY()) return true;
        }
        return false;
    }

    /*
    Move snake according to current direction.
    Moving is achieved by adding another piece to the body of the snake next to it's current head.
    If the result of the boolean ate is true, only new piece is added, so that the snake is longer. Ate is then changed to false.
    If result of the boolean ate is false, additionaly last piece of the body is removed.
     */
    public void move() {
        if (getLength()<3||ate) {
            switch (direction)  {

                case UP:
                    body.add(new Piece(getHead().getX(), getHead().getY()-1));
                    break;

                case DOWN:
                    body.add(new Piece(getHead().getX(), getHead().getY()+1));
                    break;

                case LEFT:
                    body.add(new Piece(getHead().getX()-1, getHead().getY()));
                    break;

                case RIGHT:
                    body.add(new Piece(getHead().getX()+1, getHead().getY()));
            }
            ate = false;
        } else {
            switch (direction)  {

                case UP:
                    body.remove(0);
                    body.add(new Piece(getHead().getX(), getHead().getY()-1));
                    break;

                case DOWN:
                    body.remove(0);
                    body.add(new Piece(getHead().getX(), getHead().getY()+1));
                    break;

                case LEFT:
                    body.remove(0);
                    body.add(new Piece(getHead().getX()-1, getHead().getY()));
                    break;

                case RIGHT:
                    body.remove(0);
                    body.add(new Piece(getHead().getX()+1, getHead().getY()));
            }
        }
    }
}
