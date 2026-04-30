public class FrameStack {
  private StackNode top;
  private StackNode bottom;
  private int maxFrames;
  private int numFrames;
  private int numFaults;
  public FrameStack(int maxFrames) {
    this.maxFrames = maxFrames;
    numFrames = 0;
    numFaults = 0;
    top = null;
    bottom = null;
  }
  public int getNumFaults() {
    return numFaults;
  }
  public void add(int value) {
    if(maxFrames == numFrames) {
      findVictim(value);
      return;
    }
    if(top == null) {
      top = new StackNode(value);
      bottom = top;
    } else {
      top.setAbove(new StackNode(value, null, top));
      top = top.getAbove();
    }
    System.out.println("Page Fault: no page evicted; page " + value + " brought into memory");
    numFaults++;
    numFrames++;
  }
  private void findVictim(int value) {
    StackNode current = top;
    while(current != null) {
      if(current.getValue() == value){
        if(current == top)
          return;
        StackNode above = current.getAbove();
        StackNode below = current.getBelow();
        top.setAbove(current);
        above.setBelow(below);
        if(below != null) {
          below.setAbove(above);
        } else {
          bottom = above;
        }
        current.setBelow(top);
        current.setAbove(null);
        top = current;
        return;
      }
      current = current.getBelow();
    }
    pageFault(value);
  }
  private void pageFault(int value) {
    System.out.println("Page Fault: page " + bottom.getValue() + " evicted; page " + value + " brought into memory");
    if(top == bottom) {
      top = new StackNode(value);
      bottom = top;
    } else {
      bottom = bottom.getAbove();
      bottom.setBelow(null);
      top.setAbove(new StackNode(value, null, top));
      top = top.getAbove();
    }
    numFaults++;
  }
}
