class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result =new ArrayList<>();

        char [][]board = new char[n][n];

        for(int i  =0; i< n;i++){
            for(int j= 0; j< n;j++){

                board[i][j] = '.';
            }
        }

        helper(board , n ,0 , result );
        return result;
    }

    void helper(char [][]board , int n ,int row ,List<List<String>> result ){
        if(row == n){
            List<String> path = new ArrayList<>();

            for(int r = 0; r< n; r++){
                path.add(new String(board[r]));
            }

            result.add(path);
            return;
        }

        for(int col = 0; col< n; col++){
            if(isSafe(board , row , col , n)){
                board[row][col ]='Q';
                helper(board , n , row+1 , result);
                board[row][col] = '.';
            }
        }
    }

    boolean isSafe(char[][] board , int row ,int col , int n){
        for(int r = row-1 ; r>=0; r--){
            if(board[r][col] =='Q'){
                return false;
            }
        }

        for(int r = row-1 , c = col-1 ; r >= 0 && c >=0 ; r-- , c--){
             if(board[r][c] =='Q'){
                return false;
            }
        }

        for(int r = row-1 , c = col+1 ; r>=0 && c <n; r-- , c++){
             if(board[r][c] =='Q'){
                return false;
            }
        }

        return true;
    }
}
