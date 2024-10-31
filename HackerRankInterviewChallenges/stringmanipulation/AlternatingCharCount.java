package stringmanipulation;

/*
 * When given a string of only A and B characters in varying order, determine the number of deletions required to ensure that no 
 * two adjacent characters are the same.
 */
public class AlternatingCharCount {
  public static void main(String[] args) {
    String input = "AABAAB";
    System.out.println(alternatingCharacters(input));
  }

  public static int alternatingCharacters(String input) {
    // Declare count
    int deletionCount = 0;
    //Traverse the string and check if next is equal to current
    //If equal, then increment deletionCount
    //If not then next becomes current and continue to traverse the string input
    char current = input.charAt(0);
    for( int i=1; i<input.length(); i++){
      if(current == input.charAt(i)){
        deletionCount++;
      }else{
        current = input.charAt(i);
      }
    }

    return deletionCount;
  }
}
