package Recursion.sequence.get;

import java.util.ArrayList;

public class StairCasePath {

    public static void main(String[] args) {

        int n=5;
        ArrayList<String> paths = getPossibleStairCasePath(n);
        System.out.println(paths);
    }

    private static ArrayList<String> getPossibleStairCasePath(int n) {
        ArrayList<String>  allThePaths= new ArrayList<>();

        if(n==0){
            allThePaths.add("");
            return allThePaths;
        } else if(n<0){

            return allThePaths;
        }


        ArrayList<String> paths1=getPossibleStairCasePath(n-1);
        ArrayList<String> paths2=getPossibleStairCasePath(n-2);
        ArrayList<String> paths3=getPossibleStairCasePath(n-3);

        for (String path1:paths1) {
            allThePaths.add(1+path1);
        }

        for (String path2:paths2) {
            allThePaths.add(2+path2);
        }

        for (String path3:paths3) {
            allThePaths.add(3+path3);
        }
        return allThePaths;
    }
}
