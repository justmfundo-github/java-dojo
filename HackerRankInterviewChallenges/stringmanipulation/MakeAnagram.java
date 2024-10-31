package stringmanipulation;

import java.util.HashMap;
import java.util.Map;


/*
 * For two strings to be anagrams, both strings should contain the same letters in the same exact frequency.
 * Given two strings a and b, that may or may not be of the same length, determine the number of character/letter
 * deletions needed to make the two strings anagrams of each other. 
 * Any Characters can be deleted from either String.
 */


/*
* 1st The smallest String will always be tested against.
* 2nd We need to identify which letters make an anagram so that we can determine which ones do not
* 3rd Count the number of letters which do not make the anagram
*/

/*
 * Identify the letters the first string. Perform a count on the number of each letter
 * Compare this list of characters in the first string to the second while removing said characters from both lists if they are the same
 * Count whatever is left
 */
public class MakeAnagram {
  public static void main(String[] args) {
    // String a = "fcrxzwscanmligyxyvym";
    // String b = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";

    String a = "showman";
    String b = "woman";

    System.out.println("Minimum # of deletions: " + makeAnagram(a, b));
  }
  
  public static int makeAnagram(String a, String b) {
    //Create the int variable to be returned
    int minNumOfDeletions = 0;
    String longerString = "";
    
    //Create a hashmap of the shorter string or baaseline string. The one we will test against.
    Map<Character, Integer> shorterStrMap = new HashMap<>();
    //Identify the shorter string and create a map of the letters in said string along with the count of each letter
    if(a.length() <= b.length()){
      for(int i=0; i < a.length(); i++ ){
        shorterStrMap.put(a.charAt(i), shorterStrMap.getOrDefault(a.charAt(i), 0)+1);
        longerString = b;
      }
    }else{
      for(int k=0; k < b.length(); k++ ){
        shorterStrMap.put(b.charAt(k), shorterStrMap.getOrDefault(b.charAt(k), 0)+1);
        longerString = a;
      }
    }

    // Now, we need to traverse the map as we iterate through the next string. Using the following conditions.
    // Any character that matches has it's value decrimented.
    // Any value decrimented below 0 means the characters needed to satisfy the anagram were met and exceeded
    // Any key with a value above or below 0 means a letter that was not needed and must be removed
    // System.out.println(shorterStrMap);
    for( int j=0; j < longerString.length(); j++ ){
        shorterStrMap.put(longerString.charAt(j), shorterStrMap.getOrDefault(longerString.charAt(j), 0)-1 );
    }

    for(Map.Entry<Character, Integer> entry : shorterStrMap.entrySet()){
      if(entry.getValue() != 0){
        minNumOfDeletions += Math.abs(entry.getValue()); // Math.abs() returns the positive value of any number...I.e -3 will return 3
      }
    }
    // System.out.println(shorterStrMap);
    // System.out.println("Number of deletions: " + minNumOfDeletions);

    return minNumOfDeletions;
  }
}
