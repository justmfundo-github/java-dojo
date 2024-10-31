/*
 * Summing the values in an array using recursion instead of a loop
 */

public class SumArray {
  public static void main(String[] args) {
    int[] sumArray = {2, 4, 6};
    int index = 0; //first index of the array
    System.out.println(sumRecursively(sumArray, index));
  }

  public static int sumRecursively(int[] sumArray, int i){
    int sum = Integer.MIN_VALUE;
    

    if(i >= sumArray.length || i < 0){ // base case I.e. Reason that recursion should stop/exit
      //done with the recursion because no more values are available in the array
      sum = 0; // Important to have the recursive function return 0 in this case otherwise the Integer.min_value is used to add to the other stack values
    }else{ // add current index value to the next index value recursively
      sum = sumArray[i] + sumRecursively(sumArray, i+1);
    }


    return sum;
  }
}
