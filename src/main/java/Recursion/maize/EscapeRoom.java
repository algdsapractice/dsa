package Recursion.maize;

//public class Ethos_RCBGT /*
//Problem Statement
//We are in a room and the room contains virus, we need to escape as soon as possible.
// Given a coordinate indicate where our start location in the room coordinate: [x, y] We can move up, down, left, right in each step,
// each step will use exactly one second.
//
//'+' means wall. '.' mains empty space we can pass; You escape the room when you reach a "." on the edge of the grid.
// If there is no solution, return -1. If the starting position is a "+", return -1.

public class EscapeRoom {

    public static void main(String[] args) {
             char[][] room = {
                                 {'+','+','.','+'},
                                 {'+','.','.','+'},
                                 {'+','+','+','.'}
                             };
             int sr=1 , sc=1;
             int time = escape(room,sr,sc);
             System.out.println(time);

    }



    public static int escape(char[][] room, int sr,int sc) {

        boolean[][] visited = new boolean[room.length][room[0].length] ;
        int min_dist= Integer.MAX_VALUE;
        int dist=0;
        if(room[sr][sc]!= '+'){
            int result= escape(room, sr, sc,visited,min_dist,dist);
            if(result!=Integer.MAX_VALUE){
                return result;
            }else {
                return -1;
            }
        } else {
            return -1;
        }

    }

    private static int escape(char[][] room, int sr, int sc,boolean[][] visited, int min_dis , int dist) {

        if(sr==0||sc==0 || room.length-1==sr || room[0].length-1==sc){
            return Math.min(min_dis,dist);
        }

        visited[sr][sc]=true;
        if(isPathValid(room, sr-1, sc, visited)){
            min_dis=escape(room, sr -1, sc,visited,min_dis, dist+1);
        }

        if(isPathValid(room, sr, sc-1, visited)){
            min_dis=escape(room, sr, sc -1,visited,min_dis, dist+1);
        }

        if(isPathValid(room, sr+1, sc, visited)){
           min_dis= escape(room, sr +1, sc,visited,min_dis, dist+1);
        }
        if(isPathValid(room, sr, sc+1, visited)){
            min_dis=escape(room, sr, sc +1,visited,min_dis, dist+1);
        }

        visited[sr][sc]=false;

        return min_dis;
    }

    private static boolean isPathValid(char[][] room, int sr, int sc, boolean[][] visited) {
        if(sr >=0 && sc >= 0 && sc < room[0].length&& sr < room.length&& room[sr][sc] != '+' && visited[sr][sc]==false ){
            return true;
        }else{
            return false;
        }
    }


}
