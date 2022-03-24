package slidingwindow;

import java.util.HashMap;
import java.util.Map;

///Given a string with lowercase letters only,
// if you are allowed to replace no more than k letters with any letter,
// find the length of the longest substring
// having the same letters after replacement.

//Input: String="aabccbb", k=2
//Output: 5
// K =2
// 5 - 3 > 2
//a -> 0
// k-> 1
// j -> 1
//aaakdafoaaaaaa
// 6
// 10
// 14
public class CharacterReplacement {

    public static int findLength(String str, int k) {
        Map<Character,Integer> chFrMap = new HashMap<>();
        int maxRep= Integer.MIN_VALUE;
        int maxWindowLength= Integer.MIN_VALUE;
        int windowStart=0;
        for(int windowEnd =0 ; windowEnd<str.length();windowEnd++){
            Character rightChar = str.charAt(windowEnd);
            chFrMap.put(rightChar,chFrMap.getOrDefault(rightChar,0)+1);
            maxRep=Math.max(maxRep,chFrMap.get(rightChar));
            int windowLength = windowEnd- windowStart+1;
            // shrink condition for window
            if(windowLength-maxRep>k){
                Character leftChar= str.charAt(windowStart);
                chFrMap.put(leftChar,chFrMap.get(leftChar)-1);
                windowStart++;

            }
            maxWindowLength = Math.max(maxWindowLength,windowLength);

        }
        return maxWindowLength;
    }

    public static void main(String[] args) {
        System.out.println(CharacterReplacement.findLength("aabccbb", 2));
        System.out.println(CharacterReplacement.findLength("abbcb", 1));
        System.out.println(CharacterReplacement.findLength("abccde", 1));
    }
}
