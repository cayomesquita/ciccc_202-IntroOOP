package labs.lab3;

public class Bishop extends Piece {

    public static final int DEFAULT_VALUE = 3;

    public Bishop(boolean isWhite) {
        super(DEFAULT_VALUE, isWhite);
    }

    @Override
    public void move() {
        System.out.println("Diagonally");
    }

    @Override
    public String toString() {
        return "Bishop{" +
                "value=" + value +
                ", isWhite=" + isWhite +
                '}';
    }

}
