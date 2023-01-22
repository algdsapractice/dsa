package Recursion;

//public class Ethos_RCBGT /*
//Problem Statement
//We are in a room and the room contains virus, we need to escape as soon as possible. Given a coordinate indicate where our start location in the room coordinate: [x, y] We can move up, down, left, right in each step, each step will use exactly one second.
//
//Input:
//
//Room :
//
//   [ ["+","+",".","+"],
//
//     [".",".",".","+"],
//
//     ["+","+","+","."] ]
//
//start coordinate [1,2]
//
//'+' means wall. '.' mains empty space we can pass; You escape the room when you reach a "." on the edge of the grid. If there is no solution, return -1. If the starting poisition is a "+", return -1.
//
//
//min steps/ seconds
//
//if can escape : seconds
//no : -1
//
//[]
//
//
//// n-1_
//
//
// */
//
//class Solution {
//
//    static int counter =0;
//
//    // public static void main(String[] args) {
//    //   ArrayList<String> strings = new ArrayList<String>();
//    //   strings.add("Hello, World!");
//    //   strings.add("Welcome to CoderPad.");
//    //   strings.add("This pad is running Java " + Runtime.version().feature());
//
//    //   for (String string : strings) {
//    //     System.out.println(string);
//    //   }
//
//    // }
//
//    public static void main(String args[]) {
//
//        char[][] room = {
//                {'+','+','.','+'},
//                {'.','.','.','+'},
//                {'+','+','+','.'}
//        };
//
//        int[] coord = {2,3};
//        int x= 2;
//        int y=3;
//        escape(room,x,y);
//
//    }
//
//    public static int escape(char[][] room, int x,int y) {
//        //return -1;
//
//
//
//        char ch = room[x][y];
//        int x_length = room[x].length;
//        int y_length = room[y].length;
//
//
//
//        if(y_length==y || y<0){
//            return -1;
//        }
//
//        if(ch=='+'){
//            return -1;
//        }
//
//        // return counter++;
//
//        if(x_length==x)
//        {
//            return -1;
//        } else if {
//            return escape(room,x+1, y);
//        }
//
//        if(x_length==y)
//        {
//            return -1;
//        }else
//        {
//            return escape(room,x,y+1);
//        }
//
//        if(x<0){
//            return -1;
//        } else {
//            return  escape(room,x-1, y);
//        }
//        return escape(room,x,y-1);
//
//    }
//}{
//}
