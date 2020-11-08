public class Bishop extends Piece {
    ///////////////////////////////////////////////////
    protected static final int VALUE = 3;
    ///////////////////////////////////////////////////

    public Bishop(boolean isWhite, Position position) {
        super(VALUE, isWhite, position);
    }

    @Override
    public void move(Position newPosition) {
        // if there is another piece is exist in the destiny position, should stop one block before
        // better to loop to increase row and col till the destiny, and set at the maximum position.

        setPosition(newPosition);
        System.out.println("Moved Diagonally");
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
