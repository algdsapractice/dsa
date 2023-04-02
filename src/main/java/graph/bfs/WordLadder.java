package graph.bfs;

import java.util.*;

public class WordLadder {

    public static void main(String[] args) {

       String beginWord = "hit", endWord = "cog";
       String [] words = {"hot","dot","dog","lot","log","cog"};
        List<String>   wordList = Arrays.asList(words);
        int length = getLadderLength(beginWord,endWord,wordList);
        System.out.println(length);
    }

    private static int getLadderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)){
            return 0;

        }
        HashMap<String,Boolean> vMap= new HashMap<String,Boolean>();

        for(String word : wordList){
            vMap.put(word,false);
        }

        Queue queue = new LinkedList<String>();
        int length=1;
        queue.add(beginWord);
        vMap.put(beginWord,true);
        
        while(!queue.isEmpty()){
                for(int i =0 ; i<queue.size();i++){
                    String word = (String) queue.poll();
                    if(word.equals(endWord)){
                        return length;
                    }
                    wordMatch(word,vMap,queue);
                }
               length++;
        }

        return 0;
    }

    private static void wordMatch(String word, HashMap<String,
            Boolean> vMap, Queue queue) {

        for (int i=0;i<word.length();i++){
            char[] chars = word.toCharArray();
            for(int j =0 ; j<26 ; j++){
                char c = (char) ('a'+j);
                chars[i]=c;
                String s = String.valueOf(chars);

                if(vMap.containsKey(s)&&vMap.get(s)==false){
                    queue.add(s);
                    vMap.put(s,true);
                }
            }
        }
    }


}
