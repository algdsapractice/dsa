package Recursion.patterns;

public class MaxScoreWords {
    public static void main(String[] args) {
        String [] words = {"dog","cat","dad","good"};
        char[] letters = {'a','b','c','d','d','d','g','o','o'};
        int [] score= {1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
        int index=0;
        // converting characters to frequency

        int [] frequency = new int[score.length];
        for(char ch : letters){
            frequency[ch - 'a']++;
//            System.out.println("position");
//            System.out.println(ch - 'a');
//            System.out.println("fr");
//            System.out.println(frequency[ch - 'a']);
        }
        //System.out.println(freq.length);

        int result = findMaxWord(words,frequency,score,index);

        System.out.println(result);

    }

    private static int findMaxWord(String[] words, int[] frequency, int[] score, int index) {

        if(index==words.length){
            return 0;
        }


        // not included
        int scoreNotIncluded=0+findMaxWord(words,frequency,score,index+1);

        // included

        int wordScore =0;
        int scoreIncluded = 0;
        String word = words[index];
        boolean toBeIncluded= true;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int frequencyIndex= ch-'a';
            if(frequency[frequencyIndex]<0){
                toBeIncluded=false;
            }
            frequency[frequencyIndex]--;
            wordScore += frequency[frequencyIndex];
        }

        if(toBeIncluded){
            scoreIncluded = wordScore+findMaxWord(words,frequency,score,index+1);
        }

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int frequencyIndex= ch-'a';
            frequency[frequencyIndex]++;
        }

        return  Math.max(scoreNotIncluded,scoreIncluded);
    }
}
