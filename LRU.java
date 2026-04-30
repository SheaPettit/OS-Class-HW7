public class LRU {
  public static void main(String[] args) {
    int[] reference = {1, 3, 2, 4, 2, 1, 5, 4, 2, 3, 3, 4, 1, 2, 1, 2, 3, 4, 5, 4, 1, 5, 3, 5, 2, 3, 4, 1, 1, 2, 1, 3, 4, 5};
    FrameStack stack = new FrameStack(3);
    for(int i = 0; i < reference.length; i++){
      stack.add(reference[i]);
    }
    System.out.println("Total number of faults is " + stack.getNumFaults());
  }
}
