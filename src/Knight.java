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
    public boolean isValidMove (Position newPosition){
        if (!super.isValidMove(position)){
            return false;
        }
        if (newPosition.getCol() ==  (this.position.getCol() +2) && newPosition.getRow() == (this.position.getRow() +1) ||
            newPosition.getCol() ==  (this.position.getCol() +2) && newPosition.getRow() == (this.position.getRow() -1) ||
            newPosition.getCol() ==  (this.position.getCol() -2) && newPosition.getRow() == (this.position.getRow() +1) ||
            newPosition.getCol() ==  (this.position.getCol() -2) && newPosition.getRow() == (this.position.getRow() -1) ||
            newPosition.getCol() ==  (this.position.getCol() +1) && newPosition.getRow() == (this.position.getRow() +2) ||
            newPosition.getCol() ==  (this.position.getCol() -1) && newPosition.getRow() == (this.position.getRow() +2) ||
            newPosition.getCol() ==  (this.position.getCol() +1) && newPosition.getRow() == (this.position.getRow() -2) ||
            newPosition.getCol() ==  (this.position.getCol() -1) && newPosition.getRow() == (this.position.getRow() -2)) {
            return true;
        }  else {
            return false;
        }
    }


    @Override
    public String toString() {
        String color = (isWhite()) ? "White" : "Black";
        return "Knight{" +
            "value=" + getValue() +
            ", color=" + color +
            ", position=(" + getPosition().getRow() + ", " + getPosition().getCol() + ')' +
            '}';
    }
}
