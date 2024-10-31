import java.util.HashMap;
import java.util.Map;

public class FibonacciMemoisation{
  public static void main(String[] args) {

    //including memoisation to store and keep track of any fibonacci values that have already been calculated
    Map<Integer, Long> calculatedFibonacci = new HashMap<>();//Hashmap to store calculated fibonaccis

    System.out.println(calcFibonacci(1, calculatedFibonacci));
    System.out.println(calcFibonacci(2, calculatedFibonacci));
    System.out.println(calcFibonacci(3, calculatedFibonacci));
    System.out.println(calcFibonacci(4, calculatedFibonacci));
    System.out.println(calcFibonacci(5, calculatedFibonacci));
    System.out.println(calcFibonacci(6, calculatedFibonacci));
    System.out.println(calcFibonacci(7, calculatedFibonacci));
    System.out.println(calcFibonacci(50, calculatedFibonacci));    
  }

  public static long calcFibonacci(int n, Map<Integer, Long> calcFib){
    
    //first check if the current fibonacci value/key has already been calculated or not
    if(calcFib.containsKey(n)){
      return calcFib.get(n);
    }
    if(n <= 2){return 1;}

    //now calculate fibonacci and store each result in the Hashmap. Remember to always pass the Hashmap to each calculation of fibonacci
    calcFib.put(n, calcFibonacci(n-1, calcFib) + calcFibonacci(n-2, calcFib));
    return calcFib.get(n);
  }
}