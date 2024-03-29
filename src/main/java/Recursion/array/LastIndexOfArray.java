package Recursion.array;

public class LastIndexOfArray {

    public static void main(String[] args) {
        int[] arr = {12,35,98,56,07,98};
        int n = arr.length-1;
        int data = 98;
        int index = getLastIndexOfArray(arr,n,data);
        System.out.println(index);


        int index2= getLastIndexOfArrayIterateFromBegin(arr,n,data);
        System.out.println(index2);

    }

    private static int getLastIndexOfArrayIterateFromBegin(int[] arr, int n, int data) {

        if(arr.length==n){
            return -1;
        }

        int index = getLastIndexOfArrayIterateFromBegin(arr , n+1,data);

        if(index==-1){

            if(arr[n]==data){
                return  n;
            } else{
                return -1;
            }
        } else{
            return index;
        }

    }


    private static int getLastIndexOfArray(int[] arr, int n, int data) {
        if(n==-1){
            return -1;
        }
        if(arr[n]==data){
            return n;
        } else{
            int index= getLastIndexOfArray(arr,n-1,data);
            return index;
        }


    }


}
