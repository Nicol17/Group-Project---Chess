import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Game {
    ///////////////////////////////////////////////////
    protected static final Integer BOARD_RANGE = 8;
    private static final char[] COL_NAME = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
    private static final HashMap<Integer, String> WHITE_PIECES = new HashMap<Integer, String>() {{
        put(Bishop.VALUE, "♗");
        put(King.VALUE, "♔");
        put(Knight.VALUE, "♘");
        put(Pawn.VALUE, "♙");
        put(Queen.VALUE, "♕");
        put(Rook.VALUE, "♖");
    }};
    private static final HashMap<Integer, String> BLACK_PIECES = new HashMap<Integer, String>() {{
        put(Bishop.VALUE, "♝");
        put(King.VALUE, "♚");
        put(Knight.VALUE, "♞");
        put(Pawn.VALUE, "♟");
        put(Queen.VALUE, "♛");
        put(Rook.VALUE, "♜");
    }};
    private static final Pattern PATTERN_SINGLE_POSITION = Pattern.compile("[a-hA-H][1-8]", Pattern.CASE_INSENSITIVE);
    private static final Pattern PATTERN_DOUBLE_POSITION = Pattern.compile("[a-hA-H][1-8][a-hA-H][1-8]", Pattern.CASE_INSENSITIVE);
    private static final String HELP_OPTION = "help";
    private static final String BOARD_OPTION = "board";
    private static final String RESIGN_OPTION = "resign";
    private static final String MOVES_OPTION = "moves";
    private static final String QUIT_OPTION = "quit";

    ///////////////////////////////////////////////////
    private Piece[][] board;
    private boolean isWhiteTurn;        // true: white, false: black
    private boolean isContinueTurn;     // true: will not switch turn
    private King whiteKing;
    private King blackKing;


    public Game() {
        this.board = new Piece[BOARD_RANGE][BOARD_RANGE];
        this.isWhiteTurn = true;        // Start from White
        this.isContinueTurn = false;    // default: switch in each execution
        whiteKing = null;
        blackKing = null;
    }

    public boolean isWhiteTurn() {
        return isWhiteTurn;
    }

    public void setWhiteTurn(boolean whiteTurn) {
        isWhiteTurn = whiteTurn;
    }

    private void switchTurn() {
        isWhiteTurn = !isWhiteTurn;
    }

    public boolean isContinueTurn() {
        return isContinueTurn;
    }

    public void setContinueTurn(boolean continueTurn) {
        isContinueTurn = continueTurn;
    }

    /**
     * Start game
     */
    public void run() {
        // initialize board
        initBoard();
        displayBoard();

        // start game from white
        Scanner input = new Scanner(System.in);

        while (true) {
            whoseTurn();
            System.out.println("Enter UCI (Type 'help' for help): ");
            String userInput = input.nextLine();
            // trim(): remove spaces (e.g. " a5 " will be "a5")
            userInput = userInput.trim();

            if (!menuOptions(userInput))
                break;

            // switch player
            if (!isContinueTurn)
                switchTurn();

            // check if game is over
            if (isGameOver()) {
                displayResult();
                break;
            }
        }
    }

    /**
     * Initialize board
     */
    private void initBoard() {
        whiteKing = new King(true, new Position(0, 4));
        blackKing = new King(false, new Position(7, 4));
        // white
        board[0][0] = new Rook(true, new Position(0, 0));
        board[0][1] = new Knight(true, new Position(0, 1));
        board[0][2] = new Bishop(true, new Position(0, 2));
        board[0][3] = new Queen(true, new Position(0, 3));
        board[0][4] = whiteKing;
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
        board[7][4] = blackKing;
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

    /**
     * Display whose turn to move
     */
    public void whoseTurn() {
        if (isWhiteTurn) {
            System.out.println("\nWhite to Move");
        } else {
            System.out.println("\nBlack to Move");
        }
    }

    /**
     * Display menu
     *
     * @param userInput
     * @return boolean - true: continue game, false: quit game
     */
    private boolean menuOptions(String userInput) {
        switch (userInput.toLowerCase()) {
            case HELP_OPTION: // display all options
                displayHelp();
                setContinueTurn(true);
                break;
            case BOARD_OPTION: // display the board
                displayBoard();
                setContinueTurn(true);
                break;
            case RESIGN_OPTION: // Player resigns
                if (isWhiteTurn) {
                    System.out.println("Game Over Black won by resignation");
                } else {
                    System.out.println("Game Over Whites won by resignation");
                }
                return false;
            case MOVES_OPTION: // list all possible moves
                //displayPossibilities();
                displayMoves();
                setContinueTurn(true);
                break;
            case QUIT_OPTION:   // quit game
                System.out.println("Bye!");
                return false;
            default:
//                System.out.println("Enter UCI (Type 'help' for help): ");
                if (isValidInput(userInput)) {
                    //select square / select piece --> display possible moves --> displayPossibilities();
                    // select piece and desired move --> setPosition()
//                    System.out.println("will be implemented....");
                    toSelect(userInput);
                } else {
                    System.out.println("Invalid Input, please try again");
                    setContinueTurn(true);
                }
                break;
            // case square:
            // when user inputs a square (e.g. b1), list all possible moves for that square.
            // case UCI (should already be integrated when we validate user input)
        }
        return true;
    }

    /**
     * Display help for user
     */
    public void displayHelp() {
        System.out.println("type 'help' for help");
        System.out.println("type 'board' to see the board again");
        System.out.println("type 'resign' to resign");
        System.out.println("type 'moves' to list all possible moves");
        System.out.println("type 'quit' to stop this app");
        System.out.println("type a square (e.g. a2, b1...) to list all possible moves for that square");
        System.out.println("type UCI (e.g.a2a4, b1c3) to make a move");
    }

    public void displayMoves() {
        for (int r = BOARD_RANGE - 1; r >= 0; r--) {
            for (int c = 0; c < BOARD_RANGE; c++) {
                // empty place: skip
                if (board[r][c] == null) {
                    continue;
                }

                int value = board[r][c].getValue();
                if (board[r][c].isWhite() == isWhiteTurn()) {
                    ArrayList<Position> poss = board[r][c].getPoss(board, board[r][c]);
                    switch (value) {
                        case (Pawn.VALUE):
                            if (!displayPoss(poss)) {
                                System.out.println("Pawn has no available moves");
                                continue;
                            } else {
                                System.out.println("Pawn available moves: " + displayPoss(poss));
                                break;
                            }
                        case (Rook.VALUE):
                            if (!displayPoss(poss)) {
                                System.out.println("Rook has no available moves");
                                continue;
                            } else {
                                System.out.println("Rook available moves: " + displayPoss(poss));
                                break;
                            }
                        case (Knight.VALUE):
                            if (!displayPoss(poss)) {
                                System.out.println("Knight has no available moves");
                                continue;
                            } else {
                                System.out.println("Knight available moves: " + displayPoss(poss));
                                break;
                            }
                        case (Bishop.VALUE):
                            if (!displayPoss(poss)) {
                                System.out.println("Bishop has no available moves");
                                continue;
                            } else {
                                System.out.println("Bishop available moves: " + displayPoss(poss));
                                break;
                            }
                        case (Queen.VALUE):
                            if (!displayPoss(poss)) {
                                System.out.println("Queen has no available moves");
                                continue;
                            } else {
                                System.out.println("Queen available moves: " + displayPoss(poss));
                                break;
                            }
                        case (King.VALUE):
                            if (!displayPoss(poss)) {
                                System.out.println("King has no available moves");
                                continue;
                            } else {
                                System.out.println("King available moves: " + displayPoss(poss));
                                break;
                            }
                    }
                }
            }
        }
    }

    /**
     * Display the current board
     */
    private void displayBoard() {
        StringBuilder sb = new StringBuilder();
        for (int r = BOARD_RANGE - 1; r >= 0; r--) {
            for (int c = 0; c < BOARD_RANGE; c++) {
                // empty place: show a dash
                if (board[r][c] == null) {
                    sb.append("- ");
                    continue;
                }

                // append an icon of each peach depends on color
                // - no corresponding icon: append a dash
                int value = board[r][c].getValue();
                if (board[r][c].isWhite()) {
                    if (WHITE_PIECES.containsKey(value))
                        sb.append(WHITE_PIECES.get(value)).append(" ");
                    else
                        sb.append("- ");
                } else {
                    if (BLACK_PIECES.containsKey(value))
                        sb.append(BLACK_PIECES.get(value)).append(" ");
                    else
                        sb.append("- ");
                }
            }
            // add row number
            sb.append(" ").append(r + 1).append("\n");
        }
        // add column name
        sb.append("\n");
        for (char c : COL_NAME) {
            sb.append(c).append(" ");
        }
        System.out.println(sb.toString());
    }

    /**
     * Validate user input
     *
     * @param userInput
     * @return
     */
    public boolean isValidInput(String userInput) {
        if (PATTERN_SINGLE_POSITION.matcher(userInput).matches()) {
            return true;
        } else if (PATTERN_DOUBLE_POSITION.matcher(userInput).matches()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * According to the user input, display possible moves and/or move a piece
     * - if input contains one position:
     * display possible position and call a next method to get the destiny
     * <p>
     * - if input contains two positions:
     * if selected piece can move to the destiny, move
     * if cannot move, call a next method to get the destiny
     * <p>
     * If the selected piece has no possible moves, continue the same player.
     *
     * @param userInput
     * @return
     */
    private boolean toSelect(String userInput) {
        String selPos = getFistPos(userInput);
        int selRow = getRowNum(selPos);
        int selCol = getColNum(selPos);
        String destPos = getSecondPos(userInput);
//        System.out.printf("selected: '%s' (%d, %d), %s%n", selPos, selRow, selCol, board[selRow][selCol]);

        if (!isValidSelect(selRow, selCol))
            return false;

        // get possible positions for selected piece
        ArrayList<Position> poss = board[selRow][selCol].getPoss(board, board[selRow][selCol]);
//        System.out.println("poss: \n" + Arrays.toString(poss.toArray()));
        // no possible positions
        if (poss.size() == 0) {
            System.out.println("No positions where this piece can move.");
            // continue this player
            setContinueTurn(true);
            return false;
        }

        // stop to continue this player once get a valid piece
        setContinueTurn(false);

        // single position: get user input for the destiny
        if (destPos.length() == 0)
            return toDestiny(selPos, poss);

        // double position: check if the selected piece can move to the destiny position
        int destRow = getRowNum(destPos);
        int destCol = getColNum(destPos);
//        System.out.printf("destiny : '%s' (%d, %d)%n", destPos, destRow, destCol);
        Position p = new Position(destRow, destCol);
        if (poss.contains(p)) {
            // move position
            movePiece(selRow, selCol, destRow, destCol);
            return true;
        }

        // invalid destiny: get user input for the destiny
        return toDestiny(selPos, poss);
    }

    /**
     * Validate the selected piece
     *
     * @param selRow
     * @param selCol
     * @return
     */
    private boolean isValidSelect(int selRow, int selCol) {
        // empty place
        if (board[selRow][selCol] == null) {
            System.out.println("No piece is there, please try again.");
            // continue this player
            setContinueTurn(true);
            return false;
        }

        // different color
        if (board[selRow][selCol].isWhite() != isWhiteTurn) {
            System.out.println("Different color was selected, please try again.");
            // continue this player
            setContinueTurn(true);
            return false;
        }
        return true;
    }

    /**
     * Iterate until get the destiny position and move piece
     *
     * @param selPos a position of the piece that user wants to move
     * @param poss   possible positions for {@param selPos}
     * @return
     */
    private boolean toDestiny(String selPos, ArrayList<Position> poss) {
        int selRow = getRowNum(selPos);
        int selCol = getColNum(selPos);
        Scanner in = new Scanner(System.in);
        while (true) {
            // get user input
            displayPoss(selPos, poss);
            System.out.println("Enter a destiny position: ");
            String input = in.nextLine();
            input = input.trim();
            if (!PATTERN_SINGLE_POSITION.matcher(input).matches()) {
                // input must be a single position
                System.out.println("Invalid Input, please try again");
                continue;
            }

            // check if the destiny position is in the possible list
            int destRow = getRowNum(input);
            int destCol = getColNum(input);
            Position p = new Position(destRow, destCol);
            if (poss.contains(p)) {
                // move position
                movePiece(selRow, selCol, destRow, destCol);
                break;
            }
        }
        return true;
    }

    /**
     * Move a piece from the selected position to the destiny.
     *
     * @param selRow
     * @param selCol
     * @param destRow
     * @param destCol
     */
    private void movePiece(int selRow, int selCol, int destRow, int destCol) {
        if (board[selRow][selCol].getValue() == King.VALUE) {
            if (board[selRow][selCol].isWhite()) {
                whiteKing.setPosition(new Position(destRow, destCol));
            } else {
                blackKing.setPosition(new Position(destRow, destCol));
            }
        }
        board[selRow][selCol].setPosition(new Position(destRow, destCol));
        board[destRow][destCol] = board[selRow][selCol];
        board[selRow][selCol] = null;
        displayBoard();
    }

    /**
     * Return a position name extracting from user input.
     * This value is treated as a selected piece position that user wants to move.
     * e.g. if input = 'd4', return as it is 'd4'
     * e.g. if input = 'd4g8', return 'd4'
     *
     * @param userInput
     * @return
     */
    private String getFistPos(String userInput) {
        if (PATTERN_SINGLE_POSITION.matcher(userInput).matches())
            return userInput;

        if (PATTERN_DOUBLE_POSITION.matcher(userInput).matches())
            return userInput.substring(0, 2);

        return "";
    }

    /**
     * Return a position name extracting from user input.
     * This value is treated as a destiny position where the selected piece will move to.
     * e.g. if input = 'd4g8', return 'g8'
     *
     * @param userInput
     * @return
     */
    private String getSecondPos(String userInput) {
        if (PATTERN_DOUBLE_POSITION.matcher(userInput).matches())
            return userInput.substring(2, 4);

        return "";
    }

    /**
     * Return a number of Row number displayed
     *
     * @param input
     * @return
     */
    private int getRowNum(String input) {
        return Integer.parseInt(String.valueOf(input.charAt(1))) - 1;
    }

    /**
     * Return a number of Column Name.
     *
     * @param input a string of position name (e.g. 'c4')
     * @return int of column number
     */
    private int getColNum(String input) {
        char c = input.charAt(0);
        for (int i = 0; i < COL_NAME.length; i++) {
            if (COL_NAME[i] == c) {
                return i;
            }
        }
        return -1;
    }

    private boolean displayPoss(ArrayList<Position> positions) {
        return displayPoss("", positions, false);
    }

    /**
     * Display a list of Positions as a string.
     * Column number is converted to a char of Column Name.
     * e.g. '{f3, e4}'
     *
     * @param input     a position of Piece which the user wants to move (e.g. 'e7')
     * @param positions an ArrayList of Position
     * @return boolean - true: there is possible positions, false: no possible positions
     */

    private boolean displayPoss(String input, ArrayList<Position> positions) {
        return displayPoss(input, positions, true);
    }

    private boolean displayPoss(String input, ArrayList<Position> positions, boolean individualDisplay) {
        StringBuilder sb = new StringBuilder();
        if (individualDisplay) {
            sb.append("Possible moves for ");
            sb.append(input).append(":\n");

        }
        if (positions == null || positions.size() == 0) {
            sb.append("No positions where this piece can move.");
            System.out.println(sb.toString());
            return false;
        }

        sb.append("{");
        for (int i = 0; i < positions.size(); i++) {
            Position p = positions.get(i);
            char colName = COL_NAME[p.getCol()];
            int rowNum = p.getRow() + 1;
            sb.append(colName).append(rowNum);
            if (i < positions.size() - 1)
                sb.append(", ");
            else
                sb.append("}");
        }
        System.out.println(sb.toString());
        return true;
    }

    public boolean isGameOver() {
        if (isKingCheckmate()) {
            return true;
        } else if (isGameDrawn()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Check if King is checked.
     * if King is in Check and has no legal movements --> CHECKMATE
     * Eliminate possibilities that coincide with Enemy's pieces
     * if King.getPoss == null && King in check --> return True
     *
     * @return
     */
    public boolean isKingCheckmate() {
        King k = isWhiteTurn ? whiteKing : blackKing;
        ArrayList<Position> kingPoss = k.getPoss(board, k);
        return (!isEscapable(kingPoss) && (King.isKingChecked(board, k.getPosition(), isWhiteTurn)));
    }

    /**
     * Check if the game is drawn.
     * if King is not in check but it has no legal movements
     * Eliminate possibilities that coincide with Enemy's pieces
     * if King.getPoss == null && King in check --> return True
     *
     * @return
     */
    public boolean isGameDrawn() {
        King k = isWhiteTurn ? whiteKing : blackKing;
        ArrayList<Position> kingPoss = k.getPoss(board, k);
        return (!isEscapable(kingPoss) && (!King.isKingChecked(board, k.getPosition(), isWhiteTurn)));
    }

    public void displayResult() {
        if (isWhiteTurn) {
            System.out.println("Game over! Blacks win by Checkmate!");
        } else {
            System.out.println("Game over! Whites win by Checkmate!");
        }
    }

    /**
     * Return if King is able to escape from the enemy.
     *
     * @param kingPoss
     * @return
     */
    private boolean isEscapable(ArrayList<Position> kingPoss) {
        ArrayList<Position> enemyPoss = getEnemyPoss();
        if (kingPoss.size() == 0 || enemyPoss.size() == 0) {
            return isKingProtected();
        }

        for (Position p : kingPoss) {
            if (enemyPoss.contains(p)) {
                // same position : remove from kingPoss
                kingPoss.remove(p);
            }
        }
        return kingPoss.size() == 0;
    }

    /**
     * if the king is surrounded by the same color, cannot move but still not game over
     *
     * @return
     */
    private boolean isKingProtected() {
        King k = isWhiteTurn ? whiteKing : blackKing;
        int row = k.getPosition().getRow();
        int col = k.getPosition().getCol();

        // front of King
        if (checkPieceColor(row + 1, col - 1))
            return true;
        if (checkPieceColor(row + 1, col))
            return true;
        if (checkPieceColor(row + 1, col + 1))
            return true;

        // besides King
        if (checkPieceColor(row, col - 1))
            return true;
        if (checkPieceColor(row, col + 1))
            return true;

        // behind King
        if (checkPieceColor(row - 1, col - 1))
            return true;
        if (checkPieceColor(row - 1, col))
            return true;
        if (checkPieceColor(row - 1, col + 1))
            return true;
        return false;
    }

    /**
     * Check if the color in the target position is the same color
     * @param targetRow
     * @param targetCol
     * @return
     */
    private boolean checkPieceColor(int targetRow, int targetCol) {
        if (targetRow < 0 || targetRow >= BOARD_RANGE
                || targetCol < 0 || targetCol >= BOARD_RANGE)
            return false;

        return (board[targetRow][targetCol].isWhite() == isWhiteTurn);
    }

    /**
     * Return Enemy's possible positions as a list
     *
     * @return
     */
    private ArrayList<Position> getEnemyPoss() {
        ArrayList<Position> poss = new ArrayList<>();
        for (int r = Game.BOARD_RANGE - 1; r >= 0; r--) {
            for (int c = 0; c < Game.BOARD_RANGE; c++) {
                // no piece or same color: skip
                if (board[r][c] == null || board[r][c].isWhite() != isWhiteTurn)
                    continue;

                // different color -> getPoss
                ArrayList<Position> result = board[r][c].getPoss(board, board[r][c]);
                // no possible positions
                if (result == null || result.size() == 0) {
                    continue;
                }
                poss.addAll(result);
            }
        }
        return poss;
    }

}

