/*
 * Write a function to convert integer to roman numerals
 * Do I need to cater for negative numbers? No
 * 
 */

public class IntegerToRomanNumeral {

  public static void main(String[] args) {
    int num = 501;
    System.out.println("Roman numeral of: " + num + " is:" + intToRoman(num));
  }
  

  public static String  intToRoman(int num){
    String[] thousands = {" " , "M", "MM", "MMM"};
    String[] hundreds = {" ", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String[] tens = {" " , "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String[] units = {" ", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    
    return thousands[num/1000] + hundreds[(num % 1000) / 100] + tens[(num % 100) /10] + units[num % 10];
  }
}
