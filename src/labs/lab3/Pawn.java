package labs.lab3;

public class Pawn extends Piece {

    public static final int DEFAULT_VALUE = 1_000;

    public Pawn(boolean isWhite) {
        super(DEFAULT_VALUE, isWhite);
    }

    @Override
    public void move() {
        System.out.println("One square");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Piece) {
            Piece other = (Piece) obj;
            return this.isWhite == other.isWhite && this.getValue() == other.getValue();
        }
        return false;
    }

    @Override
    public String toString() {
        return "King{" +
                "value=" + value +
                ", isWhite=" + isWhite +
                '}';
    }
}
