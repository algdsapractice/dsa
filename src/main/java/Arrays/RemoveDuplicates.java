package Arrays;

import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {

        int arr[] = {9,4,5,1,3,9,5,4,5,6,7};
        int arr2[] = {9,4,5,1,3,9,5,4,5,6,7};
        System.out.println("Numbers before sorting");
        System.out.println(Arrays.toString(arr));
        int n = arr.length;
        Arrays.sort(arr);
        Arrays.sort(arr2);
        System.out.println("Numbers after sorting");
        System.out.println(Arrays.toString(arr));

        int length= removeDuplicates(arr, n);
        System.out.println("Unique numbers with n memory");
        for (int i=0; i<length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        int length1 = removeDuplicatesInPlace(arr2, n);
        System.out.println("Unique numbers with in memory");
        for (int i=0; i<length1;i++){
            System.out.print(arr2[i]+" ");
        }

    }

    private static int removeDuplicatesInPlace(int[] arr2, int n) {
        int j=0;
        for(int i=0;i<n-1;i++){
            if(arr2[i]!=arr2[i+1]){
                arr2[j++] = arr2[i];
            }
        }
        arr2[j++] = arr2[n-1];
        return j;
    }

    private static int removeDuplicates(int[] arr, int n) {

        if (n==0 || n==1){
            return n;
        }
        int j =0;
        int[] temp = new int[n];

        for (int i=0; i < n-1; i++) {
            if(arr[i]!=arr[i+1]){
                temp[j++]=arr[i];
            }
        }
        temp[j++] = arr[n-1];

        for (int i=0; i < j; i++) {
            arr[i] = temp[i];
        }
        System.out.println("Temp Array");
        System.out.println(Arrays.toString(temp));

        return j;
    }
}
