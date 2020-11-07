public abstract class Piece {
    private int value;
    private boolean isWhite;
    protected Position position;

    public Piece(int value, boolean isWhite, Position position) {
        this.value = value;
        this.isWhite = isWhite;
        this.position = position;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public void setWhite(boolean white) {
        isWhite = white;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public abstract void move(Position newPosition);

    /**
     * Return true if the new position is inside the board.
     * Should include '0' as minimum range since row/col index ranges are 0 to 7.
     * @param newPosition
     * @return
     */
    public boolean isValidMove(Position newPosition) {
        return (newPosition.getRow() >= 0 && newPosition.getCol() >= 0
                && newPosition.getRow() < 8 && newPosition.getCol() < 8);
    }

    @Override
    public String toString() {
        return "Piece{" +
                "value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return value == piece.value &&
                isWhite == piece.isWhite;
    }
}
