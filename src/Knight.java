import java.util.ArrayList;

public class Knight extends Piece {
    ///////////////////////////////////////////////////
    protected static final int VALUE = 2;
    ///////////////////////////////////////////////////

    public Knight(boolean isWhite, Position position) {
        super(VALUE, isWhite, position);
    }

    /**
     * Return a list of possible positions for the piece user selected (Knight):
     * - moves in a shape of "L"
     * - if the same color piece is in the destiny      --> cannot move
     * - if if the same color piece is in the destiny   --> take it and move
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

        // up / right
        Position result = checkDest(board, selPiece, row + 2, col + 1);
        if (result != null) poss.add(result);

        // up / left
        result = checkDest(board, selPiece, row + 2, col - 1);
        if (result != null) poss.add(result);

        // right / up
        result = checkDest(board, selPiece, row + 1, col + 2);
        if (result != null) poss.add(result);

        // right / down
        result = checkDest(board, selPiece, row - 1, col + 2);
        if (result != null) poss.add(result);

        // down / right
        result = checkDest(board, selPiece, row - 2, col + 1);
        if (result != null) poss.add(result);

        // down / left
        result = checkDest(board, selPiece, row - 2, col + 1);
        if (result != null) poss.add(result);

        // left / up
        result = checkDest(board, selPiece, row + 1, col - 2);
        if (result != null) poss.add(result);

        // left / down
        result = checkDest(board, selPiece, row - 1, col - 2);
        if (result != null) poss.add(result);

        return poss;
    }

    /**
     * Return a result if {@param piece} can move to Position({@param targetRow}, {@param targetCol}).
     *
     * @param board     the current board from Game class
     * @param selPiece  the selected piece that user wants to move it
     * @param targetRow row of Position to check if {@param piece} can move to
     * @param targetCol column of Position to check if {@param piece} can move to
     * @return Position if {@param piece} can move to. otherwise, null
     */
    private Position checkDest(Piece[][] board, Piece selPiece, int targetRow, int targetCol) {
        if (board[targetRow][targetCol] == null) {
            // no piece: can move
            return new Position(targetRow, targetCol);
        } else {
            if (board[targetRow][targetCol].isWhite() == selPiece.isWhite()) {
                // same color: cannot move
            } else {
                // different color: can move
                return new Position(targetRow, targetCol);
            }
        }
        return null;
    }

    @Override
    public void move(Position newPosition) {
        System.out.println("Like an L");
    }

    @Override
    public boolean isValidMove(Position newPosition) {
        if (!super.isValidMove(position)) {
            return false;
        }
        if (newPosition.getCol() == (this.position.getCol() + 2) && newPosition.getRow() == (this.position.getRow() + 1) ||
                newPosition.getCol() == (this.position.getCol() + 2) && newPosition.getRow() == (this.position.getRow() - 1) ||
                newPosition.getCol() == (this.position.getCol() - 2) && newPosition.getRow() == (this.position.getRow() + 1) ||
                newPosition.getCol() == (this.position.getCol() - 2) && newPosition.getRow() == (this.position.getRow() - 1) ||
                newPosition.getCol() == (this.position.getCol() + 1) && newPosition.getRow() == (this.position.getRow() + 2) ||
                newPosition.getCol() == (this.position.getCol() - 1) && newPosition.getRow() == (this.position.getRow() + 2) ||
                newPosition.getCol() == (this.position.getCol() + 1) && newPosition.getRow() == (this.position.getRow() - 2) ||
                newPosition.getCol() == (this.position.getCol() - 1) && newPosition.getRow() == (this.position.getRow() - 2)) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public String toString() {
        String color = (isWhite()) ? "White" : "Black";
        return "Knight{" +
                "value=" + getValue() +
                ", color=" + color +
                ", position=(" + getPosition().getRow() + ", " + getPosition().getCol() + ')' +
                '}';
    }
}
