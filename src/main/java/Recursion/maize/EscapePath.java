package Recursion.maize;

public class EscapePath {
    public static void main(String[] args) {
        char[][] room = {
                {'+','+','.','+'},
                {'.','.','.','+'},
                {'+','+','+','.'}
        };
        int sr=1 , sc=2;

        boolean[][]  visited = new boolean[room.length][room[0].length];
        String ans ="";
        escapePath(room,sr,sc,ans,visited);

    }

    private static void escapePath(char[][] room, int sr, int sc, String ans, boolean[][] visited) {

        if(sr<0 || sc <0 || sr> room.length || sc > room[0].length || room[sr][sc]== '+' || visited[sr][sc]==true ){
            return;
        }

        if(sr==room.length-1 || sc==room[0].length-1 || sc==0 || sr==0){
            System.out.println(ans);
        }

        visited[sr][sc]=true;
        escapePath(room,sr-1,sc,ans+"t",visited);
        escapePath(room,sr,sc-1,ans+"l",visited);
        escapePath(room,sr+1,sc,ans+"d",visited);
        escapePath(room,sr,sc+1,ans+"r",visited);
        visited[sr][sc]=false;
    }


}
