package stack;
import java.util.*;

public class MinimumDiscount{

    public static List<Integer> list = new ArrayList<>();

    public static int[] getDiscount(int[] arr){

        int n = arr.length;
        int[] result = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int i = n-1 ; i>=0; i--){

            while(!stack.isEmpty() && stack.peek() > arr[i]){

                stack.pop();
            }

            if(!stack.isEmpty() && stack.peek() <= arr[i]){

                int num =  arr[i]-stack.peek();

                result[i]=num;

            }else{
                list.add(i);
                result[i]=arr[i];
            }


            stack.push(arr[i]);


        }

        return result;

    }



    public static void main(String[] args) {

        int[] arr = {5, 4, 5, 1, 3, 3, 8, 2};

        int[] result = getDiscount(arr);

        System.out.println(Arrays.toString(result));

        // Total Discount
        System.out.println(Arrays.stream(result).sum());

        // index of array where there is 0 profit

        list.stream().forEach(v->System.out.print(v));



    }
}
