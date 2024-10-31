/*
 * Given three sorted arrays in non-decreasing order, print all common elements in these arrays.
 * Using the Hashing approach
 * 
 * Starting with the first array, create a hashmap with each value in the array as a key and a value of 1 next to it
 * Iterate through the next array and set the value of each value found in the hashmap and array to 2 (note that incrementing 
 * the value would mean duplicates would be accounted for which we don't need in this case)
 * Iterate on the 3rd array and set value of found keys to 3
 * Retrieve and list all keys with 3 as their value
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonElements {
  public static void main(String[] args) {
    // Sample Input
    ArrayList<Integer> A = new ArrayList<>(List.of(1, 5, 10, 20, 30));
    ArrayList<Integer> B = new ArrayList<>(List.of(5, 13, 15, 20));
    ArrayList<Integer> C = new ArrayList<>(List.of(5, 20));

    // Function call and storing result
    ArrayList<Integer> ans = commonElements(A, B, C);

    // Printing common elements
    System.out.print("Common elements are: ");
    for (int i = 0; i < ans.size(); i++)
        System.out.print(ans.get(i) + " ");
  }

  private static ArrayList<Integer> commonElements(ArrayList<Integer> a, ArrayList<Integer> b, ArrayList<Integer> c) {
    /*
     * Note that you could optimise this solution a little bit by identifying the smallest array first and only testing against
     * the values in that array
     */

    // Create a map to store all the similar elements
    Map<Integer, Integer> commonIntMap = new HashMap<Integer, Integer>();

    // Mark all the elements in the first array with
        // value=1
    for(int i=0; i<a.size(); i++){
      commonIntMap.put(a.get(i), 1);
    }

    // Mark all the elements which are common in first
        // and second array with value = 2
    for(int i=0; i<b.size(); i++){
      if(commonIntMap.containsKey(b.get(i)) && commonIntMap.get(b.get(i)) == 1){
        commonIntMap.put(b.get(i), 2);
      }
    }

    // Mark all the elements which are common in first,
        // second, and third array with value = 3
    for(int i=0; i<c.size(); i++){
      if(commonIntMap.containsKey(c.get(i)) && commonIntMap.get(c.get(i)) == 2){
        commonIntMap.put(c.get(i), 3);
      }
    }

    System.out.println(commonIntMap);
    // Store all the common elements
    ArrayList<Integer> commonElements = new ArrayList<>();
    for (int ele : commonIntMap.keySet()) {
        if (commonIntMap.get(ele) == 3)
            commonElements.add(ele);
    }

    return commonElements;
  }
}
