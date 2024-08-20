import java.util.Arrays;

public class DijkstraMatrix {
    static final int INF = Integer.MAX_VALUE; // Define infinity

    // Dijkstra's algorithm implementation
    public static int[] dijkstra(int[][] graph, int source) {
        int V = graph.length; // Number of vertices
        int[] dist = new int[V]; // Array to store the shortest distance from source to each vertex
        boolean[] visited = new boolean[V]; // Array to keep track of visited nodes

        Arrays.fill(dist, INF); // Initialize distances to infinity
        dist[source] = 0; // Distance to source node is 0

        // Main loop of Dijkstra's algorithm
        for (int i = 0; i < V - 1; i++) {
            int u = minDistance(dist, visited); // Find the unvisited node with the smallest distance
            visited[u] = true; // Mark the node as visited

            // Update distances for the neighbors of the selected node
            for (int v = 0; v < V; v++) {
                if (!visited[v] && graph[u][v] != 0 && dist[u] != INF && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v]; // Update distance
                }
            }
        }
        return dist; // Return the shortest distances
    }

    // Helper method to find the minimum distance node
    private static int minDistance(int[] dist, boolean[] visited) {
        int min = INF, minIndex = -1;
        for (int i = 0; i < dist.length; i++) {
            if (!visited[i] && dist[i] <= min) {
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        // Example graph represented as an adjacency matrix
        int[][] graph = {
            {0, 4, 2, 0, 0},
            {4, 0, 5, 10, 0},
            {2, 5, 0, 3, 0},
            {0, 10, 3, 0, 1},
            {0, 0, 0, 1, 0}
        };
        int[] distances = dijkstra(graph, 0); // Run Dijkstra's algorithm from source node 0
        System.out.println("Shortest distances from source:");
        for (int i = 0; i < distances.length; i++) {
            System.out.println("To vertex " + i + " : " + distances[i]); // Print shortest distances
        }
    }
}
