package Arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.lang.Math.max;

public class LongestConsecutiveSubSeq{

    public static void main(String[] args) {

        int[] arr = {12,20,3,11,2,4,8,5};
        //int result = longestConSubSeqUsingMap(arr);
        // System.out.println(result);

        int result = longestConSubSeqUsingHashSet(arr);
        System.out.println(result);


    }

    public  static int longestConSubSeqUsingMap(int[] nums){

        // Iterate over array and put the array in map with value as key

        Map<Integer,Boolean> map = new HashMap<>();

        for(int i=0; i<nums.length;i++){

            map.put(nums[i],true);
        }

        // Iterate over the number and mark it values as false for the value less than that number are present in map key

        for(int i=0; i<nums.length;i++){

            if(map.containsKey(nums[i]-1)){
                map.put(nums[i],false);
            }

        }


        int max=0;

        for(Integer key : map.keySet()){

            if(map.get(key)==true){

                max = max(max,getCount(key,map));
            }

        }
        return max;

    }

    public static int getCount(int k,Map<Integer,Boolean> map){

        int count=0;
        while(map.containsKey(k)){
            count++;
            k++;
        }

        return count;
    }

    public  static int longestConSubSeqUsingHashSet(int[] nums)
    {

        int max=0;

        Set set = new HashSet<>();
        for(int i=0;i< nums.length;i++)
        {
            set.add(nums[i]);

        }

        for(int i=0; i<nums.length; i++)
        {

            if(!set.contains(nums[i]-1))
            {
                int count=0;
                int k = nums[i];
                while(set.contains(k)){
                    count++;
                    k++;
                }
                max = max(count,max);
            }


        }
        return max;
    }

}
