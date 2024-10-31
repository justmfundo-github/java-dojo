package warmup;

/*
 * An avid hiker keeps meticulous records of their hikes. During the last hike that took exactly n steps, for every step it was noted if it was 
 * an uphill, U, or a downhill, D step. Hikes always start and end at sea level, and each step up or down represents a  unit change in altitude. 
 * We define the following terms:

 * A mountain is a sequence of consecutive steps above sea level, starting with a step up from sea level and ending with a step down to sea level.
 * A valley is a sequence of consecutive steps below sea level, starting with a step down from sea level and ending with a step up to sea level.
 * Given the sequence of up and down steps during a hike, find and print the number of valleys walked through
 */


public class ValleyCountResult {
    public static void main(String[] args){
        int steps = 8;
        String path = "DDUUUUDDDDDDUUUUDDUUUUUUDDDD";
        System.out.println("Number of valleys: " + countingValleys(steps, path));
    }

    public static int countingValleys(int steps, String path) {
        // Write your code here
        int seaLevel = 0;
        int valleyCount = 0;
        for(String a : path.split("")){
            if(a.equalsIgnoreCase("D")){
                
                seaLevel -= 1;

            }else if(a.equalsIgnoreCase("U")){
                seaLevel += 1;
                /* In this case we go up "U". If we go up and the sealevel is above zero, then we are on a mountain. 
                 * If we go up to sea level then we've just come from a valley. Any time we go up to sea level then we've just completed
                 * traversing through a valley and we can then increment the number of valleys traversed. 
                 */
                if(seaLevel == 0){
                    //add 1 to the valley counter
                    valleyCount += 1;
                }
            }
        }
        return valleyCount;
    }
}
