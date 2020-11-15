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
        ArrayList<Position> poss = new ArrayList<>();
        final int rowPos = selPiece.getPosition().getRow();
        final int colPos = selPiece.getPosition().getCol();
        int curRow;
        int curCol;
        // move white Rook
        if (selPiece.isWhite()) {
            // from rowPos to row index 0(line 0)
            curRow = rowPos;
            curCol = colPos;
            while (curRow >= 0) {
                if (curRow == rowPos) {
                    curRow--;
                    continue;
                }
                if (board[curRow][curCol] == null) {
                    poss.add(new Position(curRow, curCol));
                    curRow--;
                } else {
                    if (selPiece.isWhite() != board[curRow][curCol].isWhite()) {
                        poss.add(new Position(curRow, curCol));
                        break;
                    } else {
                        break;
                    }
                }
            }
            // from rowPos to BOARD_RANGE(index 7 or line 8)
            curRow = rowPos;
            curCol = colPos;
            while (curRow < Game.BOARD_RANGE) {
                if (curRow == rowPos) {
                    curRow++;
                    continue;
                }
                if (board[curRow][curCol] == null) {
                    poss.add(new Position(curRow, curCol));
                    curRow++;
                } else {
                    if (selPiece.isWhite() != board[curRow][curCol].isWhite()) {
                        poss.add(new Position(curRow, curCol));
                        break;
                    } else {
                        break;
                    }
                }
            }
            // if Rook can be moved horizontally (left to right)
            // from colPos to col index 0(line 0)
            curRow = rowPos;
            curCol = colPos;
            while (curCol >= 0) {
                if (curCol == colPos) {
                    curCol--;
                    continue;
                }
                if (board[curRow][curCol] == null) {
                    poss.add(new Position(curRow, curCol));
                    curCol--;
                } else {
                    if (selPiece.isWhite() != board[curRow][curCol].isWhite()) {
                        poss.add(new Position(curRow, curCol));
                        break;
                    } else {
                        break;
                    }
                }
            }
            // from colPos to BOARD_RANGE(index 7 or column h)
            curRow = rowPos;
            curCol = colPos;
            while (curCol < Game.BOARD_RANGE) {
                if (curCol == colPos) {
                    curCol++;
                    continue;
                }
                if (board[curRow][curCol] == null) {
                    poss.add(new Position(curRow, curCol));
                    curCol++;
                } else {
                    if (selPiece.isWhite() != board[curRow][curCol].isWhite()) {
                        poss.add(new Position(curRow, curCol));
                        break;
                    } else {
                        break;
                    }
                }
            }
            return poss;
        // move black Rook
        } else {
            // if Rook can be moved horizontally (left to right)
            // from rowPos to index 7(line 8)
            curRow = rowPos;
            curCol = colPos;
            while (curRow <= Game.BOARD_RANGE - 1) {
                if (curRow == rowPos) {
                    curRow++;
                    continue;
                }
                if (board[curRow][curCol] == null) {
                    poss.add(new Position(curRow, curCol));
                    curRow++;
                } else {
                    if (selPiece.isWhite() == board[curRow][curCol].isWhite()) {
                        break;
                    } else {
                        poss.add(new Position(curRow, curCol));
                        break;
                    }
                }
            }
            // from rowPos to index 0(line 0)
            curRow = rowPos;
            curCol = colPos;
            while (curRow >= 0) {
                if (curRow == rowPos) {
                    curRow--;
                    continue;
                }
                if (board[curRow][curCol] == null) {
                    poss.add(new Position(curRow, curCol));
                    curRow--;
                } else {
                    if (selPiece.isWhite() == board[curRow][curCol].isWhite()) {
                        break;
                    } else {
                        poss.add(new Position(curRow, curCol));
                        break;
                    }
                }
            }

            // if Rook can be moved vertically (bottom to top)
            // from colPos to index 0(column a)
            curRow = rowPos;
            curCol = colPos;
            while (curCol >= 0) {
                if (curCol == colPos) {
                    curCol--;
                    continue;
                }
                if (board[curRow][curCol] == null) {
                    poss.add(new Position(curRow, curCol));
                    curCol--;
                } else {
                    if (selPiece.isWhite() == board[curRow][curCol].isWhite()) {
                        break;
                    } else {
                        poss.add(new Position(curRow, curCol));
                        break;
                    }
                }
            }
            // from colPos to index 7(column h)
            curRow = rowPos;
            curCol = colPos;
            while (curCol <= Game.BOARD_RANGE - 1) {
                if (curCol == colPos) {
                    curCol++;
                    continue;
                }
                if (board[curRow][curCol] == null) {
                    poss.add(new Position(curRow, curCol));
                    curCol++;
                } else {
                    if (selPiece.isWhite() == board[curRow][curCol].isWhite()) {
                        break;
                    } else {
                        poss.add(new Position(curRow, curCol));
                        break;
                    }
                }
            }
            return poss;
        }
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
