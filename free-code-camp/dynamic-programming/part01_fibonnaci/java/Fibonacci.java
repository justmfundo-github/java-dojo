public class Fibonacci{
  public static void main(String[] args) {
    System.out.println(calcFibonacci(1));
    System.out.println(calcFibonacci(2));
    System.out.println(calcFibonacci(3));
    System.out.println(calcFibonacci(4));
    System.out.println(calcFibonacci(5));
    System.out.println(calcFibonacci(6));
    System.out.println(calcFibonacci(7));
    System.out.println(calcFibonacci(50));    
  }

  public static long calcFibonacci(int n){
    if(n <= 2){return 1;}

    return calcFibonacci(n-1) + calcFibonacci(n-2);
  }
}