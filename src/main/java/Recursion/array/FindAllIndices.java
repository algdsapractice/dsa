package Recursion.array;


// 12,35,98,56,07,98

import java.util.Arrays;

public class FindAllIndices {

    public static void main(String[] args) {
        int[] arr = {12,35,98,56,07,98};
        int n = 0;
        int data = 98;
        int counter=0;
        int[] indices = getAllIndices(arr,n,data,counter);
        System.out.println(Arrays.toString(indices));

    }

    private static int[] getAllIndices(int[] arr, int n, int data, int counter) {

        if(arr.length==n){
            int[] resultArray = new int[counter];
            return resultArray;

        }
        if(arr[n]==data){
            int[] resultArray = getAllIndices(arr,n+1, data, counter+1 );
            resultArray[counter]=n;
            return resultArray;
        }
        else{
            int[] resultArray =  getAllIndices(arr,n+1, data, counter);
            return resultArray;
        }


    }
}
