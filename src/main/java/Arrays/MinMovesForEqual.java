package Arrays;

//https://leetcode.com/problems/minimum-moves-to-equal-array-elements/description/
public class MinMovesForEqual {

    public static int minMoves(int[] nums) {

        int min = Integer.MAX_VALUE;
        int moves=0;

        for(int i =0; i<nums.length;i++){

            min = Math.min(min,nums[i]);
        }

        for(int i=0; i<nums.length; i++){
            moves += nums[i]-min;
        }

        return moves;

    }

    public static void main(String[] args) {

        int[] nums = {1,2,3};
        int result = minMoves(nums);
        System.out.println(result);

    }
}
