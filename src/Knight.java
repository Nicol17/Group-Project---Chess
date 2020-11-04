public class Knight extends Piece {

  public Knight(boolean isWhite) {
    super(isWhite);
    super.value = 2;
  }

  // Method
  public void move() {
    System.out.println("Like an L");
  }

  @Override
  public String toString() {
    return "Knight{Value=" + value + ", isWhite=" + isWhite + "}";
  }
}
