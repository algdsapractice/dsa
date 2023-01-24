package Recursion;

public class MaxArray {
    // 112,69,22,98,23,45 -> max(int arr[], n) -> 98
    // 12,69,22,98,23,45

    // 12 -> 98


    // if( n > (n+1) ) {
    // return n

    // faith -> max(arr,n+1) -> max

    // -> Solution -> FE
    // max(arr,n+1) -> max
    //if(max>[arr[n]]){
    // return max} else{
    //} return []
    //

    public static int max=0;
    public static int findMax(int[] arr, int size) {

        if(size==arr.length-1){
            return arr[size];
        }

            int max = findMax(arr,size+1); // line1
            if(max>arr[size]){
                return max; // line 2
            }
            else {
                return arr[size]; //line 3
            }

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[] a= {12,69,22,98,23,45};
        int n =0;
        int max = findMax(a,n);
        System.out.println(max);
    }
}