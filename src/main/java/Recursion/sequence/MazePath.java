package Recursion.sequence;

import java.util.ArrayList;

public class MazePath {

    public static void main(String[] args) {
        int destinationRow=3;
        int destinationColumn=3;
        int sourceRow=1;
        int sourceColumn=1;

        ArrayList<String> paths = getAllPossibleMazePaths(sourceRow,sourceColumn,destinationRow,destinationColumn);
        System.out.println(paths);
    }

    private static ArrayList<String> getAllPossibleMazePaths(int sourceRow, int sourceColumn, int destinationRow, int destinationColumn) {
        ArrayList<String> allPossiblePaths = new ArrayList<>();
        ArrayList<String> horizontalPaths= new ArrayList<>();
        ArrayList<String> verticalPaths=new ArrayList<>();

        if(sourceRow==destinationRow && sourceColumn==destinationColumn){
            allPossiblePaths.add("");
            return  allPossiblePaths;
        }

        if(sourceColumn<destinationColumn ){
            horizontalPaths=getAllPossibleMazePaths(sourceRow,sourceColumn+1,destinationRow,destinationColumn);// horizontal movement
        }
        if(sourceRow<destinationRow){
            verticalPaths=getAllPossibleMazePaths(sourceRow+1,sourceColumn,destinationRow,destinationColumn);// vertical movement

        }

        for (String horizontalPath:horizontalPaths) {
            allPossiblePaths.add("h"+horizontalPath);
        }

        for (String verticalPath:verticalPaths) {
            allPossiblePaths.add("v"+verticalPath);
        }


        return  allPossiblePaths;


    }





}
