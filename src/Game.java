import java.util.HashMap;

public class Game {
    ///////////////////////////////////////////////////
    private static final Integer BOARD_RANGE = 8;
    private static final char[] COL_NAME = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
    private static final HashMap<Integer, String> WHITE_PIECES = new HashMap<>(){{
        put(Bishop.VALUE, "♗");
        put(King.VALUE, "♔");
        put(Knight.VALUE, "♘");
        put(Pawn.VALUE, "♙");
        put(Queen.VALUE, "♕");
        put(Rook.VALUE, "♖");
    }};
    private static final HashMap<Integer, String> BLACK_PIECES = new HashMap<>(){{
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
        initializePieces();
        displayPieces();
    }

    private void initializePieces() {
        // white
        board[0][0] = new Rook(true, new Position(0, 0));
        board[0][1] = new Knight(true, new Position(0, 1));
        board[0][2] = new Bishop(true, new Position(0, 2));
        board[0][3] = new Queen(true, new Position(0, 3));
        board[0][4] = new King(true, new Position(0, 4));
        board[0][5] = new Bishop(true, new Position(0, 5));
        board[0][6] = new Knight(true, new Position(0, 6));
        board[0][7] = new Rook(true, new Position(0, 7));

        board[1][0] = new Pawn(true, new Position(0, 7), false, null);
        board[1][1] = new Pawn(true, new Position(0, 7), false, null);
        board[1][2] = new Pawn(true, new Position(0, 7), false, null);
        board[1][3] = new Pawn(true, new Position(0, 7), false, null);
        board[1][4] = new Pawn(true, new Position(0, 7), false, null);
        board[1][5] = new Pawn(true, new Position(0, 7), false, null);
        board[1][6] = new Pawn(true, new Position(0, 7), false, null);
        board[1][7] = new Pawn(true, new Position(0, 7), false, null);


        // black
        board[7][0] = new Rook(false, new Position(7, 0));
        board[7][1] = new Knight(false, new Position(7, 1));
        board[7][2] = new Bishop(false, new Position(7, 2));
        board[7][3] = new Queen(false, new Position(7, 3));
        board[7][4] = new King(false, new Position(7, 4));
        board[7][5] = new Bishop(false, new Position(7, 5));
        board[7][6] = new Knight(false, new Position(7, 6));
        board[7][7] = new Rook(false, new Position(7, 7));

        board[6][0] = new Pawn(false, new Position(0, 7), false, null);
        board[6][1] = new Pawn(false, new Position(0, 7), false, null);
        board[6][2] = new Pawn(false, new Position(0, 7), false, null);
        board[6][3] = new Pawn(false, new Position(0, 7), false, null);
        board[6][4] = new Pawn(false, new Position(0, 7), false, null);
        board[6][5] = new Pawn(false, new Position(0, 7), false, null);
        board[6][6] = new Pawn(false, new Position(0, 7), false, null);
        board[6][7] = new Pawn(false, new Position(0, 7), false, null);
    }

    private void displayPieces() {
        StringBuilder sb = new StringBuilder();
        for (int r = BOARD_RANGE-1; r >= 0; r--) {
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

}

