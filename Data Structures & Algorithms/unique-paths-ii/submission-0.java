class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
   
      int n = obstacleGrid.length;
      int m = obstacleGrid[0].length;

      int [][] dp = new int [n+1][m+1];

      for(int [] row : dp){
        Arrays.fill(row , -1);
      }

      return dfs(obstacleGrid , 0,0,n,m , dp);
    }

    int dfs(int [][]obstacleGrid , int i ,int j,int n,int m ,int[][] dp){

     if(i >= n || j>= m){
        return 0;
       }

        if(obstacleGrid[i][j] == 1){
        return 0;
       }

       if( i == n-1 && j == m-1){
        return 1;
       }


       if(dp[i][j]!= -1){
        return dp[i][j];
       }

       int down = dfs(obstacleGrid , i +1 , j , n , m , dp);
       int right = dfs(obstacleGrid  , i , j+1 , n , m , dp);

       return dp[i][j] = down +right;
    }
    

    }