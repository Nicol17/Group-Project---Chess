public class Queen extends Piece {
    ///////////////////////////////////////////////////
    private static final int VALUE = 9;
    ///////////////////////////////////////////////////

    public Queen(int value, boolean isWhite, Position position) {
        super(value, isWhite, position);
    }

//    public Queen() {
//        this(false);
//    }

//    public Queen(boolean isWhite) {
//        super(VALUE_QUEEN, isWhite);
//    }

    @Override
    public void move() {
        System.out.println("Like bishop and rook");
    }

    @Override
    public String toString() {
        return "Queen{" +
                "value=" + getValue() +
                '}';
    }

}
