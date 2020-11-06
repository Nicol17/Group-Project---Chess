public class Bishop extends Piece {
    ///////////////////////////////////////////////////
    private static final int VALUE = 3;
    ///////////////////////////////////////////////////

    public Bishop(boolean isWhite, Position position) {
        super(VALUE, isWhite, position);
    }

    public Bishop(int value, boolean isWhite, Position position) {
        super(value, isWhite, position);
    }


//    public Bishop() {
//        this(false);
//    }
//
//    public Bishop(boolean isWhite) {
//        super(VALUE_BISHOP, isWhite);
//    }

    @Override
    public void move() {
        System.out.println("Diagonally");
    }

    /**
     * 1. Use SuperClass validation to check if the newPosition is inside the board range.
     * 2. Check if the newPosition is valid for this piece.
     * --> Bishop: Only diagonally
     *
     * @param newPosition
     * @return
     */
    @Override
    public boolean isValidMove(Position newPosition) {
        if (!super.isValidMove(newPosition))
            return false;
        return (Math.abs(this.position.getRow() - newPosition.getRow())
                == Math.abs(this.position.getCol() - newPosition.getCol()));
    }

    @Override
    public String toString() {
        String color = (isWhite()) ? "White" : "Black";
        return "Bishop{" +
                "value=" + getValue() +
                ", color=" + color +
                ", position=(" + getPosition().getRow() + ", " + getPosition().getCol() + ')' +
                '}';
    }


}
