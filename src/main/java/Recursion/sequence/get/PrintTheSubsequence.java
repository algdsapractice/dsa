package Recursion.sequence.get;

//  ""
// 2^0 = 1
// a,b,c -> n = 2^n

// "",c , b, a ,bc , ac, ab ,abc

// - - -
// - - c
// - b -
// a - -

// - b c
// a - c
// ab -
// a b c
// Faith
// bc  -> [--, b , c, ,bc ]

// abc -> a , " "

// [--, b , c, ,bc , a, ab , ac, ,abc ]

// abc -> bc -> c-> ""

import java.util.ArrayList;

public class PrintTheSubsequence {


    public static void main(String[] args) {
        String data = "abc";
        ArrayList<String> arrayList =printSubSequence(data);
        System.out.println(arrayList);
    }

    private static ArrayList<String> printSubSequence(String data) {
        ArrayList<String> result = new ArrayList<>();
        if(data.length()==0){
            result.add("");
            return result;
        }
        char firstChar = data.charAt(0);// a
        String remainingString = data.substring(1); // bc
        ArrayList<String>  combination = printSubSequence(remainingString);
        for (String s: combination) {
            result.add("" +s);
            result.add(firstChar +s);
        }

        return  result;
    }

}
