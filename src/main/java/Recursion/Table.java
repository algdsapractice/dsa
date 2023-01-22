package Recursion;



// 2 -> 10

// 2 >  4 >  6  > 8 -> 20

// 3 -> 6 -> 9 -> 10

//  2
// Expectation
//printTable(2) -> 2 ... 20

// Delegation
       // printTable(4) -> 4 to 20

//Solution
// printTable(2) -> 2 -> printTable(4)

public class Table {

    public static void main(String[] args) {
        int data =4;
        int limit =10;
        int pointer =1;
        printTable(data,limit,pointer);
    }

    private static void printTable(int data, int limit, int pointer) {
        if(pointer > limit){
            return;
        }
        System.out.println(data*pointer);
        printTable(data, limit,pointer+1);

    }


}
