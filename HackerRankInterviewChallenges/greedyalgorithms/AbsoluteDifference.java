package greedyalgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * The absolute difference is the positive difference between two values a and b, is written a-b or b-1 and they are equal. If a=3 and 
 * b=2, |3-2| = |2-3| = 1. Given an array of integers, find the minimum absolute difference between any two elements in the array.
 */

/* 
 * To ensure that all combinations of numbers have been checked
 * Check the first element against all the elements that follow. 
 * Then check the second element against all the elements that follow. 
 * Then check the third element against all that follow. 
 * Continue incrementing the start index and checking against the following values 
 * until the second to last index is reached and check against the last index value. 
 */
public class AbsoluteDifference {
  public static void main(String[] args) {
    List<Integer> testIntArray = new ArrayList<>(Arrays.asList(59,-36,-13,1,-53,-92,-2,-96,-54,75));
    System.out.println("Minimum Absolute Diff: " + minimumAbsoluteDifference(testIntArray));
  }

  public static int minimumAbsoluteDifference(List<Integer> arr) {
    int minDiff = Integer.MAX_VALUE;

    int arrayBegin = 0;

    //System.out.println(arr);
    while(arrayBegin < arr.size()-1){// while loop will start at 0 and continue until the second last index of the list of integers

      for(int i=arrayBegin+1; i<arr.size(); i++){
        //System.out.print("|" + arr.get(arrayBegin) + " - " + arr.get(i) + " = " + Math.abs(arr.get(arrayBegin) - arr.get(i)) + "|");
        if(minDiff > Math.abs(arr.get(arrayBegin) - arr.get(i))){
          minDiff = Math.abs(arr.get(arrayBegin) - arr.get(i));
        }
      }
      //System.out.println();

      arrayBegin++;
    }

    return minDiff;
    }
}
