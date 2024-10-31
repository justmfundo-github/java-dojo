public class LongestPalindrome {
  int resultStart;
  int resultLenth;

  public static void main(String[] args) {
    String inputStr = "aedbdeafdcdfaftf";
    LongestPalindrome longPal = new LongestPalindrome();
    System.out.println(longPal.longestPalindrome(inputStr));
  }

  public String longestPalindrome(String str){
    int strLength = str.length();
    if(strLength < 2){
      return str;
    }

    for( int start=0; start < strLength - 1; start++){
      expandRange(str, start, start);
      expandRange(str, start, start + 1);
    }
    return str.substring(resultStart, resultStart + resultLenth);
  }
  private void expandRange(String str, int begin, int end){
    while(begin >= 0 && end < str.length() && str.charAt(begin) == str.charAt(end) ){
      begin--;
      end++;
    }
    if(resultLenth < end -begin -1 ){
      resultStart = begin + 1; 
      resultLenth = end - begin - 1; 
    }
  }
}
