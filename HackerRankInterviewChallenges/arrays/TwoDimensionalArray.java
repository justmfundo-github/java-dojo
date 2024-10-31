package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoDimensionalArray {
  public static void main(String[] args) {
    // int arr2d[][] = {{-9,-9,-9,1,1,1},{0,-9,0,4,3,2},{-9,-9,-9,1,2,3},{0,0,8,6,6,0},{0,0,0,-2,0,0},{0,0,1,2,4,0}};

// 0,-4,-6,0,-7,-6
// -1,-2,-6,-8,-3,-1
// -8,-4,-2,-8,-8,-6
// -3,-1,-2,-5,-7,-4
// -3,-5,-3,-6,-6,-6
// -3,-6,0,-8,-6,-7

    List<List<Integer>> list2d = new ArrayList<>();
    
    list2d.add(new ArrayList<>(Arrays.asList(0,-4,-6,0,-7,-6)));
    list2d.add(new ArrayList<>(Arrays.asList(-1,-2,-6,-8,-3,-1)));
    list2d.add(new ArrayList<>(Arrays.asList(-8,-4,-2,-8,-8,-6)));
    list2d.add(new ArrayList<>(Arrays.asList(-3,-1,-2,-5,-7,-4)));
    list2d.add(new ArrayList<>(Arrays.asList(-3,-5,-3,-6,-6,-6)));
    list2d.add(new ArrayList<>(Arrays.asList(-3,-6,0,-8,-6,-7)));

    // list2d.add(new ArrayList<>(Arrays.asList(-9,-9,-9,1,1,1)));
    // list2d.add(new ArrayList<>(Arrays.asList(0,-9,0,4,3,2)));
    // list2d.add(new ArrayList<>(Arrays.asList(-9,-9,-9,1,2,3)));
    // list2d.add(new ArrayList<>(Arrays.asList(0,0,8,6,6,0)));
    // list2d.add(new ArrayList<>(Arrays.asList(0,0,0,-2,0,0)));
    // list2d.add(new ArrayList<>(Arrays.asList(0,0,1,2,4,0)));

    int largestHourGlassSum = hourglassSum(list2d);
    System.out.println("Largest sum: " + largestHourGlassSum);

    
  }

  private static int hourglassSum(List<List<Integer>> arr) {
    int hourglassSum = Integer.MIN_VALUE;
    int largestHourGlass = Integer.MIN_VALUE;
    for (int i = 0; i < arr.size()-2; i++) {
      for (int j = 0; j < arr.get(i).size()-2; j++) {
        System.out.print(arr.get(i).get(j) + arr.get(i).get(j+1) + arr.get(i).get(j+2) + arr.get(i+1).get(j+1) + arr.get(i+2).get(j) + arr.get(i+2).get(j+1) + arr.get(i+2).get(j+2) + " ");
        hourglassSum = arr.get(i).get(j) + arr.get(i).get(j+1) + arr.get(i).get(j+2) + arr.get(i+1).get(j+1) + arr.get(i+2).get(j) + arr.get(i+2).get(j+1) + arr.get(i+2).get(j+2);
        
        if(hourglassSum > largestHourGlass){
          largestHourGlass = hourglassSum;
        }
      }
      System.out.println("\t\tSum so far: " + largestHourGlass);
      
    }
    return largestHourGlass;
  }
}
