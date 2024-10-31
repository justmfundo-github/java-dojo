/*
 * Selection sort is a simple and efficient sorting algorithm that works by repeatedly selecting 
 * the smallest (or largest) element from the unsorted portion of the list and moving it to the sorted portion of the list. 
 */

public class SelectionSortAlgorithm {
  // Driver code to test above
  public static void main(String args[])
  {
    SelectionSortAlgorithm ob = new SelectionSortAlgorithm();
      int arr[] = {64,25,12,22,11};
      System.out.println("UnSorted array: ");
      ob.printArray(arr);
      ob.sort(arr);
      System.out.println("\nSorted array: ");
      ob.printArray(arr);
  }

  private void printArray(int[] arr) {
    for(int num : arr){
      System.out.print(num + " ");
    }

  }

  private void sort(int[] arr) {
    //Create a loop for the array that will run from start to finish
    //For each index, find the smallest number in the arr and 
    //then swap the found smallest number with the current index
    //The array will begin to sort itself from the left pulling the next smallest number to the left with each iteration of the main loop
  
    for(int i=0; i<arr.length - 1; i++){
      //create the smallest value index place holder
      int smallestIndx = i;
      
      //inner loop needs to test index and swap with the smallest found value
      for(int j=i+1; j<arr.length; j++){
        if(arr[j] < arr[i]){
          smallestIndx = j;
        }
      }
      //now that i have the index of the smallest value, i can swap the value at this index with the current index(i.e the first value
      //in the current subset of iteration i)
      int tempValue = arr[i]; // put the value of the current index or first index in a temp variable
      arr[i] = arr[smallestIndx]; // replace the current index value with the number found at the smallest index
      arr[smallestIndx] = tempValue; // place what was the first the index value into the location that was the smallest 
    }
  }
}
