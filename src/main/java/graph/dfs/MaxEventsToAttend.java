package graph.dfs;

import java.util.Arrays;

//{{1,2,4},
// {3,4,3},
// {2,3,10}
// };

public class MaxEventsToAttend {

    public static int maxValue(int [][] events, int k){
        Arrays.sort(events,(arr1,arr2) -> arr1[0]-arr2[1]);
        int [][] memo = new int[k+1][events.length];
        return dfs(events,k,0,memo);

    }

    private static int dfs(int[][] events, int k, int idx,int [][] memo) {
        if(k==1){
            int max=0;
            while(idx<events.length) max= Math.max(max,events[idx++][2]);
            return max;

        }

        if(memo[k][idx]!=0) return memo[k][idx];

        int ret =0;

        for(int i=0;i<events.length;i++){

            // if I attend the i the event them the values

            int value = events[i][2];

            for(int j=i+1;j< events.length;j++){

                if(events[j][0] > events[i][1]){

                    ret = Math.max(ret,value+dfs(events,k-1,j,memo));
                }
            }

            ret = Math.max(ret,value);
        }
        return memo[k][idx]=ret;
    }

    public static void main(String[] args) {
        int [][] events = {{1,2,4},{3,4,3},{2,3,10}};
        int k = 2;

       int count = maxValue(events,k);
        System.out.println(count);
    }
}
