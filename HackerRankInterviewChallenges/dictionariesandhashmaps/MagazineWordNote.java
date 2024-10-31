package dictionariesandhashmaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Check if the list of words in the note ArrayList are all available in the magazine ArrayList.
 * Use Hashmap to create a list of words and the number of times they apear in the magazine ArrayList
 * Iterate through the note, checking each word against the above created Hashmap. If a word isn't found in the above Hashmap
 * then print "No".
 * If a word is repeated in magazine then it's corresponding value should reflect the number of times it appears. 
 * As you iterate through the note ArrayList's words, subtract one from the word count. If the word appears several times in the 
 * note and eventually the Hashmap has 0 of that word left, then print No.
 * Otherwise print yes because all the words in note were accounted for in the magazine. 
 */

public class MagazineWordNote {
  public static void main(String[] args) {
    //List<String> magazine = new ArrayList<>(Arrays.asList("two","times","three","is","not","four", "three"));
    List<String> magazine = new ArrayList<>(Arrays.asList("ive" ,"got", "a", "lovely", "bunch", "of", "coconuts"));
     
    //List<String> note = new ArrayList<>(Arrays.asList("two","times","two","is","four"));
    List<String> note = new ArrayList<>(Arrays.asList("ive", "got", "some", "coconuts"));
    

    checkMagazine(magazine, note);
  }

  public static void checkMagazine(List<String> magazine, List<String> note) {
    
    if(magazine.size() < note.size()){
      System.out.println("No");
      return;
    }

    boolean noteFits = true;

    //Create the map of Word keys, vs number of times each word appears
    Map<String, Integer> wordMap = new HashMap<String, Integer>();
    //Populate the map by iterating through the magazine ArrayList, populating the Hashmap with each word as a key. Incrementing the key value
    //if each word is repeated.
    magazine.forEach(word -> wordMap.put(word, wordMap.getOrDefault(word, 0)+1));

    // System.out.println(wordMap);

    //Iterate through note. For each word found in the Hashmap, decrement the key value/number of times the word was found in magazine
    //If the word is not available as a key ini the Hashmap then print "No".
    for(String word : note){
      if(wordMap.get(word) == null || wordMap.get(word) == 0){
        noteFits = false;
        break;
      }else{
        wordMap.put(word, wordMap.get(word)-1);
        
      }
    }
    // System.out.println(wordMap);
    System.out.println(noteFits?"Yes" : "No");
  }
}
