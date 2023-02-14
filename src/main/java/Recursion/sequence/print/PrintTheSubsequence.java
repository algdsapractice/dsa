package Recursion.sequence.print;

public class PrintTheSubsequence {
    public static void main(String[] args) {

        String str = "abc";
        printSubSeq(str,"");

    }

    private static void printSubSeq(String question, String ans) {

        if(question.length()==0){
            System.out.println(ans);
            return;
        }

        char ch =question.charAt(0);//a
        String rs = question.substring(1);//bc

        printSubSeq(rs,ans+ch);
        printSubSeq(rs,ans+"");


    }
}
