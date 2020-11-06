import java.util.Objects;

public class Pawn extends Piece {
    ///////////////////////////////////////////////////
    private static final int VALUE = 1;
    ///////////////////////////////////////////////////

    private boolean promoted;
    private Piece newPiece;

    public Pawn(int value, boolean isWhite, Position position, boolean promoted, Piece newPiece) {
        super(value, isWhite, position);
        this.promoted = promoted;
        this.newPiece = newPiece;
    }

//    public Pawn() {
//        this(false, false, null);
//    }
//
//    public Pawn(boolean isWhite, boolean promoted, Piece newPiece) {
//        super(VALUE_PAWN, isWhite);
//        this.promoted = promoted;
//        this.newPiece = newPiece;
//    }

    // not sure what they want..
    public void promote(Piece newPiece) {
        if (!promoted) {
            promoted = true;
            this.newPiece = newPiece;
        }
    }

    @Override
    public void move() {
        System.out.println("Forward 1");
    }

    @Override
    public String toString() {
        return "Pawn{" +
                "value=" + getValue() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pawn pawn = (Pawn) o;
        return promoted == pawn.promoted &&
                Objects.equals(newPiece, pawn.newPiece);
    }
}
