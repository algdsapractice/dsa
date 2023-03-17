package Recursion.backtracking.subseq;

public class ValidIPAddress {

    public static void main(String[] args) {

        String ip = "35557";
        String ans = "";
        int index=0;
        validIPAddress(ip,ans,index);
    }


    public static void validIPAddress(String ip, String ans , int index) {

        System.out.println(ans);
        if(ip == null || ip.length() == 0){
            return;
        }

        if(index==ip.length()+4)

        validIPAddress(ip,ip.substring(index,index+1)+"."+ip.substring(index+2),index+1);

    }


}

