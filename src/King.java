import java.util.ArrayList;

public class King extends Piece {
    ///////////////////////////////////////////////////
    protected static final int VALUE = 1_000;

    ///////////////////////////////////////////////////
    public King(boolean isWhite, Position position) {
        super(VALUE, isWhite, position);
    }

    /**
     * Return a list of possible position for the piece user selected
     *
     * @param board    the current board from Game class
     * @param selPiece the selected piece that user wants to move it
     */
    @Override
    public ArrayList<Position> getPoss(Piece[][] board, Piece selPiece) {
        final int row = selPiece.getPosition().getRow();
        final int col = selPiece.getPosition().getCol();
        ArrayList<Position> poss = new ArrayList<>();
//        System.out.printf("(row,col): (%d,%d)%n", row, col);
//        System.out.printf("selected piece: %s%n", board[row][col]);
//        System.out.println("--- possibility ---");
//        right
        Position position = checkForKing(board, board[row][col], row, col + 1);
        if (position != null)
            poss.add(position);
//        left
        position = checkForKing(board, board[row][col], row, col - 1);
        if (position != null)
            poss.add(position);
//        up
        position = checkForKing(board, board[row][col], row + 1, col);
        if (position != null)
            poss.add(position);
//        down
        position = checkForKing(board, board[row][col], row - 1, col);
        if (position != null)
            poss.add(position);
//        right / up
        position = checkForKing(board, board[row][col], row + 1, col + 1);
        if (position != null)
            poss.add(position);
//        right / down
        position = checkForKing(board, board[row][col], row + 1, col - 1);
        if (position != null)
            poss.add(position);
//        left / up
        position = checkForKing(board, board[row][col], row - 1, col + 1);
        if (position != null)
            poss.add(position);
//        left / down
        position = checkForKing(board, board[row][col], row - 1, col - 1);
        if (position != null)
            poss.add(position);

        return poss;
    }

    /**
     * Return a position if king can move to Position
     *
     * @param board     the current board from Game class
     * @param king      king's position
     * @param targetRow row of Position to check if {@param piece} can move to
     * @param targetCol column of Position to check if {@param piece} can move to
     * @return
     */
    private static Position checkForKing(Piece[][] board, Piece king, int targetRow, int targetCol) {
        if (targetRow < 0 || targetRow >= Game.BOARD_RANGE
                || targetCol < 0 || targetCol >= Game.BOARD_RANGE)
            return null;

        if (board[targetRow][targetCol] == null) {
            return new Position(targetRow, targetCol);
        } else {
            if (board[targetRow][targetCol].isWhite() == king.isWhite()) {
                return null;
            } else {
                //can move
                return new Position(targetRow, targetCol);
            }
        }
    }

    /**
     *
     * @param board
     * @param currentKing
     * @param kingsColour
     * @return
     */
    protected static boolean isKingChecked(Piece[][] board, Position currentKing, boolean kingsColour) {
        ArrayList<Position> poss = new ArrayList<>();
        for (int r = Game.BOARD_RANGE - 1; r >= 0; r--) {
            for (int c = 0; c < Game.BOARD_RANGE; c++) {
//        no piece: skip
                if (board[r][c] == null) {
                    continue;
                }
                if (board[r][c].isWhite() != kingsColour) {
//          different color -> getPoss
                    ArrayList<Position> enemyPoss = board[r][c].getPoss(board, board[r][c]);
//        System.out.println("poss: \n" + Arrays.toString(poss.toArray()));
                    // no possible positions
                    if (enemyPoss == null || enemyPoss.size() == 0) {
                        continue;
                    }
                    if (enemyPoss.contains(currentKing)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void move(Position newPosition) {
        System.out.println("One square");
    }

    @Override
    public boolean isValidMove(Position newPosition) {
        if (!super.isValidMove(position)) {
            return false;
        }
        if (newPosition.getCol() == (this.position.getCol() + 1) && (newPosition.getRow()
                == this.position.getRow()) ||
                newPosition.getCol() == (this.position.getCol() - 1) && (newPosition.getRow()
                        == this.position.getRow()) ||
                newPosition.getCol() == (this.position.getCol()) && newPosition.getRow() == (
                        this.position.getRow() + 1) ||
                newPosition.getCol() == (this.position.getCol()) && newPosition.getRow() == (
                        this.position.getRow() - 1) ||
                newPosition.getCol() == (this.position.getCol() + 1) && newPosition.getRow() == (
                        this.position.getRow() + 1) ||
                newPosition.getCol() == (this.position.getCol() - 1) && newPosition.getRow() == (
                        this.position.getRow() + 1) ||
                newPosition.getCol() == (this.position.getCol() + 1) && newPosition.getRow() == (
                        this.position.getRow() - 1) ||
                newPosition.getCol() == (this.position.getCol() - 1) && newPosition.getRow() == (
                        this.position.getRow() - 1)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        String color = (isWhite()) ? "White" : "Black";
        return "King{" +
                "value=" + getValue() +
                ", color=" + color +
                ", position=(" + getPosition().getRow() + ", " + getPosition().getCol() + ')' +
                '}';
    }
}