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
    public boolean isValidMove(Position newPosition) {
        if (!super.isValidMove(newPosition)) {
            return false;
        }
        if (newPosition.getCol() ==  (this.position.getCol()) ||
            (newPosition.getRow() == this.position.getRow())) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        String color = (isWhite()) ? "White" : "Black";
        return "Rook{" +
            "value=" + getValue() +
            ", color=" + color +
            ", position=(" + getPosition().getRow() + ", " + getPosition().getCol() + ')' +
            '}';
    }
}
