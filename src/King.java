public class King extends Piece {
    ///////////////////////////////////////////////////
    protected static final int VALUE = 1_000;
    ///////////////////////////////////////////////////


    public King( boolean isWhite, Position position) {
        super(VALUE, isWhite, position);
    }

    @Override
    public void move(Position newPosition) {
        System.out.println("One square");
    }

    @Override
    public String toString() {
        return "King{" +
                "value=" + getValue() +
                '}';
    }
}
