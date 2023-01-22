package Recursion;

public class Zigzag {

    public static void main(String[] args) {
        print(3);
    }
    public static void print(int n){
        if(n==0){
            return;
        }
        System.out.println("Pre "+ n); // line 1
        print(n-1);                    // line 2
        System.out.println("IN "+ n);  // line 3
        print(n-1);                    // line 4
        System.out.println("post "+ n); // line 5
    }
}
