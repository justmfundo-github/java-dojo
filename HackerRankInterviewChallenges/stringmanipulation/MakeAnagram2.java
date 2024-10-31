package stringmanipulation;

/*
 * For two strings to be anagrams, both strings should contain the same letters in the same exact frequency.
 * Given two strings a and b, that may or may not be of the same length, determine the number of character/letter
 * deletions needed to make the two strings anagrams of each other. 
 * Any Characters can be deleted from either String.
 */

/*
 * This solution assumes our test only deals with small letters of the alphabet. Hashmap more appropriate if we don't know 
 * which characters could be in the string
 * Solution also leverages the fact that characters can be treated as integers
 * 
 * To solve this, we create two arrays both storing a count of each letter that shows up in each string
 * We then compare those strings and return the difference. I.e. Take the first value representing 'a' in both arrays
 * and subtract one count from the other and return a positive difference. We're not interested in the negative.
 */

public class MakeAnagram2 {
  public static int NUMBER_OF_LETTERS = 26;
  public static void main(String[] args) {
    String a = "fcrxzwscanmligyxyvym";
    String b = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";

    // String a = "showman";
    // String b = "woman";

    System.out.println("Minimum # of deletions: " + makeAnagram(a, b));
  }
  
  public static int makeAnagram(String a, String b) {
    int minNumOfDeletions = 0;

    int firstStrCharCount[] = getCharCount(a);
    int secondStrCharCount[] = getCharCount(b);
    minNumOfDeletions = getDifferenceOfArrays(firstStrCharCount, secondStrCharCount);
    return minNumOfDeletions;
  }

  private static int getDifferenceOfArrays(int[] firstStrCharCount, int[] secondStrCharCount) {
    if(firstStrCharCount.length != secondStrCharCount.length){
      return -1; // just double checking if both arrays represent arrays of 26 letters. Got to do better error handling
    }
    int returnTotal = 0;
    for(int i=0; i<firstStrCharCount.length; i++){
      int difference = Math.abs(firstStrCharCount[i] - secondStrCharCount[i]);
      returnTotal += difference;
    }
    return returnTotal;
  }

  private static int[] getCharCount(String a) {
    int [] charCount = new int[NUMBER_OF_LETTERS]; // represents an array that has a place for each letter of the alphabet
    for(int i=0; i<a.length(); i++){
      char c = a.charAt(i);
      int offset = (int)'a';
      int code = c - offset; // represents the index of the letter 
      charCount[code]++;      //value at the afforementioned index is incremented whenever a letter of this value index is found in the string
      System.out.println("Offset: " + offset + "\t\tc: " + (int)c + "\t\t Code: " + code + "\t\t charCount: " + charCount[code]);
    }
    return charCount;
  }  
}
