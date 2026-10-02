class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        List<List<Edge>> graph = new ArrayList<>();

        for(int i =0; i< n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i =0; i< flights.length; i++){

            int u = flights[i][0];
            int v = flights[i][1];
            int w = flights[i][2];

            graph.get(u).add(new Edge(v, w));
        }

        int [][]distance = new int[n][k+2];
        for(int i =0; i< n;i++){
        Arrays.fill(distance[i] , Integer.MAX_VALUE);
        }
        
        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b)-> a.price - b.price);
        
        distance[src][0]=0;
        queue.offer(new Pair(src , 0,0));

        while(!queue.isEmpty()){

            Pair  current = queue.poll();
            int flight = current.flight;
            int price = current.price;
            int stop = current.stop;

            if(flight == dst){
                return price;
            }

            if(stop>k){
                continue;
            }


            for(Edge edge: graph.get(flight)){
                 int nextFlight = edge.destination;
                 int newPrice = edge.weight+ price;

                 if(newPrice < distance[nextFlight][stop+1]){
                    distance[nextFlight][stop+1] = newPrice;
                    queue.offer(new Pair(nextFlight , stop+1 , newPrice));
                 }

            }
        }
        return -1;
   
    }

    class Pair{
        int flight;
        int stop; 
        int price;

        Pair(int flight ,int stop, int price){
            this.flight = flight;
            this.stop = stop;
            this.price = price;
        }
    }

    class Edge{
        int destination;
        int weight;

        Edge(int destination, int weight){
         this.destination = destination ;
         this.weight = weight;
        }
    }
}

