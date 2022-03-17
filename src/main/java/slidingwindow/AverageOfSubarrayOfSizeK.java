package slidingwindow;

//Given an array, find the average of all subarrays of ‘K’ contiguous elements in it.

import java.util.Arrays;

// int i =9;


//Given an array of positive numbers and a positive number ‘k,’
// find the maximum sum of any contiguous subarray of size ‘k’.

//Input: [2, 1, 5, 1, 3, 2], k=3
//Output: 9
//Explanation: Subarray with maximum sum is [5, 1, 3].
//sum = 0, maxsum = -10000
//for(int windowEnd=0 ; windowEnd<n; windowEnd++){
//    sum+= arr[windowEnd];
//
//    if(windowEnd<k-1){
//        maxsum = Math.max(sum,maxsum);
//        sum -= arr[windowStart];
//        windowstart++
//        }
//
//}
//
//return maxsum;

//Array: [1, 3, 2, 6, -1, 4, 1, 8, 2], K=5

// i =0 , K =5
// j = 0, 1 ,2 , 3 ,4
// [2.2,4.5,]
//9
public class AverageOfSubarrayOfSizeK {


    /*public static double[] findAverages(int k, int[] arr){

        int n = arr.length;
        System.out.println("length"+n);
        double[] average = new double[n-k+1];
        for(int i=0;i<=n-k;i++){
            double sum =0;
            for(int j=i ; j<i+k;j++ ) {
                sum=arr[j]+sum;
            }
            average[i]= sum/k;
        }
        return average;
    }*/



    public static double[] findAverages(int k, int[] arr){

        int n = arr.length;

        double[] average = new double[n-k+1];

        int windowStart=0;
        double sum =0;
        for(int windowEnd =0;windowEnd<=n;windowEnd++){

            sum += arr[windowEnd];
            if(windowEnd>=k-1){
                average[windowStart]=sum/k;
                sum -= arr[windowStart];
                windowStart++;
            }

        }
        return average;
    }


    public static void main(String[] args) {
        double[] result = AverageOfSubarrayOfSizeK.findAverages(5, new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 });
        System.out.println("Averages of subarrays of size K: " + Arrays.toString(result));
    }

}
