package Recursion.sequence.get;

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/


// 2-> abc
// 3-> def
// 6 -> mno

// 3 , 6

// [dm, dn ,do, em , en , eo, fm,fn,fo ]

import java.util.ArrayList;
import java.util.List;

public class PhoneNumberComb {

    public static void main(String[] args) {
        String digits = "236";
        letterCombinations(digits);

    }


    static String[] letters = {" ", "", "abc", "def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public static List<String> letterCombinations(String digits) {
        //236
        List<String> resultString = new ArrayList<>();


        if(digits.length()==0){
            resultString.add("");
            return resultString;
        }
        Character firstChar = digits.charAt(0); //2
        String remainingString = digits.substring(1); // 36

        List<String> combinations = letterCombinations(remainingString);

         String lettersOnPhone = letters[Integer.parseInt(firstChar.toString())]; //abc

         for(int i=0 ; i<lettersOnPhone.length();i++){

             char firstCharOnMobile = lettersOnPhone.charAt(i); //a

             for (String s: combinations) {
                 resultString.add(firstCharOnMobile+s);
             }

         }
        System.out.println(resultString);
        return resultString;

    }
}
