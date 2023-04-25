package dp.knapsack;

import static java.lang.Math.max;


public class TabKnapSack01{


    public static int getMaxProfit(int[] wt,int[] prices,int capacity,int n)
    {

        int[][] dp = new int[n+1][capacity+1];


        for(int i =0; i<=n;i++)
        {
            for(int j=0; j<=capacity ; j++)
            {
                if(j==0 || i==0)
                {
                    dp[i][j]=0;
                }
                else if(wt[i-1] <= j)
                {

                    dp[i][j]=max(prices[i-1]+dp[i-1][j-wt[i-1]],dp[i-1][j]);
                }
                else
                {
                    dp[i][j]=dp[i-1][j];
                }
            }

        }
        return dp[n][capacity];
    }

    public static void main(String[] args)
    {

        int[] wt = {2,5,1,3,4};
        int[] prices={15,14,10,45,30};
        int capacity=7;

        int n= wt.length;

        int result=getMaxProfit(wt,prices,capacity,n);
        System.out.println(result);

    }

}
