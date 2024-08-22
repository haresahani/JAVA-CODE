import java.util.*;

public class DijkstraPriorityQueue {

    static class Node {
        int vertex;
        int weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    // Dijkstra's algorithm implementation using priority queue
    public static int[] dijkstra(int V, List<List<Node>> adjList, int source) {
        int[] distances = new int[V]; // Array to store the shortest distance from source to each vertex
        Arrays.fill(distances, Integer.MAX_VALUE); // Initialize distances to infinity
        distances[source] = 0; // Distance to source node is 0

        // Priority queue to get the node with the smallest distance
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.weight));
        pq.add(new Node(source, 0)); // Add the source node to the queue

        // Main loop of Dijkstra's algorithm
        while (!pq.isEmpty()) {
            Node node = pq.poll(); // Extract the node with the smallest distance
            int u = node.vertex;

            // Update distances for the neighbors of the selected node
            for (Node neighbor : adjList.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.weight;

                if (distances[u] + weight < distances[v]) {
                    distances[v] = distances[u] + weight; // Update distance
                    pq.add(new Node(v, distances[v])); // Add the updated node to the queue
                }
            }
        }
        return distances; // Return the shortest distances
    }

    public static void main(String[] args) {
        int V = 5; // Number of vertices
        List<List<Node>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>()); // Initialize adjacency list
        }

        // Example graph represented as an adjacency list
        adjList.get(0).add(new Node(1, 4));
        adjList.get(0).add(new Node(2, 2));
        adjList.get(1).add(new Node(2, 5));
        adjList.get(1).add(new Node(3, 10));
        adjList.get(2).add(new Node(3, 3));
        adjList.get(3).add(new Node(4, 1));

        int[] distances = dijkstra(V, adjList, 0); // Run Dijkstra's algorithm from source node 0

        System.out.println("Shortest distances from source:");
        for (int i = 0; i < V; i++) {
            System.out.println("To vertex " + i + " : " + distances[i]); // Print shortest distances
        }
    }
}
