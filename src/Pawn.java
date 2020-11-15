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
        ArrayList<Position> poss = new ArrayList<>();
        int rowPos = selPiece.getPosition().getRow();
        int colPos = selPiece.getPosition().getCol();
//        System.out.println("-- Pawn is called --");
//        System.out.printf("selected (row, col): (%d, %d)%n", row, col);
        // in case of white piece
        if (selPiece.isWhite() == true) {
            if (!isPromoted()) {
                int firstWhiteRowPos = 1;
                int firstWhiteMaxRowPos = 3;
                // first movement for Pawn
                // In first movement Pawn can be moved by maximum 2 steps forward straight
                while (firstWhiteRowPos < firstWhiteMaxRowPos) {
                    if (firstWhiteRowPos == 1) {
                        if (colPos == 0) {
                            if ((board[rowPos + 1][colPos + 1] != null) && ((selPiece.isWhite()) != (board[rowPos + 1][colPos + 1].isWhite()))) {
                                poss.add(new Position(rowPos + 1, colPos + 1));
                            }
                        }else if (colPos == 7) {
                            if ((board[rowPos + 1][colPos - 1] != null) && ((selPiece.isWhite()) != (board[rowPos + 1][colPos - 1].isWhite()))) {
                                poss.add(new Position(rowPos + 1, colPos - 1));
                            }
                        } else {
                            // take right top black piece
                            if ((board[rowPos + 1][colPos + 1] != null) && ((selPiece.isWhite()) != (board[rowPos + 1][colPos + 1].isWhite()))) {
                                poss.add(new Position(rowPos + 1, colPos + 1));
                            }
                            // take left top black piece
                            if ((board[rowPos + 1][colPos - 1] != null) && ((selPiece.isWhite()) != (board[rowPos + 1][colPos - 1].isWhite()))) {
                                poss.add(new Position(rowPos + 1, colPos - 1));
                            }
                        }
                    }
                    // if destiny piece's color is same, stop in front of the piece
                    if ((board[rowPos + 1][colPos]) != null) {
                        break;
                    }
                    poss.add(new Position(rowPos + 1, colPos));
                    rowPos++;
                    firstWhiteRowPos++;

                    if (firstWhiteRowPos == firstWhiteMaxRowPos) {
                        break;
                    }
                }
                this.promoted = true;
                firstWhiteRowPos = 1;
                firstWhiteMaxRowPos = 3;
                return poss;
            } else {
                int startCountWhite = 0;
                int endCountWhite = 1;
                // since second movement for Pawn
                // Since second movement Pawn can be moved by at most 1 step forward straight
                while(startCountWhite < endCountWhite) {
                    if (startCountWhite == 0) {
                        if (colPos == 0) {
                            if (((board[rowPos + 1][colPos + 1]) != null) && ((selPiece.isWhite()) != (board[rowPos + 1][colPos + 1].isWhite()))) {
                                poss.add(new Position(rowPos + 1, colPos + 1));
                            }
                        } else if (colPos == 7) {
                            if (((board[rowPos + 1][colPos - 1]) != null) && ((selPiece.isWhite()) != (board[rowPos + 1][colPos - 1].isWhite()))) {
                                poss.add(new Position(rowPos + 1, colPos - 1));
                            }
                        } else {
                            // take right top black piece
                            if (((board[rowPos + 1][colPos + 1]) != null) && ((selPiece.isWhite()) != (board[rowPos + 1][colPos + 1].isWhite()))) {
                                poss.add(new Position(rowPos + 1, colPos + 1));
                            }
                            // take left top black piece
                            if (((board[rowPos + 1][colPos - 1]) != null) && ((selPiece.isWhite()) != (board[rowPos + 1][colPos - 1].isWhite()))) {
                                poss.add(new Position(rowPos + 1, colPos - 1));
                            }
                        }
                    }
                    // if destiny piece's color is same, stop in front of the piece
                    if ((board[rowPos + 1][colPos]) != null) {
                        break;
                    }
                    poss.add(new Position(rowPos + 1, colPos));
                    rowPos++;
                    startCountWhite++;

                    if (startCountWhite == endCountWhite) {
                        break;
                    }
                }
                return poss;
            }
            // in case of black piece
        } else {
            if (!isPromoted()) {
                int firstBlackRowPos = 7;
                int firstBlackMaxRowPos = 5;
                // first movement for Pawn
                // In first movement Pawn can be moved by maximum 2 steps forward straight
                while (firstBlackRowPos > firstBlackMaxRowPos) {
                    if (firstBlackRowPos == 7) {
                        if (colPos == 0) {
                            if ((board[rowPos - 1][colPos + 1] != null) && ((selPiece.isWhite()) != (board[rowPos - 1][colPos + 1].isWhite()))) {
                                poss.add(new Position(rowPos - 1, colPos + 1));
                            }
                        } else if (colPos == 7) {
                            if ((board[rowPos - 1][colPos - 1] != null) && ((selPiece.isWhite()) != (board[rowPos - 1][colPos - 1].isWhite()))) {
                                poss.add(new Position(rowPos - 1, colPos - 1));
                            }
                        } else {
                            // take right bottom black piece
                            if ((board[rowPos - 1][colPos + 1] != null) && ((selPiece.isWhite()) != (board[rowPos - 1][colPos + 1].isWhite()))) {
                                poss.add(new Position(rowPos - 1, colPos + 1));
                            }
                            // take left bottom black piece
                            if ((board[rowPos - 1][colPos - 1] != null) && ((selPiece.isWhite()) != (board[rowPos - 1][colPos - 1].isWhite()))) {
                                poss.add(new Position(rowPos - 1, colPos - 1));
                            }
                        }
                    }
                    // if destiny piece's color is same, stop in front of the piece
                    if ((board[rowPos - 1][colPos]) != null) {
                        break;
                    }
                    poss.add(new Position(rowPos - 1, colPos));
                    rowPos--;
                    firstBlackRowPos--;
                    if (firstBlackRowPos == firstBlackMaxRowPos) {
                        break;
                    }
                }
                this.promoted = true;
                firstBlackRowPos = 7;
                firstBlackMaxRowPos = 5;
                return poss;
            } else {
                int startCountBlack = 0;
                int endCountBlack = 1;
                // since second movement for Pawn
                // Since second movement Pawn can be moved by at most 1 step forward straight
                while (startCountBlack < endCountBlack) {
                    if (startCountBlack == 0) {
                        if (colPos == 0) {
                            // take right bottom black piece
                            if ((board[rowPos - 1][colPos + 1] != null) && ((selPiece.isWhite()) != (board[rowPos - 1][colPos + 1].isWhite()))) {
                                poss.add(new Position(rowPos - 1, colPos + 1));
                            }
                        } else if (colPos == 7) {
                            // take right bottom black piece
                            if ((board[rowPos - 1][colPos - 1] != null) && ((selPiece.isWhite()) != (board[rowPos - 1][colPos - 1].isWhite()))) {
                                poss.add(new Position(rowPos - 1, colPos - 1));
                            }
                        } else {
                            // take right bottom black piece
                            if ((board[rowPos - 1][colPos + 1] != null) && ((selPiece.isWhite()) != (board[rowPos - 1][colPos + 1].isWhite()))) {
                                poss.add(new Position(rowPos - 1, colPos + 1));
                            }
                            // take left bottom black piece
                            if ((board[rowPos - 1][colPos + 1] != null) && ((selPiece.isWhite()) != (board[rowPos - 1][colPos - 1].isWhite()))) {
                                poss.add(new Position(rowPos - 1, colPos - 1));
                            }
                        }
                    }
                    // if destiny piece's color is same, stop in front of the piece
                    if ((board[rowPos - 1][colPos]) != null) {
                        break;
                    }
                    poss.add(new Position(rowPos - 1, colPos));
                    rowPos--;
                    startCountBlack++;
                    if (startCountBlack == endCountBlack) {
                        break;
                    }
                }
                return poss;
            }
        }
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
        if (isWhite()) {
            if (this.position.getRow() == 2) {
                if (newPosition.getRow() == (this.position.getRow() + 1) ||
                        newPosition.getRow() == (this.position.getRow() + 2)) {
                    return true;
                }
            } else if (newPosition.getRow() == (this.position.getRow() + 1)) {
                return true;
            }
            return false;
            // Blacks
        } else {
            if (this.position.getRow() == 7) {
                if (newPosition.getRow() == (this.position.getRow() - 1) ||
                        newPosition.getRow() == (this.position.getRow() - 2)) {
                    return true;
                }
            } else if (newPosition.getRow() == (this.position.getRow() - 1)) {
                return true;
            }
            return false;
        }
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
