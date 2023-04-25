package dp.knapsack;

// Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
//Output: True
import java.util.*;

public class SubSetSum{


    public static boolean subsetSum(int[] arr,int sum){

        boolean[][] dp =  new boolean[arr.length+1][sum+1];

        for(int i =0;i<=arr.length;i++){

            dp[i][0]= true;
        }

        for(int j=1 ; j<=sum;j++){
            dp[0][j]=false;

        }

        for(int i =1; i<=arr.length;i++){

            for(int j =1 ; j<=sum; j++){

                if(dp[i-1][j]==true)
                {
                    dp[i][j]=true;
                }
                else
                {
                    if(arr[i-1]<j){

                        dp[i][j]=dp[i-1][j-arr[i-1]];
                    }
                    else if(arr[i-1]==j)
                    {
                        dp[i][j]=true;

                    } else{
                        dp[i][j]=false;

                    }

                }



            }
        }

        // System.out.println(Arrays.deepToString(dp));

        for(boolean[] num : dp){
            System.out.println();

            for(boolean data: num){

                System.out.print(data+" ");
            }
        }

        return dp[arr.length][sum];


    }


    public static void main(String[] args) {
        int[] arr= {3,4,5, 2};
        int sum=6;
        boolean res=subsetSum(arr,sum);
        System.out.println();
        System.out.println(res);
    }


}