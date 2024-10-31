/*
 * Simple and straight forward is to use a StringBuilder and then use the Stringbuilder.reverse() method
 */

 /*
  * Manual approach however...
  * It's a good idea to work with a stringbuilder so that you don't end up creating multiple strings and taking up memory because strings are immutable
  */

public class ReverseString {
  public static void main(String[] args) {
    // String input = "The Man in the Mirror";
    String input = "BookWorm";

    System.out.println(input);
    System.out.println(reverseStringManually(input));
    System.out.println(reverseUsingStringBuilder(input));
  }

  private static String reverseUsingStringBuilder(String input) {
    StringBuilder reveresedStringBuilder = new StringBuilder(input);
    return reveresedStringBuilder
                  .reverse()
                  .toString();
  }

  private static String reverseStringManually(String input) {
    StringBuilder reversedString = new StringBuilder();
    for(int i=input.length()-1; i>=0; i--){
      //System.out.print(input.charAt(i));
      reversedString.append(input.charAt(i));
    }    
    return reversedString.toString();
  }
}
