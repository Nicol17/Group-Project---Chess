import java.util.Objects;

public class Pawn extends Piece {
    ///////////////////////////////////////////////////
    protected static final int VALUE = 1;
    ///////////////////////////////////////////////////

    private boolean promoted;
    private Piece newPiece;

    public Pawn( boolean isWhite, Position position, boolean promoted, Piece newPiece) {
        super(VALUE, isWhite, position);
        this.promoted = promoted;
        this.newPiece = newPiece;
    }

    // not sure what they want..
    public void promote(Piece newPiece) {
        if (!promoted) {
            promoted = true;
            this.newPiece = newPiece;
        }
    }

    @Override
    public void move(Position newPosition) {
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
