import java.util.ArrayList;

public class Queen extends Piece {
    ///////////////////////////////////////////////////
    protected static final int VALUE = 9;
    ///////////////////////////////////////////////////

    public Queen(boolean isWhite, Position position) {
        super(VALUE, isWhite, position);
    }

    @Override
    public ArrayList<Position> getPoss(Piece[][] board, Piece selPiece) {
        return null;
    }

    @Override
    public void move(Position newPosition) {
        System.out.println("Like bishop and rook");
    }


    @Override
    public boolean isValidMove(Position newPosition) {
        if (!super.isValidMove(newPosition)) {
            return false;
        }
        if (newPosition.getCol() == this.position.getCol() ||
            newPosition.getRow() == this.position.getRow()) {
            return true;
        }
        if (Math.abs(this.position.getRow() - newPosition.getRow())
            == Math.abs(this.position.getCol() - newPosition.getCol())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        String color = (isWhite()) ? "White" : "Black";
        return "Bishop{" +
            "value=" + getValue() +
            ", color=" + color +
            ", position=(" + getPosition().getRow() + ", " + getPosition().getCol() + ')' +
            '}';
    }

}
