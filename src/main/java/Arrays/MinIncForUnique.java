package Arrays;

import java.util.Arrays;

public class MinIncForUnique {




    public static void main(String[] args) {
        int[] nums = {3,2,1,2,1,7};

       int count = getIncrementStep(nums);
        System.out.println(count);

    }

    private static int getIncrementStep(int[] nums) {

        Arrays.sort(nums);
        int total = 0;
        for(int i = 1; i < nums.length; i++){
            int current = nums[i];
            int previous = nums[i-1];
            if(current<=previous){
                int newValue=previous+1;
                    total+=newValue-nums[i];
                   nums[i] = newValue;
            }


        }

        return  total;
    }
}
