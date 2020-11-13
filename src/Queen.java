import java.util.ArrayList;

public class Queen extends Piece {
    ///////////////////////////////////////////////////
    protected static final int VALUE = 9;
    ///////////////////////////////////////////////////

    public Queen(boolean isWhite, Position position) {
        super(VALUE, isWhite, position);
    }

    /**
     * Return a list of possible positions for the piece user selected (Bishop):
     * - moves diagonally, vertically, and horizontally
     * - diagonal moves: call Bishop's getPoss
     * - vertical and horizontal moves: call Rook's getPoss
     *
     * @param board
     * @param selPiece
     * @return
     */
    @Override
    public ArrayList<Position> getPoss(Piece[][] board, Piece selPiece) {
        final int row = selPiece.getPosition().getRow();
        final int col = selPiece.getPosition().getCol();
        ArrayList<Position> poss = new ArrayList<>();

        // create dummy instances to call each class's 'getPoss()'
        Piece b = new Bishop(selPiece.isWhite(), new Position(row, col));
        Piece r = new Rook(selPiece.isWhite(), new Position(row, col));
        // diagonally: Bishop class
        ArrayList<Position> possDiag = b.getPoss(board, b);
        // vertically and horizontally: Rook class
        ArrayList<Position> possVH = r.getPoss(board, selPiece);

        poss.addAll(possDiag);
        poss.addAll(possVH);
        return poss;
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
