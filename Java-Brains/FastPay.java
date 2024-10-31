import java.util.HashMap;
import java.util.Map;

public class FastPay{
  public static void main(String[] args) {
    // String input = "ApplesPlumsGrapes";
    // HashMap returnedMap = returnMap(input);
  }

  public static Map<Character, Integer> returnMap(String input){
    Map<Character, Integer> reMap = new HashMap<>();
    
    //Iterate through the string, identify each letter as a key, 
    
    for(int i=0; i<input.length(); i++){
      if(reMap.containsKey(input.charAt(i))){
        reMap.put(input.charAt(i), reMap.get(input.charAt(i))+ 1);
      }else{
        reMap.put(input.charAt(i), 1);
      }
      
    }

    //If I encounter same letter. Increase the value of Integer
    

    System.out.println(reMap);

    return reMap;
  }
}