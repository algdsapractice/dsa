package patterns.intervals;

import java.util.*;
///Merge Intervals

// Non overlapping intervals
// [1,3] [6,9] i1.end < i2.start
// [5,8][2,4] i2.end < i1.start -> not required after sorting since its first criteria

/// After sorting
// [2,4][5,8]

//Over lapping intervals

// start time as it is and End time which is maximum of both intervals

//[1,4] [2,3] i2 is in between i1 -> [1,4]
//[1,4] [2,6] i2.end > i1.end -> [1,6]

//[1,3][2,5]  i1 is in between i2 -> [1,5]
//[2,4] [1,3] i1.end > i2.end -> not required after sorting since its first 3 criteria


//Input: intervals = [[1,3],[2,6],[15,18],[8,10]]
//Output: [[1,6],[8,10],[15,18]]

import java.util.*;

public class MergeIntervals{

    public static int[][] mergeInterval(int[][] intervals){


        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        System.out.println("After Sorting");
        System.out.println(Arrays.deepToString(intervals));
        LinkedList<int[] > bagIntervals = new LinkedList<>();

        for(int[] interval:intervals){

            // Non OverLapping Intervals

            if(bagIntervals.isEmpty() || bagIntervals.getLast()[1] < interval[0]){
                bagIntervals.addLast(interval);
            }else{

                bagIntervals.getLast()[1] = Math.max(bagIntervals.getLast()[1],interval[1]);

            }

        }

        return bagIntervals.toArray(new int[bagIntervals.size()][]);


    }

    public static void main(String[] args) {


        int[][] intervals = {{1,3},{2,6},{15,18},{8,10}};
        System.out.println("Question Array");
        System.out.println(Arrays.deepToString(intervals));


        int[][] mergedIntervals=mergeInterval(intervals);
        System.out.println("Merged Array");

        System.out.println(Arrays.deepToString(mergedIntervals));

    }


}