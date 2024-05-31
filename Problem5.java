import java.util.*;

public class Problem5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Program by: Vaughn Dylan Quinn R. Mangas");
        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();
        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();

        // Initialize adjacency list for the graph
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // Read edges and build the adjacency list
        System.out.println("Enter the edges (format: from to):");
        for (int i = 0; i < edges; i++) {
            String from = scanner.next();
            String to = scanner.next();
            int fromIndex = from.charAt(0) - 'a';
            int toIndex = to.charAt(0) - 'a';
            adjacencyList.get(fromIndex).add(toIndex);
            adjacencyList.get(toIndex).add(fromIndex);
        }

        scanner.close();

        // Check if the graph is bipartite
        boolean isBipartite = checkBipartite(adjacencyList);
        System.out.println("The graph is " + (isBipartite ? "bipartite." : "not bipartite."));
    }

    // Function to check if the graph is bipartite
    public static boolean checkBipartite(List<List<Integer>> adjacencyList) {
        int vertices = adjacencyList.size();
        int[] colors = new int[vertices];
        Arrays.fill(colors, -1);

        Queue<Integer> queue = new LinkedList<>();
        
        // Process each vertex (handling disconnected graph)
        for (int i = 0; i < vertices; i++) {
            if (colors[i] == -1) {
                queue.add(i);
                colors[i] = 0;

                // Perform BFS (Breadth-First Search Algorithm)
                while (!queue.isEmpty()) {
                    int current = queue.poll();
                    for (int neighbor : adjacencyList.get(current)) {
                        if (colors[neighbor] == -1) {
                            colors[neighbor] = 1 - colors[current];
                            queue.add(neighbor);
                        } else if (colors[neighbor] == colors[current]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
