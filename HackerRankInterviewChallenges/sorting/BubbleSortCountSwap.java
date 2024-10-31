package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Use a bubble sort to re-arrange an array of integers in ascending order. 
 * Count the number of number swaps required to complete the buble sort.
 * Print the number of swaps, the int value at the first index and finally print the int value at the last index of the sorted array.
 * 
 * Remember that a bubble sort iterates through the array several times. The first value of the array is checked against the second value. 
 * If the second value is less than the first. Then the first value bubbles up. This continues until the number cannot move up/bubble up. 
 * Process is repeated arr.length number of times. Two array counts used. One for length of the array count. 
 * The other(nested) for the bubble sort and swapping. 
 */

public class BubbleSortCountSwap {
  public static void main(String[] args) {
    //List<Integer> arrToSort = new ArrayList<>(Arrays.asList(4,6,2,1));
    List<Integer> arrToSort = new ArrayList<>(Arrays.asList(3,2,1));
    System.out.println(arrToSort);
    countSwaps(arrToSort);
  }

  public static void countSwaps(List<Integer> a) {
    int swapCount = 0;
    for (int i = 0; i < a.size(); i++) {
      for (int j = 0; j < a.size() - 1; j++) {
          // Swap adjacent elements if they are in decreasing order
          if (a.get(j) > a.get(j+1)) {
            int temp = a.get(j);
            a.set(j, a.get(j+1));
            a.set(j+1, temp);
            swapCount++;
          }
      }
    }
    System.out.println("Array is sorted in "  + swapCount + " swaps.");
    System.out.println("First Element: " + a.get(0));
    System.out.println("Last Element: " + a.get(a.size()-1));
  }
}
