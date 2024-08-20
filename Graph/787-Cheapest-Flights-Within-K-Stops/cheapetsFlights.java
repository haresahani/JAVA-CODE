class cheapetsFlights {
    // Class to represent an edge in the graph (flight between two cities)
    static class Edge {
        int src;   // Source city
        int dest;  // Destination city
        int wt;    // Weight (cost) of the flight

        public Edge(int s, int d, int wt) {
            this.src = s;
            this.dest = d;
            this.wt = wt;
        }
    }
    
    // Class to represent the current state (city, cost, stops) during BFS traversal
    static class Info {
        int v;     // Current city
        int cost;  // Cumulative cost to reach the current city
        int stops; // Number of stops made to reach the current city

        public Info(int v, int c, int s) {
            this.v = v;
            this.cost = c;
            this.stops = s;
        }
    }

    public static int findCheapestPrice(int n, int flights[][], int src, int dest, int k) {
        // Create a graph as an adjacency list
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(flights, graph);

        // Arrays to track the minimum cost and minimum stops to each city
        int dist[] = new int[n];
        int stops[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);  // Initialize distances to infinity
        Arrays.fill(stops, Integer.MAX_VALUE); // Initialize stops to infinity
        dist[src] = 0;  // Starting city has 0 cost
        stops[src] = 0; // Starting city has 0 stops

        // Queue for BFS, starting from the source city
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0)); // Initialize with source city, cost 0, and stops 0

        // BFS loop
        while (!q.isEmpty()) {
            Info curr = q.remove(); // Dequeue the current state

            // If the current number of stops exceeds k, skip further processing
            if (curr.stops > k) {
                continue;
            }

            // Explore all neighboring cities (flights) from the current city
            for (Edge e : graph[curr.v]) {
                int v = e.dest; // Neighboring city
                int wt = e.wt;  // Cost to reach the neighboring city

                // If a cheaper route is found or fewer stops are needed, update and continue BFS
                if (curr.cost + wt < dist[v] || curr.stops + 1 < stops[v]) {
                    dist[v] = curr.cost + wt;      // Update the minimum cost to reach city v
                    stops[v] = curr.stops + 1;     // Update the minimum stops to reach city v
                    q.add(new Info(v, dist[v], curr.stops + 1)); // Add city v to the queue
                }
            }
        }

        // Return the minimum cost to reach the destination city, or -1 if unreachable
        return dist[dest] == Integer.MAX_VALUE ? -1 : dist[dest];
    }

    // Helper method to create the graph from the input flights data
    private static void createGraph(int[][] flights, ArrayList<Edge>[] graph) {
        // Initialize the graph with empty lists for each city
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        // Populate the graph with edges (flights)
        for (int[] flight : flights) {
            graph[flight[0]].add(new Edge(flight[0], flight[1], flight[2]));
        }
    }
}
//tc 
//sc