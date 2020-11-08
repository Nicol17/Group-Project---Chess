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

    public boolean isPromoted() {
        return promoted;
    }

    @Override
    public void move(Position newPosition) {
        System.out.println("Forward 1");
    }

    @Override
    public boolean isValidMove (Position newPosition){
        if (!super.isValidMove(position)){
            return false;
        }
        if (this.position.getCol() == 2) {
            if (newPosition.getRow() ==  (this.position.getRow() + 1) ||
                newPosition.getRow() == (this.position.getRow() + 2)) {
                return true;
            }
        } else if (newPosition.getRow() ==  (this.position.getRow() + 1)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String color = (isWhite()) ? "White" : "Black";
        return "Pawn{" +
            "value=" + getValue() +
            ", color=" + color +
            ", promoted=" + isPromoted() +
            ", position=(" + getPosition().getRow() + ", " + getPosition().getCol() + ')' +
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
