public class LRU {
  public static void main(String[] args) {
    int[] reference = {1, 3, 2, 4, 2, 1, 5, 4, 2, 3, 3, 4, 1, 2, 1, 2, 3, 4, 5, 4, 1, 5, 3, 5, 2, 3, 4, 1, 1, 2, 1, 3, 4, 5};
    int numFrames = 3;
    printRefNumFrames(reference, numFrames);
    FrameStack stack = new FrameStack(numFrames);
    for(int i = 0; i < reference.length; i++){
      stack.add(reference[i]);
    }
    System.out.println("Total number of faults is " + stack.getNumFaults());
  }
  private static void printRefNumFrames(int[] reference, int numFrames){
    System.out.print("Reference string: (");
    for(int i = 0; i < reference.length; i++) {
      if(i != 0)
        System.out.print(", ");
      System.out.print(reference[i]);
    }
    System.out.println(")\nNumber of Page Frames: " + numFrames);
  }
}
