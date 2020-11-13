import java.util.ArrayList;

public class Bishop extends Piece {
    ///////////////////////////////////////////////////
    protected static final int VALUE = 3;
    ///////////////////////////////////////////////////

    public Bishop(boolean isWhite, Position position) {
        super(VALUE, isWhite, position);
    }

    /**
     * Return a list of possible positions for the piece user selected (Bishop):
     * - moves only diagonally
     * - no limit till hit another piece
     * - if hit the same color (Piece A), stop one block before --> new position is Piece A's (row -1, col -1)
     * - if hit the other color (Piece B), take it and stop     --> new position is the same as Piece B
     *
     * @param board    the current board from Game class
     * @param selPiece the selected piece that user wants to move it
     * @return
     */
    @Override
    public ArrayList<Position> getPoss(Piece[][] board, Piece selPiece) {
        final int row = selPiece.getPosition().getRow();
        final int col = selPiece.getPosition().getCol();
        int curRow;
        int curCol;
        ArrayList<Position> poss = new ArrayList<>();

//        System.out.println("-- Bishop is called --");
//        System.out.printf("selected (row, col): (%d, %d)%n", row, col);

        // diagonal / left to right / up
        curRow = row;
        curCol = col;
        while (0 < curRow && curRow < Game.BOARD_RANGE - 1 && 0 < curCol && curCol < Game.BOARD_RANGE - 1) {
            Object[] result = checkDest(board, selPiece, ++curRow, ++curCol);
            if (result[0] != null)
                poss.add((Position) result[0]);
            if (!result[1].equals(true))
                break;
        }

        // diagonal / left to right / down
        curRow = row;
        curCol = col;
        while (0 < curRow && curRow < Game.BOARD_RANGE - 1 && 0 < curCol && curCol < Game.BOARD_RANGE - 1) {
            Object[] result = checkDest(board, selPiece, --curRow, ++curCol);
            if (result[0] != null)
                poss.add((Position) result[0]);
            if (!result[1].equals(true))
                break;
        }

        // diagonal / right to left / up
        curRow = row;
        curCol = col;
        while (0 < curRow && curRow < Game.BOARD_RANGE - 1 && 0 < curCol && curCol < Game.BOARD_RANGE - 1) {
            Object[] result = checkDest(board, selPiece, ++curRow, --curCol);
            if (result[0] != null)
                poss.add((Position) result[0]);
            if (!result[1].equals(true))
                break;
        }

        // diagonal / right to left / down
        curRow = row;
        curCol = col;
        while (0 < curRow && curRow < Game.BOARD_RANGE - 1 && 0 < curCol && curCol < Game.BOARD_RANGE - 1) {
            Object[] result = checkDest(board, selPiece, --curRow, --curCol);
            if (result[0] != null)
                poss.add((Position) result[0]);
            if (!result[1].equals(true))
                break;
        }
        return poss;
    }

    /**
     * Return a result if {@param piece} can move to Position({@param targetRow}, {@param targetCol}).
     *
     * @param board     the current board from Game class
     * @param selPiece  the selected piece that user wants to move it
     * @param targetRow row of Position to check if {@param piece} can move to
     * @param targetCol column of Position to check if {@param piece} can move to
     * @return Object[] of result:
     *         - [0]: Position if {@param piece} can move to. otherwise, null
     *         - [1]: boolean - true:continue checking, false:stop checking
     */
    private Object[] checkDest(Piece[][] board, Piece selPiece, int targetRow, int targetCol) {
        Object[] result = new Object[]{
                null, false
        };
        if (board[targetRow][targetCol] == null) {
            // no piece: can move and continue
            result[0] = new Position(targetRow, targetCol);
            result[1] = true;
        } else {
            if (board[targetRow][targetCol].isWhite() == selPiece.isWhite()) {
                // same color: cannot move and stop
            } else {
                // different color: can move and stop
                result[0] = new Position(targetRow, targetCol);
            }
        }
        return result;
    }

    @Override
    public void move(Position newPosition) {
        System.out.println("Moved Diagonally");
    }

    /**
     * 1. Use SuperClass validation to check if the newPosition is inside the board range.
     * 2. Check if the newPosition is valid for this piece.
     * --> Bishop: Only diagonally
     *
     * @param newPosition
     * @return
     */
    @Override
    public boolean isValidMove(Position newPosition) {
        if (!super.isValidMove(newPosition))
            return false;
        return (Math.abs(this.position.getRow() - newPosition.getRow())
                == Math.abs(this.position.getCol() - newPosition.getCol()));
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
