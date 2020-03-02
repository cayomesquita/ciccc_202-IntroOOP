package labs.lab3;

public class King extends Piece {

    public static final int DEFAULT_VALUE = 1_000;

    public King(boolean isWhite) {
        super(DEFAULT_VALUE, isWhite);
    }

    @Override
    public void move() {
        System.out.println("One square");
    }

    @Override
    public String toString() {
        return "King{" +
                "value=" + value +
                ", isWhite=" + isWhite +
                '}';
    }
}
