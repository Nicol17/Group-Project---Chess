import java.util.ArrayList;
import java.util.Objects;

public class Pawn extends Piece {
    ///////////////////////////////////////////////////
    protected static final int VALUE = 1;
    ///////////////////////////////////////////////////

    private boolean promoted;
    private Piece newPiece;

    public Pawn(boolean isWhite, Position position, boolean promoted, Piece newPiece) {
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
        int rowPos = selPiece.getPosition().getRow();
        int colPos = selPiece.getPosition().getCol();
        // in case of white piece
        if (selPiece.isWhite() == true) {
            if (rowPos == 1) {
                // first movement for Pawn
                // In first movement Pawn can be moved by maximum 2 steps forward straight
                for (int i = rowPos; i <= rowPos + 2; i++) {
                    // if destiny piece's color is same, stop in front of the piece
                    if ((board[rowPos + 1][colPos]) != null) {
                        break;
                    }
                    positions.add(new Position(rowPos + 1, colPos));
                }
                // take right top black piece
                if ((selPiece.isWhite()) != (board[rowPos + 1][colPos + 1].isWhite())) {
                    positions.add(new Position(rowPos + 1, colPos + 1));

                }
                // take left top black piece
                if ((selPiece.isWhite()) != (board[rowPos + 1][colPos - 1].isWhite())) {
                    positions.add(new Position(rowPos + 1, colPos - 1));
                }
            } else if (rowPos >= 2 && rowPos < 7) {
                // since second movement for Pawn
                // Since second movement Pawn can be moved by at most 1 step forward straight
                for (int i = rowPos; i <= rowPos + 1; i++) {
                    // if destiny piece's color is same, stop in front of the piece
                    if ((board[rowPos + 1][colPos]) != null) {
                        break;
                    }
                    positions.add(new Position(rowPos + 1, colPos));
                }
                // take right top black piece
                if ((selPiece.isWhite()) != (board[rowPos + 1][colPos + 1].isWhite())) {
                    positions.add(new Position(rowPos + 1, colPos + 1));
                }
                // take left top black piece
                if ((selPiece.isWhite()) != (board[rowPos + 1][colPos - 1].isWhite())) {
                    positions.add(new Position(rowPos + 1, colPos - 1));
                }
            }
            return positions;
            // in case of black piece
        } else {
            if (rowPos == 7) {
                // first movement for Pawn
                // In first movement Pawn can be moved by maximum 2 steps forward straight
                for (int i = rowPos; i >= rowPos - 2; i--) {
                    // if destiny piece's color is same, stop in front of the piece
                    if ((board[rowPos - 1][colPos]) != null) {
                        break;
                    }
                    positions.add(new Position(rowPos - 1, colPos));
                }
                // take right bottom black piece
                if ((selPiece.isWhite()) != (board[rowPos - 1][colPos + 1].isWhite())) {
                    positions.add(new Position(rowPos - 1, colPos + 1));
                }
                // take left bottom black piece
                if ((selPiece.isWhite()) != (board[rowPos - 1][colPos - 1].isWhite())) {
                    positions.add(new Position(rowPos - 1, colPos - 1));
                }
            } else if (rowPos >= 2 && rowPos < 7) {
                // since second movement for Pawn
                // Since second movement Pawn can be moved by at most 1 step forward straight
                for (int i = rowPos; i >= rowPos - 1; i--) {
                    // if destiny piece's color is same, stop in front of the piece
                    if ((board[rowPos - 1][colPos]) != null) {
                        break;
                    }
                    positions.add(new Position(rowPos - 1, colPos));
                }
                // take right bottom black piece
                if ((selPiece.isWhite()) != (board[rowPos - 1][colPos + 1].isWhite())) {
                    positions.add(new Position(rowPos - 1, colPos + 1));
                }
                // take left bottom black piece
                if ((selPiece.isWhite()) != (board[rowPos - 1][colPos - 1].isWhite())) {
                    positions.add(new Position(rowPos - 1, colPos - 1));
                }
            }
        }

        return positions;
    }

    @Override
    public void move(Position newPosition) {
        System.out.println("Forward 1");
    }

    @Override
    public boolean isValidMove(Position newPosition) {
        if (!super.isValidMove(position)) {
            return false;
        }
        if (this.position.getCol() == 2) {
            if (newPosition.getRow() == (this.position.getRow() + 1) ||
                    newPosition.getRow() == (this.position.getRow() + 2)) {
                return true;
            }
        } else if (newPosition.getRow() == (this.position.getRow() + 1)) {
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
