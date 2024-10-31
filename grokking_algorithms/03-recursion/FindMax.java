import java.util.ArrayList;
import java.util.List;

public class FindMax {
  public static void main(String[] args) {
    List<Integer> numList = new ArrayList<>();
    numList.add(2);
    numList.add(4);
    numList.add(6);
    numList.add(9);
    
    int max = Integer.MIN_VALUE;
    int index = 0;
    // System.out.println("Max value of the list: " + findMax(numList, index, max));
    System.out.println("Max value of the list: " + findMaxPart2(numList, index));
  }

  // Initial attempt has a bug I couldn't fix

  // private static int findMax(List<Integer> numList, int index, int max) {
  //   System.out.println("Index" + index);
  //   if(index < numList.size()-1){
  //     if(index == 0){
  //       max = numList.get(index);
  //       System.out.println("First Max: " + max);
  //     }
      
  //     if (max < numList.get(index + 1)) {
  //       max = numList.get(index + 1);
        
  //     }
  //     System.out.println("Current Largest: " + max);
  //     findMax(numList, index + 1, max);
  //   }
  //   return max;
  // }

  private static int findMaxPart2(List<Integer> numList, int index) {
    System.out.println("Index" + index);
    if(index == numList.size()-1){
      return numList.get(index);
    }else{
      return Math.max(numList.get(index), findMaxPart2(numList, index + 1));
    }
  }
}
