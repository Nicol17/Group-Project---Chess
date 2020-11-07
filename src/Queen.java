public class Queen extends Piece {
    ///////////////////////////////////////////////////
    protected static final int VALUE = 9;
    ///////////////////////////////////////////////////

    public Queen(boolean isWhite, Position position) {
        super(VALUE, isWhite, position);
    }

    @Override
    public void move(Position newPosition) {
        System.out.println("Like bishop and rook");
    }

    @Override
    public String toString() {
        return "Queen{" +
                "value=" + getValue() +
                '}';
    }

}
