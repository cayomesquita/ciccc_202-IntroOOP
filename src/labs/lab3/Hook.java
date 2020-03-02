package labs.lab3;

public class Hook extends Piece {

    public static final int DEFAULT_VALUE = 5;

    public Hook(boolean isWhite) {
        super(DEFAULT_VALUE, isWhite);
    }

    @Override
    public void move() {
        System.out.println("Horizontally or verticall");
    }

    @Override
    public String toString() {
        return "Hook{" +
                "value=" + value +
                ", isWhite=" + isWhite +
                '}';
    }
}
