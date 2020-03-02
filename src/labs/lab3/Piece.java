package labs.lab3;

public abstract class Piece {

    protected int value;
    protected boolean isWhite;

    public Piece(int value, boolean isWhite) {
        this.value = value;
        this.isWhite = isWhite;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public abstract void move();

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
        return "{" +
                "value=" + value +
                ", isWhite=" + isWhite +
                '}';
    }
}
