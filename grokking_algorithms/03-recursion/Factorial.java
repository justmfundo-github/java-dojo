/*
 * Illustrating the power of recursion using factorial.
 * Factorial of a positive integer (number) is the sum of multiplication of all the integers smaller than that positive integer. 
 * For example, factorial of 5 is 5 * 4 * 3 * 2 * 1 which equals to 120.
 * Remember, it is important to ensure that there is a condition to stop the recursion called the "base case".
 * NB: the condition to continue the recursion is called the "recursive case"
 */
public class Factorial {
  public static void main(String[] args) {
    int num = 5;
    System.out.println(calculateFactorial(num));
  }

  public static int calculateFactorial(int num){
    int factorial = Integer.MIN_VALUE;
      if(num == 1){ // The base case here serves to return 1 to the most recent call in the recursion instead of recalling the recursion
        return 1; // The returned one is the last value to be returned by the funtion to be used in the factorial calculation.
      }else{
        factorial = num * (calculateFactorial(num -1));
      }
    return factorial;
  }
}
