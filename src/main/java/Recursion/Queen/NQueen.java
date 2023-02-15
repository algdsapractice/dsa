package Recursion.Queen;

public class NQueen {

    public static void main(String[] args) {
        int [][] chess = new int[4][4];
        int row = 0;
        String ans="";
        findPosition(chess,ans,row);
    }

    private static void findPosition(int[][] chess, String ans, int row) {

        if(chess.length==row){
            System.out.println(ans);
            return;
        }

        for (int col =0; col<chess[0].length ; col++){
            if(isValidMove(chess,row,col)){
                chess[row][col]=1;
                findPosition(chess,ans +row + "-" + col+",",row+1);
                chess[row][col]=0;
            }

        }

    }

    private static boolean isValidMove(int[][] chess, int row, int col) {
        // Right diagonal movement
        for(int i = row-1 , j=col+1; i>=0 && j<chess.length; i-- ,j++ ){
            if(chess[i][j]==1){
                return false;
            }
        }

        // Left diagonal movement
        for(int i = row-1 , j=col-1; i>=0 && j>=0; i-- ,j-- ){
            if(chess[i][j]==1){
                return false;
            }
        }


        // Vertical movement
        for(int i = row-1 , j=col; i>=0 ; i--  ){
            if(chess[i][j]==1){
                return false;
            }
        }

        return true;
    }
}
