import java.util.ArrayList;

public class Driver {

  public static void main(String[] args) {
    // testing - by yurie

    ArrayList<Piece> whites = new ArrayList();
    Pawn pawn = new Pawn(true);
    Knight knight = new Knight(true);
    Bishop bishop = new Bishop(true);
    Rock rock = new Rock(true);
    Queen queen = new Queen(true);
    King king = new King (true);
    whites.add(pawn);
    whites.add(knight);
    whites.add(bishop);
    whites.add(rock);
    whites.add(queen);
    whites.add(king);

    // 1.-
    System.out.println(whites);

    // 2.-
    for (Piece piece : whites) {
      piece.move();
    }

    // 3.-
    Pawn p1 = new Pawn(true, true, new Queen(true));
    Pawn p2 = new Pawn(true,false);
    Pawn p3 = new Pawn(false, false);
    Pawn p4 = new Pawn(false, true, new Queen(true));
    Pawn p5 = new Pawn(true, true, new Knight(true));
    

    // 4.-
    System.out.println(p1.equals(p2));
    System.out.println(p1.equals(p4));
    System.out.println(p1.equals(p5));
    System.out.println(p2.equals(p3));
    System.out.println(p4.equals(p5));
    p4.move();

  }

}
