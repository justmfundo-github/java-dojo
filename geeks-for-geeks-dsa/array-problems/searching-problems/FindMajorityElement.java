/*
 * Find the majority element in the array. A majority element in an array A[] of size n is an element 
 * that appears more than n/2 times (and hence there is at most one such element). 
 * Input : A[]={3, 4, 2, 4, 2, 4, 4}
 * Output : 4
 * Explanation: The frequency of 4 is greater than the half of the size of the array size. 
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindMajorityElement {
  // Driver code
  public static void main(String[] args)
  {

      int arr[] = { 1, 1, 2, 1, 3, 5, 1 };
      int n = arr.length;

      // Function calling
      findMajority(arr, n);

      // Using hashing version method
      findMajorityUsingHashing(arr, n);

      // Using sorting and counter increment method
      findMajorityBySorting(arr, n);
  }
  /*
  * The basic solution is to have two loops and keep track of the maximum count for all different elements. 
  * If the maximum count becomes greater than n/2 then break the loops and return the element having the maximum count. 
  * If the maximum count doesn’t become more than n/2 then the majority element doesn’t exist.
  */
  // Function to find Majority element in an array
    static void findMajority(int arr[], int n)
    {
        int maxCount = 0;
        int index = -1; // sentinels
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j])
                    count++;
            }

            // update maxCount if count of
            // current element is greater
            if (count > maxCount) {
                maxCount = count;
                index = i;
            }
        }

        // if maxCount is greater than n/2
        // return the corresponding element
        if (maxCount > n / 2)
            System.out.println(arr[index]);

        else
            System.out.println("No Majority Element");
    }

    /*
     * In Hashtable(key-value pair), at value, maintain a count for each element(key), 
     * and whenever the count is greater than half of the array length, return that key(majority element). 
     */
    static void findMajorityUsingHashing(int arr[], int n){
      Map<Integer, Integer> majorityMap = new HashMap<>();
      int majorityMax = n/2;
      int maxValue = Integer.MIN_VALUE;
      for(int i=0; i<arr.length; i++){
        //if key doesn't exist, then add key and set value to 1
        if(!majorityMap.containsKey(arr[i])){
          majorityMap.putIfAbsent(arr[i], 1);
        }else{//if key exists then increment it's value by 1
          majorityMap.computeIfPresent(arr[i], (k, v) -> v+1);
          
          if(majorityMap.get(arr[i]) > majorityMax){
            maxValue = arr[i];
            break;
          }
        }
      }
      if(maxValue > 0){
        System.out.println("Majority index: " + maxValue);
      }else{
        System.out.println("There is no Majority value");
      }
    }

    /*
     * The idea is to sort the array. Sorting makes similar elements in the array adjacent, 
     * so traverse the array and update the count until the present element is similar to the previous one. 
     * If the frequency is more than half the size of the array, print the majority element.
     */
    public static void findMajorityBySorting(int arr[], int n){
      //Sort the array
      Arrays.sort(arr);
      //Create a counter which will increment when we find an adjacent value
      int majorityCounter = 1;
      //If count reaches n/2 max then we break and take note of the value at i
      for(int i=1; i<arr.length; i++){
        if(arr[i] == arr[i-1]){
          majorityCounter++;
          if(majorityCounter > n/2){
            System.out.println("Majority value is: " + arr[i]);
            break;
          }
        }else{
          majorityCounter = 1;
        }
      }
    }
}
