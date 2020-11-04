public class Queen extends Piece {

  public Queen(boolean isWhite) {
    super(isWhite);
    super.value = 9;
  }

  // Method
  public void move() {
    System.out.println("Like Bishop and Rock");
  }

  @Override
  public String toString() {
    return "Queen{Value=" + value + ", isWhite=" + isWhite + "}";
  }

}
