package stack;


import java.util.*;

public class NextGreaterElement{

    public static int[] findNge(int [] arr, int n)
    {
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i=n-1; i>=0; i--)
        {

            while (!stack.isEmpty() && arr[i] > stack.peek())
            {
                stack.pop();
            }

            if(!stack.isEmpty()  && arr[i]<stack.peek()){

                result[i]=stack.peek();
            } else {
                result[i]=-1;
            }

            stack.push(arr[i]);
        }


        return result;

    }



    public static void main(String[] args) {

        int[] arr = {1,3,2,4};
        int n = arr.length;


        // 3,4,4,-1

        int[] result=findNge(arr,n);
        System.out.println(Arrays.toString(result));

    }

}