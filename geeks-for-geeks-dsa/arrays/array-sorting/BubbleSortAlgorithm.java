/*
 * Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in the wrong order
 * 
 * traverse from left and compare adjacent elements and the higher one is placed at right side. 
 * In this way, the largest element is moved to the rightmost end at first. 
 * This process is then continued to find the second largest and place it and so on until the data is sorted.
 */

 /* Select Sort VS Bubble Sort
  * Select sort looks through the loop for the smallest value. Keeps the index of the smallest value, and then swaps the first element with
  * the smallest value. This loop is repeated for every item in the array. Only one swap is possible for every iteration of the main loop.

  * Bubble sort traverses the array while checking each value and comparing it with the next. In this case the larger of the two is moved
  * to the end of the array. The process is repeated as the array is gradually sorted from the end/largest to the smallest value.
  * Swaps occur multiiple times in this approach.
  */
  

public class BubbleSortAlgorithm {  
      // Driver program
      public static void main(String args[])
      {
          int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
          int n = arr.length;
          bubbleSort(arr, n);
          System.out.println("Sorted array: ");
          printArray(arr, n);
      }

      private static void bubbleSort(int[] arr, int n) {
        //Create some needed variables.
        boolean swapped = false; // conditional to test if a swap had to be done, if not, then we break/continue

        //Create the outer for loop for the arr
        for(int i=0; i<arr.length; i++){

          for(int j=0; j<arr.length-i-1; j++){
            if(arr[j] > arr[j+1]){
              // then swap arr[j] and arr[j+1]
              int tempVal = arr[j];
              arr[j] = arr[j+1];
              arr[j+1] = tempVal;
              swapped = true;
            }
          }
          // If no two elements were
          // swapped by inner loop, then break because it means no swapping happened and therefore the array is sorted 
          // and there is no need to keep going
          if (swapped == false)
              break;
        }
      }

      // Function to print an array
      static void printArray(int arr[], int size)
      {
          int i;
          for (i = 0; i < size; i++)
              System.out.print(arr[i] + " ");
          System.out.println();
      }
}
