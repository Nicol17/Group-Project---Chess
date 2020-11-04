public class King extends Piece {

  public King(boolean isWhite) {
    super(isWhite);
    super.value = 1000;
  }

  // Method
  public void move() {
    System.out.println("One Square");
  }

  @Override
  public String toString() {
    return "King{Value=" + value + ", isWhite=" + isWhite + "}";
  }

}
