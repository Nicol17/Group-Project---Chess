public class King extends Piece {
    ///////////////////////////////////////////////////
    private static final int VALUE = 1_000;
    ///////////////////////////////////////////////////


    public King(int value, boolean isWhite, Position position) {
        super(value, isWhite, position);
    }

//    public King() {
//        this(false);
//    }
//
//    public King(boolean isWhite) {
//        super(VALUE_KING, isWhite);
//    }

    @Override
    public void move() {
        System.out.println("One square");
    }

    @Override
    public String toString() {
        return "King{" +
                "value=" + getValue() +
                '}';
    }
}
