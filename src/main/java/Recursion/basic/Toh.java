package Recursion.basic;

public class Toh {

    public static void main(String[] args) {
        int  noOfDisk=10;
        char t1='A';
        char t2='B';
        char t3='C';
        // toh(3,A,B,C)
        solveToh(noOfDisk,t1,t2,t3);
    }

    private static void solveToh(int noOfDisk, char t1, char t2, char t3) {
        if(noOfDisk==0){
            return;
        }

        // toh (2,A,C,B)
        solveToh(noOfDisk-1,t1,t3,t2);
        // 3[A-B]
        System.out.println("move "+noOfDisk + " from " + t1 + " to " + t2);
        // toh(2,C,B,A)
        solveToh(noOfDisk-1,t3,t2,t1);

    }


}
