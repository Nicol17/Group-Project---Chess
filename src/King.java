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
     * @return
     */
    @Override
    public ArrayList<Position> getPoss(Piece[][] board, Piece selPiece) {
        final int row = selPiece.getPosition().getRow();
        final int col = selPiece.getPosition().getCol();
        int curRow;
        int curCol;
        ArrayList<Position> psb = new ArrayList<>();

        System.out.printf("(row,col): (%d,%d)%n", row, col);
        System.out.printf("selected piece: %s%n", board[row][col]);
        System.out.println("--- possibility ---");

        Position position = checkForKing(board, board[row][col], row, col + 1);
        if (position != null)
            psb.add(position);
        position = checkForKing(board, board[row][col], row, col - 1);
        if (position != null) {
            psb.add(position);
        }
        position = checkForKing(board, board[row][col], row + 1, col);
        if (position != null) {
            psb.add(position);
        }
        position = checkForKing(board, board[row][col], row - 1, col);
        if (position != null) {
            psb.add(position);
        }
        position = checkForKing(board, board[row][col], row + 1, col + 1);
        if (position != null) {
            psb.add(position);
        }
        position = checkForKing(board, board[row][col], row + 1, col - 1);
        if (position != null) {
            psb.add(position);
        }
        position = checkForKing(board, board[row][col], row - 1, col + 1);
        if (position != null) {
            psb.add(position);
        }
        position = checkForKing(board, board[row][col], row - 1, col - 1);
        if (position != null) {
            psb.add(position);
        }
        return psb;
    }

    private Position checkForKing(Piece[][] board, Piece king, int targetRow, int targetCol) {
        if (board[targetRow][targetCol] == null) {
//            psb.add(new Position(targetRow, targetCol));
            System.out.printf("(row,col): (%d,%d)%n", targetRow, targetCol);
            return new Position(targetRow, targetCol);
        } else {
            if (board[targetRow][targetCol].isWhite() == king.isWhite()) {
                return null;
            } else {
                //can move
//                psb.add(new Position(targetRow, targetCol));
                System.out.printf("(row,col): (%d,%d)%n", targetRow, targetCol);
                System.out.println("different color");
                return new Position(targetRow, targetCol);
            }
        }
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
        if (newPosition.getCol() == (this.position.getCol() + 1) && (newPosition.getRow() == this.position.getRow()) ||
                newPosition.getCol() == (this.position.getCol() - 1) && (newPosition.getRow() == this.position.getRow()) ||
                newPosition.getCol() == (this.position.getCol()) && newPosition.getRow() == (this.position.getRow() + 1) ||
                newPosition.getCol() == (this.position.getCol()) && newPosition.getRow() == (this.position.getRow() - 1) ||
                newPosition.getCol() == (this.position.getCol() + 1) && newPosition.getRow() == (this.position.getRow() + 1) ||
                newPosition.getCol() == (this.position.getCol() - 1) && newPosition.getRow() == (this.position.getRow() + 1) ||
                newPosition.getCol() == (this.position.getCol() + 1) && newPosition.getRow() == (this.position.getRow() - 1) ||
                newPosition.getCol() == (this.position.getCol() - 1) && newPosition.getRow() == (this.position.getRow() - 1)) {
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
