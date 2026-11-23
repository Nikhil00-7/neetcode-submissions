class Solution {
    public void solve(char[][] board) {
        

        int n = board.length;
        int m = board[0].length;

        for(int i =0; i< n; i++){
            if(board[i][0] == 'O'){
                dfs(board , i , 0 , n , m);
            }

            if(board[i][m-1] == 'O'){
                dfs(board,  i , m -1, n , m);
            }
        }

        for(int j =0; j< m ; j++){
            if(board[0][j] == 'O'){
                dfs(board , 0 , j , n , m);
            }

            if(board[n-1][j] == 'O'){
                dfs(board , n-1 , j , n , m);
            }
        }

        for(int i =0; i< n ; i++){
            for(int j =0; j< m ; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }


int []x ={0,0, -1,1};
int []y = {1,-1,0,0};

boolean isValid(int row ,int col ,int n ,int m ){
    return row >= 0 && row <n && col >= 0 && col < m;
}

void dfs(char board[][] ,int  i , int j ,int n ,int m){

if(isValid(i , j , n , m) && board[i][j] != 'O'){
    return;
}

board[i][j]= '#';

for(int k =0; k< 4 ; k++){
    int row  = i + x[k];
    int col = j + y[k];
    if(isValid(row ,col , n , m) && board[row][col] == 'O'){
        dfs(board , row , col , n , m);
    }
}
    }
}
