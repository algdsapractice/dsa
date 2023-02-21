package Recursion.subset;

public class PrintAbbrevation {

    public static void main(String[] args) {
        String str = "abc";
        String ans = "";
        int count = 0;
        int index=0;
        printAbbrev(str,ans, count,index);
    }

    private static void printAbbrev(String str, String ans, int count, int index) {


        if(str.length()==index){
            if(count==0){
                System.out.println(ans);

            }
            else{
                System.out.println(ans+count);
            }
            return;
        }

        // not participating
        printAbbrev(str,ans,count+1,index+1);

        // participating
        if(count==0){
            printAbbrev(str,ans+str.charAt(index),0,index+1);

        }else{
            printAbbrev(str,ans+count+str.charAt(index),0,index+1);

        }

    }
}
