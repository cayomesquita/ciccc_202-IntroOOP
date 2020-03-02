package labs.lab3;

public class Knight extends Piece {

    public static final int DEFAULT_VALUE = 2;

    public Knight(boolean isWhite) {
        super(DEFAULT_VALUE, isWhite);
    }

    @Override
    public void move() {
        System.out.println("Like an L");
    }

    @Override
    public String toString() {
        return "Knight{" +
                "value=" + value +
                ", isWhite=" + isWhite +
                '}';
    }
}
