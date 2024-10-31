package warmup;

import java.util.Arrays;
import java.util.List;

public class CloudJumpingResults {
    public static void main(String[] args){
        //List<Integer> clouds = Arrays.asList(0, 0, 1, 0, 0, 1, 0, 1); // 0 0 1 0 0 1 0  // 0 0 0 0 1 0
        // List<Integer> clouds = Arrays.asList(0, 0, 1, 0, 0, 1, 0);
        List<Integer> clouds = Arrays.asList(0, 0, 0, 0, 1, 0);
        System.out.println(jumpingOnClouds(clouds));
    }

    public static int jumpingOnClouds(List<Integer> c) {
        // Write your code here
        int numOfMoves = 0;
        Integer[] cloudArr = new Integer[c.size()]; 
        c.toArray(cloudArr);
        // we don't need to iterate the entire array because we will jump ahead sometimes.... 
        // so a do while loop makes more sense here because the game is always winnable
        // 0, 0, 1, 0, 0, 1, 0, 1
        // 0, 1, 0, 0, 0, 1, 0, 0
        int i = 0; 
        do {
            // if(i==cloudArr.length-1 || )break;
            //if two moves is not greater than the array or lands on a 1... then make two moves
            //and increment the number of moves
            if((i <= cloudArr.length-3) && (!cloudArr[i+2].equals(1))){
                i +=2; 
                numOfMoves +=1;

            }else if( (i <= cloudArr.length-2) && (!cloudArr[i+1].equals(1))){ // else make one move and increment the number of moves
                i += 1;
                numOfMoves += 1;
            }else{
                break;
            }
        } while (i<cloudArr.length );

        
        return numOfMoves;
    }
}
