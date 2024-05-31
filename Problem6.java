import java.util.*;

public class Problem6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Program by: Vaughn Dylan Quinn R. Mangas");
        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();
        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();

        // Initialize the adjacency matrix
        int[][] adjacencyMatrix = new int[vertices][vertices];

        System.out.println("Enter the edges (format: from to):");
        for (int i = 0; i < edges; i++) {
            String from = scanner.next();
            String to = scanner.next();

            int fromIndex = from.charAt(0) - 'a';
            int toIndex = to.charAt(0) - 'a';

            adjacencyMatrix[fromIndex][toIndex]++;
        }

        // Function for the adjacency matrix
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}


