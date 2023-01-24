package Recursion;

public class PrintArrayData {

        //12,69,22,98,23,45


        public static void print(int[] a, int size) {
            if (size==-1) return;
            print(a, size-1);
            System.out.println(a [size]);

        }

        public static void main(String[] args) {
            // TODO Auto-generated method stub

            int[] a= {12,69,22,98,23,45};

            print(a,a.length-1);
        }

}

