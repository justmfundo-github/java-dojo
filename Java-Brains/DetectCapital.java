public class DetectCapital {


  public boolean detectCapitalUse(String word){
    int numberOfCapitals = 0;
    for(int i=0; i < word.length(); i++){
      if(Character.isUpperCase(word.charAt(i))){
        numberOfCapitals++;
      }
    }
    if(numberOfCapitals == word.length() || numberOfCapitals == 0){
      return true;
    } 
    return numberOfCapitals == 1 && Character.isUpperCase(word.charAt(0));
  }
  
}
