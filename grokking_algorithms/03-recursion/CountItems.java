/*
 * Method to recursively count number of items in a list
 */

import java.util.ArrayList;
import java.util.List;

public class CountItems {
  public static void main(String[] args) {
    List<Integer> numList = new ArrayList<>(); //create the list
    //add values to the list
    numList.add(2);
    numList.add(4);
    numList.add(6);
    
    int index = 0;

    index = calcListSize(numList, index);
    System.out.println("Size of the list is: " + index);
  }

  private static int calcListSize(List<Integer> numList, int index) {
    if (index < numList.size()) {//here we check for the recursive case rather than the base case
      return calcListSize(numList, index + 1); // note that for each recursive call, the index is incremented
    }
    return index;
    }
}
