package labs.lab3;

import java.util.ArrayList;

public class Driver {

    public static void main(String[] args) {
        ArrayList<Piece> pieceList = new ArrayList<>();
        pieceList.add(new King(true));
        pieceList.add(new Queen(true));
        pieceList.add(new Hook(true));
        pieceList.add(new Bishop(true));
        pieceList.add(new Knight(true));
        pieceList.add(new Pawn(true));

        pieceList.forEach(piece -> piece.move());

        Pawn p1 = new Pawn(true);
        p1.promote(new Queen(p1.isWhite()));
        Pawn p2 = new Pawn(true);
        Pawn p3 = new Pawn(false);
        Pawn p4 = new Pawn(false);
        p4.promote(new Queen(p4.isWhite()));
        Pawn p5 = new Pawn(true);
        p5.promote(new King(p5.isWhite()));

        System.out.println(p1.equals(p2)); // false
        System.out.println(p1.equals(p4)); // false
        System.out.println(p1.equals(p5)); // false
        System.out.println(p2.equals(p3)); // false
        System.out.println(p4.equals(p5)); // false
    }
}
