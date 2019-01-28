package game;

import java.util.Objects;

/*
/ Building block of every piece in the game - snake body, fruits, walls.
 */

public class Piece {
    private int x;
    private int y;

    // constructor puts a piece at given coords on the board
    public Piece(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return x == piece.x &&
                y == piece.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
