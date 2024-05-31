import java.util.*;

public class Problem3 {
    static class Graph {
        private final int V; // Number of vertices
        private final List<List<Integer>> adj;

        Graph(int V) {
            this.V = V;
            adj = new ArrayList<>(V);
            for (int i = 0; i < V; i++)
                adj.add(new LinkedList<>());
        }

        void addEdge(int v, int w) {
            adj.get(v).add(w);
        }

        // Utility function for DFS to detect cycles
        boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack) {
            if (recStack[i]) return true;
            if (visited[i]) return false;

            visited[i] = true;
            recStack[i] = true;

            for (Integer c : adj.get(i))
                if (isCyclicUtil(c, visited, recStack))
                    return true;

            recStack[i] = false;
            return false;
        }

        // Main function to check if the graph contains a cycle
        boolean isCyclic() {
            boolean[] visited = new boolean[V];
            boolean[] recStack = new boolean[V];
            for (int i = 0; i < V; i++)
                if (isCyclicUtil(i, visited, recStack))
                    return true;
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Program by: Vaughn Dylan Quinn R. Mangas");
        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();
        System.out.print("Enter the number of edges: ");
        int E = scanner.nextInt();

        Graph graph = new Graph(V);
        Map<String, Integer> map = new HashMap<>(); // Map to store vertex names to index mapping
        int index = 0;

        System.out.println("Enter the edges (format: from to):");
        for (int i = 0; i < E; i++) {
            String from = scanner.next();
            String to = scanner.next();

            if (!map.containsKey(from)) map.put(from, index++);
            if (!map.containsKey(to)) map.put(to, index++);

            graph.addEdge(map.get(from), map.get(to));
        }

        if (graph.isCyclic())
            System.out.println("Graph contains a cycle.");
        else
            System.out.println("Graph does not contain a cycle.");
        
        scanner.close();
    }
}
