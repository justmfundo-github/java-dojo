import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Just like a binary search where we break up the search into pieces with each iteration,
 * the quicksort algorithm starts in a similar way. Don't get it twisted however, because the rest is entirely different. 
 * First select a pivot point. I.e. Pick a value in the middle(or anywhere) in a list. 
 * Then create three lists/arrays. One list will have all the values less than the pivot. The other list will have the values larger than the pivot.
 * The third list is a list of one! The pivot value.
 * Use recursion to then repeat the above process for each list on either side of the pivot. 
 * The recursive processing of adjacent lists should continue until each iteration has returned just one value. The pivot. The lists are then concatenated.
 * The lesser lists on the left, the pivot in the middle and the larger lists on the right. 
 * 
 * What's the base case in this situation?
 */
public class QuickSort {
  public static void main(String[] args) {
    List<Integer> numList = new ArrayList<>();
    numList.add(3); numList.add(6); numList.add(2); numList.add(9); numList.add(7); numList.add(12); numList.add(10);
    System.out.print("Before Sorting: ");
    System.out.println(numList);

    List<Integer> sortedList = doQuickSort(numList);
    System.out.println("Sorted List: " + sortedList);
    
  }

  private static List<Integer> doQuickSort(List<Integer> numList) {
    if(numList.size() < 2){
      //if length of the array is 0 or less than 2 return the value at index 0
      return numList;
    }else{
      // Select middle index or close to it as pivot index
      int pivot = numList.size()/2;

      List<Integer> lessThanArr = new ArrayList<>();
      lessThanArr = numList.stream() //Filtering and collecting all the less than values and placing them in the less than list
                      .filter(num -> num < numList.get(pivot))
                      .collect(Collectors.toList());

      List<Integer> greaterThanArr = new ArrayList<>();
      greaterThanArr = numList.stream() //Filtering and collecting all the greater than values and placing them in the greater than list
                          .filter(num -> num > numList.get(pivot))
                          .collect(Collectors.toList());
      

      // System.out.println("Less Than: " + lessThanArr);
      // System.out.println("Greater Than: " + greaterThanArr);

      List<Integer> pivotList = new ArrayList<>();
      pivotList.add(numList.get(pivot));

      return Stream.of(doQuickSort(lessThanArr), pivotList, doQuickSort(greaterThanArr))
                                      .flatMap(Collection::stream)
                                      .collect(Collectors.toList()); //Combining the three lists lessThanList + pivot + moreThanList
    }
  }
  
}
