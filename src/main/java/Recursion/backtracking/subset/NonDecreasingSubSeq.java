package Recursion.backtracking.subset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/non-decreasing-subsequences/
public class NonDecreasingSubSeq {


    public static void main(String[] args) {

        int[] nums = {4,6,7,7};
        List<List<Integer>> result = getSubSequence(nums);
        System.out.println(result);
    }

    private static List<List<Integer>> getSubSequence(int[] nums) {
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        List<Integer> bag = new ArrayList<>();
        int index=0;
        findSubSequence(nums,index,bag,result);

        return new ArrayList<>(result);

    }

    private static void findSubSequence(int[] nums, int index, List<Integer> bag, Set<List<Integer>> result) {

        if(nums.length==index){
            if(bag.size()>=2){
                result.add(new ArrayList<>(bag));
            }
            return ;
        }

        //  lastIndexOfBag=bag.size()-1;
        if(bag.isEmpty() || bag.get(bag.size()-1)<=nums[index]){

            bag.add(nums[index]);
            findSubSequence(nums,index+1,bag,result);
            bag.remove(bag.size()-1);

        }

        findSubSequence(nums,index+1,bag,result);




    }
}
