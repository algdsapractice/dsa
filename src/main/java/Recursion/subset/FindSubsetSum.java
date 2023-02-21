package Recursion.subset;

public class FindSubsetSum {

    public static void main(String[] args) {

        int[] arr = {5,2,3,5};
        int targetSum = 10;
        getTheTargetSum(arr,targetSum);
        //System.out.println(pairs);
    }

    private static void getTheTargetSum(int[] arr, int targetSum) {
        int idx=0;
        int sum =0;
        String set =" ";
        getTheTargetSum(arr,idx,"",sum,targetSum);
    }

    private static void getTheTargetSum(int[] arr,int idx , String set,  int sum,int targetSum) {

        if(arr.length==idx ){
            if( targetSum==sum){
                System.out.println(set+".");
            }
            return ;

        }

       getTheTargetSum(arr,idx+1,set+arr[idx]+ ", ",sum+arr[idx],targetSum);
        getTheTargetSum(arr,idx+1,set,sum,targetSum);


    }


}
