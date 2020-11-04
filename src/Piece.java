public abstract class Piece {
  protected int value;
  protected boolean isWhite;

  // Constructors

  public Piece() {}

  public Piece(boolean isWhite) {
    this.isWhite = isWhite;
  }


  // getter, setter

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  // Method

  public abstract void move();

  // Overrides
  @Override
  public String toString() {
    return "Piece{Value=" + value + ", isWhite=" + isWhite + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || this.getClass() != o.getClass()) return false;
    Piece that = (Piece) o;
    if (this.value == that.value && this.isWhite== that.isWhite) {
      return true;
    } else {
      return false;
    }
  }
}
