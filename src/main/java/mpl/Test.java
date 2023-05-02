package mpl;


/*
public int opn2(int n){
	if(n > 1) {
		opn2(n/2);
	}
}
 */

public class Test {


    public static void main(String[] args) {
        String a = "XYZX";
        String b = "XXYZ";
        boolean test = getRotat(a, b);
        System.out.println(test);
    }

    private static boolean getRotat(String a, String b) {


        boolean test = true;
        if (a.length() != b.length()) {
            test= false;
        }

        int p1 = 0;
        int p2 = b.indexOf(a.charAt(0));

        if(p2==-1){
            test= false;
        }

        for(int i=0; i<a.length(); i++) {

            if(a.charAt(p1) != b.charAt(p2)){
                test= false;
            }
            p1 = (p1+1) % a.length();
            p2 = (p2+1) % b.length();

        }

        return test;
    }

}
