import java.util.*;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> adjacencyList = new HashMap<>();
        
        System.out.println("Program by: Vaughn Dylan Quinn R. Mangas");
        System.out.println("Enter the edges (format: from to). (Type \"end\" to finish):");

        // Input edges and build adjacency list
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
            String[] edge = input.split(" ");
            String node1 = edge[0];
            String node2 = edge[1];
            adjacencyList.putIfAbsent(node1, new ArrayList<>());
            adjacencyList.putIfAbsent(node2, new ArrayList<>());
            adjacencyList.get(node1).add(node2);
            adjacencyList.get(node2).add(node1);
        }

        // Track visited nodes and count connected components
        Set<String> visited = new HashSet<>();
        int connectedComponents = 0;

        // Perform depth-first search on each unvisited node
        for (String node : adjacencyList.keySet()) {
            if (!visited.contains(node)) {
                connectedComponents++;
                dfs(node, visited, adjacencyList);
            }
        }

        // Output graph connectivity result
        if (connectedComponents == 1) {
            System.out.println("The graph is connected.");
        } else {
            System.out.println("The graph is not connected.");
            System.out.println("Number of connected components: " + connectedComponents);
        }
        
        scanner.close();
    }

    // Depth-first search traversal
    private static void dfs(String node, Set<String> visited, Map<String, List<String>> adjacencyList) {
        Stack<String> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            String current = stack.pop();
            if (!visited.contains(current)) {
                visited.add(current);
                for (String neighbor : adjacencyList.get(current)) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }
}
