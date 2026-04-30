public class StackNode {
  private StackNode above;
  private StackNode below;
  private int value;
  public StackNode(int value) {
    this.above = null;
    this.below = null;
    this.value = value;
  }
  public StackNode(int value, StackNode above, StackNode below) {
    this.above = above;
    this.below = below;
    this.value = value;
  }
  public StackNode getAbove() {
    return above;
  }
  public StackNode getBelow() {
    return below;
  }
  public int getValue() {
    return value;
  }
  public void setAbove(StackNode above) {
    this.above = above;
  }
  public void setBelow(StackNode below) {
    this.below = below;
  }
  public void setValue(int value) {
    this.value = value;
  }
}
