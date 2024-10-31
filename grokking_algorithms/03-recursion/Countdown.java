/*
 * Simple countdown method illustrating how recursion works. I.e. A method that calls itself repeatedly while gradually changing it's parameters. 
 * In this case, we call the countdown method repeatedly. Each time, the number it is called with is decremented by one. 
 * However it is important to ensure that there is a condition to stop the recursion called the "base case".
 * NB: the condition to continue the recursion is called the "recursive case"
 */
public class Countdown {
  public static void main(String[] args){
    int num = 17;
    countdown(num);
  }

  private static void countdown(int num) {
    System.out.print(num + " ");
    if(num <= 0){ //base case
      return;
    }else{
      countdown(num-1);
    }
  }  
}
