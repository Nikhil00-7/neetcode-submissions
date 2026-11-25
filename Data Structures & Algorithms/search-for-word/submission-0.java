class Solution {
    public boolean exist(char[][] board, String word) {
        
        int n = board.length;
        int m = board[0].length;

        boolean [][]visited = new boolean [n][m];
        for(int i =0; i< n;i++){
            for(int j = 0; j< m; j++){

                if(dfs(board , i , j , n , m , visited , word, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    int [] x ={0,0,-1,1};
    int []y = {1,-1,0,0};

    private boolean isValid(int row , int col , int n ,int m ){
        return row >=0 && row<n && col >=0 && col < m;
    }
    private boolean dfs(char [][]board , int i , int j , int n ,int m ,boolean [][]visited , 
    String word , int index){

        if(!isValid(i ,j , n , m) || visited[i][j]){
            return false;
        }

        if(board[i][j] != word.charAt(index)){
            return false;
        }
        if(index == word.length()-1){
            return true;
        }

        visited[i][j] = true;

        for(int k =0; k< 4; k++){
            int row = i + x[k];
            int col = j + y[k];

            if(dfs(board , row , col , n , m , visited , word , index+1)){
                visited[row][col] = false;
                return true;
            }
        }

        visited[i][j] = false;
        return false;
    }


}
