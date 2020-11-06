public class Knight extends Piece {
    ///////////////////////////////////////////////////
    private static final int VALUE = 2;
    ///////////////////////////////////////////////////

    public Knight(int value, boolean isWhite, Position position) {
        super(value, isWhite, position);
    }

//    public Knight() {
//        this(false);
//    }
//
//    public Knight(boolean isWhite) {
//        super(VALUE_KNIGHT, isWhite);
//    }

    @Override
    public void move() {
        System.out.println("Like an L");
    }

    @Override
    public String toString() {
        return "Knight{" +
                "value=" + getValue() +
                '}';
    }

}
