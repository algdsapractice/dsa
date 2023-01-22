package BinarySearch;

public class Sqrt   {


    // 1 2 3 4
    //
    //
    public static int square_root(int n) {
        if (n == 0) return 0;
        int left = 1;
        int right = n;
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid <= n / mid) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    // Driver code
    public static void main(String[] args) {
        System.out.println("Square root :" + Sqrt.square_root(4));
        System.out.println("Square root :" + Sqrt.square_root(8));
        System.out.println("Square root :" + Sqrt.square_root(100000));
    }
}