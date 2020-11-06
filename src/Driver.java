
import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        ArrayList<Piece> pieces = new ArrayList<>();

        // white Bishops
        pieces.add(new Bishop(true, new Position(0, 0)));
        pieces.add(new Bishop(true, new Position(0, 7)));
        // black Bishops
        pieces.add(new Bishop(false, new Position(7, 0)));
        pieces.add(new Bishop(false, new Position(7, 7)));


        // print each move
        System.out.println("----- each move -----");
        for (Piece p : pieces) {
            System.out.print(p + ": ");
            p.move();
        }

    }
}
