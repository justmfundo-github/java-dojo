/*
 * Write a program to print all the Leaders in the array. An element is a Leader if it is greater than all the elements to its right side.
 * Input: arr[] = {16, 17, 4, 3, 5, 2}
 * Output: 17 5 2
 * Explanation: 17 is greater than all the elements to its right: 4, 3, 5 and 2, therefore 17 is a leader.
 * 5 is greater than all the elements to its right: 2, therefore 5 is a leader.
 * 2 has no element to its right, therefore 2 is a leader.
 */

public class LeadersInArray {
    /*
  * Easy but inefficient solution
  * Use two loops. The outer loop runs from 0 to size – 1 and one by one pick all elements from left to right. 
  * The inner loop compares the picked element to all the elements on its right side. If the picked element is greater than all 
  * the elements to its right side, then the picked element is the leader.
  */
   /*Java Function to print leaders in an array */
   void printLeaders(int arr[], int size) 
   {
       for (int i = 0; i < size; i++) 
       {
           int j;
           for (j = i + 1; j < size; j++) 
           {
               if (arr[i] <=arr[j])
                   break;
           }
           if (j == size) // the loop didn't break
               System.out.print(arr[i] + " ");
       }
   }

   /* Smarter more efficient solution
   * The idea is to scan all the elements from RIGHT to LEFT in an array and keep track of the maximum till now. 
   * When the maximum changes its value, print it.
   */
  public void printLeadersToo(int arr[], int size){
    int max_from_right = arr[size-1];
    System.out.print(max_from_right + " ");
    for(int i=size-2; i >= 0; i--){
      if(max_from_right < arr[i]){
        max_from_right = arr[i];
        System.out.print(max_from_right + " ");
      }
    }
  }

   /* Driver program to test above functions */
   public static void main(String[] args) 
   {
       LeadersInArray lead = new LeadersInArray();
       int arr[] = new int[]{16, 17, 4, 3, 5, 2};
       int n = arr.length;
       lead.printLeadersToo(arr, n);
   }
}
