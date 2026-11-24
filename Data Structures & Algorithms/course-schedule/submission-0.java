class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph =new ArrayList<>();

        for(int i =0; i< numCourses; i++){
            graph.add(new ArrayList<>());
        }

         int []indegree = new int [numCourses];
        for(int i =0; i< prerequisites.length;i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            
            graph.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i< numCourses ; i++){
            if(indegree[i]== 0){
                queue.offer(i);
            }
        }

        int count = 0;

        while(!queue.isEmpty()){
            int node = queue.poll();
            count++;

            for(int neighbor: graph.get(node)){
                indegree[neighbor]--;
                if(indegree[neighbor]==0){
                    queue.offer(neighbor);
                }
            }
        }

        return count == numCourses;
    }
}
