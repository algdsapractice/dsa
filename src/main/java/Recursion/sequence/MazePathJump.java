package Recursion.sequence;

import java.util.ArrayList;

public class MazePathJump {

    public static void main(String[] args) {

        int sr=1;
        int sc=1;
        int dr=4;
        int dc=4;

        ArrayList<String> paths = getMazePathWithJumps(sr,sc,dr,dc);
        System.out.println(paths);

    }

    private static ArrayList<String> getMazePathWithJumps(int sr, int sc, int dr, int dc) {
        ArrayList<String> allPossiblePaths = new ArrayList<>();
        ArrayList<String> horizontalPaths;
        ArrayList<String> verticalPaths;
        ArrayList<String> diagonalPaths;


        if(sr==dr && sc==dc){
            allPossiblePaths.add("");
            return allPossiblePaths;
        }

        // horizontal movement

        for(int step=1 ; step <= dc-sc; step++) {
            horizontalPaths = getMazePathWithJumps(sr, sc + step, dr, dc);

            for (String hpath : horizontalPaths) {
                allPossiblePaths.add("h" + step+hpath);
            }
        }
        // vertical
        for(int step=1 ; step <= dr-sr; step++) {
            verticalPaths = getMazePathWithJumps(sr+step, sc , dr, dc);

            for (String vpath : verticalPaths) {
                allPossiblePaths.add("v" + step+vpath);
            }
        }

        //diagonal
        for(int step=1 ; step <= dr-sr && step <= dc-sc; step++) {
            diagonalPaths = getMazePathWithJumps(sr+step, sc+step , dr, dc);

            for (String dpath : diagonalPaths) {
                allPossiblePaths.add("d" + step+dpath);
            }
        }

        return allPossiblePaths;

    }
}
