class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
         List<List<Edge>> graph = new ArrayList<>();

      for(int i =0; i<n+1;i++){
        graph.add(new ArrayList<>());
      }

      for(int i =0; i< times.length; i++){
        int u = times[i][0];
        int v = times[i][1];
        int w = times[i][2];

        graph.get(u).add(new Edge(v, w));
      }

      int [] distances = new int [n+1];

      Arrays.fill(distances, Integer.MAX_VALUE);

      PriorityQueue<Pair> queue = new PriorityQueue<>((a,b)-> a.distance - b.distance);
      queue.offer(new Pair(k, 0));
      distances[k]= 0;

      while(!queue.isEmpty()){
        Pair current = queue.poll();

        int node = current.node;
        int distance  = current.distance;

        if(distance > distances[node]){
            continue;
        }

        for(Edge edge: graph.get(node)){
            int nextNode = edge.destination;
            int newDistance = edge.weight + distance;

            if(newDistance< distances[nextNode]){
                distances[nextNode]  = newDistance;
                queue.offer(new Pair(nextNode, newDistance));
            }
        }
      }

      int ans = 0;
      for(int i =1; i<=n; i++){
        if(distances[i]== Integer.MAX_VALUE){
            return -1;
        }
        ans = Math.max(ans, distances[i]);
      }

      return ans;
    }

    class Edge{
    int destination;
    int weight; 
    Edge(int destination, int weight){
      this.destination= destination;
      this.weight = weight;
    }
}
class Pair{
    int node;
    int distance;

    Pair(int node, int distance){
        this.node= node;
        this.distance= distance;
    }
}
}
