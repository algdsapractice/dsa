package graph.dfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordSearchFromList {

    class TrieNode{

        public boolean isWord = false;
        public TrieNode[] children = new TrieNode[26];
    }

        TrieNode trie = new TrieNode();
        boolean[][] visited ;

    public List<String> findWords(char[][] board , String [] words){
        int row = board.length;
        int col = board[0].length;
        Set<String> result = new HashSet<String>();
        visited = new boolean[row][col];

        for(String word : words){
            insertAWordInTrie(word);
        }
        for(int i = 0; i < row; i++){
            for(int j=0;j<col;j++){
                if(trie.children[board[i][j]-'a']!= null){
                    dfs(board,i,j,trie,"",result);

                }
            }

        }

        return  new LinkedList<>(result);
    }

    private void dfs(char[][] board, int sr, int sc, TrieNode trie, String s, Set<String> result) {
        int row = board.length;
        int col = board[0].length;
        char ch= board[sr][sc];

        if(sr<0 || sc<0|| sc >=row || sc >= col || visited[sr][sc]==true || trie.children[ch]==null){
            return;
        }

        visited[sr][sc]=true;
        trie = trie.children[ch];
        if(trie.isWord){
            result.add(s);
        }

        dfs(board,sr++,sc,trie,s+ch,result);
        dfs(board,sr,sc++,trie,s+ch,result);

        dfs(board,sr--,sc,trie,s+ch,result);

        dfs(board,sr,sc--,trie,s+ch,result);

        visited[sr][sc]=true;

    }

    private void insertAWordInTrie(String word) {
        TrieNode node = trie;

        for(int i = 0; i < word.length();i++){
            char ch = word.charAt(i);

            if(node.children[ch-'a']!=null){
                node.children[ch-'a'] = new TrieNode();
            }
            node = node.children[ch-'a'];
        }

        node.isWord=true;
    }

}
