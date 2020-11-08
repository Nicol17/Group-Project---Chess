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
    public boolean isValidMove (Position newPosition){
        if (!super.isValidMove(position)){
            return false;
        }
        if (newPosition.getCol() ==  (this.position.getCol() +1) && (newPosition.getRow() == this.position.getRow()) ||
            newPosition.getCol() ==  (this.position.getCol() -1) && (newPosition.getRow() == this.position.getRow()) ||
            newPosition.getCol() ==  (this.position.getCol()) && newPosition.getRow() == (this.position.getRow() +1) ||
            newPosition.getCol() ==  (this.position.getCol()) && newPosition.getRow() == (this.position.getRow() -1) ||
            newPosition.getCol() ==  (this.position.getCol() + 1) && newPosition.getRow() == (this.position.getRow() + 1) ||
            newPosition.getCol() ==  (this.position.getCol() - 1) && newPosition.getRow() == (this.position.getRow() + 1) ||
            newPosition.getCol() ==  (this.position.getCol() + 1) && newPosition.getRow() == (this.position.getRow() -1) ||
            newPosition.getCol() ==  (this.position.getCol() - 1) && newPosition.getRow() == (this.position.getRow() -1)) {
            return true;
        }  else {
            return false;
        }
    }


    @Override
    public String toString() {
        String color = (isWhite()) ? "White" : "Black";
        return "King{" +
            "value=" + getValue() +
            ", color=" + color +
            ", position=(" + getPosition().getRow() + ", " + getPosition().getCol() + ')' +
            '}';
    }
}
