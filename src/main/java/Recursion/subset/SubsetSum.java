package Recursion.subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// int arr [3,4,5,2], sum =6
// arr[n-1]> sum
// sum 6 -2 => 4

// if(capacity < weight[n]){

//}

// if(capacity >= weight[i])
// include -> capacity - weightp[i]
// exclude -> capacity

// if(sum < arr[n]){

// return set arr, sum , n-1
//}

// if(sum >= arr[i])
// include -> sum - arr[n-1]
// exclude -> sum

// [3,4,5,2]
// 2 -> (6,3)
// 2 -> (4,3)
//

public class SubsetSum {


    // public static boolean subsetSum(int[] arr,int sum, int n,boolean[][] memo){


    // 	if(sum ==0 ){
    // 		return true;
    // 	}

    // 	if(n==0){
    // 		return false;
    // 	}

    // 	if(memo[n][sum]==true){
    // 		return memo[n][sum];
    // 	}

    // 	if(sum < arr[n-1]){

    // 		return memo[n][sum]=subsetSum(arr,sum,n-1,memo);
    // 	}


    // 	if(sum>=arr[n-1]){

    // 		return  memo[n][sum]=(subsetSum(arr,sum,n-1,memo) || subsetSum(arr,sum-arr[n-1],n-1,memo));
    // 	}

    // 	return false;

    // }

    // second approach
    public static List<Integer> getSubsetSum(int[] arr, int sum, int n, List<Integer> g) {
        // Base cases
        if (sum == 0) {
            return g;
        }
        if (n == 0 && sum != 0) {
            return null;
        }

        // If last element is greater than sum, ignore it
        if (arr[n-1] > sum) {
            return getSubsetSum(arr, sum, n-1, g);
        }

        // Check if sum can be obtained by including or excluding the last element
        List<Integer> subset = getSubsetSum(arr, sum, n-1, g);
        if (subset != null) {
            return subset;
        }
        List<Integer> newG = new ArrayList<Integer>(g);
        newG.add(arr[n-1]);
        subset = getSubsetSum(arr, sum-arr[n-1], n-1, newG);
        if (subset != null) {
            return subset;
        }
        return null;
    }


    public static List<Integer> subsetSum(int[] arr,int sum, int n){



        if(sum ==0){
            return new ArrayList<>();
        }

        if(sum !=0 && n==0){
            return null;
        }



        if(sum < arr[n-1]){

            return subsetSum(arr,sum,n-1);
        }

        List<Integer> result = subsetSum(arr,sum,n-1);

        if(result!=null){
            return result;
        }

        result = subsetSum(arr,sum-arr[n-1],n-1);

        if(result!=null){
            result.add(arr[n-1]);
            return result;
        }




        return null;

    }


    public static void main(String[] args) {
        int[] arr= {3,4,5, 2};
        int sum=6;
        int n = arr.length;
        boolean[][] memo = new boolean[n+1][sum+1];
        Arrays.stream(memo).forEach(s -> Arrays.fill(s,false));
        // boolean res=subsetSum(arr,sum,n,memo);
        // System.out.println();
        // System.out.println(res);

        List<Integer> list = new ArrayList<>();
        List<Integer> result=subsetSum(arr,sum,n);

        System.out.println(result);
    }


}