package graph.dfs;

import java.util.ArrayList;
import java.util.Arrays;

public class ConsecutiveDifference {

    public static void main(String[] args) {

        int n =3;
        int k =7;

       int[] res= numsSameConsecDiff(3,7);

        Arrays.stream(res).forEach(System.out::println);
    }

    public static int[] numsSameConsecDiff(int n, int k) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        int no_of_digit = 0;
        if(n==1){
            return new int[]{1,2,3,4,5,6,7,8,9};
        }

        for (int i=1; i<10; i++) {
            dfs(n, k,i,no_of_digit,i,result);
        }

        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++) {
                answer[i] = result.get(i).intValue();
        }

        return answer;
    }

    private static void dfs(int n, int k, int current, int no_of_digit,
                     int prev, ArrayList<Integer> result) {


        if(n-1==no_of_digit){
            result.add(current);
            return;
        }

        int next = prev+k;
        if(next<10) {
            dfs(n, k, (current*10) + next, no_of_digit + 1, next, result);
        }


        next = prev-k;
        if(next>=0) {
            dfs(n, k, (current*10) + next, no_of_digit + 1, next, result);
        }


    }
}
