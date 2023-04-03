package graph.dfs;

public class NumberOfIslands {

    public int countIslands(char[][] board){
        int count = 0;
        int row = board.length;
        int column = board[0].length;

        for(int i = 0; i < row; i++){
            for (int j = 0; j < column; j++) {
               if(board[row][column] ==1){
                   dfs(board,row,column);
               }
               count++;
            }
        }
        return count;
    }

    private void dfs(char[][] board, int row, int column) {

        if(row<0 || column <0 || row > board.length || column >= board[0].length || board[row][column]==0){
            return;
        }

        board[row][column]=0;

        dfs(board,row++,column);

        dfs(board,row--,column);

        dfs(board,row,column++);

        dfs(board,row,column--);

    }
}
