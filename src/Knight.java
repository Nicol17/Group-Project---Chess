public class Knight extends Piece {
    ///////////////////////////////////////////////////
    protected static final int VALUE = 2;
    ///////////////////////////////////////////////////

    public Knight(boolean isWhite, Position position) {
        super(VALUE, isWhite, position);
    }

    @Override
    public void move(Position newPosition) {
        System.out.println("Like an L");
    }

    @Override
    public String toString() {
        return "Knight{" +
                "value=" + getValue() +
                '}';
    }

}
