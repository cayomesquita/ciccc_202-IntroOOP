package labs.lab3;

public class Queen extends Piece {

    public static final int DEFAULT_VALUE = 9;

    public Queen(boolean isWhite) {
        super(DEFAULT_VALUE, isWhite);
    }

    @Override
    public void move() {
        System.out.println("Like bishop and rook");
    }

    @Override
    public String toString() {
        return "Queen{" +
                "value=" + value +
                ", isWhite=" + isWhite +
                '}';
    }
}
