class Solution {

    int[]x = {0,0 ,1,-1};
    int []y = {-1 ,1 , 0,0};
    public int minimumEffortPath(int[][] heights) {
         int n = heights.length;
    int m = heights[0].length;

    int [][] efforts = new int [n][m];

    for(int i =0; i< n;i++){
     Arrays.fill(efforts[i] , Integer.MAX_VALUE);
    }
  
    PriorityQueue<Pair> queue = new PriorityQueue<>((a,b)-> a.effort - b.effort);
     efforts[0][0] = 0;

     queue.offer(new Pair(0, 0, 0));

     while(!queue.isEmpty()){
        Pair current = queue.poll();

        int row = current.row;
        int col = current.col;
        int effort = current.effort;

        if(row == n-1 && col ==m -1){
          return effort;
        }

        for(int k =0; k< 4; k++){
           int newRow = row + x[k];
           int newCol = col + y[k];

           if(!valid(n, m, newRow, newCol)){
            continue;
           }

           int newEffort = Math.max(effort, Math.abs(heights[newRow][newCol]- heights[row][col])) ;
           if(newEffort < efforts[newRow][newCol]){
            efforts[newRow][newCol] = newEffort;
            queue.offer(new Pair(newRow, newCol, newEffort));
           }
        }
     }
     return -1;

    }

    boolean valid(int n ,int m ,int row , int col){
        return row>= 0 && row <n && col >= 0 && col< m;
    }

    class Pair{
    int row;
    int col ;
    int effort;
    Pair(int row ,int col ,int effort){
        this.row = row;
        this.col = col ;
        this.effort = effort;
    }
}
}