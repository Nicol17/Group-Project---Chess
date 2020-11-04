public class Bishop extends Piece {

  public Bishop(boolean isWhite) {
    super(isWhite);
    super.value = 3;
  }

  // Method
  public void move() {
    System.out.println("Diagonally");
  }

  @Override
  public String toString() {
    return "Bishop{Value=" + value + ", isWhite=" + isWhite + "}";
  }

}
