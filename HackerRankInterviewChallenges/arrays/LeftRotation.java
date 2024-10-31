package arrays;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LeftRotation {
  public static void main(String[] args) {
    int [] tempArray = {1,2,3,4,5,7,9,11};
    
    //Create array or list of numbers
    List<Integer> shiftList = new ArrayList<Integer>();
    for(int i : tempArray){
      shiftList.add(i);
    }
    //Create number of shifts variable
    int numOfShifts = 43;
    
    //print orginal list 
    System.out.println("Original: \t" + shiftList);
    //and then print shifted list
    System.out.println("Shifted: \t" + rotLeft(shiftList, numOfShifts));
  }
  

    /* Complete the 'rotLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER d
     */

    public static List<Integer> rotLeft(List<Integer> a, int d) {

      /*create code to perform one shift correctly and then make that repeatable n times....
      * this solution although functional, fails when the values used are large. i.e. The code isn't efficient
      */

      /*
       * So let's optimise the code by saying that if the shift value is equal to the size of the array then it is a meaningless shift
       * So if shifts are larger than the arraysize then divide shifts by array size and only shift by the remainder
       */

      /*
       * Optimisation while better, still doesn't achieve the desired efficiency goal 
       */

      // note that the remainder optimisation is still required for both solutions
      // int tempInt = Integer.MIN_VALUE;
      // int count = 0;
      int remainderShifts = d % a.size();
      System.out.println("Remainder: " + remainderShifts);
      
      /*
      while(count < remainderShifts){

        tempInt = a.get(0);
        for(int i=0; i<a.size(); i++){
          
          if(i != a.size()-1){
            a.set(i, a.get(i+1));
          }else{
            a.set(i, tempInt);
          }
        }

        count++;
      }
      
      return a;
      */

      /*
       * Let's attempt another approach where, we simply create two subsets of the original array
       * 1st subset is from the 0 index to the index of the shiftValue
       * 2nd subset is from the shiftValue+1 to the end of the array/list
       * Then create a third array/list using the two subsets starting with the 2nd subset and then tacking the 1st subset to end of the new array
       */

      // Creating the first subset 
      List<Integer> firstSubset = new ArrayList<>(a.subList(0, remainderShifts));
      
      // Creating the second subset
      List<Integer> secondSubset = new ArrayList<>(a.subList(remainderShifts, a.size()));

      // Creating the final subset by combining the two
      List<Integer> shiftedList = Stream.of(secondSubset, firstSubset).flatMap(Collection::stream).collect(Collectors.toList());
      
      System.out.println("Original List: \t" + a);
      System.out.println("1stSub: \t" + secondSubset + " : " + firstSubset + " : 2ndSub");

      System.out.println("Full Shifted List: \t" + shiftedList);
      return shiftedList;
    }
}
