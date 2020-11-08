
import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        Game g = new Game();
        g.run();

        King k1 = new King(true, new Position(1, 5));
        System.out.println(k1.isValidMove(new Position(1, 7)));
        System.out.println(k1.isValidMove(new Position(2, 5)));
        System.out.println();
        Pawn p1 = new Pawn(true, new Position(2, 2), false, null);
        System.out.println(p1.isValidMove(new Position(4, 2)));
        System.out.println(p1.isValidMove(new Position(3, 2)));
        System.out.println(p1.isValidMove(new Position(5, 2)));
        System.out.println();
        Knight kn1 = new Knight(true, new Position(1, 2));
        System.out.println(kn1.isValidMove(new Position(3,3)));
        System.out.println(kn1.isValidMove(new Position(2,4)));
        System.out.println(kn1.isValidMove(new Position(2,3)));
        System.out.println();
        Rook r1 = new Rook(true, new Position(1,1));
        System.out.println(r1.isValidMove(new Position(1, 7)));
        System.out.println(r1.isValidMove(new Position(7, 1)));
        System.out.println(r1.isValidMove(new Position(2, 7)));
        System.out.println();
        Queen q1 = new Queen(true, new Position(1,4));
        System.out.println(q1.isValidMove(new Position(3, 4)));
        System.out.println(q1.isValidMove(new Position(1, 7)));
        System.out.println(q1.isValidMove(new Position(2, 5)));
        System.out.println(q1.isValidMove(new Position(2, 7)));
        System.out.println();
        Bishop b1 = new Bishop(true, new Position(0,0));
        System.out.println(b1.isValidMove(new Position(4, 4)));
        System.out.println(b1.isValidMove(new Position(0, 4)));


    }
}
