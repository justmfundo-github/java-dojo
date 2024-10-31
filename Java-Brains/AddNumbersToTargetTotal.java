/*
 * Given an array of integers, return indices of the two numbers such that that add up to the specified target
 * Assume each input can have only one solution. You may not use the same element twice.
 */

 /*
  * The Brute force solution would be to create a for loop, iterate through each value and create a second loop to check the rest of the array to see if 
  * the current value(from the outer) added added to each number in the inner loop. If the two numbers match the sum required then store the two array indexes
  * of those numbers and break out of the loop and return the indexes.   
  */

  /* The smart approach is to use a data structure to store each number as you loop through the array with one loop(no inner loop). For each number, calculate
   * the number required to make up the sum. Then check the created data structure to see if that number has been encountered yet. If yes, then return the 
   * indexes. If not, then add the current value to the data structure and continue.
   */


import java.util.HashMap;
import java.util.Map;

public class AddNumbersToTargetTotal {
  public static void main(String[] args) {
    // int[] nums = {2, 7, 11, 15, 3, 8};
    int[] nums = {2, 3, 7, 4, 8};
    int target = 7;

    int[] sumOperandIndexes = returnSumIndicies(nums, target);
    for(int j : sumOperandIndexes){
      System.out.print(j + " ");
    } 
  }

  public static int[] returnSumIndicies(int[] array, int targetSum){
    
    Map<Integer, Integer> valuesMap = new HashMap<>();
    int delta = Integer.MIN_VALUE;

    //store the first value of array in the map
    valuesMap.put(array[0], 0);

    for(int i=1; i<array.length; i++){ //iterate through the array
      delta = targetSum - array[i]; //calculate the difference required
      if(valuesMap.containsKey(delta)){ //check to see if the value of the difference exists in our new daata structure
        //System.out.println(valuesMap.get(delta));
        return new int[] {valuesMap.get(delta), i}; // return operands and exit the loop
      }else{
        valuesMap.put(array[i], i);
      }
    }
    return new int[] {-1, -1};// return if the relevant numbers are not found
  }
}
