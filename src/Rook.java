public class Rook extends Piece {
    ///////////////////////////////////////////////////
    protected static final int VALUE = 5;
    ///////////////////////////////////////////////////

    public Rook(boolean isWhite, Position position) {
        super(VALUE, isWhite, position);
    }

    @Override
    public void move(Position newPosition) {
        System.out.println("Horizontally or vertically");
    }

    @Override
    public String toString() {
        return "Rook{" +
                "value=" + getValue() +
                '}';
    }
}
