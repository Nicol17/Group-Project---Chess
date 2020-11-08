import java.util.HashMap;

public class Game {
    ///////////////////////////////////////////////////
    private static final Integer BOARD_RANGE = 8;
    private static final char[] COL_NAME = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
    private static final HashMap<Integer, String> WHITE_PIECES = new HashMap<>() {{
        put(Bishop.VALUE, "♗");
        put(King.VALUE, "♔");
        put(Knight.VALUE, "♘");
        put(Pawn.VALUE, "♙");
        put(Queen.VALUE, "♕");
        put(Rook.VALUE, "♖");
    }};
    private static final HashMap<Integer, String> BLACK_PIECES = new HashMap<>() {{
        put(Bishop.VALUE, "♝");
        put(King.VALUE, "♚");
        put(Knight.VALUE, "♞");
        put(Pawn.VALUE, "♟");
        put(Queen.VALUE, "♛");
        put(Rook.VALUE, "♜");
    }};
    ///////////////////////////////////////////////////
    private Piece[][] board;

    public Game() {
        this.board = new Piece[BOARD_RANGE][BOARD_RANGE];
    }

    /**
     * Start game
     */
    public void run() {
        initBoard();
        displayBoard();

////        while (true) {
//        if (!testYurie())
//            System.out.println("fail to move");
////        }

    }

    private void initBoard() {
        // white
        board[0][0] = new Rook(true, new Position(0, 0));
        board[0][1] = new Knight(true, new Position(0, 1));
        board[0][2] = new Bishop(true, new Position(0, 2));
        board[0][3] = new Queen(true, new Position(0, 3));
        board[0][4] = new King(true, new Position(0, 4));
        board[0][5] = new Bishop(true, new Position(0, 5));
        board[0][6] = new Knight(true, new Position(0, 6));
        board[0][7] = new Rook(true, new Position(0, 7));

        board[1][0] = new Pawn(true, new Position(1, 0), false, null);
        board[1][1] = new Pawn(true, new Position(1, 1), false, null);
        board[1][2] = new Pawn(true, new Position(1, 2), false, null);
        board[1][3] = new Pawn(true, new Position(1, 3), false, null);
        board[1][4] = new Pawn(true, new Position(1, 4), false, null);
        board[1][5] = new Pawn(true, new Position(1, 5), false, null);
        board[1][6] = new Pawn(true, new Position(1, 6), false, null);
        board[1][7] = new Pawn(true, new Position(1, 7), false, null);


        // black
        board[7][0] = new Rook(false, new Position(7, 0));
        board[7][1] = new Knight(false, new Position(7, 1));
        board[7][2] = new Bishop(false, new Position(7, 2));
        board[7][3] = new Queen(false, new Position(7, 3));
        board[7][4] = new King(false, new Position(7, 4));
        board[7][5] = new Bishop(false, new Position(7, 5));
        board[7][6] = new Knight(false, new Position(7, 6));
        board[7][7] = new Rook(false, new Position(7, 7));

        board[6][0] = new Pawn(false, new Position(6, 0), false, null);
        board[6][1] = new Pawn(false, new Position(6, 1), false, null);
        board[6][2] = new Pawn(false, new Position(6, 2), false, null);
        board[6][3] = new Pawn(false, new Position(6, 3), false, null);
        board[6][4] = new Pawn(false, new Position(6, 4), false, null);
        board[6][5] = new Pawn(false, new Position(6, 5), false, null);
        board[6][6] = new Pawn(false, new Position(6, 6), false, null);
        board[6][7] = new Pawn(false, new Position(6, 7), false, null);
    }

    private void displayBoard() {
        StringBuilder sb = new StringBuilder();
        for (int r = BOARD_RANGE - 1; r >= 0; r--) {
            for (int c = 0; c < BOARD_RANGE; c++) {
                if (board[r][c] == null) {
                    sb.append("- ");
                    continue;
                }
                int value = board[r][c].getValue();
                if (board[r][c].isWhite()) {
                    sb.append(WHITE_PIECES.get(value)).append(" ");
                } else {
                    sb.append(BLACK_PIECES.get(value)).append(" ");
                }
            }
            sb.append(" ").append(r + 1).append("\n");
        }
        sb.append("\n");
        for (char c : COL_NAME) {
            sb.append(c).append(" ");
        }
        System.out.println(sb.toString());
    }

//    private boolean testYurie() {
//        displayPossibility();
//        return true;
//    }
//
//    private void displayPossibility() {
//        // for White Bishop: board[0][2] = c1
////        String input = "c1";
//        String input = "b2";
//        int row = Integer.parseInt(String.valueOf(input.charAt(1))) - 1;
//        int col = getColNum(input.charAt(0));
//        System.out.printf("(row, col): (%d , %d)%n", row, col);
//        System.out.printf("selected piece: %s%n", board[row][col]);
//        diagonalLtR(board[row][col]);
//    }
//
//    private void diagonalLtR(Piece piece) {
//        ArrayList<Position> psb = new ArrayList<>();
//
//        // default position for white Bishop
//        int curRow = piece.getPosition().getRow();
//        int curCol = piece.getPosition().getCol();
//        System.out.printf("selected (row, col): (%d , %d)%n", curRow, curCol);
//
//        // diagonally left to right
//        System.out.println("--- possibility ---");
//        while (curRow < BOARD_RANGE - 1 && curCol < BOARD_RANGE - 1) {
//            if (board[curRow + 1][curCol + 1] == null) {
//                // there is no piece --> can move and continue
//                psb.add(new Position(curRow++, curCol++));
//                System.out.printf("(row, col): (%d , %d)%n", curRow, curCol);
//            } else {
//                if (board[curRow + 1][curCol + 1].isWhite() == piece.isWhite()) {
//                    // there is same color --> stop
//                }else{
//                    // there is different color --> can move and stop
//                    psb.add(new Position(curRow++, curCol++));
//                    System.out.printf("(row, col): (%d , %d)%n", curRow, curCol);
//                }
//                break;
//            }
//        }
//    }



    private int getColNum(char c) {
        for (int i = 0; i < COL_NAME.length; i++) {
            if (COL_NAME[i] == c) {
                return i;
            }
        }
        return -1;
    }
}

