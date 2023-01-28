package Recursion.basic;

// print 1 to 5 ->
// you can not use the loop

// -> when see a sub problem

// HLT
// Bigger Problem ->  When Delegation

// Solution ->

//Exepectation
// print (0) -> 0, 1, 2 ,3
// Faith
// print(1) -> 1 ,2, 3

// print(0) -> 0 -> print(1)
public class RecusrionBasic {




    // print(0)  // print(1)  // print(2) // print(3)


    public static void main(String[] args) {
        print(1);
    }


    private static void print(int data) {

        if(data ==3){
            return;
        }
        // Head Recursion

        print(data+1);
        System.out.println(data);


    }


}
