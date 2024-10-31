package warmup;

/*
 * There is a string, s, of lowercase English letters that is repeated infinitely many times. Given an integer, n, find 
 * and print the number of letter a's in the first n letters of the infinite string.
 * Example
 * s='abcac'
 * n=10
 * The substring we consider is abcacabcac, the first  characters of the infinite string. There are  occurrences of a in the substring.
 */

public class ReapeatedStringTest {
  public static void main(String[] args) {
    String strToBeRepeated = "a";
    long strCheckLimit = 10000000000l;

    System.out.println("Number of character 'a's: " + repeatedString(strToBeRepeated, strCheckLimit));
  }

  /*Note that my first solution involved creating the very long string first and then checking the string for 
   * the number of valid characters 'a'. However that leads to issues when dealing with very large strings. 
   * I.e. String gets bigger than the virtual machine wants to deal with.
   * So.. Let's solve this one mathematically
   */

  public static long repeatedString(String s, long n) {
    long numOfChars = 0;
    // long strLength = s.length();
    long numOfCharsInSampleString = s.chars().filter(ch -> ch == 'a').count();

    numOfChars = numOfCharsInSampleString * (n/s.length());

    return numOfChars;
  }

}
