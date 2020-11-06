public class Rook extends Piece {
    ///////////////////////////////////////////////////
    private static final int VALUE = 5;
    ///////////////////////////////////////////////////

    public Rook(int value, boolean isWhite, Position position) {
        super(value, isWhite, position);
    }


//    public Rook() {
//        this(false);
//    }

//    public Rook(boolean isWhite) {
//        super(VALUE_ROOK, isWhite);
//    }

    @Override
    public void move() {
        System.out.println("Horizontally or vertically");
    }

    @Override
    public String toString() {
        return "Rook{" +
                "value=" + getValue() +
                '}';
    }
}
