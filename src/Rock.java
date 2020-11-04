public class Rock extends Piece {

  public Rock(boolean isWhite) {
    super(isWhite);
    super.value = 5;
  }

  // Method
  public void move() {
    System.out.println("Horizontally or Vertically");
  }

  @Override
  public String toString() {
    return "Rock{Value=" + value + ", isWhite=" + isWhite + "}";
  }

}
