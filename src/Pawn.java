public class Pawn extends Piece {
  private boolean promoted;
  private Piece newPiece;

  public Pawn(boolean isWhite) {
    super(isWhite);
    super.value = 1;
  }

  public Pawn(boolean isWhite, boolean promoted) {
    super(isWhite);
    this.promoted = promoted;
  }

  public Pawn(boolean isWhite, boolean promoted, Piece newPiece) {
    super(isWhite);
    this.promoted = promoted;
    this.newPiece = newPiece;
  }

  // Methods
  public void move() {
    System.out.println("Forward 1");
  }

  public void promote(Piece newPiece) {}

  @Override
  public String toString() {
    return "Pawn{Value=" + value + ", isWhite=" + isWhite + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || this.getClass() != o.getClass()) return false;
    Pawn that = (Pawn) o;
    if (this.value == that.value && this.isWhite== that.isWhite && this.promoted == that.promoted && this.newPiece == that.newPiece) {
      return true;
    } else {
      return false;
    }
  }
}
