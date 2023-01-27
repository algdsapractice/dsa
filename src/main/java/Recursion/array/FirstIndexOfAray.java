package Recursion.array;


// 98

// 12,35,98,56,07,98;

// 98

// -1 , 4

//Expectation
// f(arr , 0, data) -> index

//Faith
//  f(arr , 1, data) -> index


// Solution

// F -> E

//f(arr , 0, data)


// f(arr , 1, data) ->

// if( arr[0] == dataa)
//    0
//   index


public class FirstIndexOfAray {
    public static void main(String[] args) {
        int[] arr = {12,35,98,56,07,98};
        int n = 0;
        int data = 98;
//        int firstIndex = getFirstIndexHeadRecursion(arr,0,data);
        int firstIndex = getFirstIndexTailRecursion(arr,0,data);
        System.out.println(firstIndex);
    }

    // This might not be the best approach since we are returning the indexes at the end after traversing the complete array
    private static int getFirstIndexHeadRecursion(int[] arr, int n, int data) {

        if(arr.length==n){
            return -1;
        }
        int index = getFirstIndexHeadRecursion(arr,n+1, data); // line 1

        if(arr[n]==data){   // line 2
            return n;       // line 3
        } else{
            return index;   // line 4
        }
    }

    // This approach is better than tail recursion since we get the index while going up
    private static int getFirstIndexTailRecursion(int[] arr, int n, int data) {

        if(arr.length==n){
            return -1;
        }

        if(arr[n]==data){
            return n;
        } else{
            int index = getFirstIndexTailRecursion(arr,n+1, data);
            return index;
        }
    }
}
