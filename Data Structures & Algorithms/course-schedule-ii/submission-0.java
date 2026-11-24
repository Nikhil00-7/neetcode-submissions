class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> graph = new ArrayList<>();

        for(int i =0; i< numCourses; i++){
            graph.add(new ArrayList<>());
        }

         int []indegree = new int[numCourses];
        for(int i =0; i< prerequisites.length;i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            
            graph.get(v).add(u);
            indegree[u]++;
        }

        Queue<Integer> queue =new LinkedList<>();

        for(int i =0; i< numCourses;i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }

        int index = 0;
        int result [] = new int [numCourses];

        while(!queue.isEmpty()){
            int node = queue.poll();

            result [index++] = node;

            for(int neighbor: graph.get(node)){
                indegree[neighbor]--;
                if(indegree[neighbor]==0){
                    queue.offer(neighbor);
                }
            }
        }

        if(index != numCourses){
            return new int []{};
        }

        return result;
    }
}
