package slidingwindow;
import java.util.*;
//Longest Substring with maximum K Distinct Characters

// 400 ,map.google.com
// 400 ,mail.google.com
// 200 , mail.yahoo.com

// com ->100


//Given a string, find the length of the longest substring in it with no more than K distinct characters.

//Input: String="araaci", K=2
// a -> 0
// r -> 0
// c -> 1
//Output: 4
//Explanation: The longest substring with no more than '2' distinct characters is "araa".

//Input: String="araaci", K=1
//Output: 2
//Explanation: The longest substring with no more than '1' distinct characters is "aa".


//Input: String="cbbebi", K=3
//Output: 5
//Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".






class LongestSubstringKDistinct {

    public static int findLength(String str, int k) {

        Map<Character,Integer> charFreqMap= new HashMap<>();
        int windowStart =0 ; int maxLength = Integer.MAX_VALUE;
        for(int windowEnd=0 ; windowEnd<str.length();windowEnd++){
                char rightChar = str.charAt(windowEnd);
            charFreqMap.put(rightChar,charFreqMap.getOrDefault(rightChar,0)+1);
            while(charFreqMap.size()>k){
                char leftChar = str.charAt(windowStart);
                charFreqMap.put(leftChar,charFreqMap.get(leftChar)-1);
                if(charFreqMap.get(leftChar)==0){
                    charFreqMap.remove(leftChar);
                }
                windowStart++;
            }
            int lengthOfWindow= windowEnd-windowStart+1;
            maxLength = Math.max(maxLength,lengthOfWindow);

        }

        return maxLength ;

    }











//    public static int findLength(String str, int k) {
//        if (str == null || str.length() == 0)
//            throw new IllegalArgumentException();
//
//        int windowStart = 0, maxLength = 0;
//        Map<Character, Integer> charFrequencyMap = new HashMap<>();
//        // in the following loop we'll try to extend the range [windowStart, windowEnd]
//        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
//            char rightChar = str.charAt(windowEnd);
//            charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);
//            // shrink the sliding window, until we are left with 'k' distinct characters in the frequency map
//            while (charFrequencyMap.size() > k) {
//                char leftChar = str.charAt(windowStart);
//                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
//                if (charFrequencyMap.get(leftChar) == 0) {
//                    charFrequencyMap.remove(leftChar);
//                }
//                windowStart++; // shrink the window
//            }
//            maxLength = Math.max(maxLength, windowEnd - windowStart + 1); // remember the maximum length so far
//        }
//
//        return maxLength;
//    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
    }
}