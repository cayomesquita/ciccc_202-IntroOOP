package labs.lab3;

public class Pawn extends Piece {

    public static final int DEFAULT_VALUE = 1;

    private boolean promoted;
    private Piece newPiece;

    public Pawn(boolean isWhite) {
        super(DEFAULT_VALUE, isWhite);
        this.newPiece = null;
        this.promoted = false;
    }

    public void promote(Piece newPiece) {
        if (!(newPiece instanceof Pawn || newPiece instanceof King)) {
            this.newPiece = newPiece;
            promoted = true;
        }
    }

    @Override
    public void move() {
        System.out.println("Forward 1");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Pawn) {
            Pawn other = (Pawn) obj;
            if (this.isWhite() != other.isWhite()) {
                return false;
            }
            if (this.promoted != other.promoted) {
                return false;
            }
            if (this.promoted) {
                return this.newPiece != null && other.newPiece != null && this.newPiece.equals(other.newPiece);
            }
            return this.getValue() == other.getValue();
        }
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Pawn{" +
                "promoted=" + promoted +
                ", newPiece=" + newPiece +
                ", value=" + value +
                ", isWhite=" + isWhite +
                '}';
    }
}
