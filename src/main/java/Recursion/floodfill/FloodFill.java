package Recursion.floodfill;

import java.util.Arrays;

//https://leetcode.com/problems/flood-fill/
public class FloodFill {

    public static void main(String[] args) {
        int[][] image = {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };

        int sr =1, sc=1, color=2;

        int [][] result= floodFill(image,sr,sc,color);

        System.out.println(Arrays.deepToString(result));

    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {


        if (image[sr][sc] != color) {
            floodFill(image, sr, sc, color, image[sr][sc]);
        }
        return image;

    }

    private static void floodFill(int[][] image, int sr, int sc, int oldColor, int color) {
        if(sr>=image.length || sc>=image[0].length || sr<0 || sc<0 || image[sr][sc]!=color){
            return;
        }

        image[sr][sc]=oldColor;
        floodFill(image,sr+1,sc,oldColor,color);// top
        floodFill(image,sr,sc-1,oldColor,color); // left
        floodFill(image,sr-1,sc,oldColor,color); // down
        floodFill(image,sr,sc+1,oldColor,color); // right
    }
}
