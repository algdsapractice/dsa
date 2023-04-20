package dp;

//-> selection/combination/choices
//-> Optimal solution

// https://www.interviewbit.com/blog/0-1-knapsack-problem/

// capacity -> 40

// values -> [10,20,30,40] ->

// wt -> [30,10,40,20] ->

// 2

//

//[-1,1,2]

//-> 40-> 30

//-> 30,10 -> 10,20-> 30

// -> 10+20-> 20+40 -> 60

// 	w1 > capacity
//		-> not included

// w1 < = capacity

// 		-> include
//		-> not include

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.abs;
import java.util.*;
import java.io.*;
import java.math.*;

public class KnapSack01{

    // Memoisation



    public static int getMaxProfit(int[] wt,int[] prices,int capacity,int n,int[][] dp){

        // base condition

        if(capacity==0 || n==0){
            return 0;
        }

        if(dp[capacity][n]!=-1){
            return dp[capacity][n];
        }
        // choice

        if(wt[n-1] <= capacity){

            return dp[capacity][n]=max (prices[n-1]+getMaxProfit(wt,prices,capacity-wt[n-1],n-1,dp),

                    getMaxProfit(wt,prices,capacity,n-1,dp));

        } else {
            return dp[capacity][n]=getMaxProfit(wt,prices,capacity,n-1,dp);
        }

    }


    public static void main(String[] args) {

        int[] wt = {30,10,40,20};
        int[] prices={10,20,30,40};
        int capacity=40;
        int n= wt.length;
        int[][] dp= new int[capacity+1][n+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        int result=getMaxProfit(wt,prices,capacity,n,dp);
        System.out.println(result);

    }

}
























