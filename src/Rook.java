import java.util.ArrayList;

public class Rook extends Piece {
    ///////////////////////////////////////////////////
    protected static final int VALUE = 5;
    ///////////////////////////////////////////////////

    public Rook(boolean isWhite, Position position) {
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
        ArrayList<Position> positions = new ArrayList<>();

        int row = selPiece.getPosition().getRow();
        int col = selPiece.getPosition().getCol();

        // if Rook can be moved horizontally (left to right)
        for (int i = col; i < Game.BOARD_RANGE; i++) {
            // if destiny piece's color is same, stop in front of the piece
            if (selPiece.isWhite() == board[row][col + 1].isWhite()) {
                break;
            }
            if (selPiece.isWhite() != board[row][col + 1].isWhite()) {
                selPiece.setPosition(new Position(row, col + 1));
                break;
            }
            positions.add(new Position(row, col + 1));
        }
        // if Rook can be moved horizontally (right to left)
        for (int i = col; i > 0; i--) {
            // if destiny piece's color is same, stop in front of the piece
            if (selPiece.isWhite() == board[row][col - 1].isWhite()) {
                break;
            }
            if (selPiece.isWhite() != board[row][col - 1].isWhite()) {
                positions.add(new Position(row, col - 1));
                break;
            }
            positions.add(new Position(row, col - 1));
        }
        // if Rook can be moved vertically (bottom to top)
        for (int i = row; i < Game.BOARD_RANGE; i++) {
            // if destiny piece's color is same, stop in front of the piece
            if (selPiece.isWhite() == board[row + 1][col].isWhite()) {
                break;
            }
            if (selPiece.isWhite() != board[row + 1][col].isWhite()) {
                positions.add(new Position(row + 1, col));
                break;
            }
            positions.add(new Position(row + 1, col));
        }
        // if Rook can be moved vertically (top to bottom)
        for (int i = row; i > 0; i--) {
            // if destiny piece's color is same, stop in front of the piece
            if (selPiece.isWhite() != board[row - 1][col].isWhite()) {
                break;
            }
            if (selPiece.isWhite() != board[row - 1][col].isWhite()) {
                positions.add(new Position(row - 1, col));
                break;
            }
            positions.add(new Position(row - 1, col));
        }
        return positions;
    }

    @Override
    public void move(Position newPosition) {
        System.out.println("Horizontally or vertically");
    }

    @Override
    public boolean isValidMove(Position newPosition) {
        if (!super.isValidMove(newPosition)) {
            return false;
        }
        if (newPosition.getCol() == (this.position.getCol()) ||
                (newPosition.getRow() == this.position.getRow())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        String color = (isWhite()) ? "White" : "Black";
        return "Rook{" +
                "value=" + getValue() +
                ", color=" + color +
                ", position=(" + getPosition().getRow() + ", " + getPosition().getCol() + ')' +
                '}';
    }
}
