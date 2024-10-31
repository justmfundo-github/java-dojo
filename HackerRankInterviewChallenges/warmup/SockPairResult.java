package warmup;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class SockPairResult {

    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        Map<Integer, Long> map = ar.stream().collect(Collectors.groupingBy(i -> i, Collectors.counting()) );
        int pairCount = 0;
        for(Long a : map.values()){
            pairCount += a/2;
        }
        return pairCount;
    }

    public static void main(String[] args){
        int n = 7;
        List<Integer> listArr = Arrays.asList(1, 2, 1, 4, 2, 1, 4, 3, 2);
        System.out.println(sockMerchant(n, listArr));
    }

}